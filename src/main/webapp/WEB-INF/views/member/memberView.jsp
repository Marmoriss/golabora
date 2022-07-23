<%@page import="com.kh.golabora.member.model.dto.Gender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member-view-style.css" />
<%
    String memberId = loginMember.getMemberId();
    String memberName = loginMember.getMemberName();
    String phone = loginMember.getPhone();
    String gender = loginMember.getGender() != null ? loginMember.getGender().name() : "";
    String genreCode = loginMember.getGenreCode();

    
    
    
%>
<div id=enroll-container>
    <div id="userInfo">
        <h2>회원 정보</h2>
    </div>
    <form id="memberUpdateFrm"
        name="memberUpdateFrm"
        action="<%=request.getContextPath() %>/member/memberUpdate" 
        method="post">
        <div id="user-id">
            <h3 class="update_title">
                <label for="memberId">아이디</label>
            </h3>
            <input type="text" name="memberId" id="memberId" value="<%= memberId %>" readonly>
        </div>
        <div id="user-name">
            <h3 class="update_title">
                <label for="memberName">이름</label>
            </h3>
            <input type="text"  name="memberName" id="memberName" value="<%= memberName %>"  required><br>
        </div>
        <div id="user-phone">
            <h3 class="update_title">
                <label for="phone">전화번호</label>
            </h3>   
            <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%= phone %>" required><br>
        </div>
        <div id="user-gender">
            <h3 class="update_title">
                <label for="gender0">성별</label>
            </h3>   
            <input type="radio" name="gender" id="gender0" value="M" <%= "M".equals(gender) ? "checked" : "" %>>
            <label id="gen0" for="gender0">남</label>
            <input type="radio" name="gender" id="gender1" value="F" <%= "F".equals(gender) ? "checked" : "" %>>
            <label for="gender1">여</label>
        </div>
        <div id="user-genre">
            <h3 class="join_title">
                <label for="genreCode">최애 장르</label>
            </h3>   
            <select id="genreCode" name="genreCode"  >
                <option value="G1" <%= "G1".equals(genreCode) ? "selected" : "" %>>액션</option>
                <option value="G2" <%= "G2".equals(genreCode) ? "selected" : "" %>>드라마</option>
                <option value="G3" <%= "G3".equals(genreCode) ? "selected" : "" %>>로맨스</option>
                <option value="G4" <%= "G4".equals(genreCode) ? "selected" : "" %>>코미디</option>
                <option value="G5" <%= "G5".equals(genreCode) ? "selected" : "" %>>스릴러</option>
                <option value="G6" <%= "G6".equals(genreCode) ? "selected" : "" %>>호러</option>
                <option value="G7" <%= "G7".equals(genreCode) ? "selected" : "" %>>판타지</option>                     
                <option value="G8" <%= "G8".equals(genreCode) ? "selected" : "" %>>다큐</option>                      
            </select>   
        </div>
        <div id="btns">
            <input type="submit" value="정보수정"/>
            <input type="button" value="비밀번호변경" onclick="updatePassword();" />
            <input type="button" onclick="deleteMember();" value="탈퇴"/>
        </div>
    </form>
</div>
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
    location.href = "<%= request.getContextPath() %>/member/memberDelete";
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

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
