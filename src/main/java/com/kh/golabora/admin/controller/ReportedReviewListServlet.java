package com.kh.golabora.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.common.HelloGolaboraUtils;
import com.kh.golabora.review.model.dto.ReportedReview;
import com.kh.golabora.review.model.service.ReviewService;

/**
 * Servlet implementation class ManageReportedReviewsServlet
 */
@WebServlet("/admin/reviewList")
public class ReportedReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewService reviewService = new ReviewService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 신고 리뷰 목록 출력
		try {
			// 1. 사용자 입력값
			int numPerPage = 5;
			int cPage = 1;

			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch (NumberFormatException e) {}
			int start = (cPage - 1) * numPerPage + 1;
			int end = cPage * numPerPage;

			Map<String, Object> param = new HashMap<>();
			param.put("start", start);
			param.put("end", end);

			// 2. 업무로직
			// a. content 영역
			List<ReportedReview> list = reviewService.findAllReportedReview(param);

			// b. pagebar 영역
			int totalContent = reviewService.getTotalReportedReview();
			String url = request.getRequestURI(); // /golabora/admin/reviewList
			String pagebar = HelloGolaboraUtils.getPagebar(cPage, numPerPage, totalContent, url);

			// 3. view단 처리
			request.setAttribute("list", list);
			request.setAttribute("pagebar", pagebar);
			request.getRequestDispatcher("/WEB-INF/views/")
				.forward(request, response);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}