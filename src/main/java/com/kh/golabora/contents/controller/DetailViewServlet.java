package com.kh.golabora.contents.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.contents.model.service.ContentsService;

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
			
			// 2. 업무로직
			List<ContentsInfo> detailPage = contentsService.findOneContents(contentsNo);
			
			// 3. view단 처리
			request.setAttribute("detailPage", detailPage);
			request.setAttribute("contentsNo", contentsNo);
			request.getRequestDispatcher("/WEB-INF/views/contents/contentsDetailView.jsp")
				.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
