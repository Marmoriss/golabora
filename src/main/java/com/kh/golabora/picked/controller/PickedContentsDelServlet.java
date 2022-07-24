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
 * Servlet implementation class PickedContentsDelServlet
 */
@WebServlet("/member/pickedContentsDel")
public class PickedContentsDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedService = new PickedService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String contentsNo = request.getParameter("contentsNo");
			String memberId = request.getParameter("memberId");
			
			PickedContents pickedContents = new PickedContents(contentsNo, memberId);
			
			//2. 서비스로직호출
			int result = pickedService.deleteContents(pickedContents);
			
			String referrer = request.getHeader("referer");
			response.sendRedirect(referrer);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
