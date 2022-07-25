<%@page import="com.kh.golabora.contents.model.dto.PickedProducerExt"%>
<%@page import="com.kh.golabora.contents.model.dto.PickedActorExt"%>
<%@page import="com.kh.golabora.contents.model.dto.PickedContentsExt"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/picked.css" />
<%
List<PickedContentsExt> pickedContentsList = (List<PickedContentsExt>) request.getAttribute("pickedContentsList");
List<PickedActorExt> pickedActorList = (List<PickedActorExt>) request.getAttribute("pickedActorList");
List<PickedProducerExt> pickedProducerList = (List<PickedProducerExt>) request.getAttribute("pickedProducerList");

%>
<section id="picked-list-wrap">
    <div id="picked-contents-title">
        <h3>내가 찜한 콘텐츠❤</h3>
    </div>
    <div id="picked-contents-wrap">
        <% if(pickedContentsList == null || pickedContentsList.isEmpty()) {%>
            <h3>내가 찜한 콘텐츠가 없습니다.</h3>
        <% } else { 
            for(PickedContentsExt pickedContents : pickedContentsList){%>
	            <div class="movieItem" >
	                <a href="<%= request.getContextPath() %>/contents/detailView?no=<%= pickedContents.getContentsNo() %>"
	                    title="<%= pickedContents.getContentsTitle() %>" style="display: block;">
	                    <div class="poster">
	                        <img src="<%= request.getContextPath() %>/images/<%= pickedContents.getOriginalFilename() %>" alt="<%= pickedContents.getContentsTitle() %>" />
	                    </div>
	                </a>
	                <div class="info">
	                    <div class="title"><%= pickedContents.getContentsTitle() %></div>
	                    <div class="rating">
	                        <div class="light-wrap">평점</div>
	                        <i id="button-action-wish" class="fa-solid fa-heart"></i>
	                    </div>
	                </div>
	            </div>
	        <% }
            } %>
    </div>
    <hr />
    <div id="picked-actor-title">
        <h3>내가 찜한 배우❤</h3>
    </div>
    <div id="picked-actor-wrap">
        <% if(pickedActorList == null || pickedActorList.isEmpty()) {%>
            <h3>내가 찜한 배우가 없습니다.</h3>
        <% } else { 
            for(PickedActorExt pickedActor : pickedActorList){%>
	            <div class="actor-info">
	                <i class="fa-solid fa-circle-user"></i>
	                <h4><%= pickedActor.getActorName() %></h4>
	            </div>
            <% } %>
        <% } %>
    </div>
    <hr />
    <div id="picked-producer-title">
        <h3>내가 찜한 감독❤</h3>
    </div>
    <div id="picked-producer-wrap">
        <% if(pickedProducerList == null || pickedProducerList.isEmpty()) {%>
            <h3>내가 찜한 감독이 없습니다.</h3>
        <% } else { 
            for(PickedProducerExt pickedProducer : pickedProducerList){%>
            <div class="producer-info">
                <i class="fa-solid fa-circle-user"></i>
                <h4><%= pickedProducer.getProducerName() %></h4>
            </div>
            <% } %>
        <% } %>
    </div>
</section>
<script>
document.querySelector('#button-action-wish').addEventListener('click', (e) => {
    if(e.target.style.color == ''){
        e.target.style.color = '#cda0fe';
        alert('찜 목록에 추가되었습니다.');
    } else {
        e.target.style.color = '';
        alert('찜 목록에서 제거되었습니다.');
    }
})
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>