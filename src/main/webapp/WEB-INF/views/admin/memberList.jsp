<%@page import="com.kh.golabora.member.model.dto.Gender"%>
<%@page import="com.kh.golabora.contents.model.dto.Genre"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPage.jsp" %>
<%
	List<Member> list = (List<Member>) request.getAttribute("list");
	String type = request.getParameter("searchType");
	String kw = request.getParameter("searchKeyword");
%>
<!-- 관리자용 admin.css link -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<style>
div#search-container {
	width: 100%;
	margin: 0 0 10px 0;
	padding: 3px;
	background-color: none;
}
div#search-memberId {
	display: <%= type == null || "member_id".equals(type) ? "inline-block" : "none" %>;
}
div#search-memberName {
	display: <%= "member_name".equals(type) ? "inline-block" : "none" %>;
}
</style>
<script>
window.addEventListener('load', (e) => {
	document.querySelector("select#searchType").onchange = (e) => {
		document.querySelectorAll(".search-type").forEach((div, index) => {
			div.style.display = "none";			
		});
		let id;
		switch(e.target.value){
		case "member_id" : id = "memberId"; break;
		case "member_name" : id = "memberName"; break;
		}
		document.querySelector(`#search-\${id}`).style.display = "inline-block";
	}
});
</script>

<div id="memberList-container">
	<h2>회원관리</h2>
	
	<div id="search-container">
		
        <select id="searchType">
            <option value="member_id" <%= "member_id".equals(type) ? "selected" : "" %>>아이디</option>		
            <option value="member_name" <%= "member_name".equals(type) ? "selected" : "" %>>회원명</option>
        </select>
        <div id="search-memberId" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder">
                <input type="hidden" name="searchType" value="member_id"/>
                <input type="text" name="searchKeyword"  size="25" placeholder="검색할 아이디를 입력하세요." 
                	value="<%= "member_id".equals(type) ? kw : "" %>"/>
                <button type="submit">검색</button>			
            </form>	
        </div>
        <div id="search-memberName" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder">
                <input type="hidden" name="searchType" value="member_name"/>
                <input type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력하세요."
                	value="<%= "member_name".equals(type) ? kw : "" %>"/>
                <button type="submit">검색</button>			
            </form>	
        </div>
    </div>
	
	
	<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>회원권한</th>
				<th>성별</th>
				<th>전화번호</th>			
				<th>장르</th>
				<th>가입일</th><%-- 날짜형식 yyyy-MM-dd  --%>
			</tr>
		</thead>
		<tbody>
		<%
			if(list == null || list.isEmpty()){
		%>
			<tr>
				<td colspan="10" align="center"> 검색 결과가 없습니다. </td>
			</tr>
		<%
			} 
			else {
				for(Member m : list){
					String genreCode = m.getGenreCode();
					switch(genreCode){
					case "G1" : genreCode = "액션"; break;
					case "G2" : genreCode = "드라마"; break;
					case "G3" : genreCode = "로맨스"; break;
					case "G4" : genreCode = "코미디"; break;
					case "G5" : genreCode = "스릴러"; break;
					case "G6" : genreCode = "호러"; break;
					case "G7" : genreCode = "판타지"; break;
					case "G8" : genreCode = "다큐"; break;
					}
		%>
			<tr>
				<td><%= m.getMemberId() %></td>
				<td><%= m.getMemberName() %></td>
				<td><%= m.getMemberRole() %></td>
				<td><%= m.getGender() == null ? "" : (m.getGender() == Gender.M ? "남" : "여") %></td>				
				<td><%= m.getPhone() %></td>				
				<td><%= genreCode  %></td>				
				<td><%= new SimpleDateFormat("yyyy-MM-dd").format(m.getEnrollDate()) %></td>		
			</tr>		
		<%		} 
			}
		%>
			</tbody>
	</table>
	
	<div id="pagebar">
		<%= request.getAttribute("pagebar") %>
	</div>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp" %>
