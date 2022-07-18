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
		    <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchNames" method="GET">
			    <input type="hidden" name="searchType" value="contents_title"/>
			    <input type="text" name="searchKeyword" 
                    placeholder="작품명을 검색해보세요" value=""/>
			    <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
		    </form>
	    </div>
        <div id="search-actor_name" class="search-type">
            <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchNames" method="GET">
                <input type="hidden" name="searchType" value="actor_name"/>
                <input type="text" name="searchKeyword" 
                    placeholder="배우명을 검색해보세요" value=""/>
                <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
            </form>
        </div>
        <div id="search-producer_name" class="search-type">
            <form id="searchNamesFrm" action="<%= request.getContextPath() %>/search/searchNames" method="GET">
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
	    	<h3>OTT</h3>
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