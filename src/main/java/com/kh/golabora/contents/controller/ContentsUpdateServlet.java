package com.kh.golabora.contents.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.service.ContentsService;


/**
 * Servlet implementation class ContentsUpdateServlet
 */
@WebServlet("/contents/contentsUpdate")
public class ContentsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentsService contentsService = new ContentsService();

	/**
	 * update member set member_name = ?, gender = ?, birthday = ?, email = ?, phone = ?, hobby = ? where member_id = ?
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		private String contentsNo;
//		private String genreCode;
//		private int watchableAge;
//		private String contentsTitle;
//		private String releaseDate;
//		private String runningTime;
//		private int watchCount;
//		private String contentsPlot;
//		private String originalFilename;
//		private String renamedFilename;
	}

}
