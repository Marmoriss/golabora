<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/contents/contentsMainView.jsp" %>
<section id="admin-contents-delete">
	<h1>✂ 영화 컨텐츠 삭제</h1>
	<div class="contents-container">
	<form action="<%=request.getContextPath()%>/contents/contentsDelete" 
	method="POST" 
	class="contentsDelete"
	onsubmit="return confirm('이 영화를 삭제하시겠습니까?');">
		<h3>영화제목</h3>
		<input type="text" name="contentsTitle" placeholder="제목을 정확히 입력해주세요"/>
		<br /><br /><br />
		
		<input type="submit" value="영화 삭제" />
	</div>
</section>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>