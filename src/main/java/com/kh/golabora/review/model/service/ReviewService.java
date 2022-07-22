package com.kh.golabora.review.model.service;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.golabora.review.model.dao.ReviewDao;
import com.kh.golabora.review.model.dto.ReportedReview;
public class ReviewService {

	private ReviewDao reviewDao = new ReviewDao();

	public List<ReportedReview> findAllReportedReview(Map<String, Object> param) {
		Connection conn = getConnection();
		List<ReportedReview> list = reviewDao.findAllReportedReview(conn, param);
		close(conn);
		return list;
	}

	public int getTotalReportedReview() {
		Connection conn = getConnection();
		int totalContent = reviewDao.getTotalReportedReview(conn); 
		close(conn);
		return totalContent;
	}
}
