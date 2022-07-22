package com.kh.golabora.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.review.model.dto.Review;
import com.kh.golabora.review.model.service.ReviewService;

/**
 * 리뷰 등록용 servlet
 */
@WebServlet("/review/reviewEnroll")
public class ReviewEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewService();

	/**
	 * GET 리뷰 등록폼 요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentsNo = request.getParameter("contentsNo");
		System.out.println("contentsNo = "+contentsNo);
		List<ContentsInfo> contentsInfo = reviewService.findReviewContentsInfo(contentsNo);
		
		request.setAttribute("contentsInfo", contentsInfo);
		request.setAttribute("contentsNo", contentsNo);
		request.getRequestDispatcher("/WEB-INF/views/review/reviewEnroll.jsp").forward(request, response);
	}

	/**
	 * POST db review insert 요청
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 입력값 처리 review 객체 만들기
		String memberId = request.getParameter("memberId");
		String contentsNo = request.getParameter("contentsNo");
		String reviewContent = request.getParameter("reviewContent");
		int star = Integer.parseInt(request.getParameter("star"));
		Review review = new Review(null, memberId, contentsNo, reviewContent, star, null);
		
		//2. 업무로직
		int result = reviewService.insertReview(review);
		
		//3. redirect
		request.getSession().setAttribute("msg", "리뷰를 성공적으로 등록했습니다!");
		response.sendRedirect(request.getContextPath()+"/contents/detailView?no="+contentsNo);
	}

}
