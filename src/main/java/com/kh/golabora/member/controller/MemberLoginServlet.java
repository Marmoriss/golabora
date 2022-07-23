package com.kh.golabora.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.common.HelloMvcUtils;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.member.model.service.MemberService;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/memberLogin.jsp")
			.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 2. 사용자입력값 처리
			String memberId = request.getParameter("memberId");
			String password = HelloMvcUtils.getEncryptedPassword(request.getParameter("password"), memberId);
			String saveId = request.getParameter("saveId");
			System.out.println("memberId = " + memberId);
			System.out.println("password = " + password);
			System.out.println("saveId = " + saveId); // "on" | null 
			
			// 3. 업무로직 : 로그인여부 판단
			Member member = memberService.findById(memberId);
			System.out.println("member@MemberLoginServlet = " + member);
			
			HttpSession session = request.getSession(true); // 세션이 존재하지 않으면, 새로 생성해서 반환. true생략가능
			System.out.println(session.getId()); // 클라이언트쪽과 동일
			
			// 로그인 성공
			if(member != null && password.equals(member.getPassword())) {
				session.setAttribute("loginMember", member);
				
			
				Cookie cookie = new Cookie("saveId", memberId);
				cookie.setPath(request.getContextPath()); 
				
				
				if(saveId != null) {
					
					cookie.setMaxAge(7 * 24 * 60 * 60); 
				}
				
				else {
					cookie.setMaxAge(0); 
				}
					
				response.addCookie(cookie); 
				response.sendRedirect(request.getContextPath() + "/");
			}
			
			
			// 4. 응답 처리 : 로그인후 url변경을 위해 리다이렉트처리
//			
			else {
				session.setAttribute("msg", "아이디 또는 비밀번호가 일치한지 확인바랍니다.");
				String location = request.getHeader("Referer");
				response.sendRedirect(location);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e; 
		}
		
	}

}
