package com.kh.golabora.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.contents.model.dto.PickedContents;
import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class MemberPickedListServlet
 */
@WebServlet("/member/pickedList")
public class MemberPickedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/member/memberPickedList.jsp");
	reqDispatcher.forward(request, response);
	
	}
}
