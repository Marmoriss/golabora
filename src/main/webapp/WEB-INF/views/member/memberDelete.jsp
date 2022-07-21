<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<section id=enroll-container>
	<h2>회원정보</h2>
	<p>GolaBora 웹사이트에서 회원님의 계정이 삭제됩니다.<br/>
	   탈퇴시 개인정보 및 이용정보가 삭제되며 복구할 수 없습니다.<br/>
	   본인의 비밀번호를 입력한 후 유의사항 동의에 체크하세요.
	</p>
	<form 
		name="memberDeleteFrm" 
		action="<%=request.getContextPath()%>/member/memberDelete" 
		method="post">
		<table>
			<tr>			
				<td>	
				<input type="checkbox" name="memberId" id="memberId" value="<%= loginMember.getMemberId() %>"><label for="memberId">유의사항 동의</label>
				</td>			
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>	
					<input type="password" id="password" name="password" required><br>
				</td>
			</tr>
			<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit"  value="회원 탈퇴" />
					</td>
				</tr>
			
		</table>
	</form>
	</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	