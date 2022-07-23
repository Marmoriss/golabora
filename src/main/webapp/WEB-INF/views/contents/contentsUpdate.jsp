<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 style="color: #ffff">영화 컨텐츠 수정</h2>
	
	<form action="<%=request.getContextPath()%>/contents/contentsUpdate" 
	 method="POST" 
	 class="contentsUpdate">
	
		<label for="genreCode">장르 코드 : </label>
		<input type="text" name="genreCode" id="genreCode" placeholder="장르를 입력하세요" />
		<br>
	
		<label for="watchableAge">연령 제한 : </label>
		<input type="text" name="watchableAge" id="watchableAge" placeholder="연령 제한을 입력하세요" />
		<br>
	
		<label for="contentsTitle">영화 제목 : </label>
		<input type="text" name="contentsTitle" id="contentsTitle" placeholder="영화 제목을 입력하세요" />
		<br>
	
		<label for="releaseDate">개봉 날짜 : </label>
		<input type="text" name="releaseDate" id="releaseDate" placeholder="개봉 날짜를 입력하세요" />
		<br>
		
		<label for="runningTime">상영 시간 : </label>
		<input type="text" name="runningTime" id="runningTime" placeholder="상영 시간을 입력하세요" />
		<br>
	
		<label for="contentsPlot">줄거리 : </label>
		<input type="text" name="contentsPlot" id="contentsPlot" placeholder="줄거리를 입력하세요" />
		<br>
	
		<label for="originalFilename">변경 전 파일 이름 : </label>
		<input type="originalFilename" name="originalFilename" id="originalFilename" placeholder="변경 전 파일 이름을 입력하세요" />
		<br>
	
		<label for="renamedFilename">변경 후 파일 이름 : </label>
		<input type="renamedFilename" name="renamedFilename" id="renamedFilename" placeholder="변경 후 파일 이름을 입력하세요" />
		<br />
		
		<label for="contentsNo">변경하실 영화의 번호 :  </label>
		<input type="text" name="contentsNo" id="contentsNo" placeholder="영화 번호를 입력하세요" />
		<br>
		
		<input type="submit" value="영화수정" />
	</form>

</body>
</html>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>