package com.kh.golabora.search.model.dao;

import static com.kh.golabora.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.dto.ContentsWithActor;
import com.kh.golabora.contents.model.dto.ContentsWithProducer;
import com.kh.golabora.contents.model.dto.Gender;
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

	public List<Contents> findContentsByOttNo(Connection conn, String[] ottNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Contents> list = new ArrayList<>();

		try {
			// ott를 여러개 선택했을 때
			if (ottNo.length > 1) {
				String sql = prop.getProperty("findContentsByOttNo");
				String lastCode = ottNo[ottNo.length - 1];

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, ottNo[0]);
				pstmt.setString(2, lastCode);
				
				// ott 1개만 선택했을 때
			} else {
				String sql = prop.getProperty("findContentsByOneOttNo");

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ottNo[0]);
			}
			
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
		String contentsNo = rset.getString("contents_no");
		String genreCode = rset.getString("genre_code");
		int watchableAge = rset.getInt("watchable_age");
		String contentTitle = rset.getString("contents_title");
		String releaseDate = rset.getString("release_date");
		String runningTime = rset.getString("running_time");
		int watchCount = rset.getInt("watch_count");
		String contentPlot = rset.getString("contents_plot");
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

	public List<Contents> findContentsbyContentsTitle(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findContentsbyContentsTitle");
		List<Contents> list = new ArrayList<>();
		String col = (String) param.get("searchType");
		String val = (String) param.get("searchKeyword");
		sql = sql.replace("#", col);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + val + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Contents contents = handleContentsResultSet(rset);
				list.add(contents);
			}
		} catch (SQLException e) {
			throw new SearchException("영화명 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<ContentsWithProducer> findContentsbyProducerName(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findContentsbyProducerName");
		List<ContentsWithProducer> list = new ArrayList<>();
		String col = (String) param.get("searchType");
		String val = (String) param.get("searchKeyword");
		sql = sql.replace("#", col);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + val + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String contentsNo = rset.getString("contents_no");
				String genreCode = rset.getString("genre_code");
				int watchableAge = rset.getInt("watchable_age");
				String contentTitle = rset.getString("contents_title");
				String releaseDate = rset.getString("release_date");
				String runningTime = rset.getString("running_time");
				int watchCount = rset.getInt("watch_count");
				String contentPlot = rset.getString("contents_plot");
				String originalFilename = rset.getString("original_filename");
				String renamedFilename = rset.getString("renamed_filename");
				
				ContentsWithProducer contents = new ContentsWithProducer(contentsNo, genreCode, 
						watchableAge, contentsNo, releaseDate, runningTime, watchCount, 
						contentsNo, originalFilename, renamedFilename);
				
				contents.setProducerNo(rset.getString("producer_no"));
				contents.setProducerName(rset.getString("producer_name"));
				contents.setGender(Gender.valueOf(rset.getString("gender")));
				
				list.add(contents);
			}
			
		} catch (SQLException e) {
			throw new SearchException("감독명으로 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<ContentsWithActor> findContentsbyActorName(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findContentsbyActorName");
		List<ContentsWithActor> list = new ArrayList<>();
		String col = (String) param.get("searchType");
		String val = (String) param.get("searchKeyword");
		sql = sql.replace("#", col);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + val + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String contentsNo = rset.getString("contents_no");
				String genreCode = rset.getString("genre_code");
				int watchableAge = rset.getInt("watchable_age");
				String contentTitle = rset.getString("contents_title");
				String releaseDate = rset.getString("release_date");
				String runningTime = rset.getString("running_time");
				int watchCount = rset.getInt("watch_count");
				String contentPlot = rset.getString("contents_plot");
				String originalFilename = rset.getString("original_filename");
				String renamedFilename = rset.getString("renamed_filename");
				
				ContentsWithActor contents = new ContentsWithActor(contentsNo, genreCode, watchableAge, 
						contentsNo, releaseDate, runningTime, watchCount, contentsNo, 
						originalFilename, renamedFilename);
				
				contents.setActorNo(rset.getString("actor_no"));
				contents.setActorName(rset.getString("actor_name"));
				contents.setGender(Gender.valueOf(rset.getString("gender")));
				
				list.add(contents);
			}
			
		} catch (SQLException e) {
			throw new SearchException("배우명으로 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


}
