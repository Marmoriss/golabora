<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.golabora.contents.model.dto.ContentsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contents-detialView.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
<%
List<ContentsInfo> list = (List<ContentsInfo>) request.getAttribute("detailPage");
String contentsNo = (String) request.getAttribute("contentsNo");
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
        <img src="" alt="" />
    </div>
    <div id="contents-info">
	    <div id="titleAndOtt">
	        <div id="contents-title">
	            <h3><%= contentsInfo.getContentsTitle() %> (<%= contentsInfo.getReleaseDate() %>)</h3>
	        </div>
	        <div id="contents-ott">
                <img src="" alt="" />
                넷플릭스
                <!-- ott별 아이콘 넣을 수 있게 반복처리, 조건문 추가 -->
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
            <input type="checkbox" name="picked-contents" id="picked-contents" value=""/>
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
<script>
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
        alert('찜 목록에 추가되었습니다.');
    } else {
        e.target.className = 'fa-solid fa-circle-user';
        e.target.style.color = '';
        alert('찜 목록에서 제거되었습니다.');
    }
});


</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>