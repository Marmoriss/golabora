package com.kh.golabora.member.controller;

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
import com.kh.golabora.review.model.dto.Review;
import com.kh.golabora.review.model.service.ReviewService;

/**
 * Servlet implementation class MemberReviewServlet
 */
@WebServlet("/member/memberReview")
public class MemberReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewService reviewService = new ReviewService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			int cPage = 1;
			int numPerPage = 10;
			
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch(NumberFormatException e) {}
			
			//content 영역
			int start = (cPage - 1) * numPerPage + 1;
			int end = cPage * numPerPage;
			String memberId = request.getParameter("memberId");
			System.out.println("memberId"+memberId);
			Map<String, Object>param = new HashMap<>();
			param.put("start", start); 
			param.put("end", end);
			param.put("memberId", memberId);
			//select * from (select row_number() over (order by reg_date desc) rnum, r.* from review r) r where rnum between ? and ?
			List<Review> list = reviewService.findReviewByMemberId(param);
			
			//pagebar 영역
			int totalContent = reviewService.getTotalReviewByMemberId(memberId); //전체 게시물 수 
			System.out.println("totalContent = "+ totalContent);
			String url = request.getRequestURI()+"?memberId"+memberId; //페이지넘겼을 때의 주소 요청
			String pagebar = HelloGolaboraUtils.getPagebar(cPage, numPerPage, totalContent, url);
			
			//view단 응답처리
			request.setAttribute("list", list);
			request.setAttribute("pagebar", pagebar);
			request.setAttribute("memberId", memberId);
			request.getRequestDispatcher("/WEB-INF/views/member/memberReviewList.jsp").forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	

}
