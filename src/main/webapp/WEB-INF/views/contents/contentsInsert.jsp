<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/contents/contentsMainView.jsp" %>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contents-style.css" />
<section id="admin-contents-enroll">
	<h1>🎞 영화 컨텐츠 등록</h1>
	<div class="contents-container">
		<form 
		action="<%=request.getContextPath()%>/contents/contentsInsert"  
		method="POST" 
		enctype="multipart/form-data"
		class="contentsInsert"
		onsubmit="return confirm('이 영화를 등록하시겠습니까?');">
			 <div id="enroll-genre">
				<h3>장르</h3>		 
				<div>
		            <input type="radio" name="genreCode" value="G1" id="check1" checked/>
		            <label for="check1">액션</label>
	            </div>
	            <div>
		            <input type="radio" name="genreCode" value="G2" id="check2"/>
		            <label for="check2">드라마</label>
	            </div>
	            <div>
		            <input type="radio" name="genreCode" value="G3" id="check3"/>
		            <label for="check3">로맨스</label>
	           	</div>
	            <div>
		            <input type="radio" name="genreCode" value="G4" id="check4"/>
		            <label for="check4">코미디</label>
	            </div>
	            <br />
	            <div>
		            <input type="radio" name="genreCode" value="G5" id="check5"/>
		            <label for="check5">스릴러</label>
	            </div>
	            <div>
		            <input type="radio" name="genreCode" value="G6" id="check6"/>
		            <label for="check6">호러</label>
	            </div>
	            <div>
		            <input type="radio" name="genreCode" value="G7" id="check7"/>
	            	<label for="check7">판타지</label>
	            </div>
	            <div>
		            <input type="radio" name="genreCode" value="G8" id="check8"/>
		            <label for="check8">다큐</label>
	            </div>
	          </div>
			
			<div id="watchable">
				<h3>연령 제한</h3>
			 	<div>
		            <input type="radio" name="watchableAge" value="0" id="watch1" checked/>
		            <label for="watch1">전체</label>
	            </div>
	            <div>
		            <input type="radio" name="watchableAge" value="12" id="watch2"/>
		            <label for="watch2">12세</label>
	            </div>
	            <div>
		            <input type="radio" name="watchableAge" value="15" id="watch3"/>
	            	<label for="watch3">15세</label>
	            </div>
	            <div>
		            <input type="radio" name="watchableAge" value="19" id="watch4"/>
		            <label for="watch4">19세</label>
	            </div>
	          </div>
			<h3>영화제목</h3>
			<input type="text" name="contentsTitle" id="contentsTitle" placeholder="영화 제목을 입력하세요" />
			
			<h3>개봉년도</h3>
			<input type="text" name="releaseDate" id="releaseDate" placeholder="개봉 날짜를 입력하세요" />
			
			<h3>상영시간 (분)</h3>
			<input type="text" name="runningTime" id="runningTime" placeholder="ex) 155" />
		
			<h3>줄거리</h3>
			<textarea name="contentsPlot" id="contentsPlot" cols="60" rows="10" placeholder="줄거리를 입력하세요(300자 이내)"></textarea>
			
			<h3>포스터 등록</h3>			
			<input type="file" name="upfile" />
			
			<h3>포스터 파일명</h3>
			<input type="text" name="originalFilename" placeholder="파일명을 그대로 입력해주세요. ex)라라랜드.jpg"/>
			
			<br /><br /><br />
			<input type="submit" value="영화등록" />
			
			
		</form>
	</div>
</section>	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>