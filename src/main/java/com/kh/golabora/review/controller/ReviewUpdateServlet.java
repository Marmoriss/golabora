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
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/review/reviewUpdate")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewService();
       
   
	/**
	 * GET 수정폼 요청 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String contentsNo = request.getParameter("contentsNo");
			String reviewNo = request.getParameter("reviewNo");
			List<ContentsInfo> contentsInfo = reviewService.findReviewContentsInfo(contentsNo);
			
			Review review = reviewService.findByReviewNo(reviewNo);
			
			request.setAttribute("review", review);
			request.setAttribute("contentsInfo", contentsInfo);
			request.getRequestDispatcher("/WEB-INF/views/review/reviewUpdate.jsp")
			.forward(request, response);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewNo = request.getParameter("reviewNo");
		String memberId = request.getParameter("memberId");
		String contentsNo = request.getParameter("contentsNo");
		String reviewContent = request.getParameter("reviewContent");
		int star = Integer.parseInt(request.getParameter("star"));
		Review review = new Review(reviewNo, memberId, contentsNo, reviewContent, star, null);
	
		int result = reviewService.updateReview(review);
		
		request.getSession().setAttribute("msg", "리뷰를 수정하였습니다!");
		response.sendRedirect(request.getContextPath()+"/contents/detailView?no="+contentsNo);
		
	}

}
