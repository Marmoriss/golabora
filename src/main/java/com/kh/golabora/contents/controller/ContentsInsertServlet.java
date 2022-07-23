package com.kh.golabora.contents.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.service.ContentsService;




/**
 * Servlet implementation class ContentsEnroll
 */
@WebServlet("/contents/contentsInsert")
public class ContentsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentsService contentsService = new ContentsService();

	
	/**
	 * GET 콘텐츠 등록 폼 요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/contents/contentsInsert.jsp")
		.forward(request, response);
	}

	/**
	 * POST db insert 요청
	 * 
	 * insert into contents values (seq_contents_no.nextval, ?, ?, ?, ?, ?, default, ?, ?, ?)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1. 인코딩 처리
			request.setCharacterEncoding("utf-8");
			
			// 2. 사용자 입력값 처리

			String genreCode = request.getParameter("genreCode");
			int watchableAge = Integer.parseInt(request.getParameter("watchableAge"));
			String contentsTitle = request.getParameter("contentsTitle");
			String releaseDate = request.getParameter("releaseDate");
			String runningTime = request.getParameter("runningTime");
			String contentsPlot = request.getParameter("contentsPlot");
			String originalFilename = request.getParameter("originalFilename");
			String renamedFilename = request.getParameter("renamedFilename");
			
			Contents contents = new Contents(null, genreCode, watchableAge, contentsTitle, releaseDate,
					runningTime, 0, contentsPlot, originalFilename, renamedFilename);

			
			// 3. db insert
			int result = contentsService.insertContents(contents);
			System.out.println("result@ContentsInsertServlet = " + result);
			
			// 4. 응답처리 redirect
			HttpSession session = request.getSession();
			session.setAttribute("msg", "영화 콘텐츠 등록이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/contents/contentsMainView");
			
		
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
	}

}
