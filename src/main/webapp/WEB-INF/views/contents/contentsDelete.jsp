<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

</head>
<body>

<h2 style="color: #ffff">영화 컨텐츠 삭제</h2>
	
	<form action="<%=request.getContextPath()%>/contents/contentsDelete" 
	method="POST" 
	class="contentsDelete">
	
		<label for="contentsNo">삭제할 영화의 번호 : </label>
		<input type="text" name="contentsNo" id="contentsNo" placeholder="삭제할 영화의 번호를 입력하세요" />
		<br>
		
		<input type="submit" value="영화 삭제" />



<style>
	.contentsDelete {
		color : white;
	}
</style>

</body>
</html>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>