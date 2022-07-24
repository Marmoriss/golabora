package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.PickedContentsExt;
import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class PickedContentServlet
 */
@WebServlet("/pickedContents")
public class PickedContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedContensService = new PickedService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<PickedContentsExt> list = pickedContensService.findContents();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/picked/pickedContents.jsp")
				.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
