package com.kh.golabora.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.golabora.member.model.service.MemberService;

/**
 * Servlet implementation class AdminStatisticListServlet
 */
@WebServlet("/admin/statisticsList")
public class AdminStatisticListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 최근 5일 날짜, 가입자 수 조회
		Map<String, Integer> param = memberService.findRecentMemberCount();
		
		for(Entry<String, Integer> entrySet : param.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
		}
		
		request.setAttribute("param", param);
		
		
		request.getRequestDispatcher("/WEB-INF/views/admin/statisticsList.jsp")
		.forward(request, response);
	}


}
