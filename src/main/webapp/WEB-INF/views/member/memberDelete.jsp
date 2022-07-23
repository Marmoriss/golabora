<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
	<div id=delete-container>
	<header>회원정보</header>
	<p>GolaBora 웹사이트에서 회원님의 계정이 삭제됩니다.<br/>
	   탈퇴시 개인정보 및 이용정보가 삭제되며 복구할 수 없습니다.<br/>
	   본인의 비밀번호를 입력한 후 유의사항 동의에 체크하세요.
	</p>
	<form 
		name="memberDeleteFrm" 
		action="<%=request.getContextPath()%>/member/memberDelete" 
		method="post">
		<div>
		<input type="checkbox" name="memberId" id="memberId" value="<%= loginMember.getMemberId() %>"><label for="memberId">유의사항 동의</label>
		</div>
		<div class="password">
		<h3 class="delete_title">
                     <label for="password">비밀번호</label>
                 </h3>
		<input type="password" id="password" name="password" required><br>
		</div>

			<input type="submit"  value="회원 탈퇴" />
	

	</form>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	