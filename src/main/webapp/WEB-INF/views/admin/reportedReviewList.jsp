<%@page import="com.kh.golabora.review.model.dto.ReportedYn"%>
<%@page import="com.kh.golabora.review.model.dto.DeletedReview"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kh.golabora.review.model.dto.ReportedReview"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reported-review-style.css" />
<%
List<ReportedReview> list = (List<ReportedReview>) request.getAttribute("list");
List<DeletedReview> deletedList = (List<DeletedReview>) request.getAttribute("deletedList");
int todayReportCount = (Integer) request.getAttribute("todayReportCount");
String pagebar = (String) request.getAttribute("pagebar");
%>

<section id="reportedReview-container">
    <div id="reportedReview-Info">
	    <h2>신고 관리</h2>
    </div>
    <div id="repo-review-count">
        <h3>금일 신고 리뷰 | <%= todayReportCount %>건</h3>
        <h3>처리 중인 신고 리뷰 | </h3>
    </div>
    <form id="repoReviewDelete" name="repoReviewDelete" action="<%= request.getContextPath() %>/admin/reviewDelete" method="POST">
	    <input type="hidden" name="deleteReviews" value="deleteCeck"/>
	    <button type="submit" id="delete-btn">삭제</button>
	    <div id="table-wrap">
		    <table id="repo-review-board">
		        <tr>
		            <th></th>
		        	<th>번호</th>
		        	<th>리뷰 번호</th>
		        	<th>신고자 아이디</th>
		        	<th>신고일</th>
		        	<th>신고 사유</th>
		        	<th>처리 여부</th>
		        </tr>
		        <tr>
		        <% if(list == null || list.isEmpty()){ %>
		        <tr>
		            <td colspan="5" align="center">조회된 신고 리뷰가 없습니다.</td>
		        </tr>
		        <% } else {
		        	for(ReportedReview repoReview : list){
		        %>
		        <tr>
		            <td><input type="checkbox" name="repoReviewNo" class="deleteCheck" value="<%= repoReview.getReportedReviewNo() %>"/></td>
		            <td><%= repoReview.getReportedReviewNo() %></td>
		            <td><%= repoReview.getReviewNo() %></td>
		            <td><%= repoReview.getReporterId() %></td>
		            <td><%= new SimpleDateFormat("yyyy-MM-dd hh:mm").format(repoReview.getReportedDate()) %></td>
		            <td><%= repoReview.getReason() %></td>
	<!-- 	            삭제 리뷰 테이블과 비교해서 삭제됐으면 삭제, 아니면 처리 중으로 -->
                    <% if( deletedList.contains(repoReview.getReviewNo())) {%>
                    <td class="processing">삭제 완료</td>
                    <% } else { %>
                    <td class="processing">처리 중</td>
                    <% } %>
		        </tr>
		        <%
		           
		            }
		        }
		        %>
		    </table>
	    </div>
    </form>
    <div id="pagebar"><%= pagebar %></div>
<script>
window.addEventListener('load', (e) => {
	const processing = document.querySelectorAll(".processing");
	let count = 0;
	processing.forEach((ch, index) => {
		if(ch.innerHTML == '처리 중'){
			count++;
			console.log(ch.innerHTML, count);
		}
	})
	
	document.querySelector('#repo-review-count').firstElementChild.nextElementSibling.innerHTML += count + '건';
});



</script>
</section>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>