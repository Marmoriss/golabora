package com.kh.golabora.contents.model.service;

import static com.kh.golabora.common.JdbcTemplate.close;
import static com.kh.golabora.common.JdbcTemplate.commit;
import static com.kh.golabora.common.JdbcTemplate.getConnection;
import static com.kh.golabora.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.golabora.contents.model.dao.ContentsDao;
import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.contents.model.exception.ContentsException;
import com.kh.golabora.review.model.dto.Review;


public class ContentsService {
	private ContentsDao contentsDao = new ContentsDao();

	
	public int insertContents(Contents contents) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = contentsDao.insertContents(conn, contents);
			commit(conn);
			
		} catch(Exception e) {
			rollback(conn);
			throw e;
			
		} finally {
			close(conn);
		}
		return result;
	}

/**
 * 주희 코드 시작
 */
	
	public List<ContentsInfo> findOneContents(String contentsNo) {
		Connection conn = getConnection();
		List<ContentsInfo> detailPage = contentsDao.findOneContents(conn, contentsNo);
		close(conn);
		return detailPage;
	}

public List<String> findOttNameByContentsTitle(String contentsTitle) {
	Connection conn = getConnection();
	List<String> ottnames = contentsDao.findOttNameByContentsTitle(conn, contentsTitle);
	close(conn);
	return ottnames;
}
	
/**
 * 주희 코드 끝
 */
	
	/**
	 * 수아 코드 시작
	 */
	public List<Review> findReviewByContentsNo(Map<String, Object> param){
		Connection conn = getConnection();
		List<Review> reviewList = contentsDao.findReviewByContentsNo(conn, param);
		close(conn);
		return reviewList;
	}
	

	//콘텐츠별 전체 리뷰 갯수 조회
		public int getTotalReviewByContentsNo(String contentsNo) {
			Connection conn = getConnection();
			int totalReviewByContentsNo = contentsDao.getTotalReviewByContentsNo(conn, contentsNo);
			close(conn);
			return totalReviewByContentsNo;
		}
	/**
	 * 수아 코드 끝
	 */
		
	/**
	 * 은미 코드 시작
	 */

		public int updateContents(Contents contents) {
			Connection conn = getConnection();
			int result = 0;
			try {
				result = contentsDao.updateContents(conn, contents);
				commit(conn);
			} catch (Exception e) {
				rollback(conn);
				throw e;
			} finally {
				close(conn);
			}
			
			return result;
		}

	public int deleteContents(String contentsTitle) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = contentsDao.deleteContents(conn, contentsTitle);
			if(result == 0)
				throw new ContentsException("해당 번호의 영화는 존재하지 않습니다.");
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		
		return result;
	}

	public ContentsInfo findByContentsTitle(String contentsTitle) {
		Connection conn = getConnection();
		ContentsInfo contentsInfo = contentsDao.findByContentsTitle(conn, contentsTitle);
		close(conn);
		return contentsInfo;
	}
		
	/**
	 * 은미 코드 끝
	 */
}
