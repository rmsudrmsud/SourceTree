<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = () => {
	
	  let div = document.getElementById("res");
	  div.innerHTML = xhttp.responseText; 
	}
	
	let param = "?name="+f.name.value
	xhttp.open("GET", "/webApp1/ajax/test1"+param);
	//4.요청보냄
	xhttp.send();
}
const b = () => {
	
const xhttp = new XMLHttpRequest();

	xhttp.onload = () => {	
	  let div = document.getElementById("res");
	  div.innerHTML = xhttp.responseText; 
	}
	//3. 비동기 요청
	//param1 전송방식 posts, get, patch, update, delete
	//param2 요청받을 서버 페이지 경로
	let param = "name="+f.name.value
	xhttp.open("post", "/webApp1/ajax/test1");
	
	//request 헤더에 content type 을 application으로 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded"); 
	//post방식으로 보낼땐 헤더방식을 세팅해줘야 값이 정상적으로 감. @방식, application 방식
	
	//4.요청보냄
	xhttp.send(param);
}
</script>
</head>
<body>
<form action="" name="f">
name:<input type="text" name="name"><br/>
<input type="button" value="get" onclick="a()">
<input type="button" value="post" onclick="b()">
</form><br/>
<div id="res"></div>
</body>
</html>