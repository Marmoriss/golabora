<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<section id="member-pick-list">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member-view-style.css" />

<div id=picked-container>
    <div id="userInfo">
        <h2>회원 정보</h2>
<div id="backgrd">
    <div id="pageno">
        <h2>나의 찜 목록</h2>
    </div>
    
        <div class ="picked_menu">
           	<li class="pcl"><a href="<%= request.getContextPath() %>/member/pickedContents">찜한 콘텐츠 보기</a></li>
			<li class="pal"><a href="<%= request.getContextPath() %>/member/pickedActor">찜한 배우 보기</a></li>
			<li class="ppl"><a href="<%= request.getContextPath() %>/member/pickedProducer">찜한 감독 보기</a></li>
        </div>
</div>

</div>


</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
