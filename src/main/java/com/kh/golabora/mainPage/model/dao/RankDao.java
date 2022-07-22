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

import javax.websocket.Session;

import com.kh.golabora.contents.model.dto.Contents;

public class RankDao {

private Properties prop = new Properties();
	
	public RankDao() {
		String filename = RankDao.class.getResource("/sql/mainpage/mainpage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	private Contents handleRankResultSet(ResultSet rset) throws SQLException {

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
	

	public List<Contents> rankNet(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> rank = new ArrayList<>();
		String sql = prop.getProperty("rankNet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Contents contents = handleRankResultSet(rset);
				rank.add(contents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}	
		return rank;
	}

	
	public List<Contents> rankWav(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> rank = new ArrayList<>();
		String sql = prop.getProperty("rankWav");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Contents contents = handleRankResultSet(rset);
				rank.add(contents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}	
		return rank;
	}
	

	public List<Contents> rankWat(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> rank = new ArrayList<>();
		String sql = prop.getProperty("rankWat");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Contents contents = handleRankResultSet(rset);
				rank.add(contents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}	
		return rank;
	}

}
