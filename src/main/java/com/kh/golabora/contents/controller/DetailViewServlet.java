package com.kh.golabora.contents.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.common.HelloGolaboraUtils;
import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.contents.model.service.ContentsService;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.review.model.dto.Review;

/**
 * Servlet implementation class DetailViewServlet
 */
@WebServlet("/contents/detailView")
public class DetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContentsService contentsService = new ContentsService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 사용자 입력값 처리
			String contentsNo = request.getParameter("no");
			System.out.println("no = " + contentsNo);
			int cPage = 1; 
			int numPerPage = 5;
			
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch (NumberFormatException e) {}
			
			int start = (cPage - 1) * numPerPage + 1;
			int end = cPage * numPerPage;
			
			Map<String, Object>param = new HashMap<>();
			
			param.put("start", start); 
			param.put("end", end); 
			param.put("contentsNo", contentsNo);
			
			HttpSession session = request.getSession();
			Member loginMember = (Member) session.getAttribute("loginMember");
			String memberId = null;
			if(loginMember != null)
				memberId = loginMember.getMemberId();
			
			
			// 2. 업무로직
			// 페이지 로딩을 위한 정보 - 뷰테이블 쿼리 사용
			List<ContentsInfo> detailPage = contentsService.findOneContents(contentsNo);
			List<Review> reviewList = contentsService.findReviewByContentsNo(param);
			// ott정보 로딩을 위한 정보 contents_title로 ott_name찾기
			
			String contentsTitle = null;
			for(ContentsInfo contents : detailPage) {
				contentsTitle = contents.getContentsTitle();
			};
			
			List<String> ottNames = contentsService.findOttNameByContentsTitle(contentsTitle);
			for(String ottName : ottNames) {
				System.out.println("ottName = " + ottName);
			}
			
			int totalContent = contentsService.getTotalReviewByContentsNo(contentsNo);
			String url = request.getRequestURI()+"?no="+contentsNo;
			String pagebar = HelloGolaboraUtils.getPagebar(cPage, numPerPage, totalContent, url);
			System.out.println("pagebar= "+pagebar);
			System.out.println("url="+url );
			
			// 찜목록 받기
			
			// 3. view단 처리
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("detailPage", detailPage);
			request.setAttribute("contentsNo", contentsNo);
			request.setAttribute("ottNames", ottNames);
			request.setAttribute("pagebar", pagebar);
			request.getRequestDispatcher("/WEB-INF/views/contents/contentsDetailView.jsp")
				.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
