package com.kh.golabora.member.controller;

import java.io.IOException;
import java.util.Enumeration;

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
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/memberDelete.jsp")
			.forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 사용자 입력값 처리
			String memberId = request.getParameter("memberId");
			String password = HelloMvcUtils.getEncryptedPassword(request.getParameter("password"), memberId);
			
			//2. a.비밀번호 검증
			Member member = memberService.findById(memberId);
			String msg = null;
			String location = request.getContextPath();
			if(member != null && password.equals(member.getPassword())) {
			//2. 서비스로직호출
			int result = memberService.deleteMember(memberId);
			
			// 모든 속성 제거하기
			HttpSession session = request.getSession();
//			session.invalidate();
			Enumeration<String> names = session.getAttributeNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				session.removeAttribute(name);
			}
			// saveId cookie 제거
			Cookie c = new Cookie("saveId",memberId);
			c.setPath(request.getContextPath());
			c.setMaxAge(0);			//쿠키의 유효기간 0=> 즉시삭제
			response.addCookie(c);	
			
			//3. 리다이렉트 처리
			session.setAttribute("msg", "회원을 성공적으로 삭제했습니다.");
			response.sendRedirect(request.getContextPath() + "/");
			}
			else {
				msg = "비밀번호가 일치하지 않습니다.";
				location += "/member/memberDelete";
				request.getSession().setAttribute("msg", msg);
				response.sendRedirect(location);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
