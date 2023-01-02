<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//동기요청: 페이지 이동
const a = () => {
	location.href="/webApp1/IdCheck2?id="+f.id.value;
}

//비동기요청: 페이지 이동 안함
const b = () => {
	//비동기 요청 객체 생성
	const xhttp = new XMLHttpRequest();
	
	//서버로부터 응답이 왔을때 호출될 함수 등록
	xhttp.onload = () => {
	let div = document.getElementById("res");
	div.innerHTML = xhttp.responseText; //응답 텍스트

	}
	
	//요청 파라메터
	let param = "id="+f2.id.value;
	
	//전송방식, 서버페이지 설정
	xhttp.open("post", "/webApp1/ajax/idcheck");
	
	//post header 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	//요청 보냄
	xhttp.send(param);
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form name="f">
id:<input type="text" name="id" value="${id }">
<input type="button" value="중복체크" onclick="a()"><span>${msg }</span><br/>
pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name"><br/>
<input type="submit" value="가입">
</form><br/>

<form name="f2">
id:<input type="text" name="id">
<input type="button" value="중복체크" onclick="b()"><span id="res"></span><br/>
pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name"><br/>
<input type="submit" value="가입">
</form>
</body>
</html>