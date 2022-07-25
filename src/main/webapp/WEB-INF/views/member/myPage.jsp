<%@page import="com.kh.golabora.member.model.dto.MemberRole"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage-style.css" />

<section id="mypage-container">

<div class="mypage-header">
	<h3>GOLABORA</h3>
</div>

<div class="mypage-list">
    <div id="user-wrap">
		<i class="fa-solid fa-circle-user"></i>
		<h3><%= loginMember.getMemberName() %></h3>
		
		<%-- 일반회원용 메뉴 --%>
		<% if(loginMember != null && loginMember.getMemberRole() == MemberRole.U){%>
		<p>일반회원</p>
    </div>
    <div class="line"></div>
	<ul id="mypage-nav">
		<li class="member-view"><a href="<%= request.getContextPath() %>/member/memberView">나의 정보 보기</a></li>
		<!-- 이게 메인이어서 바로 보이게 해주시면될거같아여 -->
		<li class="member-picked"><a href="<%= request.getContextPath() %>/member/pickedList">나의 찜 목록 보기</a></li>
		<li class="member-playlist"><a href="#">나의 플레이리스트</a></li>
		<li class="member-review"><a href="<%= request.getContextPath() %>/member/memberReview?memberId=<%= loginMember.getMemberId() != null ? loginMember.getMemberId() : ""%>">나의 리뷰 보기</a></li>
	</ul>
	<%} %>
	
	<%-- 관리자용 메뉴 --%>
	<% if(loginMember != null && loginMember.getMemberRole() == MemberRole.A){%>
		<p>관리자</p>
    </div>
	<div class="line"></div>
	<ul id="admin-nav">
		<li class="admin-statistics"><a href="<%= request.getContextPath() %>/admin/statisticsList">통계 관리</a></li>
		<li class="admin-contents"><a href="<%= request.getContextPath() %>/contents/contentsInsert">콘텐츠 관리</a></li>
		<li class="admin-member"><a href="<%= request.getContextPath() %>/admin/memberList">회원 관리</a></li>
		<li class="admin-review"><a href="<%= request.getContextPath() %>/admin/review">리뷰 관리</a></li>
		<li class="admin-reported"><a href="<%= request.getContextPath() %>/admin/reportedReviewList">신고 관리</a></li>
	</ul>
	<%} %>

</section>
