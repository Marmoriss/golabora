package com.kh.golabora.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.common.HelloMvcUtils;
import com.kh.golabora.member.model.dto.Gender;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.member.model.service.MemberService;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/member/memberEnroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * GET 회원가입폼 요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/memberEnroll.jsp")
			.forward(request, response);
	}

	/**
	 * POST db insert 요청
	 * 
	 * insert into member values (?, ?, ?, ?, ?, ?, default, default)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 인코딩처리
			request.setCharacterEncoding("utf-8");
			
			// 2. 사용자입력값처리
			String memberId = request.getParameter("memberId");
			String genreCode = request.getParameter("genre");
			String password = HelloMvcUtils.getEncryptedPassword(request.getParameter("password"), memberId);
			String _gender = request.getParameter("gender");
			String memberName = request.getParameter("memberName");
			String phone = request.getParameter("phone");
			
			Gender gender = _gender != null ? Gender.valueOf(_gender) : null;
			
			Member member = 
					new Member(memberId, genreCode, password, memberName, gender, 
							  phone, null, null);
			
			System.out.println("member@MemberEnrollServlet = " + member);
			
			// 3. 업무로직 : db insert
			int result = memberService.insertMember(member); 
			System.out.println("result@MemberEnrollServlet = " + result);
			
			// 4. 응답처리 : redirect
			HttpSession session = request.getSession();
			session.setAttribute("msg", "회원가입이 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/");
		
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
		
	}

}



