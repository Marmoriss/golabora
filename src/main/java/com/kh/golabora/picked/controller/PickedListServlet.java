package com.kh.golabora.picked.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.contents.model.dto.PickedActorExt;
import com.kh.golabora.contents.model.dto.PickedContentsExt;
import com.kh.golabora.contents.model.dto.PickedProducerExt;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.picked.service.PickedService;

/**
 * Servlet implementation class PickedListServlet
 */
@WebServlet("/member/pickedList")
public class PickedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PickedService pickedService = new PickedService();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 입력값
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		
		// 업무 로직 (찜리스트 불러오기)
		// 찜한 콘텐츠
		List<PickedContentsExt> pickedContentsList = pickedService.findPickedContentsList(memberId);
		
		// 찜배우
		List<PickedActorExt> pickedActorList = pickedService.findPickedActorList(memberId);
		
		// 찜감독
		List<PickedProducerExt> pickedProducerList = pickedService.findPickedProducerList(memberId);
		
		// view단 연결
		request.setAttribute("pickedContentsList", pickedContentsList);
		request.setAttribute("pickedActorList", pickedActorList);
		request.setAttribute("pickedProducerList", pickedProducerList);
		
		request.getRequestDispatcher("/WEB-INF/views/picked/pickedList.jsp")
			.forward(request, response);
			
	}

}
