<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contents-detialView.css" />


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
	            <h3>영화제목 (2017)</h3>
	        </div>
	        <div id="contents-ott">
                <img src="" alt="" />
                넷플릭스
                <!-- ott별 아이콘 넣을 수 있게 반복처리, 조건문 추가 -->
            </div>
	    </div>
	    <div id="contents-star">
            <i class="fa-solid fa-star"></i>
            <p>5.0 | 액션</p>
        </div>
        <div id="contents-plot">
            어짜구저짜구 어짜구저짜구어짜구저짜구어짜구저짜구어짜구저짜구어짜구저짜구어짜구저짜구어짜구저짜구어짜구저짜구어짜구저짜구
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
            <h4>김감자</h4>
        </div>
    </div>
    <div id="contents-actor">
        <div id="actor-info-wrap">
        <!-- 반복문 필요 -->
            <div class="actor-info">
	            <i class="fa-solid fa-circle-user"></i>
	            <h4>이고구마</h4>
            </div>
            <div class="actor-info">
                <i class="fa-solid fa-circle-user"></i>
                <h4>이고구마</h4>
            </div>
            <div class="actor-info">
                <i class="fa-solid fa-circle-user"></i>
                <h4>이고구마</h4>
            </div>
            <div class="actor-info">
                <i class="fa-solid fa-circle-user"></i>
                <h4>이고구마</h4>
            </div>
            <div class="actor-info">
                <i class="fa-solid fa-circle-user"></i>
                <h4>이고구마</h4>
            </div>
        </div>
    </div>
</div>

<hr />
<!-- 수아님 여기 밑으로 붙여주시면 됩니당~!~! -->
<script>
document.querySelector('#btn-back').addEventListener('click', () => {
	window.history.back();
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>