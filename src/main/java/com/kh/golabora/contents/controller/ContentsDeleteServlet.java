package com.kh.golabora.contents.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.service.ContentsService;



/**
 * Servlet implementation class ContentsDeleteServlet
 */
@WebServlet("/contents/contentsDelete")
public class ContentsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentsService contentsService = new ContentsService();

	/**
	 * 삭제 폼 받기
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/contents/contentsDelete.jsp")
		.forward(request, response);
	}

	/**
	 * db delete
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 사용자 입력값 처리
			String contentsNo = request.getParameter("contentsNo");
			
			//2. 서비스로직호출
			int result = contentsService.deleteContents(contentsNo);
			
			//3. 응답 리다이렉트
			HttpSession session = request.getSession();
			String msg = "";

			if(result > 0){
				msg = "영화 컨텐츠가 삭제되었습니다.";
			}

			//3. 리다이렉트 처리
			session.setAttribute("msg", "영화 콘텐츠를 삭제하였습니다.");
			response.sendRedirect(request.getContextPath() + "/contents/contentsMainView");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
