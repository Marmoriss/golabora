<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<div id=enroll-container class="enroll-container">
	
	<header>회원 가입</header>
	<form name="memberEnrollFrm" class="memberEnrollFrm"action="" method="POST">
		
				<div>
					 <h3 class="join_title">
                        <label for="_memberId">아이디</label>
                    </h3>
					<input type="text" placeholder="4글자이상" name="memberId" id="_memberId" value="" onblur="idchk(this)" onclick="idcheck()" required>
					<div>
					<h3 id="required"></h3>
					<input type="button" value="중복검사" onclick="checkIdDuplicate();" />
					<input type="hidden" id="idValid" value="0" />
					<p id="idMsg"></p>
					</div>
					<%-- 중복검사전 0, 중복검사후(유효한 아이디) 1 --%>
				</div>
				<div>
					 <h3 class="join_title">
                        <label for="_password">비밀번호</label>
                    </h3>
					<input type="password" name="password" id="_password" onblur="pwchk(this)" onclick="pwcheck()"required>
					<h3 id="required2"></h3>
				</div>
				<div>
					 <h3 class="join_title">
                        <label for="passwordCheck">비밀번호확인</label>
                    </h3>
					<input type="password" id="passwordCheck"  required>
				</div>
				<div>
					<h3 class="join_title">
                        <label for="memberName">이름</label>
                    </h3>
					<input type="text"  name="memberName" id="memberName" onblur="namechk(this)"  onclick="namecheck()"required><br>
					<h3 id="required3"></h3>
				</div>
				<div>
					<h3 class="join_title">
                        <label for="phone">전화번호</label>
                    </h3>
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11"  required><br>
				</div>
				<div>
					<h3 class="join_title">
                        <label for="gender0">성별</label>
                    </h3>
					<input type="radio" name="gender" id="gender0" value="M">
					<label id="gen0"for="gender0">남</label>
					<input type="radio" name="gender" id="gender1" value="F">
					<label for="gender1">여</label>
				</div>
			
				<div id="genreBox">
					<h3 class="join_title">
                        <label class="genreBox"for="genre0">최애 장르 선택하기</label>
                    </h3>
                    <div>
					<input type="radio" name="genre" id="genre0" value="G1" checked/><label for="genre0">액션</label><br />
					</div>
					<div>
					<input type="radio" name="genre" id="genre1" value="G2" /><label for="genre1">드라마</label><br />
					</div>
					<div>
					<input type="radio" name="genre" id="genre2" value="G3" /><label for="genre2">로맨스</label>
					</div>
					<div>
					<input type="radio" name="genre" id="genre3" value="G4" /><label for="genre3">코미디</label>
					</div>
					<div>
					<input type="radio" name="genre" id="genre4" value="G5" /><label for="genre4">스릴러</label><br />
					</div>
					<div>
					<input type="radio" name="genre" id="genre5" value="G6" /><label for="genre5">호러</label>
					</div>
					<div>
					<input type="radio" name="genre" id="genre6" value="G7" /><label for="genre6">판타지</label><br />
					</div>
					<div>
					<input type="radio" name="genre" id="genre7" value="G8" /><label for="genre7">다큐</label><br />
					</div>
				</div>
		
		<input type="submit" value="회원 가입하기" >
	
	</form>
</div>
<form 
	action="<%= request.getContextPath() %>/member/checkIdDuplicate"
	name="checkIdDuplicateFrm">
	<input type="hidden" name="memberId" />
</form>

<script>
/**
 * 사용자입력한 id 중복여부 검사
 * - 폼을 팝업에서 제출
 */
 function idchk(obj) {
     if(obj.value == "") {
       document.getElementById("required").innerHTML = "아이디를 입력해주세요.";
     } else {
         document.getElementById("required").innerHTML="";
     }
   }
   
 function pwchk(obj) {
     if(obj.value == "") {
       document.getElementById("required2").innerHTML = "비밀번호를 입력해주세요.";
     } else {
       document.getElementById("required2").innerHTML = "";
     }
   }
 function namechk(obj) {
     if(obj.value == "") {
       document.getElementById("required3").innerHTML = "이름을 입력해주세요.";
     } else {
       document.getElementById("required3").innerHTML = "";
     }
   }
 
 
 function idcheck() { 
     document.getElementById("required").innerHTML ="아이디는 영문자/숫자로 최소 4글자이상이어야 합니다.";
   }
 
 function pwcheck() { 
     document.getElementById("required2").innerHTML ="비밀번호는 영문자/숫자/특수기호로 최소 4글자이상이어야 합니다.";
   }
 function namecheck() { 
     document.getElementById("required3").innerHTML ="한글 2글자 이상 입력해주세요";
   }
 
const checkIdDuplicate = () => {
	const memberId = document.querySelector("#_memberId");
	if(!/^[a-zA-Z0-9]{4,}$/.test(memberId.value)){
		alert("아이디를 입력해주세요.");
		memberId.select();
		return;
	}
	
	// popup제어
	const title = "checkIdDuplicatePopup";
	const spec = "width=300px, height=300px";
	const popup = open("", title, spec);
	
	// form제어
	const frm = document.checkIdDuplicateFrm;
	frm.target = title; // 폼을 제출대상이 현재 윈도우가 아닌 팝업으로 지정
	frm.memberId.value = memberId.value;
	frm.submit();
};

/**
 * 비밀번호 일치여부 검사
 */
document.querySelector("#passwordCheck").onblur = (e) => {
	console.log(123);
	const password = document.querySelector("#_password");
	const passwordCheck = e.target;
	if(password.value !== passwordCheck.value){
		alert("비밀번호가 일치하지 않습니다.");
		password.select();
	}
};

document.querySelector("#_memberId").onchange = (e) => {
	document.querySelector("#idValid").value = 0;
};

/**
 * 폼 유효성 검사
 */
document.memberEnrollFrm.onsubmit = (e) => {
	const memberId = document.querySelector("#_memberId");
	if(!/^[a-zA-Z0-9]{4,}$/.test(memberId.value)){
		alert("아이디는 영문자/숫자로 최소 4글자이상이어야 합니다.");
		memberId.select();
		return false;
	}
	
	const idValid = document.querySelector("#idValid");
	if(idValid.value !== "1"){
		alert("아이디 중복 검사해주세요.");
		memberId.nextElementSibling.focus();
		return false;
	}
	
	
	const password = document.querySelector("#_password");
	if(!/^[a-zA-Z0-9!@#$%^&*()]{4,}$/.test(password.value)){
		alert("비밀번호는 영문자/숫자/특수기호로 최소 4글자이상이어야 합니다.");
		password.select();
		return false;
	}
	const passwordCheck = document.querySelector("#passwordCheck");
	if(password.value !== passwordCheck.value){
		alert("비밀번호가 일치하지 않습니다.");
		password.select();
		return false;
	}
	
	const memberName = document.querySelector("#memberName");
	if(!/^[가-힣]{2,}$/.test(memberName.value)){
		alert("한글 2글자 이상 입력해주세요");
		memberName.select();
		return false;
	}
	
	const phone = document.querySelector("#phone");
	if(!/^010[0-9]{8}$/.test(phone.value)){
		alert("유효한 전화번호를 입력해주세요");
		phone.select();
		return false;
	}
	
}


</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>