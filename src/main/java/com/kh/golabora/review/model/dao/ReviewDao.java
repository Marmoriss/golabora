package com.kh.golabora.review.model.dao;

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

import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.review.model.dto.ReportedReview;
import com.kh.golabora.review.model.dto.Review;
import com.kh.golabora.review.model.exception.ReviewException;

public class ReviewDao {

	private Properties prop = new Properties();
	
	public ReviewDao() {
		String filename = ReviewDao.class.getResource("/sql/review/review-query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//리뷰 insert
	public int insertReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertReview");
		//insertReview = insert into review values('re'||seq_review_no.nextval,?,?,?,?,default)
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getMemberId());
			pstmt.setString(2, review.getContentsNo());
			pstmt.setString(3, review.getReviewContent());
			pstmt.setInt(4, review.getStar());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ReviewException("리뷰 등록 오류!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//리뷰 resultSet
			private Review handleReviewResultSet(ResultSet rset) throws SQLException {
				String reviewNo = rset.getString("review_no");
				String memberId = rset.getString("member_id");
				String contentNo = rset.getString("contents_no");
				String reviewContent = rset.getString("review_content");
				int star = rset.getInt("star");
				Date regDate = rset.getDate("reg_date");
				
				return new Review(reviewNo, memberId, contentNo, reviewContent, star, regDate);
			}

	//리뷰 1건 조회
	public Review findByReviewNo(Connection conn, String reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review review = null;
		String sql = prop.getProperty("findByReviewNo");
		//select * from review where review_no = ?
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewNo);
			
			rset = pstmt.executeQuery();
			while(rset.next())
				review = handleReviewResultSet(rset);
		} catch (SQLException e) {
			throw new ReviewException("리뷰 1건 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return review;
	}

	

	//리뷰 수정
	public int updateReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateReview");
		//update review set reviewContent = ?, star = ? where review_no = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getReviewContent());
			pstmt.setInt(2, review.getStar());
			pstmt.setString(3, review.getReviewNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ReviewException("리뷰 수정 오류!", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	//콘텐츠 별 리뷰 갯수 조회
	public int getTotalReviewByContentsNo(Connection conn, String contentsNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalReviewByContentsNo = 0;
		String sql = prop.getProperty("getTotalReviewByContentsNo");
		//select count(*) from review where contents_no = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contentsNo);
			rset = pstmt.executeQuery();
			while(rset.next())
				totalReviewByContentsNo = rset.getInt(1);
		} catch (SQLException e) {
			throw new ReviewException("콘텐츠 별 전체 리뷰 수 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalReviewByContentsNo;
	}


	//리뷰삭제
	public int deleteReview(Connection conn, String reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteReview");
		//delete from review where review_no = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ReviewException("리뷰 삭제 오류!", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	//회원별 리뷰 조회
	public List<Review> findReviewByMemberId(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> list = new ArrayList<>();
		String sql = prop.getProperty("findReviewByMemberId");
		//select * from review where member_id = ? between ? and ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)param.get("memberId"));
			pstmt.setInt(2, (int)param.get("start"));
			pstmt.setInt(3, (int)param.get("end"));
			while(rset.next()) {
				Review review = handleReviewResultSet(rset);
				list.add(review);
			}
		} catch (SQLException e) {
			throw new ReviewException("회원별 리뷰 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//회원별 리뷰 갯수 조회
	public int getTotalReviewByMemberId(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalReviewByMemberId = 0;
		String sql = prop.getProperty("getTotalReviewByMemberId");
		//select count(*) from review where member_id = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next())
				totalReviewByMemberId = rset.getInt(1);
		} catch (SQLException e) {
			throw new ReviewException("회원별 전체 리뷰 수 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalReviewByMemberId;
	}

	//신고리뷰 신고테이블에 insert
	public int insertReportedReview(Connection conn, ReportedReview reportedReview) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertReportedReview");
		//insert into reported_review values('re' || seq_reported_review_no.nextval, ?,?,default,?)
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reportedReview.getReviewNo());
			pstmt.setString(2, reportedReview.getReporterId());
			pstmt.setString(3, reportedReview.getReason());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ReviewException("신고게시물 등록 오류!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
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

	public List<ContentsInfo> findReviewContentsInfo(Connection conn, String contentsNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findReviewContentsInfo");
		List<ContentsInfo> contentsInfo = new ArrayList<>();
		//select * from v_contents_info where contents_no = ? 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contentsNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ContentsInfo contents = handleContentsInfoRset(rset);
				contentsInfo.add(contents);
			}
		} catch (SQLException e) {
			throw new ReviewException("리뷰 등록 콘텐츠 조회 오류!", e);	
		} finally {
			close(rset);
			close(pstmt);
		}
		return contentsInfo;
	}
	
	// 신고된 리뷰 전체 조회
	public List<ReportedReview> findAllReportedReview(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ReportedReview> list = new ArrayList<>();
		String sql = prop.getProperty("findAllReportedReview");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) param.get("start"));
			pstmt.setInt(2, (int) param.get("end"));

			rset = pstmt.executeQuery();

			while(rset.next()) {
				ReportedReview reportedReview = handleReportedReviewResultSet(rset);
				list.add(reportedReview);
			}
		} catch (SQLException e) {
			throw new ReviewException("신고 리뷰 목록 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}


	private ReportedReview handleReportedReviewResultSet(ResultSet rset) throws SQLException{
		String reportedReviewNo = rset.getString("reported_review_no");
		String reviewNo = rset.getString("reviewNo");
		String reporterId = rset.getString("reporter_id");
		Date reportedDate = rset.getDate("reported_date");
		String reason = rset.getString("reason");

		ReportedReview reportedReview = 
				new ReportedReview(reportedReviewNo, reviewNo, reporterId, reportedDate, reason);

		return reportedReview;
	}
	
	// 신고된 리뷰 테이블 총 신고 리뷰 수 조회
	public int getTotalReportedReview(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalContent = 0;
		String sql = prop.getProperty("getTotalReportedReview");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if(rset.next())
				totalContent = rset.getInt(1);

		} catch (SQLException e) {
			throw new ReviewException("총 신고 리뷰수 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalContent;
	}
}
