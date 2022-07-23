package com.kh.golabora.member.model.service;

import static com.kh.golabora.common.JdbcTemplate.close;
import static com.kh.golabora.common.JdbcTemplate.commit;
import static com.kh.golabora.common.JdbcTemplate.getConnection;
import static com.kh.golabora.common.JdbcTemplate.rollback;


import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.kh.golabora.member.model.dao.MemberDao;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.member.model.exception.MemberException;

public class MemberService {	
	private MemberDao memberDao = new MemberDao();

	/**
	 * DQL요청 - service
	 * 1. Connection객체 생성
	 * 2. Dao 요청 & Connection 전달
	 * 3. Connection 반환(close)
	 * 
	 * @param memberId
	 * @return
	 */
	public Member findById(String memberId) {
		Connection conn = getConnection();
		Member member = memberDao.findById(conn, memberId);
		close(conn);
		return member;
	}

	/**
	 * DML요청 - service
	 * 1. Connection객체 생성
	 * 2. Dao요청 & Connection 전달
	 * 3. 트랜잭션처리(정상처리 commit, 예외발생시 rollback)
	 * 4. Connection객체 반환
	 * 
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = memberDao.insertMember(conn, member);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e; // controller에 예외 던짐.
		} finally {
			close(conn);
		}
		return result;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = memberDao.updateMember(conn, member);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e; // controller에 예외 던짐.
		} finally {
			close(conn);
		}
		return result;
	}
	
	public int updatePassword(String memberId, String newPassword) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = memberDao.updatePassword(conn, memberId, newPassword);
			commit(conn);
		} 
		catch(Exception e) {
			rollback(conn);
			throw e;
		} 
		finally {
			close(conn);
		}
		return result;
	}
	
	public List<Member> findAll(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Member> list = memberDao.findAll(conn, param);
		close(conn);
		return list;
	}
	
	public int deleteMember(String memberId) {
		Connection conn = null;
		int result = 0;
		try{
			conn = getConnection();
			result = memberDao.deleteMember(conn, memberId);
			if(result == 0)
				throw new MemberException("해당 회원은 존재하지 않습니다.");
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);			
		}
		return result;
	}
	
	public int getTotalContent() {
		Connection conn = getConnection();
		int totalContent = memberDao.getTotalContent(conn);
		close(conn);
		return totalContent;
	}

	public List<Member> findMemberLike(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Member> list = memberDao.findMemberLike(conn, param);
		close(conn);
		return list;
	}

	public int getTotalContentLike(Map<String, Object> param) {
		Connection conn = getConnection();
		int totalContent = memberDao.getTotalContentLike(conn, param);
		close(conn);
		return totalContent;
	}

	public Map<String, Integer> findRecentMemberCount() {
		Connection conn = getConnection();
		Map<String, Integer> param = memberDao.findRecentMemberCount(conn);
		close(conn);
		return param;
	}
}





