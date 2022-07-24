<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kh.golabora.member.model.dto.MemberRole"%>
<%@page import="com.kh.golabora.review.model.dto.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.golabora.contents.model.dto.ContentsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contents-detialView.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review-style.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
<%
List<ContentsInfo> list = (List<ContentsInfo>) request.getAttribute("detailPage");
String contentsNo = (String) request.getAttribute("contentsNo");
List<String> ottNames = (List<String>) request.getAttribute("ottNames");
List<Review> reviewList = (List<Review>) request.getAttribute("reviewList");
%>
<%
// 한 영화에 여러 배우가 들어있기때문에 배우만 리스트로 분리해서 사용, 이외의 정보는 모두 동일함(0번지 정보 사용)
int firstIndex = 0;
ContentsInfo contentsInfo = list.get(firstIndex);

List<String> actors = new ArrayList<>();
for(ContentsInfo contents : list){
	actors.add(contents.getActorName());
}
%>

<div id="btn-back">
    <i class="fa-solid fa-angle-left"></i>
</div>
<div id="contents-info-wrap">
    <div id="contents-img">
        <img src="<%= request.getContextPath() %>/images/<%= contentsInfo.getOriginalFilename() %>" alt="<%= contentsInfo.getContentsTitle() %>" />
    </div>
    <div id="contents-info">
	    <div id="titleAndOtt">
	        <div id="contents-title">
	            <h3><%= contentsInfo.getContentsTitle() %> (<%= contentsInfo.getReleaseDate() %>)</h3>
	        </div>
	        <div id="contents-ott">
	        <% for(String ottName : ottNames) {%>
                <img src="<%= request.getContextPath() %>/images/<%= ottName %>.png" alt="<%= ottName %>" />
            <% } %>
            </div>
	    </div>
	    <div id="contents-star">
            <i class="fa-solid fa-star"></i>
            <p>5.0 | <%= contentsInfo.getGenreName() %></p>
        </div>
        <div id="contents-plot">
            <%= contentsInfo.getContentsPlot() %>
        </div>
    </div>
    
    <div id="buttons">
        <div>
            <input type="checkbox" name="watched-contents" id="watched-contents" value=""/>
            <label for="watched-contents" id="watched-contents-label">
                <i class="fa-solid fa-check"></i>
                봤어요
            </label>
        </div>
        <div>
            <input type="checkbox" name="picked-contents" id="picked-contents" value=""/ onchange="pickedContentsChange();" >
            <label for="picked-contents" id="picked-contents-label">
                <i class="fa-regular fa-thumbs-up"></i>
                찜하기
            </label>
        </div>
    </div>
</div>
<div id="picked-wrap">
    <h3>감독 / 출연진</h3>
    <div id="contents-producer">
        <div id="producer-info">
            <i class="fa-solid fa-circle-user"></i>
            <h4><%= contentsInfo.getProducerName() %></h4>
        </div>
    </div>
    <div id="contents-actor">
        <div id="actor-info-wrap">
        <!-- 반복문 필요 -->
        <%
        for(String actorName : actors){
        %>
            <div class="actor-info">
	            <i class="fa-solid fa-circle-user"></i>
	            <h4><%= actorName %></h4>
            </div>
        <% } %>
        </div>
    </div>
</div>

