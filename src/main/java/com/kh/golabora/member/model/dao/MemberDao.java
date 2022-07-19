package com.kh.golabora.member.model.dao;

import static com.kh.golabora.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}