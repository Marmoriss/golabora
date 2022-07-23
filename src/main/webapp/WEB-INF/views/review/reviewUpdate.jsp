<%@page import="com.kh.golabora.review.model.dto.Review"%>
<%@page import="com.kh.golabora.contents.model.dto.Contents" %>
<%@page import="com.kh.golabora.contents.model.dto.ContentsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>   
<%
Review review = (Review)request.getAttribute("review");
String contentsNo = (String)request.getAttribute("contentsNo");
List<ContentsInfo> list = (List<ContentsInfo>) request.getAttribute("contentsInfo");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review-style.css" />
<section id="review-enroll-container">
	<div class="back-btn">
      		<a href="javascript:history.back();">
      			<i class="fa-solid fa-angle-left"></i>
      		</a>
      	</div>
	<div class="review-editor">
      	<div class="contents-info">
      	<%
	 		int firstIndex = 0;
	 		ContentsInfo contentsInfo = list.get(firstIndex);
 		%>

      		<img src="<%= request.getContextPath() %>/images/<%= contentsInfo.getOriginalFilename() %>" alt="<%= contentsInfo.getContentsTitle() %>" />
      		<p><%= contentsInfo.getContentsTitle() %></p>
      		<span><%= contentsInfo.getReleaseDate() %> | <%= contentsInfo.getGenreName() %> </span>

      	</div>
      	
      	<div class="review-update">
      		<h1>이 영화는 어떠셨나요?</h1> 
			<form
			name="reviewUpdateFrm"
			action="<%=request.getContextPath() %>/review/reviewUpdate" 
			method="post">
				<input type="hidden" name="reviewNo" value="<%=review.getReviewNo()%>" />
		        <input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
		        <input type="hidden" name="contentsNo" value="<%= contentsInfo.getContentsNo() %>" />
		        <!-- 별점 -->
		            <div class="star-rating">
					  <input type="radio" id="5-stars" name="star" value="5" />
					  <label for="5-stars" class="star">&#9733;</label>
					  <input type="radio" id="4-stars" name="star" value="4" />
					  <label for="4-stars" class="star">&#9733;</label>
					  <input type="radio" id="3-stars" name="star" value="3" />
					  <label for="3-stars" class="star">&#9733;</label>
					  <input type="radio" id="2-stars" name="star" value="2" />
					  <label for="2-stars" class="star">&#9733;</label>
					  <input type="radio" id="1-star" name="star" value="1" />
					  <label for="1-star" class="star">&#9733;</label>
					  <input type="radio" id="0-star" name="star" value= "0" />
					</div> 
				<!-- 작성내용 -->
					<div class="update-content">
		           		<textarea name="reviewContent" cols="60" rows="10" placeholder="작품에 대한 감상을 짧게 남겨주세요 (150자 이내)"></textarea>
		            </div>
		            <button type="submit" id="btn-review-update">리뷰 수정</button>
		            
		     </form>
     	</div>
     </div>
</section>
<script>
/**
* reviewEnrollFrm 유효성 검사
*/
document.reviewUpdateFrm.onsubmit = (e) => {
	const frm = e.target;
	//별점만 필수
	if(frm.star.value=="0"){
		alert("별점을 등록해주세요");
		frm.star.focus();
		e.preventDefault();
		return false;
	}

	return true;
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>