<hr />
<!-- 수아님 여기 밑으로 붙여주시면 됩니당~!~! -->
<section id="review-container">
	
	<h1>내 리뷰 작성하기</h1>
	<!-- 리뷰 작성하기  -->
	<div id="my-review">
		<!-- 리뷰정보 전송 폼 -->
		<form name="reviewEnrollInfoFrm" 
			action="<%=request.getContextPath()%>/review/reviewEnroll" 
			method="GET">
			<input type="hidden" name="contentsNo" value="<%= contentsInfo.getContentsNo() %>"/>      
			<button>지금 리뷰 작성하러 가기</button>
		</form>
		
	</div>	
		
	<h1>모든 리뷰</h1>
		
		
	<div id="review-list">
		
		<%
		if(reviewList != null && ! reviewList.isEmpty()){ 
				for(Review _review : reviewList){
		%>
		<table class="tbl-review-list">
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
				&& (loginMember.getMemberId().equals(_review.getMemberId()) || loginMember.getMemberRole() == MemberRole.A);

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
				<!-- review update form -->
				<form action="<%= request.getContextPath()%>/review/reviewUpdate"
					  method="GET"
					  name="reviewUpdateFrm"
					  onsubmit="return confirm('리뷰를 수정하시겠습니까?');">
					<input type="hidden" name="contentsNo" value="<%= contentsInfo.getContentsNo() %>" />
					<input type="hidden" name="reviewNo" value="<%=_review.getReviewNo() %>" />
					<input type="submit" value="수정">
				</form>
				
				
			<%
			}
			%>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
				<%-- 로그인 상태고, 본인리뷰가 아니거나 관리자일때만 신고가능 --%>
			<%
			boolean canReport = loginMember != null
				&& (!loginMember.getMemberId().equals(_review.getMemberId()) || loginMember.getMemberRole() == MemberRole.A);

			if (canReport) {
			%>
				<!-- review report form -->
				<form action="<%= request.getContextPath()%>/review/reviewReport"
					  method="GET"
					  name="reviewRepFrm"
					  onsubmit="return confirm('이 리뷰를 신고하시겠습니까?');">
			 		<input type="hidden" name="contentsNo" value="<%= contentsInfo.getContentsNo() %>" />
			 		<input type="hidden" name="reviewNo" value="<%= _review.getReviewNo() %>" />
					<input type="submit" value="신고 🚨" />
				</form>
				<%} %>
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
<div id='pagebar'>
		<%= request.getAttribute("pagebar") %>
</div>


<%if(loginMember != null){  %>
	<form name="addConFrm" action="<%= request.getContextPath() %>/member/pickedContentsAdd" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
	<input type="hidden" name="contentsNo" value="<%= contentsInfo.getContentsNo() %>" />
	</form>
	<form name="delConFrm" action="<%= request.getContextPath() %>/member/pickedContentsDel" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
	<input type="hidden" name="contentsNo" value="<%= contentsInfo.getContentsNo() %>" />
	</form>
<% } %> 

<%if(loginMember != null){  %>
	<form name="addProFrm" action="<%= request.getContextPath() %>/member/pickedProducerAdd" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
	<input type="hidden" name="producerName" value="<%= contentsInfo.getProducerName() %>" />
	</form>
	<form name="delProFrm" action="<%= request.getContextPath() %>/member/pickedProducerDel" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
	<input type="hidden" name="producerName" value="<%= contentsInfo.getProducerName() %>" />
	</form>
<% } %>

<%if(loginMember != null){  %>
	<form name="addActorFrm" action="<%= request.getContextPath() %>/member/pickedActorAdd" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
	<input type="hidden" name="actorName" id="actorName" value="" />
	<form name="delActorFrm" action="<%= request.getContextPath() %>/member/pickedActorDel" method="POST">
	<input type="hidden" name="memberId" value="<%= loginMember.getMemberId() %>" />
	<input type="hidden" name="actorName" id="actorName" value="" />
	</form>
<% } %>

<script>

const pickedContentsChange = () => {
	if (document.querySelector('#picked-contents').getAttribute("checked")) {
		document.addConFrm.submit();	
	}else {
		document.delConFrm.submit();
	}
};

const pickedProducerChange = () => {
	if(document.querySelector('#producer-info i').className == 'fa-solid fa-heart'){		
		document.addProFrm.submit();
	}
	else{
		document.delProFrm.submit();
	}
};


const pickedActorChange = () => {
	if(document.querySelector('.actor-info i').className == 'fa-solid fa-heart'){		
		document.addActorFrm.submit();
	}
	else{
		document.delActorFrm.submit();
	}
};


// 뒤로가기 버튼
document.querySelector('#btn-back').addEventListener('click', () => {
	window.history.back();
});

// 감독 프로필 눌렀을 때 찜 날리기(프로필 하트로 변경)

document.querySelector('#producer-info i').addEventListener('click', (e) => {
    if(e.target.className == 'fa-solid fa-circle-user'){
		e.target.className = 'fa-solid fa-heart';
		e.target.style.color = '#cda0fe';
	    alert('찜 목록에 추가되었습니다.');
	    pickedProducerChange();
    } else {
    	e.target.className = 'fa-solid fa-circle-user';
        e.target.style.color = '';
        alert('찜 목록에서 제거되었습니다.');
    }
});

// 배우 프로필 눌렀을 때 찜 날리기(프로필 하트로 변경)
$(".actor-info i").click((e) => {
	if(e.target.className == 'fa-solid fa-circle-user'){
        e.target.className = 'fa-solid fa-heart';
        e.target.style.color = '#cda0fe';
        var b = $("e.target").closest("h4");
    } else {
        e.target.className = 'fa-solid fa-circle-user';
        e.target.style.color = '';
        alert('찜 목록에서 제거되었습니다.');
    }
});



//로그인 안 한 사용자 폼 제출 막기
document.addEventListener('submit', (e) => {
	
	if(e.target.matches("form[name=reviewEnrollInfoFrm]")){
		if(<%= loginMember == null %>){
			loginAlert();
			e.preventDefault();
			return; 
		}
		
	}
	
});

document.addEventListener('submit', (e) => {
	
	if(e.target.matches("form[name=reviewRepFrm]")){
		if(<%= loginMember == null %>){
			loginAlert();
			e.preventDefault();
			return; 
		}
		
	}
	
});

//로그인 alert
const loginAlert = () => {
	alert("로그인 후 이용할 수 있습니다.");
};
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>