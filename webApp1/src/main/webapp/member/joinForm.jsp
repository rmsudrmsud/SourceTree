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
const check = () => {
	//팜업창 오픈(웹페이지오픈소스 경로, 창이름, 창설정)
	let win = open("/webApp1/member/idCheck.jsp","win","width=300, height=200");
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
<form action="/webApp1/JoinController" method="post" name="f">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id" onclick="check()" readonly>
<!-- <input type="button" value="중복체크" onclick="check()"> -->
</td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
<tr><th>회원타입</th>
	<td>
	<input type="radio" name="type" value="1">구매자
	<input type="radio" name="type" value="2">판매자
	</td>
</tr>
<tr><th>가입완료</th><td><input type="button" value="가입" onclick="a()"></td></tr>
</table>
<input type="hidden" name="flag" value="false"> <!-- 중복체크안하면 회원가입되지않도록 하기위한 히든 -->
</form>
</body>
</html>