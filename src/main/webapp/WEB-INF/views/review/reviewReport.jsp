<%@page import="com.kh.golabora.review.model.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>   
<%
	Review reportReview = (Review) request.getAttribute("reportReview");
	String contentsNo = (String)request.getAttribute("contentsNo");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review-style.css" />
<section id="review-report-container">
	<div class="review-reporter">
	<h1>리뷰 신고</h1>
	<span>신고된 리뷰는 관리자 검토 후, 삭제될 수 있습니다.</span>
      	<div class="report-review-info">
    		<!-- 신고된 리뷰 내용 -->
     		<p><%= reportReview.getReviewContent() %></p>
      	</div>
      	
      	<div class="report-enroll">
      	<!-- 신고하면, 신고테이블로 값 전송 -->
      	<form 
   		name="reviewReportFrm"
   		action="<%= request.getContextPath()%>/review/reviewReport"
   		method="POST"
   		onsubmit="return confirm('🚨 리뷰를 정말 신고하시겠습니까? 리뷰신고 후에는 취소할 수 없습니다.');">
   		
   			<!-- 신고자 아이디 전송 -->
      		<input type="hidden" name="reporterId" value="<%= loginMember.getMemberId()%>" />
      		<!-- 신고 눌렀을 때, 신고할 리뷰번호 전송해주기 -->
      		<input type="hidden" name="reviewNo" value="<%= reportReview.getReviewNo()%>"/>
      		<input type="hidden" name="contentsNo" value="<%= contentsNo %>"/>
      		
      		<div class="report-reason">
      		<h2>🚨신고 사유를 선택해주세요🚨</h2>
      			<label><input type="radio" name="reason" value="스팸" checked/>스팸</label>
      			<label><input type="radio" name="reason" value="폭력적인 내용" />폭력적인 내용</label>
      			<label><input type="radio" name="reason" value="성적인 내용" />성적인 내용</label>
      			<label><input type="radio" name="reason" value="유해한 내용" />유해한 내용</label>
      		</div>
 			<input class="rep-btn" type="button" value="취소" onclick="history.go(-1)"> 
      		<input class="rep-btn" type="submit" value="신고하기" >
      	</form>
      	</div>
      </div>
</section>
<script>

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>