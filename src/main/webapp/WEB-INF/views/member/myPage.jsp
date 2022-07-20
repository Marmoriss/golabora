<%@page import="com.kh.golabora.member.model.dto.MemberRole"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<section id="mypage-container">
<div class="mypage-header">
	<h3>GOLABORA</h3>
</div>

<div class="mypage-list">
		<span><%= loginMember.getMemberName() %></span>
		
		<%-- 일반회원용 메뉴 --%>
		
		
		<% if(loginMember != null && loginMember.getMemberRole() == MemberRole.U){%>
		<p>일반회원</p>
		
		<ul class="mypage-nav">
			<li class="member-view"><a href="#">나의 정보 보기</a></li>
			<!-- 이게 메인이어서 바로 보이게 해주시면될거같아여 -->
			<li class="member-picked"><a href="#">나의 찜 목록 보기</a></li>
			<li class="member-playlist"><a href="#">나의 플레이리스트 보기</a></li>
			<li class="member-review"><a href="<%= request.getContextPath() %>/member/memberReview">나의 리뷰 보기</a></li>
		</ul>
		<%} %>
		
		<%-- 관리자용 메뉴 --%>
		<% if(loginMember != null && loginMember.getMemberRole() == MemberRole.A){%>
		<p>관리자</p>
		
		<ul class="admin-nav">
			<li class="admin-statistics"><a href="#">통계 관리</a></li>
			<li class="admin-contents"><a href="<%= request.getContextPath() %>/contents/contentsInsert">콘텐츠 관리</a></li>
			<li class="admin-member"><a href="#">회원 관리</a></li>
			<li class="admin-reported"><a href="#">신고 관리</a></li>
		</ul>
		<%} %>
</div>
</section>
