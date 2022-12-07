<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 페이지 디렉티브. jsp페이지의 현재설정 -->
    <!-- jsp도 html 과비슷하게 하지만 자바언어를 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
let idFlag = false;
const check = () =>{
	
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = () => { //xhttp.onload : ajax 요청이오자마자 실행되는것. window.onload 와다름
		let obj = JSON.parse(xhttp.responseText);
	let div = document.getElementById("ch_res");
	  div.innerHTML = obj.msg; //응답 텍스트
	  if(obj.flag){
		  f.flag.value='true';
	  }
	}
	//요청할 파라메터
	let param = "id="+f.id.value
	
	//전송방식, 서버페이지 설정
	xhttp.open("post", "${pageContext.request.contextPath }/DispatcherServlet?url=/member/idcheck")
	//post방식일때 postheader 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	//요청 보냄
	xhttp.send(param); // 이녀석이 idcheck로 감
}

const a = () => {
	if(f.flag.value!='true'){
		alert('아이디 중복체크 하시오');
		return;
	}
	
	if(f.pwd.value==''){
		alert('비밀번호는 필수');
		return;
	}
	
	f.submit(); //전송
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet" method="post" name="f">
<input type="hidden" name="url" value="/member/add">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id">
<input type="button" value="중복체크" onclick="check()">
<span id="ch_res"></span> <!-- 사용가능한지 불가능한지 띄워줄 영역 span -->

</td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
<tr><th>회원타입</th>
	<td>
	<input type="radio" name="type" value="1" checked>구매자
	<input type="radio" name="type" value="2">판매자
	</td>
</tr>
<tr><th>가입완료</th><td><input type="button" value="가입" onclick="a()"></td></tr>
</table>
<input type="hidden" name="flag" value="false"> <!-- 중복체크안하면 회원가입되지않도록 하기위한 히든 -->
</form>
</body>
</html>