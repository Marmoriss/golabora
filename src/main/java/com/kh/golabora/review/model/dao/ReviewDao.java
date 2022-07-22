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

import com.kh.golabora.review.model.dto.ReportedReview;
import com.kh.golabora.review.model.exception.ReviewException;
import com.kh.golabora.search.model.dao.SearchDao;

public class ReviewDao {
	
	private Properties prop = new Properties();
	public ReviewDao() {
		String filename = SearchDao.class.getResource("/sql/search/review-query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
				ReportedReview reportedReview = handleReviewResultSet(rset);
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
	private ReportedReview handleReviewResultSet(ResultSet rset) throws SQLException{
		String reportedReviewNo = rset.getString("reported_review_no");
		String reviewNo = rset.getString("reviewNo");
		String reporterId = rset.getString("reporter_id");
		Date reportedDate = rset.getDate("reported_date");
		String reason = rset.getString("reason");
		
		ReportedReview reportedReview = 
				new ReportedReview(reportedReviewNo, reviewNo, reporterId, reportedDate, reason);
		
		return reportedReview;
	}
	
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










