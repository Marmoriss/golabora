<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.golabora.member.model.dto.Member"%>
<%@ page import="com.kh.golabora.contents.model.dto.PickedProducerExt"%>
<%@ page import="java.util.List"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/picked.css" />

<%
	Member loginMember = (Member) session.getAttribute("loginMember"); 
	String memberId = loginMember.getMemberId();
	String memberName = loginMember.getMemberName();
	
	List<PickedProducerExt> list = (List<PickedProducerExt>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감독 찜화면</title>
</head>

<body>
	<h2>감독 목록</h2>
		<input type="button" value="뒤로 가기" id="btn-add" onclick="location.href='"/>
		<% if (list == null) {
			%> <h3>아직 찜한 감독이 없습니다</h3>
				<input type="button" value="지금 찜하러 가기" id="btn-add" onclick="location.href='검색창" />
		<% } else { %>
			<table>
			<%	for(PickedProducerExt p : list){
				if(memberId.contentEquals(p.getMemberId())){
			%>
					<tr class="picked-producer-info">
						<td><%= p.getProducerName() %></td>
						<td><%= p.getGender() %></td>
					</tr>
		<% }}} %>
</table>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>