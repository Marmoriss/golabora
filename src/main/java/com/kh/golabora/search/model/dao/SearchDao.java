package com.kh.golabora.search.model.dao;

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
import com.kh.golabora.search.model.exception.SearchException;

public class SearchDao {

	private Properties prop = new Properties();

	public SearchDao() {
		String filename = SearchDao.class.getResource("/sql/search/search-query.properties").getPath();
//		System.out.println("filename = " + filename);
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contents> findContentsByOttNo(Connection conn, String ottNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> list = new ArrayList<>();
		String sql = prop.getProperty("findContentsByOttNo");
//		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ottNo);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Contents contents = handleContentsResultSet(rset);
				list.add(contents);
			}
		} catch (SQLException e) {
			throw new SearchException("ott별 콘텐츠 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	private Contents handleContentsResultSet(ResultSet rset) throws SQLException {
		String contentsNo = rset.getString("content_no");
		String genreCode = rset.getString("genre_code");
		int watchableAge = rset.getInt("watchable_age");
		String contentTitle = rset.getString("content_title");
		String releaseDate = rset.getString("release_date");
		String runningTime = rset.getString("running_time");
		int watchCount = rset.getInt("watch_count");
		String contentPlot = rset.getString("content_plot");
		String originalFilename = rset.getString("original_filename");
		String renamedFilename = rset.getString("renamed_filename");

		return new Contents(contentsNo, genreCode, watchableAge, contentTitle, releaseDate, runningTime, watchCount,
				contentPlot, originalFilename, renamedFilename);
	}

	public List<Contents> findContentsByGenreCode(Connection conn, String[] genreCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> list = new ArrayList<>();

		try {
			// 장르를 여러개 선택했을 때
			if (genreCode.length > 1) {
				String sql = prop.getProperty("findContentsByGenreCode");
				String lastCode = genreCode[genreCode.length - 1];

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, genreCode[0]);
				pstmt.setString(2, lastCode);
				
				// 장르 1개만 선택했을 때
			} else {
				String sql = prop.getProperty("findContentsByOneGenreCode");

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, genreCode[0]);
			}

			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Contents contents = handleContentsResultSet(rset);
				list.add(contents);
			}
		} catch (SQLException e) {
			throw new SearchException("장르별 콘텐츠 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
}
