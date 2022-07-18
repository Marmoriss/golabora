<%@page import="com.kh.golabora.contents.model.dto.Contents"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/search-style.css" />
<%
List<Contents> list = (List<Contents>) request.getAttribute("list");

%>
<script>
window.addEventListener('load', (e) => {
	document.querySelector('select#searchType').onchange = (e) => {
		document.querySelectorAll('.search-type').forEach((div, index) => {
			div.style.display = "none";
		});
		let id;
		switch(e.target.value){
		case "contents_title" : id = "contentsTitle"; break;
		case "actor_name" : id = "actorName"; break;
		case "producer_name" : id = "producerName"; break;
		}
		document.querySelector(`#search-\${id}`).style.display = 'inline-block';
	}
});
</script>
<div class="title">
    <h2>작품 검색</h2>
</div>
<div class="searchbar">
	    <select id="searchType">
	       <option value="contents_title">작품명</option>
	       <option value="actor_name">배우명</option>
	       <option value="producer_name">감독명</option>
	    </select>
	    <div id="search-contentsTitle" class="search-type">
	    <!-- 주희 수정 /search/searchNames -> /search/searchContentsTitle -->
		    <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchContentsTitle" method="GET">
			    <input type="hidden" name="searchType" value="contents_title"/>
			    <input type="text" name="searchKeyword" 
                    placeholder="작품명을 검색해보세요" value=""/>
			    <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
		    </form>f
	    </div>
        <div id="search-actor_name" class="search-type">
        <!-- 주희 수정 /search/searchNames -> /search/searchActorName -->
            <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchActorName" method="GET">
                <input type="hidden" name="searchType" value="actor_name"/>
                <input type="text" name="searchKeyword" 
                    placeholder="배우명을 검색해보세요" value=""/>
                <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
            </form>
        </div>
        <div id="search-producer_name" class="search-type">
        <!-- 주희 수정 /search/searchNames -> /search/searchProducerName -->
            <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchProducerName" method="GET">
                <input type="hidden" name="searchType" value="producer_name"/>
                <input type="text" name="searchKeyword" 
                    placeholder="감독명을 검색해보세요" value=""/>
                <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
            </form>
        </div>
</div>
<div id="search-filter">
    <div id="search-toggle">
	    <p>검색 필터</p>
	    <a id="btn_toggle"><i class="fa-solid fa-circle-chevron-down"></i></a>
    </div>
    <div id="search-toggle-down">
	    <div id="search-OttNo">
	        <form action="<%= request.getContextPath()%>/search/searchOtt" method="GET">
	            <input type="hidden" name="ottNo" value="O1"/>        
	            <button type="submit">넷플릭스</button>
	        </form>
	        <form action="<%= request.getContextPath()%>/search/searchOtt" method="GET">
	            <input type="hidden" name="ottNo" value="O2"/>        
	            <button type="submit">웨이브</button>
	        </form>
	        <form action="<%= request.getContextPath()%>/search/searchOtt" method="GET">
	            <input type="hidden" name="ottNo" value="O3"/>        
	            <button type="submit">왓챠</button>
	        </form>
	    </div>
	    <div id="search-GenreNo">
	        <form action="<%= request.getContextPath()%>/search/searchGenre" method="GET">
	            <div><input type="checkbox" name="genreCode" value="G1"/><p>액션</p></div>
	            <div><input type="checkbox" name="genreCode" value="G2"/><p>드라마</p></div>
	            <div><input type="checkbox" name="genreCode" value="G3"/><p>로맨스</p></div>
	            <div><input type="checkbox" name="genreCode" value="G4"/><p>코미디</p></div>
	            <div><input type="checkbox" name="genreCode" value="G5"/><p>스릴러</p></div>
	            <div><input type="checkbox" name="genreCode" value="G6"/><p>호러</p></div>
	            <div><input type="checkbox" name="genreCode" value="G7"/><p>판타지</p></div>
	            <div><input type="checkbox" name="genreCode" value="G8"/><p>다큐</p></div>
	            <button type="submit">검색</button>
	        </form>
        </div>
    </div>
</div>  
    <div class="contents-list-item-wrap">
    <% 
    if(list == null || list.isEmpty()) { 
    %>
        <p>검색 결과가 없습니다.</p>
	<%
    } else {
	    for(Contents contents : list) {
	%>
	        <div class="movie-item-grid" >
	            <a href="<%= request.getContextPath() %>/contents/<%= contents.getContentsNo() %>"
	                title="<%= contents.getContentsTitle() %>" style="display: block;">
	                <div class="poster">
	                    <img src="" alt="<%= contents.getContentsTitle() %>" />
	                </div>
	            </a>
	            <div class="info">
	                <div class="title"><%= contents.getContentsTitle() %></div>
	                <div class="rating">
	                    <div class"light-wrap">평점</div>
	                    <button class="button-action-wish">💜</button>
	                </div>
	            </div>
	        </div>
	<%
        }
    }
    %>
    </div>
<script>
document.querySelector('#btn_toggle').addEventListener('click', () => {
    const toggle = document.querySelector('#search-toggle-down');
	if(toggle.style.display == 'none'){
	    toggle.style.display = 'inline';
	} else {
		toggle.style.display = 'none';
	}
});

document.querySelector('#searchIcon').addEventListener('click', () => {
	const searchNamesFrm = document.querySelector('#searchNamesFrm');
    searchNamesFrm.submit();
})

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>