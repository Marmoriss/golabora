package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class PickedActorAddServlet
 */
@WebServlet("/member/pickedActorAdd")
public class PickedActorAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedService = new PickedService();
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String memberId = request.getParameter("memberId");
			String actorName = request.getParameter("actorName");
			
			Map<String, Object> an = new HashMap();
			an.put("memberId", memberId);
			an.put("producerName", actorName);

			int result = pickedService.insertActor(an);

			String referrer = request.getHeader("referer");
			response.sendRedirect(referrer);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
