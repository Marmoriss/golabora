<%@page import="com.kh.golabora.member.model.dto.Gender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String memberId = loginMember.getMemberId();
	String memberName = loginMember.getMemberName();
	String phone = loginMember.getPhone();
	String gender = loginMember.getGender() != null ? loginMember.getGender().name() : "";
	String genre = loginMember.getGenreCode();

	
	
	
%>
<section id=enroll-container>
	<h2>회원 정보</h2>
	<form 
		name="memberUpdateFrm"
		action="<%=request.getContextPath() %>/member/memberUpdate" 
		method="post">
		<table>
			<tr>
				<th>아이디<sup>*</sup></th>
				<td>
					<input type="text" name="memberId" id="memberId" value="<%= memberId %>" readonly>
				</td>
			</tr>
			<tr>
				<th>이름<sup>*</sup></th>
				<td>	
				<input type="text"  name="memberName" id="memberName" value="<%= memberName %>"  required><br>
				</td>
			</tr>		
			<tr>
				<th>휴대폰<sup>*</sup></th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%= phone %>" required><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
			       		 <input type="radio" name="gender" id="gender0" value="M" <%= "M".equals(gender) ? "checked" : "" %>>
						 <label for="gender0">남</label>
						 <input type="radio" name="gender" id="gender1" value="F" <%= "F".equals(gender) ? "checked" : "" %>>
						 <label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>최애장르 </th>
				<td>
				
				</td>
			</tr>
		</table>
        <input type="submit" value="정보수정"/>
        <input type="button" value="비밀번호변경" onclick="updatePassword();" />
        <input type="button" onclick="deleteMember();" value="탈퇴"/>
	</form>
</section>
<!-- 회원탈퇴폼 : POST /member/memberDelete 전송을 위해 시각화되지 않는 폼태그 이용 -->
<form name="memberDelFrm" action="<%= request.getContextPath() %>/member/memberDelete" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
</form>

<script>
const updatePassword = () => {
	location.href = "<%= request.getContextPath() %>/member/passwordUpdate";
};


/**
 * POST /member/memberDelete
 * memberDelFrm 제출
 */
const deleteMember = () => {
	if(confirm("정말로 탈퇴하시겠습니까?"))
		document.memberDelFrm.submit();
};

/**
 * 폼 유효성 검사
 */
document.memberUpdateFrm.onsubmit = (e) => {
	
	const memberName = document.querySelector("#memberName");
	if(!/^[가-힣]{2,}$/.test(memberName.value)){
		alert("한글 2글자이상 입력해주세요");
		memberName.select();
		return false;
	}
	
	const phone = document.querySelector("#phone");
	if(!/^010[0-9]{8}$/.test(phone.value)){
		alert("유효한 전화번호를 입력해주세요");
		phone.select();
		return false;
	}
	
}
</script>
<%!
/**
* compile시 메소드로 선언처리됨.
* 선언위치는 어디든 상관없다.
*/ 

%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
