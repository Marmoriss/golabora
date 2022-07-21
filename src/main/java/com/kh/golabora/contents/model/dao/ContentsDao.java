package com.kh.golabora.contents.model.dao;

import static com.kh.golabora.common.JdbcTemplate.close;

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
import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.contents.model.exception.ContentsException;


public class ContentsDao {

	private Properties prop = new Properties();
	/**
	 * 주희 코드 시작
	 */
	public ContentsDao() {
		String filename = ContentsDao.class.getResource("/sql/contents/contents-query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 주희 코드 끝
	 */
	public int insertContents(Connection conn, Contents contents) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertContents");
		// insert into contents values (?, ?, default, ?, ?, ?, default, ?, ?, ?)
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents.getContentsNo());
			pstmt.setString(2, contents.getGenreCode());
			pstmt.setString(3, contents.getContentsTitle());
			pstmt.setString(4, contents.getReleaseDate());
			pstmt.setString(5, contents.getRunningTime());
			pstmt.setString(6, contents.getContentsPlot());
			pstmt.setString(7, contents.getOriginalFilename());
			pstmt.setString(8, contents.getRenamedFilename());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ContentsException("영화등록 오류", e);
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 주희 코드 시작
	 */
	public List<ContentsInfo> findOneContents(Connection conn, String contentsNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findOneContents");
		List<ContentsInfo> detailPage = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contentsNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ContentsInfo contents = handleContentsInfoRset(rset);
				detailPage.add(contents);
			}
			
		} catch (SQLException e) {
			throw new ContentsException("콘텐츠 상세정보 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return detailPage;
	}

	private ContentsInfo handleContentsInfoRset(ResultSet rset) throws SQLException{
		String contentsNo = rset.getString("contents_no");
		int watchableAge = rset.getInt("watchable_age");
		String contentsTitle = rset.getString("contents_title");
		String releaseDate = rset.getString("release_date");
		String runningTime = rset.getString("running_time");
		String contentsPlot = rset.getString("contents_plot");
		String originalFilename = rset.getString("original_filename");
		String renamedFilename = rset.getString("renamed_filename");
		String genreName = rset.getString("genre_name");
		String ottName = rset.getString("ott_name");
		String actorName = rset.getString("actor_name");
		String producerName = rset.getString("producer_name");
		
		ContentsInfo contents = new ContentsInfo(contentsNo, watchableAge, 
				contentsTitle, releaseDate, runningTime, contentsPlot, 
				originalFilename, renamedFilename, genreName, ottName, 
				actorName, producerName);
		
		return contents;
	}
	
	/**
	 * 주희 코드 끝
	 */

}
