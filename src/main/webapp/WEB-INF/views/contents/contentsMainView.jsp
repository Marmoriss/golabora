<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<<<<<<< HEAD
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contents-style.css" />
<section id="admin-contents-edit">
<div class="contents-edit-header">
	<h3>GOLABORA</h3>
</div>
<div class="contents-edit-list">
<ul id="contents-edit-nav">		
	<li class="contents-enroll"><a href="<%= request.getContextPath() %>/contents/contentsInsert">영화등록</a></li>		
	<li class="contents-edit"><a href="<%= request.getContextPath() %>/contents/contentsUpdate">영화수정</a></li>
	<li class="contents-del"><a href="<%= request.getContextPath() %>/contents/contentsDelete">영화삭제</a></li>
</ul>	
</div>
</section>