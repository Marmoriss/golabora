<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.golabora.member.model.dto.Member"%>
<%@ page import="com.kh.golabora.contents.model.dto.PickedContentsExt"%>
<%@ page import="java.util.List"%>

<%
	Member loginMember = (Member) session.getAttribute("loginMember");
	String memberId = loginMember.getMemberId();
	String memberName = loginMember.getMemberName();
	
	List<PickedContentsExt> list = (List<PickedContentsExt>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배우 찜화면</title>
</head>

<body>
	<h2>배우 목록</h2>
		<input type="button" value="뒤로가기" id="btn-add" onclick="location.href='" />
			<div>
				<% if (list == null) {
				%> <h3>아직 찜한 배우가 없습니다.</h3>
					<input type="button" value="지금 찜하러 가기" id="btn-add" onclick="location.href='검색창" />
						
				<% } else {
						for (PickedContentsExt a : list) {
				%>
								<div class="picked-Contents-info">
									<span><%=a.getContentsTitle()%></span>
								</div>
				<% }} %>
			</div>
			
<script>

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>