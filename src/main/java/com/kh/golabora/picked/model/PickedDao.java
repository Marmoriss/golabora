package com.kh.golabora.picked.model;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kh.golabora.contents.model.dto.Gender;
import com.kh.golabora.contents.model.dto.PickedActor;
import com.kh.golabora.contents.model.dto.PickedActorExt;
import com.kh.golabora.contents.model.dto.PickedContents;
import com.kh.golabora.contents.model.dto.PickedContentsExt;
import com.kh.golabora.contents.model.dto.PickedProducer;
import com.kh.golabora.contents.model.dto.PickedProducerExt;
import com.kh.golabora.contents.model.exception.ContentsException;
import com.kh.golabora.picked.Execption.PickedException;
import com.kh.golabora.contents.model.dto.PickedProducer;
import com.kh.golabora.search.model.exception.SearchException;

public class PickedDao {
	
	private Properties prop = new Properties();

	public PickedDao() {
		String filename = PickedDao.class.getResource("/sql/picked/picked-query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

	public List<PickedProducerExt> findProducer(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<PickedProducerExt> list = new ArrayList<>();
		String sql = prop.getProperty("findPickedProducer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String producerNo = rset.getString("producer_no");
				String producerName = rset.getString("producer_name");
				String _gender = rset.getString("gender");
				Gender gender = _gender != null ? Gender.valueOf(_gender) : null; 

			PickedProducerExt pickedproducer
						= new PickedProducerExt(memberId, producerNo, producerName, gender);
						
				list.add(pickedproducer);
			}
		} catch (SQLException e) {
			throw new PickedException("감독명으로 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	
	public List<PickedActorExt> findActor(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<PickedActorExt> list = new ArrayList<>();
		String sql = prop.getProperty("findPickedActor");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String actorNo = rset.getString("actor_no");
				String actorName = rset.getString("actor_name");
				String _gender = rset.getString("gender");
				Gender gender = _gender != null ? Gender.valueOf(_gender) : null; 

			PickedActorExt pickedactor
						= new PickedActorExt(memberId, actorNo, actorName, gender);
						
			list.add(pickedactor);			
			}
		} catch (SQLException e) {
			throw new PickedException("배우명으로 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		}
	
	
	public int getTotalContent(Connection conn) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalContent = 0;
		String sql = prop.getProperty("getTotalContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next())
				totalContent =rset.getInt(1);
		} catch (SQLException e) {
		throw e;
		} finally {
				close(rset);
				close(pstmt);
			}	
		return totalContent;
	}

	
	public int insertContents(Connection conn, PickedContents pickedContents) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertPickedContents");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pickedContents.getContentsNo());
			pstmt.setString(2, pickedContents.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PickedException("찜 추가 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	public int insertProducer(Connection conn, Map<String, Object> pn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertPickedProducer");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) pn.get("memberId"));
			pstmt.setString(2, (String) pn.get("producerName"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PickedException("찜 추가 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	public int insertMember(Connection conn, Map<String, Object> an) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertPickedActor");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) an.get("memberId"));
			pstmt.setString(2, (String) an.get("actorName"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PickedException("찜 추가 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	public int deleteContents(Connection conn, PickedContents pickedContents) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deletePickedContents"); 

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pickedContents.getMemberId());
			pstmt.setString(2, pickedContents.getContentsNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PickedException("찜 목록 삭제 오류", e);
		} finally {
			close(pstmt);
		} 
		return result;
	}


	public int deleteProducer(Connection conn, Map<String, Object> pn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deletePickedProducer"); 

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, (String) pn.get("memberId"));
			pstmt.setString(2, (String) pn.get("producerName"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PickedException("찜 목록 삭제 오류", e);
		} finally {
			close(pstmt);
		} 
		return result;
	}


	public int deleteActor(Connection conn, Map<String, Object> an) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("de"); 

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, (String) an.get("memberId"));
			pstmt.setString(2, (String) an.get("deletePickedActor"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PickedException("찜 목록 삭제 오류", e);
		} finally {
			close(pstmt);
		} 
		return result;
	}




	public List<PickedContentsExt> findContents(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<PickedContentsExt> list = new ArrayList<>();
		String sql = prop.getProperty("findpickedContents");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String contentsNo = rset.getString("contents_no");
				String memberId = rset.getString("member_id");
				String genreCode = rset.getString("genre_code");
				int watchableAge = rset.getInt("watchable_age");
				String contentsTitle = rset.getString("contents_title");
				String releaseDate = rset.getString("release_date");
				String runningTime = rset.getString("running_time");
				int watchCount = rset.getInt("watch_count");
				String contentsPlot = rset.getString("contents_plot");
				String originalFilename = rset.getString("original_filename");
				String renamedFilename = rset.getString("renamed_filename");
			
				PickedContentsExt pickedContentsExt = new PickedContentsExt(contentsNo, memberId, genreCode, watchableAge, contentsTitle,
						releaseDate, runningTime, watchCount, contentsPlot, originalFilename, renamedFilename);
			
			}
		} catch (SQLException e) {
			throw new PickedException("감독명으로 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	
}
