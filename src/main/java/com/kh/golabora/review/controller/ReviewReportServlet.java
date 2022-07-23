package com.kh.golabora.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.review.model.dto.ReportedReview;
import com.kh.golabora.review.model.dto.Review;
import com.kh.golabora.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewReportServlet
 */
@WebServlet("/review/reviewReport")
public class ReviewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewService();   

	/**
	 * GET 리뷰 신고 등록폼 요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentsNo = request.getParameter("contentsNo");
		String reviewNo = request.getParameter("reviewNo");
		Review reportReview = reviewService.findByReviewNo(reviewNo);
		
		request.setAttribute("contentsNo", contentsNo);
		request.setAttribute("reviewNo", reviewNo);
		request.setAttribute("reportReview", reportReview);
		request.getRequestDispatcher("/WEB-INF/views/review/reviewReport.jsp").forward(request, response);
	}

	/**
	 * POST db review reported 테이블에 insert 요청
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentsNo = request.getParameter("contentsNo");
		//1. 사용자 입력값 처리 reviewReported 객체 만들기
		String reviewNo = request.getParameter("reviewNo");
		String reporterId = request.getParameter("reporterId");
		String reason = request.getParameter("reason");
		ReportedReview reportedReview = new ReportedReview(null, reviewNo, reporterId, null, reason);
		
		//2. 업무로직
		int result = reviewService.insertReportedReview(reportedReview);
		
		//3. redirect
		request.getSession().setAttribute("msg", "리뷰 신고가 완료되었습니다.");
		response.sendRedirect(request.getContextPath()+"/contents/detailView?no="+contentsNo);
	}

}
