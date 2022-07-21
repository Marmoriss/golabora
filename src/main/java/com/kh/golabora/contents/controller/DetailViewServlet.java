package com.kh.golabora.contents.controller;

import java.io.IOException;
import java.util.ArrayList;
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
			// 페이지 로딩을 위한 정보 - 뷰테이블 쿼리 사용
			List<ContentsInfo> detailPage = contentsService.findOneContents(contentsNo);
			
			// ott정보 로딩을 위한 정보 contents_title로 ott_name찾기
			
			String contentsTitle = null;
			for(ContentsInfo contents : detailPage) {
				contentsTitle = contents.getContentsTitle();
			};
			
			List<String> ottNames = contentsService.findOttNameByContentsTitle(contentsTitle);
			for(String ottName : ottNames) {
				System.out.println("ottName = " + ottName);
			}
			
			// 3. view단 처리
			request.setAttribute("detailPage", detailPage);
			request.setAttribute("contentsNo", contentsNo);
			request.setAttribute("ottNames", ottNames);
			request.getRequestDispatcher("/WEB-INF/views/contents/contentsDetailView.jsp")
				.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
