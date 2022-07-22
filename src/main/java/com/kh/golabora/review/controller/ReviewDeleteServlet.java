package com.kh.golabora.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewDeleteServlet
 * 리뷰 삭제 - 트리거 걸어두었으니, 삭제테이블로 빠지겠져..?
 */
@WebServlet("/review/reviewDelete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String reviewNo = request.getParameter("reviewNo");
		
		int result = reviewService.deleteReview(reviewNo);
		
		request.getSession().setAttribute("msg", "리뷰를 삭제했습니다!");
		String referer = request.getHeader("Referer");
		response.sendRedirect(referer);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
