<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contentsMainView.css" />
</head>
<body>
	
	
	
	<div class = "contents-header">
		<h3>영화 관리</h3>
	</div>
	
	<div id = line>
		<ul class="conCRUD">
			<li class="conInsert"><a href="<%= request.getContextPath() %>/contents/contentsInsert">영화 등록하기</a></li>
			<li class="conUpdate"><a href="<%= request.getContextPath() %>/contents/contentsUpdate">영화 수정하기</a></li>
			<li class="conDelete"><a href="<%= request.getContextPath() %>/contents/contentsDelete">영화 삭제하기</a></li>
		</ul>
	</div>	
	

</body>
</html>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>


