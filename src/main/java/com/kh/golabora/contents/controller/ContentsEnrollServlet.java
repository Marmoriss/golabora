package com.kh.golabora.contents.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.service.ContentsService;


/**
 * Servlet implementation class ContentsEnroll
 */
@WebServlet("/contents/contentsEnroll")
public class ContentsEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentsService contentsService = new ContentsService();

	
	/**
	 * Enroll Contents
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/contents/contentsEnroll.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
