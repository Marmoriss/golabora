package com.kh.golabora.member.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.golabora.member.model.dto.Gender;
import com.kh.golabora.member.model.dto.Member;
import com.kh.golabora.member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	
	/**
	 * update member set genre_code = ?, member_name = ?, gender = ?, member_phone = ? where member_id = ?
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			
			// 1. 사용자 입력값 처리
			String memberId = request.getParameter("memberId");
			String genreCode = request.getParameter("genreCode");
			String memberName = request.getParameter("memberName");
			String _gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			
			Gender gender = _gender != null ? 
								Gender.valueOf(_gender) : 
									null;
			
			Member member = 
					new Member(memberId, genreCode, null, memberName, gender, 
							phone, null, null);
			System.out.println("member@MemberEnrollServlet = " + member);
			
			//2.업무로직
			int result = memberService.updateMember(member);  

			//3. 응답 리다이렉트
			HttpSession session = request.getSession();
			String msg = "";

			if(result > 0){
				msg = "회원정보가 변경되었습니다.";
				// 세션 정보 갱신
				session.setAttribute("loginMember", memberService.findById(memberId));
			}
			
			session.setAttribute("msg", msg);
			response.sendRedirect(request.getContextPath() + "/member/memberView");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


}
