<%@page import="com.kh.golabora.contents.model.dto.ContentsWithActor"%>
<%@page import="com.kh.golabora.contents.model.dto.ContentsWithProducer"%>
<%@page import="com.kh.golabora.contents.model.dto.Contents"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/search-style.css" />
<%
List<Contents> list = (List<Contents>) request.getAttribute("list");

String type = request.getParameter("searchType");
String kw = request.getParameter("searchKeyword");
%>
<style>
div#search-contentsTitle{
    display: <%= type == null || "contents_title".equals(type) || "ott_no".equals(type) || "genre_code".equals(type) ? "inline-block" : "none" %>;
}
div#search-actorName{
    display: <%= "actor_name".equals(type) ? "inline-block" : "none" %>;
}
div#search-producerName{
    display: <%= "producer_name".equals(type) ? "inline-block" : "none" %>;
}
</style>
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
		default : id = "contentsTitle"; break;
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
	       <option value="contents_title" <%= "contents_title".equals(type) ? "selected" : "" %>>작품명</option>
	       <option value="actor_name" <%= "actor_name".equals(type) ? "selected" : "" %>>배우명</option>
	       <option value="producer_name" <%= "producer_name".equals(type) ? "selected" : "" %>>감독명</option>
	    </select>
	    <div id="search-contentsTitle" class="search-type">
		    <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchContentsTitle" method="GET">
			    <input type="hidden" name="searchType" value="contents_title"/>
			    <input type="text" name="searchKeyword" 
                    placeholder="작품명을 검색해보세요" value="<%= "contents_title".equals(type) ? kw : "" %>"/>
			    <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
		    </form>
	    </div>
        <div id="search-actorName" class="search-type">
            <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchActorName" method="GET">
                <input type="hidden" name="searchType" value="actor_name"/>
                <input type="text" name="searchKeyword" 
                    placeholder="배우명을 검색해보세요" value="<%= "actor_name".equals(type) ? kw : "" %>"/>
                <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
            </form>
        </div>
        <div id="search-producerName" class="search-type">
            <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchProducerName" method="GET">
                <input type="hidden" name="searchType" value="producer_name"/>
                <input type="text" name="searchKeyword" 
                    placeholder="감독명을 검색해보세요" value="<%= "producer_name".equals(type) ? kw : "" %>"/>
                <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
            </form>
        </div>
</div>
<div id="search-filter">
    <a id="btn_toggle">
	    <div id="search-toggle">
		    <p>검색 필터</p>
		    <i class="fa-solid fa-circle-chevron-down"></i>
	    </div>
    </a>
    <div id="search-toggle-down">
	    <div id="search-OttNo">
	    	<h3>OTT</h3>
	        <form action="<%= request.getContextPath()%>/search/searchOtt" method="GET">
		        <input type="hidden" name="searchType" value="ott_no"/>
	            <div>
		            <input type="checkbox" name="ottNo" value="O1" id="ottCheck1"/>
		            <label for="ottCheck1">넷플릭스</label>
	            </div>
	            <div>
		            <input type="checkbox" name="ottNo" value="O2" id="ottCheck2"/> 
		            <label for="ottCheck2">웨이브</label>
		        </div>
		        <div>
		            <input type="checkbox" name="ottNo" value="O3" id="ottCheck3"/>  
		            <label for="ottCheck3">왓챠</label>
		        </div>
		        <br />
		        <button type="submit">검색</button>
	        </form>
	    </div>
	    
	    <div id="search-GenreNo">
	        <form action="<%= request.getContextPath()%>/search/searchGenre" method="GET">
	        <input type="hidden" name="searchType" value="genre_code"/>
	            <h3>Genre</h3>
	            <div>
		            <input type="checkbox" name="genreCode" value="G1" id="check1"/>
		            <label for="check1">액션</label>
	            </div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G2" id="check2"/>
		            <label for="check2">드라마</label>
	            </div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G3" id="check3"/>
		            <label for="check3">로맨스</label>
	           	</div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G4" id="check4"/>
		            <label for="check4">코미디</label>
	            </div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G5" id="check5"/>
		            <label for="check5">스릴러</label>
	            </div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G6" id="check6"/>
		            <label for="check6">호러</label>
	            </div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G7" id="check7"/>
	            	<label for="check7">판타지</label>
	            </div>
	            <div>
		            <input type="checkbox" name="genreCode" value="G8" id="check8"/>
		            <label for="check8">다큐</label>
	            </div>
	            <br />
	            <button type="submit">검색</button>
	        </form>
        </div>
    </div>
</div>
    <div class="archive-movie-list-area">
	    <div class="mainContent">
	    <% 
	    if(list == null || list.isEmpty()) { 
	    %>
	        <p>검색 결과가 없습니다.</p>
		<%
	    } else {
		    for(Contents contents : list) {
		%>
		        <div class="movieItem grid" >
		            <a href="<%= request.getContextPath() %>/contents/<%= contents.getContentsNo() %>"
		                title="<%= contents.getContentsTitle() %>" style="display: block;">
		                <div class="poster">
		                    <img src="" alt="<%= contents.getContentsTitle() %>" />
		                </div>
		            </a>
		            <div class="info">
		                <div class="title"><%= contents.getContentsTitle() %></div>
		                <div class="rating">
		                    <div class="light-wrap">평점</div>
		                    <button class="button-action-wish">💜</button>
		                </div>
		            </div>
		        </div>
		<%
	        }
	    }
	    %>
	    </div>
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