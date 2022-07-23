package com.kh.golabora.contents.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.service.ContentsService;



/**
 * Servlet implementation class ContentsUpdateServlet
 */
@WebServlet("/contents/contentsUpdate")
public class ContentsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentsService contentsService = new ContentsService();
	
	
	/**
	 * GET 콘텐츠 수정 폼 요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/contents/contentsUpdate.jsp")
		.forward(request, response);
	}

	/**
	 * 
	 * POST db update 요청
	 * 
	 * update contents set genre_code = ?, watchable_age = ?, content_title = ?, release_date = ?,
	 * running_time = ?, content_plot = ?, original_filename = ?, renamed_filename = ? where content_no = ?
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			// 1. 사용자 입력값 처리
			String contentsNo = request.getParameter("contentsNo");
			String genreCode = request.getParameter("genreCode");
			int watchableAge = Integer.parseInt(request.getParameter("watchableAge"));
			String contentsTitle = request.getParameter("contentsTitle");
			String releaseDate = request.getParameter("releaseDate");
			String runningTime = request.getParameter("runningTime");
			String contentsPlot = request.getParameter("contentsPlot");
			String originalFilename = request.getParameter("originalFilename");
			String renamedFilename = request.getParameter("renamedFilename");
			
			Contents contents = new Contents(contentsNo, genreCode, watchableAge, contentsTitle, releaseDate,
					runningTime, 0, contentsPlot, originalFilename, renamedFilename);
			
			// 잘 작동되었는지 확인
			System.out.println("contents@ContentseUpdateServlet = " + contents);
			
			//2.업무로직
			int result = contentsService.updateContents(contents);  

			//3. 응답 리다이렉트
			HttpSession session = request.getSession();
			String msg = "";

			if(result > 0){
				msg = "영화 컨텐츠가 수정되었습니다.";
			}
			
			session.setAttribute("msg", msg);
			response.sendRedirect(request.getContextPath() + "/contents/contentsMainView");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		

	}

}
