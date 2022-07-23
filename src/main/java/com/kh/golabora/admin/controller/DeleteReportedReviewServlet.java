package com.kh.golabora.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.review.model.service.ReviewService;

/**
 * Servlet implementation class DeleteReportedReviewServlet
 */
@WebServlet("/admin/reviewDelete")
public class DeleteReportedReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 사용자 입력값
			String[] repoReviewNo = request.getParameterValues("repoReviewNo");
			
			// 업무로직
			int result = reviewService.deleteReportedReview(repoReviewNo);
			
			// 리다이렉트
			request.getSession().setAttribute("msg", "신고 리뷰를 성공적으로 삭제했습니다.");
			response.sendRedirect(request.getContextPath() + "/admin/reportedReviewList");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
