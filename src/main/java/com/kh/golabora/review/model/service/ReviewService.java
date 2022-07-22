package com.kh.golabora.review.model.service;
import static com.kh.golabora.common.JdbcTemplate.close;
import static com.kh.golabora.common.JdbcTemplate.commit;
import static com.kh.golabora.common.JdbcTemplate.getConnection;
import static com.kh.golabora.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.review.model.dao.ReviewDao;
import com.kh.golabora.review.model.dto.ReportedReview;
import com.kh.golabora.review.model.dto.Review;
public class ReviewService {
	
	private ReviewDao reviewDao = new ReviewDao();
	
		
	//review insert 
	public int insertReview(Review review) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = reviewDao.insertReview(conn, review);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		
		return result;
	}

	//리뷰번호로 조회 
	public Review findByReviewNo(String reviewNo) {
		Connection conn = getConnection();
		Review review = null;
		review = reviewDao.findByReviewNo(conn, reviewNo);
		commit(conn);
		return review;
	}
	
	

	
	
	//리뷰 수정
	public int updateReview(Review review) {
		Connection conn = getConnection();
		int result = 0;
		try {
		result = reviewDao.updateReview(conn, review);
		
		commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	//콘텐츠별 전체 리뷰 갯수 조회
	public int getTotalReviewByContentsNo(String contentsNo) {
		Connection conn = getConnection();
		int totalReviewByContentsNo = reviewDao.getTotalReviewByContentsNo(conn, contentsNo);
		close(conn);
		return totalReviewByContentsNo;
	}

	//리뷰 삭제
	public int deleteReview(String reviewNo) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = reviewDao.deleteReview(conn, reviewNo);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		}
			close(conn);
		return result;
	}

	//멤버별 리뷰 조회
	public List<Review> findReviewByMemberId(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Review> list = reviewDao.findReviewByMemberId(conn, param);
		close(conn);
		return list;
	}

	//멤버별 전체 리뷰 갯수 조회
	public int getTotalReviewByMemberId(String memberId) {
		Connection conn = getConnection();
		int totalReviewByMemberId = reviewDao.getTotalReviewByMemberId(conn, memberId);
		close(conn);
		return totalReviewByMemberId;
	}

	public int insertReportedReview(ReportedReview reportedReview) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = reviewDao.insertReportedReview(conn, reportedReview);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		
		return result;
	}

	//리뷰등록시 콘텐츠 정보 가져오기
	public List<ContentsInfo> findReviewContentsInfo(String contentsNo) {
		Connection conn = getConnection();
		List<ContentsInfo> contentsInfo = reviewDao.findReviewContentsInfo(conn, contentsNo);
		close(conn);
		return contentsInfo;
	}

	// 신고된 리뷰 전체 조회
	public List<ReportedReview> findAllReportedReview(Map<String, Object> param) {
		Connection conn = getConnection();
		List<ReportedReview> list = reviewDao.findAllReportedReview(conn, param);
		close(conn);
		return list;
	}
	
	// 신고된 리뷰 테이블 총 신고리뷰 수 조회
	public int getTotalReportedReview() {
		Connection conn = getConnection();
		int totalContent = reviewDao.getTotalReportedReview(conn); 
		close(conn);
		return totalContent;
	}
	
}
