<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/Join.css">
<script type="text/javascript">

const check = () => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  let obj = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("ch_res");
	  div.innerHTML = obj.msg; //응답 텍스트
	  if(obj.flag){
		  f.flag.value='true';
	  }
	}
	
	let param = "id="+f.id.value;
	
	
	//전송방식, 서버페이지 설정
	xhttp.open("post", "${pageContext.request.contextPath }/member/idcheck.do");
	
	//post header 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	//요청 보냄
	xhttp.send(param);
}

const a = () =>{
	   if(f.flag.value!='true'){
	      alert('아이디 중복체크 하시오');
	      return;
	   }
	   
	   if(f.pwd.value==''){
	      alert('패스워드 필수');
	      return;
	   }
	   
	   f.submit();//전송
	}



</script>
</head>
<body link="black" vlink="black">
	<div class="nav_part">
		<div class="name">
			<a href=""
				style="text-decoration-line: none;"> </a>
		</div>
	</div>

	<br />


	<form action="${pageContext.request.contextPath }/member/add.do"
		method="post" name="f">

		<div class="member">

			<img class="logo"
				src="${pageContext.request.contextPath }/Resources/images/travellogo.png"
				alt="이미지를 찾을 수 없습니다."
				style="width: 280px; height: 80px; ">

			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"> <input type="button"
					value="중복체크" onclick="check()"> <span id="ch_res"></span></td>
			</tr>



			<div class="field">
				<b>비밀번호</b> <input class="userpw" type="password" name="pwd">
			</div>

			<div class="field">
				<b>이름</b> <input type="text" name="name">
			</div>

			<div class="field">
				<b>전화번호</b> <input type="text" name="tel">
			</div>
			<div class="field">
				<b>이메일</b> <input type="text" name="email">
			</div>
			<!-- 3. 필드(생년월일) -->
			<div class="field birth">
				<b>생년월일</b>
				<div>
					<input type="date" name="birth">
				</div>
			</div>
			<td><input type="button" value="가입" onclick="a()"></td></tr>

<input type="hidden" name="flag" value="false">



			
	</form>
	</div>
</body>
</html>