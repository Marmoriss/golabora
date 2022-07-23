<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/statistics-style.css" />
<%
Map<String, Integer> param = (Map<String, Integer>)request.getAttribute("param");

%>
<section id="statistics-container">
    <div id="statistics-Info">
        <h2>통계 관리</h2>
    </div>
    <div id="subscribers-by-date-header">
        <h3>날짜별 가입자 수</h3>
    </div>
    <div class="vertical_chart_box">
        <div class="chart_box">
		    <ul class="axis_y">
				<li class="item">0</li>
				<li class="item">5</li>
				<li class="item">10</li>
				<li class="item">15</li>
				<li class="item">20</li>
		    </ul>
		    <ul class="axis_x">
		    <% for(Entry<String, Integer> entrySet : param.entrySet()) {
		        String date = entrySet.getKey();
		        int count = entrySet.getValue();
	        %>
				<li class="item">
					<div class="text_box">
						<strong class="date"><%= date %></strong>
						<span class="count"><%= count %>명</span>
					</div>
					<button type="button" class="graph">
	                    <span class="count data1" style="height:<%= count * 5 %>%;"></span>
					</button>
				</li>
	        <% } %>
		    </ul>
        </div>                                                 
	</div>
</section>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>