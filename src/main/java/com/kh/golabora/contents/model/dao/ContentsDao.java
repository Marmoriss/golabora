package com.kh.golabora.contents.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.golabora.common.JdbcTemplate.close;
import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.exception.ContentsException;


public class ContentsDao {

	private Properties prop = new Properties();
	
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

}
