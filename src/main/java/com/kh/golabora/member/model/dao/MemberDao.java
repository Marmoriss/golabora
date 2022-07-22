package com.kh.golabora.member.model.dao;

import static com.kh.golabora.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kh.golabora.member.model.dto.Gender;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.member.model.dto.MemberRole;
import com.kh.golabora.member.model.exception.MemberException;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String filename = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Member findById(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String sql = prop.getProperty("findById");	
		// select * from member where member_id = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = handleMemberResultSet(rset);
			}
			
		} catch (SQLException e) {
			throw new MemberException("회원 아이디 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	
	private Member handleMemberResultSet(ResultSet rset) throws SQLException {
		String memberId = rset.getString("member_id"); 
		String genreCode = rset.getString("genre_code"); 
		String password = rset.getString("password"); 
		String memberName = rset.getString("member_name"); 
		
		String _gender = rset.getString("gender");
		Gender gender = _gender != null ? Gender.valueOf(_gender) : null; 
		
		String phone = rset.getString("member_phone"); 
		MemberRole memberRole = MemberRole.valueOf(rset.getString("member_role"));
		Date enrollDate = rset.getDate("enroll_date"); 
		
		return new Member(memberId, genreCode, password, memberName, gender, 
							  phone, memberRole, enrollDate);
	}
	
public int insertMember(Connection conn, Member member) {
	PreparedStatement pstmt = null;
	int result = 0;
	String sql = prop.getProperty("insertMember");
	// insert into member values (?, ?, ?, ?, ?, ?, default, default)

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getGenreCode());
		pstmt.setString(3, member.getPassword());
		pstmt.setString(4, member.getMemberName());
		pstmt.setString(5, member.getGender() != null ? member.getGender().name() : null); // Gender.M
		pstmt.setString(6, member.getPhone());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		throw new MemberException("회원가입 오류", e);
	} finally {
		close(pstmt);
	}
	return result;
}
public int updateMember(Connection conn, Member member) {
	PreparedStatement pstmt = null;
	int result = 0;
	String sql = prop.getProperty("updateMember");
	// update member set genre_code = ?, member_name = ?, gender = ?, member_phone = ? where member_id = ?
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getGenreCode());
		pstmt.setString(2, member.getMemberName());
		pstmt.setString(3, member.getGender() != null ? member.getGender().name() : null); // Gender.M
		pstmt.setString(4, member.getPhone());
		pstmt.setString(5, member.getMemberId());
		
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		
		throw new MemberException("회원정보수정 오류", e);
	} finally {
		close(pstmt);
	}
	return result;
}
public int updatePassword(Connection conn, String memberId, String newPassword) {
	PreparedStatement pstmt = null;
	int result = 0;
	String sql = prop.getProperty("updatePassword");
//	update member set password = ? where member_id = ?
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newPassword);
		pstmt.setString(2, memberId);
		result = pstmt.executeUpdate();
		
	} 
	catch (SQLException e) {
		throw new MemberException("비밀번호 변경 오류!", e);
	} 
	finally {
		close(pstmt);
	}
	
	return result;
}

public List<Member> findAll(Connection conn, Map<String, Object> param) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	List<Member> list = new ArrayList<>();
	String sql = prop.getProperty("findAll");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (int) param.get("start"));
		pstmt.setInt(2, (int) param.get("end"));
		rset = pstmt.executeQuery();
		while(rset.next()) {
			Member member = handleMemberResultSet(rset);
			list.add(member);
		}
			
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} 
	finally {
		close(rset);
		close(pstmt);
	}
	return list;
}

public int deleteMember(Connection conn, String membmerId) {
	int result = 0;
	PreparedStatement pstmt = null;
	String query = prop.getProperty("deleteMember"); 
//	deleteMember = delete from member where member_id = ?
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, membmerId);
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		throw new MemberException("회원 삭제 오류!", e);
	} finally {
		close(pstmt);
	} 
	
	return result;
}

public int getTotalContent(Connection conn) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	int totalContent = 0;
	String sql = prop.getProperty("getTotalContent");
	
	try {
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset.next())
			totalContent = rset.getInt(1);
	} catch (SQLException e) {
		throw new MemberException("전체회원수 조회 오류!", e);
	} finally {
		close(rset);
		close(pstmt);
	}
	return totalContent;
}

public List<Member> findMemberLike(Connection conn, Map<String, Object> param) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	List<Member> list = new ArrayList<>();
	String sql = prop.getProperty("findMemberLike");
	// select * from member where # like ?
	String col = (String) param.get("searchType");
	String val = (String) param.get("searchKeyword");
	int start = (int) param.get("start");
	int end = (int) param.get("end");
	
	sql = sql.replace("#", col);
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + val + "%");
		pstmt.setInt(2, start);
		pstmt.setInt(3, end);
		rset = pstmt.executeQuery();
		while(rset.next())
			list.add(handleMemberResultSet(rset));
		
	} catch (SQLException e) {
		throw new MemberException("관리자 회원검색 오류!", e);
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
}

public int getTotalContentLike(Connection conn, Map<String, Object> param) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	int totalContent = 0;
	String sql = prop.getProperty("getTotalContentLike");
	String col = (String) param.get("searchType");
	String val = (String) param.get("searchKeyword");
	sql = sql.replace("#", col);
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + val + "%");
		rset = pstmt.executeQuery();
		if(rset.next())
			totalContent = rset.getInt(1);
		
	} catch (SQLException e) {
		throw new MemberException("관리자 검색된 회원수 조회 오류!", e);
	} finally {
		close(rset);
		close(pstmt);
	}
	return totalContent;
}


}