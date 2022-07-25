<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<section id="loading-page">
	<div>
		<span>"당신이 찾는 영화 여기서 다 GOLABORA !"</span>
		<h1>loading...</h1>
	</div>
</section>
<script>
window.onload = function () {
	 document.indexFrm.submit();
	}
</script>
<form action="<%= request.getContextPath() %>/mainNet" method="get" name="indexFrm">
	<input type="hidden">
	<input type="hidden" name="genreCode" value="<%=loginMember != null ? loginMember.getGenreCode() : ""%>" />
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>