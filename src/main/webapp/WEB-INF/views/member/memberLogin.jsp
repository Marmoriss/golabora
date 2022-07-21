<%@page import="com.kh.golabora.member.model.dto.MemberRole"%>
<%@ page import="com.kh.golabora.member.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<script>
window.onload = () => {

<% if(msg != null) { %>	
	alert("<%= msg %>");
<% } %>

<% if(loginMember == null){ %>
	document.loginFrm.onsubmit = (e) => {
		
		const memberId = document.querySelector("#memberId");
		const password = document.querySelector("#password");
		
		if(!/^.{4,}$/.test(memberId.value)){
			alert("유효한 아이디를 입력해주세요.");
			memberId.select();
			return false;
		}
		
		if(!/^.{4,}$/.test(password.value)){
			alert("유효한 비밀번호를 입력해주세요.");
			password.select();
			return false;
		}
		
	};

<% } %>

};
</script>


<div id="login-container" class="login-container">
<h1>로그인</h1>
<% if(loginMember == null){ %>
	<!-- 로그인폼 시작 -->
	<form id="loginFrm" name="loginFrm" action="<%= request.getContextPath() %>/member/login" method="POST">
		<table>
			<tr>
				<td><input type="text" name="memberId" id="memberId" placeholder="아이디" tabindex="1" 
						value="<%= saveId != null ? saveId : "" %>"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password" placeholder="비밀번호" tabindex="2"></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="saveId" id="saveId" 
						<%= saveId != null ? "checked" : "" %> />
					<label for="saveId">아이디저장</label>			
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="지금시작하기" tabindex="3"></td>			
			</tr>
		</table>
	</form>
<% } else { %>		
	<table id="login">
			<tr>
				<td>
					<%= loginMember.getMemberName() %>님, 안녕하세요.
				</td>
			</tr>				
			<tr>
				<td>
					<input type="button" value="내정보보기" 
						onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/>
					<input type="button" value="로그아웃" 
						onclick="location.href='<%= request.getContextPath() %>/member/logout';"/>
				</td>
			</tr>
		</table>
	<% } %>	
	</div>		

<%@ include file="/WEB-INF/views/common/footer.jsp" %>