<%@page import="com.kh.golabora.review.model.dto.Review"%>
<%@page import="com.kh.golabora.contents.model.dto.Contents" %>
<%@page import="com.kh.golabora.contents.model.dto.ContentsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>   
<%
	String contentsNo = (String)request.getAttribute("contentsNo");
	List<ContentsInfo> list = (List<ContentsInfo>) request.getAttribute("contentsInfo");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review-style.css" />
<section id="review-enroll-container">
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
      	
      	<div class="review-enroll">
      		<h1>이 영화는 어떠셨나요?</h1>
			<form
			name="reviewEnrollFrm"
			action="<%=request.getContextPath() %>/review/reviewEnroll" 
			method="post">
		           
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
					  <input type="radio" id="1-star" name="star" value= "1" />
					  <label for="1-star" class="star">&#9733;</label>
					</div> 
				<!-- 작성내용 -->
					<div class="enroll-content">
		           		<textarea name="reviewContent" cols="60" rows="10" placeholder="작품에 대한 감상을 짧게 남겨주세요 (150자 이내)"></textarea>
		            </div>
		            <button type="submit" id="btn-review-enroll1">리뷰 등록</button>
		     </form>
     	</div>
     </div>
</section>
<script>
/**
* reviewEnrollFrm 유효성 검사
*/
document.reviewEnrollFrm.onsubmit = (e) => {
	const frm = e.target;
	//별점만 필수
	if(!/^.+$/.test(frm.star.value)){
		alert("별점을 등록해주세요");
		frm.star.focus();
		e.preventDefault();
		return false;
	}

	return true;
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>