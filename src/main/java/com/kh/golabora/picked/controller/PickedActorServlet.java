package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.PickedActor;
import com.kh.golabora.contents.model.dto.PickedActorExt;
import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class PickedActorServlet
 */
@WebServlet("/member/pickedActor")
public class PickedActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedActorService = new PickedService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<PickedActorExt> list = pickedActorService.findActor();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/picked/pickedActor.jsp")
				.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
