<%@page import="com.kh.golabora.member.model.dto.MemberRole"%>
<%@ page import="com.kh.golabora.member.model.dto.Member"%>
<%@ page import="com.kh.golabora.contents.model.dto.Contents"%>

<%@page import="java.util.List"%>
      
	<% 
	List<Contents> rank = (List<Contents>) request.getAttribute("rank");
	List<Contents> recommend = (List<Contents>) request.getAttribute("recommend");
	%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<div class="searchbar">
            <a href="<%= request.getContextPath() %>/search/searchContents">
                <i class="fa-solid fa-magnifying-glass"></i>
			</a>
			<input type="text" placeholder="  작품명, 배우, 감독, 장르를 검색해보세요"/>
		</div>
		<!-- ranking -->
		<div id="main-ranking">
			<h3>오늘의 순위</h3>
			<!-- ott logo -->
			<nav id="ranking-nav">
				<ul>
					<li onclick="location.href='<%= request.getContextPath() %>/mainNet';"/><img src="./images/넷플릭스.png" alt="" /></li>
					<li onclick="location.href='<%= request.getContextPath() %>/mainWat';"/><img src="./images/왓챠.png" alt="" /></a></li>
					<li onclick="location.href='<%= request.getContextPath() %>/mainWav';"/><img src="./images/웨이브.png" alt="" /></a></li>
				</ul>
			</nav>
			<div id="main-ranking-list">

		<% if(rank == null || rank.isEmpty()){ %>
		<ul>
			<li colspan="10" align="center"> 검색 결과가 없습니다. </li>
		</ul>
		<%
		} else { %>
				<ul>
		<%
				int i = 1;
				for(Contents c : rank){
		%>
					<li><%= i %>  <%= c.getContentsTitle() %></li>
					
		<%		i++;
				if(i == 6) break;
					}
		%>
				</ul>
		<%		}
		%>
			</div>
		</div>
		<!-- 건우 start -->
		<!-- login -->
		<div id="main-login">
			<%if(loginMember == null){ %>
			<header>GOLABORA</header>
			<!-- 일단 button 으로 만들어놨어요 -->
			<input type="button" value="로그인 하러가기" 
								onclick="location.href='<%= request.getContextPath() %>/member/login';"/>	
			<p>아직 GOLABORA 회원이 아니시라면?</p>
			<span><a href="http://localhost:9090/golabora/member/memberEnroll">지금 회원가입 하기</a></span>
		</div>
		<% } else if(loginMember != null && loginMember.getMemberRole() == MemberRole.U) { %>
		<header>GOLABORA</header>
		<table id="login">
					<tr>
						<td>
							<%= loginMember.getMemberName() %>님 환영합니다.
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="마이페이지" 
								onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/>
							<input type="button" value="나의 찜목록 보러가기" 
								onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/>
							<input type="button" value="로그아웃" 
								onclick="location.href='<%= request.getContextPath() %>/member/logout';"/>
						</td>
					</tr>
		</table>
		<% } else{ %>
		<header>GOLABORA</header>
		<table id="login2">
					<tr>
						<td>
							<%= loginMember.getMemberName() %>님 환영합니다.
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="서비스 관리" 
								onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/>
							<input type="button" value="콘텐츠 관리" 
								onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/>
							<input type="button" value="로그아웃" 
								onclick="location.href='<%= request.getContextPath() %>/member/logout';"/>
						</td>
					</tr>
		</table>
		<% } %>
		<!-- 건우 end -->
		<!-- recommend -->
		<div id="main-recommend">
		<% if(loginMember == null){ %>
		<% } else{ %>
			<h3>나를 위한 콘텐츠 추천</h3>
			<ul>	
		<%	
		for(Contents c : recommend){
			int j = 1;			
			if(recommend != null || recommend.contains(loginMember.getGenreCode())){
			// 상세 페이지 주소 링크 미 기입
		%>
			<li>
					<div class="main-recommend-img">
					<img src="<%= request.getContextPath() %>/images/<%= c.getOriginalFilename() %>" alt="<%= c.getContentsTitle() %>" />
					</div>
					<div class="main-recommend-title">
						<span><%= c.getContentsTitle() %></span>
					</div>
		</li>
			
		<% j++;
				if(j == 6) break;
		
				}
			}
		}
		%>
			</ul>
				
			</ul>
		</div>

		<!-- playlist -->
		<div id="main-playlist">
			<h3>다른 이용자들의 최애 영화가 궁금하다면?</h3>
			<ul>
				<li>
					<div class="main-playlist-img">
						<img src="./images/라라랜드.jpg" alt=""/>
					</div>
					<div class="main-playlist-name">
						<span>플레이리스트 1</span>
					</div>
				</li>
				<li>
					<div class="main-playlist-img">
						<img src="./images/걸캅스.jpg" alt=""/>
					</div>
					<div class="main-playlist-name">
						<span>플레이리스트 2</span>
					</div>
				</li>
				<li>
					<div class="main-playlist-img">
						<img src="./images/기생충.jpg" alt=""/>
					</div>
					<div class="main-playlist-name">
						<span>플레이리스트 3</span>
					</div>
				</li>
				<li>
					<div class="main-playlist-img cropping">
						<img src="./images/돈룩업.jpg" alt=""/>
					</div>
					<div class="main-playlist-name">
						<span>플레이리스트 4</span>
					</div>
				</li>
			</ul>
			</div>
			
			<!-- playlist-list -->
			<div id="main-playlist-list">
				<ul>
					<li>01 이상한 변호사 우영우</li>
					<li>02 기러기 스위스 인도인</li>
					<li>03 이상한 나라의 수학자</li>
					<li>04 이상한 나라의 과학자</li>
				</ul>
			</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		
