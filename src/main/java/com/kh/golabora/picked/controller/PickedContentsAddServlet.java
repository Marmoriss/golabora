package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.PickedContents;
import com.kh.golabora.picked.service.PickedService;



/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/pickedContentsAdd")
public class PickedContentsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedService = new PickedService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String memberId = request.getParameter("memberId");
			String contentsNo = request.getParameter("contentsNo");
			
			int result = pickedService.insertContents(memberId, contentsNo);
			
			String referrer = request.getHeader("Referer");
			response.sendRedirect(referrer);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
