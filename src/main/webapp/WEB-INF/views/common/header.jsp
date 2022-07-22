<%@page import="com.kh.golabora.member.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String) session.getAttribute("msg");
	System.out.println("msg@jsp = " + msg);
	if(msg != null) session.removeAttribute("msg"); // 한번만 사용후 제거
	Member loginMember = (Member) session.getAttribute("loginMember"); 
	
	String saveId = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null)
		for(Cookie c : cookies){
			String name = c.getName();
			String value = c.getValue();
			System.out.println("[cookie] " + name + " = " + value);
			if("saveId".equals(name)){
				saveId = value;
			}
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GOLABORA</title>
<script src="https://kit.fontawesome.com/f0183e40db.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
</head>
<body>
	<div id="container">
		<header>
			<a href="<%= request.getContextPath() %>/index.jsp"><h1>GOLABORA</h1></a>
		</header>