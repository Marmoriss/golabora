package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.PickedProducer;
import com.kh.golabora.contents.model.dto.PickedProducerExt;
import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class PickedProducerServlet
 */
@WebServlet("/member/pickedProducer")
public class PickedProducerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PickedService pickedProducerService = new PickedService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<PickedProducerExt> list = pickedProducerService.findProducer();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/picked/pickedProducer.jsp")
				.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}