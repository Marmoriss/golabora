<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ page import="com.kh.golabora.member.model.dto.Member"%>
	<%@ page import="com.kh.golabora.contents.model.dto.PickedContents"%>

	<%@page import="java.util.List"%>
    
<%
	Member loginMember = (Member) session.getAttribute("loginMember"); 
	String memberId = loginMember.getMemberId();
	String memberName = loginMember.getMemberName();
	
	List<PickedContents> list = (List<PickedContents>) request.getAttribute("list");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜화면</title>
</head>
<body>
<h2>콘텐츠 목록</h2>

	<input type="button" value="글쓰기" id="btn-add" onclick="location.href='"/>
	
	<table id="tbl-board">
	
			<h3><%= memberId %></h3>
			<h3><%= memberName %></h3>
	
		<tr>
		<%
		// if(){ 찜목록이 없다면
		%>
		<%
		for(PickedContents c : list){
			if(memberId.contentEquals(c.getMemberId())){
		%>
		<ul>
			<li>
				<div class="main-recommend-img">
				<img src="<%= request.getContextPath() %>/images/<%= c.getOriginalFilename() %>" alt="<%= c.getContentsTitle() %>" />
				</div>
				<div class="main-recommend-title">
					<span><%= c.getMemberId() %></span>
					</div>
			</li>
		</ul>
		<%	
				}
			}
		%>
		</tr>
	</table>

</body>
</html>