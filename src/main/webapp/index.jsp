<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
window.onload = function () {
	 document.indexFrm.submit();
	}
</script>
<form action="<%= request.getContextPath() %>/mainNet" method="get" name="indexFrm"><input type="hidden"></form>