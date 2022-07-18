package com.kh.golabora.search.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.dto.ContentsWithActor;
import com.kh.golabora.search.model.service.SearchService;

/**
 * Servlet implementation class searchNamesServlet
 */
@WebServlet("/search/searchContentsTitle")
public class SearchContentsTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchService searchService = new SearchService();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 사용자 입력값 처리
			
			String searchType = request.getParameter("searchType");
			String searchKeyword = request.getParameter("searchKeyword");
			
			Map<String, Object> param = new HashMap<>();
			param.put("searchType", searchType);
			param.put("searchKeyword", searchKeyword);
			
			System.out.println("param = " + param);
			
			// 2. 업무 로직
			List<Contents> contentsTitleList = searchService.findContentsbyContentsTitle(param);
			System.out.println(contentsTitleList);
			
			// 3. view단 처리
			request.setAttribute("contentsTitleList", contentsTitleList);
			request.getRequestDispatcher("/WEB-INF/views/search/searchContents.jsp")
			.forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
