<%@page import="com.kh.golabora.contents.model.dto.ContentsInfo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.golabora.review.model.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review-style.css" />
<%
	List<Review> list = (List<Review>) request.getAttribute("list");
	String pagebar = (String) request.getAttribute("pagebar");
%>
<section id="review-list-container">
	<div id="admin-review-list">
		<h1>전체 리뷰</h1>
		<%
		if(list != null && ! list.isEmpty()){ 
				for(Review _review : list){
		%>
		<table class="tbl-admin-review-list">
			<tr>
				<td><%=_review.getMemberId()%></td>
				<td rowspan="4" class="review-content">
				<%
					if(_review.getReviewContent() != null){
				%>
					<%=_review.getReviewContent()%>
				<%} else{%>

				<% }%>
				</td>
				<td><%=new SimpleDateFormat("yy/MM/dd").format(_review.getRegDate())%></td>
			</tr>
			<tr>
				<td>⭐<%=_review.getStar()%></td>
				<td rowspan="2">
		<%
		boolean canEdit = loginMember != null
				&& loginMember.getMemberRole() == MemberRole.A;

			if (canEdit) {
			%>
				<!-- review del form -->
				<form 
					action="<%= request.getContextPath()%>/review/reviewDelete"
					method="POST"
					name="reviewDelFrm"
					onsubmit="return confirm('리뷰를 삭제하시겠습니까?');">
					<input type="hidden" name="reviewNo" value="<%= _review.getReviewNo() %>"/>
					<input type="submit" value="삭제">
				</form>
				
				<br />								
			<%
			}
			%>
				</td>
			</tr>
			<tr>

				<td rowspan="2">
					<div id="reviewChk">
						<a href="<%= request.getContextPath() %>/contents/detailView?no=<%= _review.getContentsNo() %>#review-list">이동</a>
					</div>
				</td>

			</tr>
			<tr>
				<td>
				</td>
			
			</tr>
			<%
				}
			} else {
			%>
			<table class="tbl-review-list">
			<tr>
				<td colspan="6">아직 리뷰가 없습니다.</td>
			</tr>
			</table>
			
			<%
			}
			%>
			
			</table>
	</div>
		
</section>
<div id='adminPagebar'>
		<%= request.getAttribute("pagebar") %>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>