package com.kh.golabora.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.search.model.service.SearchService;

/**
 * Servlet implementation class searchOttServelet
 */
@WebServlet("/search/searchOtt")
public class SearchOttServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SearchService searchService = new SearchService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 사용자 입력값
			String[] ottNo = request.getParameterValues("ottNo");
//			System.out.println("ottNo = " + ottNo[0]);
			
			// 2. 업무 로직
			List<Contents> list = searchService.findContentsByOttNo(ottNo);
//			System.out.println("list = " + list);
			
			// 3. view단 처리
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/search/searchContents.jsp")
				.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
