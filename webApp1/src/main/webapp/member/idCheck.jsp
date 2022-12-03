<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//페이지 로드시 시작되는 함수
window.onload = () => {
	let msg = "중복된아이디"
	if(${flag}){
		alert('${id}');
		msg = "사용가능한 아이디";
		msg += "<input type='button' value='사용' onclick='a()'>";	
		f.id.value = '${id}';
	}
	let div = document.getElementById("res");
	div.innerHTML = msg;
}

const a = () => {
	//중복체크한 아이디를 회원가입창 opener(팜업창) id 입력란에 작성
	opener.document.f.id.value = window.document.f.id.value;
	
	opener.document.f.flag.value="true";
	//현재창을 닫기
	window.close();
}
</script>
</head>
<body>
<form action="/webApp1/idcheck" method="post" name="f">
id:<input type="text" name="id" id="id">
<input type="submit" value="중복체크">
</form>
<div id="res"></div>
</body>
</html>