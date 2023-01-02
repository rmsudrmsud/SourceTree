<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	// 1. 비동기 request객체 생성
	const xhttp = new XMLHttpRequest();

	// 2. 응답을 받았을때 자동 호출될 함수를 등록
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	  let div = document.getElementById("res");
	  div.innerHTML = xhttp.responseText; //응답 텍스트
	}

	// 3. 비동기 요청 설정
	//param1:전송방식. post, get, patch, update, delete
	//param2: 요청받을 서버페이지 경로
	let param = "?name="+f.name.value
	xhttp.open("GET", "/webApp1/ajax/test1"+param);

	// 4. 요청보냄
	xhttp.send();
}

const b = () => {
	// 1. 비동기 request객체 생성
	const xhttp = new XMLHttpRequest();

	// 2. 응답을 받았을때 자동 호출될 함수를 등록
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	  let div = document.getElementById("res");
	  div.innerHTML = xhttp.responseText; //응답 텍스트
	}

	// 3. 비동기 요청 설정
	//param1:전송방식. post, get, patch, update, delete
	//param2: 요청받을 서버페이지 경로
	let param = "name="+f.name.value
	xhttp.open("post", "/webApp1/ajax/test1");

	//request 헤더에 content type을 application으로 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	// 4. 요청보냄
	xhttp.send(param);
}
</script>
</head>
<body>
<form action="" name="f">
name:<input type="text" name="name"><br/>
<input type="button" value="get전송" onclick="a()">
<input type="button" value="post전송" onclick="b()">
</form><br/>
<div id="res"></div>
</body>
</html>