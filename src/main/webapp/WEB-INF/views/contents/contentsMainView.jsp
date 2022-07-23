<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
</head>
<body>
	<h1 style="color: #ffff">컨텐츠 관리 메인화면</h1>
								
	<input type="button" value="영화 등록하기"
		onclick="location.href='<%= request.getContextPath() %>/contents/contentsInsert';" />
	<br /><br />
	<input type="button" value="영화 수정하기"
		onclick="location.href='<%= request.getContextPath() %>/contents/contentsUpdate';" />
	<br /><br />
	<input type="button" value="영화 삭제하기"
		onclick="location.href='<%= request.getContextPath() %>/contents/contentsDelete';" />
	<br /><br />

</body>
</html>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

