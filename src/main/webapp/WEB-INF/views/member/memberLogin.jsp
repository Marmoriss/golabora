<%@page import="com.kh.golabora.member.model.dto.MemberRole"%>
<%@ page import="com.kh.golabora.member.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
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
<header>로그인</header>
<% if(loginMember == null){ %>
	<!-- 로그인폼 시작 -->
	<form class="loginFrm" id="loginFrm" name="loginFrm" action="<%= request.getContextPath() %>/member/login" method="POST">
		<table class = "tb">
		
			<tr>
				<td><input type="text" class="logbtn1" name="memberId" id="memberId" placeholder="아이디" tabindex="1" 
						value="<%= saveId != null ? saveId : "" %>"></td>
			</tr>
			<tr>
				<td><input class="logbtn2"type="password" name="password" id="password" placeholder="비밀번호" tabindex="2"></td>
				<td></td>
			</tr>
			<tr>
				<td id="saveId-wrap">
					<input class="logbtn3" type="checkbox" name="saveId" id="saveId" 
						<%= saveId != null ? "checked" : "" %> />
					<label for="saveId">아이디저장</label>			
				</td>
			</tr>
			<tr>
				<td><input class="logbtn4" type="submit" value="지금시작하기" tabindex="3"></td>			
			</tr>
		
		</table>
	</form>
<% } else { %>		
	<div id="login">
			<div>
			
					<h3><%= loginMember.getMemberName() %>님, 안녕하세요.</h3>
			</div>
			<div>
					<input type="button" value="내정보보기" 
						onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/>
					<input class="btn2"type="button" value="로그아웃" 
						onclick="location.href='<%= request.getContextPath() %>/member/logout';"/>
			</div>
		</div>
	<% } %>	
	</div>		

<%@ include file="/WEB-INF/views/common/footer.jsp" %>