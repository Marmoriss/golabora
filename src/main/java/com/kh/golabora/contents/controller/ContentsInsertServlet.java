package com.kh.golabora.contents.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.service.ContentsService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;




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
			//0. 첨부파일 처리
			ServletContext application = getServletContext(); //절대경로필요하므로
			String saveDirectory = application.getRealPath("/images"); //가져와서 쓰기
			System.out.println("saveDirectory = " + saveDirectory);
			int maxPostSize = 1024 * 1024 * 10; // 1024*1024*10 = 10MB
			String encoding = "utf-8";
			FileRenamePolicy policy = new DefaultFileRenamePolicy();
			
			MultipartRequest multiReq = new MultipartRequest(
					request, saveDirectory, maxPostSize, encoding, policy);
			
			// 2. 사용자 입력값 처리

			String genreCode = multiReq.getParameter("genreCode");
			int watchableAge = Integer.parseInt(multiReq.getParameter("watchableAge"));
			String contentsTitle = multiReq.getParameter("contentsTitle");
			String releaseDate = multiReq.getParameter("releaseDate");
			String runningTime = multiReq.getParameter("runningTime");
			String contentsPlot = multiReq.getParameter("contentsPlot");
			
			//파일이름가져오기
			Enumeration<String> filenames = multiReq.getFileNames(); 
			while(filenames.hasMoreElements()) {
				String filename = filenames.nextElement();
				File upFile = multiReq.getFile(filename);
				System.out.println("upFile="+upFile);
				System.out.println("filename="+filename);
				//null이 아닐때만! 
				if(upFile != null) {
					Contents contents = new Contents();
					contents.setOriginalFilename(multiReq.getOriginalFileName(filename)); //업로드한 파일명
					contents.setRenamedFilename(multiReq.getFilesystemName(filename));
				}
			}			
			
			String originalFilename = multiReq.getParameter("originalFilename");
			
			Contents contents = new Contents(null, genreCode, watchableAge, contentsTitle, releaseDate,
					runningTime, 0, contentsPlot, originalFilename, null);

			
			// 3. db insert
			int result = contentsService.insertContents(contents);
			System.out.println("result@ContentsInsertServlet = " + result);
			
			// 4. 응답처리 redirect
			HttpSession session = request.getSession();
			session.setAttribute("msg", "영화 콘텐츠 등록이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/contents/contentsInsert");
			
		
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
	}

}
