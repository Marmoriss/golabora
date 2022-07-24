<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contentsMainView.css" />

</head>
<body>

	<div class="contents-header">
		<h3>영화 삭제</h3>
	</div>

	<div>
		<form action="<%=request.getContextPath()%>/contents/contentsDelete" 
		method="POST" 
		class="conDelete">
			
			<label for="contentsNo">삭제할 영화의 번호 : </label>
			<input type="text" name="contentsNo" id="contentsNo" placeholder="삭제할 영화의 번호를 입력하세요" />
			<br>
		
			<input type="submit" value="영화 삭제" />
			
		</form>
	</div>





</body>
</html>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>