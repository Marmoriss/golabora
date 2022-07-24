package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.PickedContents;
import com.kh.golabora.contents.model.dto.PickedProducer;
import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class PickedProducerAddServlet
 */
@WebServlet("/member/pickedProducerAdd")
public class PickedProducerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedService = new PickedService();
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String producerName = request.getParameter("producerName");
			String memberId = request.getParameter("memberId");
			
			Map<String, Object> pn = new HashMap();
			pn.put("memberId", memberId);
			pn.put("producerName", producerName);
			
			int result = pickedService.insertProducer(pn);

			String referrer = request.getHeader("referer");
			response.sendRedirect(referrer);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


}
