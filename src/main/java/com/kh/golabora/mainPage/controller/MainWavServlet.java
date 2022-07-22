package com.kh.golabora.mainPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.mainPage.model.service.RankService;
import com.kh.golabora.mainPage.model.service.RecommendService;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/mainWav")
public class MainWavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private RankService rankService = new RankService();
	private RecommendService recommendService = new RecommendService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			List<Contents> rank = rankService.rankWav();
			List<Contents> recommend = recommendService.recommendContents();

			request.setAttribute("rank", rank);
			request.setAttribute("recommend", recommend);

			request.getRequestDispatcher("/WEB-INF/views/mainpage/mainWav.jsp")
				.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	}

}
