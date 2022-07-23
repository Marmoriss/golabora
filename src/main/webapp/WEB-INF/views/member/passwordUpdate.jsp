<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
	<div id=pwUpdate-container>
		<header>비밀번호 변경</header>
		<form 
			name="passwordUpdateFrm" 
			action="<%=request.getContextPath()%>/member/passwordUpdate" 
			method="post" >
			<div>
			<h3 class="pwUpdate_title">
                <label for="oldPassword">현재 비밀번호</label>
            </h3>	
				<input type="password" name="oldPassword" id="oldPassword" required>
			</div>
			<div>
			<h3 class="pwUpdate_title">
                <label for="newPassword">변경 비밀번호</label>
            </h3>
				<input type="password" name="newPassword" id="newPassword" required>
			</div>
			<div>
			<h3 class="pwUpdate_title">
                <label for="newPasswordCheck">비밀번호 확인</label>
            </h3>	
				<input type="password" id="newPasswordCheck" required><br>
			</div>
				<input type="submit"  value="변경" />
				
				
			<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
		</form>
	</div>
	<script>
	/**
	 * 비밀번호 일치여부 검사
	 */
	document.querySelector("#newPasswordCheck").onblur = (e) => {
		const password = document.querySelector("#newPassword");
		const passwordCheck = e.target;
		if(password.value !== passwordCheck.value){
			alert("비밀번호가 일치하지 않습니다.");
			password.select();
		}
	};
	
	document.passwordUpdateFrm.onsubmit = (e) => {
		const oldPassword = document.querySelector("#oldPassword");
		const newPassword = document.querySelector("#newPassword");
		const re = /^[a-zA-Z0-9!@#$%^&*()]{4,}$/; 
		if(!re.test(oldPassword.value)){
			alert("비밀번호는 영문자/숫자/!@#$%^&*()로 최소 4글자이상이어야 합니다.");
			oldPassword.select();
			return false;
		}
		if(!re.test(newPassword.value)){
			alert("새 비밀번호는 영문자/숫자/!@#$%^&*()로 최소 4글자이상이어야 합니다.");
			newPassword.select();
			return false;
		}
		const newPasswordCheck = document.querySelector("#newPasswordCheck");
		if(newPassword.value !== newPasswordCheck.value){
			alert("비밀번호가 일치하지 않습니다.");
			newPassword.select();
			return false;
		}
	};
	
	</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
