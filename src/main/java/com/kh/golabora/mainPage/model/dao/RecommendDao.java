package com.kh.golabora.mainPage.model.dao;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.golabora.contents.model.dto.Contents;

public class RecommendDao {

private Properties prop = new Properties();
	
	public RecommendDao() {
		String filename = RecommendDao.class.getResource("/sql/mainpage/mainpage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	private Contents handleRecommendResultSet(ResultSet rset) throws SQLException {

		String contentsNo = rset.getString("contents_no");
		String genreCode = rset.getString("genre_code");
		int watchableAge = rset.getInt("watchable_age");
		String contentsTitle = rset.getString("contents_title");
		String releaseDate = rset.getString("release_date");
		String runningTime = rset.getString("running_time");
		int watchCount = rset.getInt("watch_count");
		String contentsPlot = rset.getString("contents_plot");
		String originalFilename = rset.getString("original_filename");
		String renamedFilename =rset.getString("renamed_filename");
		
		return new Contents(contentsNo, genreCode, watchableAge, contentsTitle, releaseDate, runningTime, watchCount, contentsPlot, originalFilename, renamedFilename);
	}
	

	public List<Contents> recommendContents(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> recommend = new ArrayList<>();
		String sql = prop.getProperty("recommendContents");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Contents contents = handleRecommendResultSet(rset);
				recommend.add(contents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}	
		return recommend;
	}
}
