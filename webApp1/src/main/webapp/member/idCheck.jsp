<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//페이지 로드 되자마자 실행
window.onload = () => {
	let msg = "중복된 아이디";
	if(${flag}){
		msg = "사용가능한 아이디";
		msg += "<input type='button' value='사용' onclick='a()'>";
		f.id.value = '${id}';
	}
 	let div = document.getElementById("res");
 	div.innerHTML = msg;
}

const a = () => {
	//중복체크한 아이디를 회원가입 창 id입력란에 작성
	opener.document.f.id.value = window.document.f.id.value;
	opener.document.f.flag.value="true";
	//현재 창을 닫아라
	window.close();
}
</script>
</head>
<body>
<form action="/webApp1/idcheck" method="post" name="f">
id:<input type="text" name="id">
<input type="submit" value="중복체크">
</form>
<div id="res"></div>
</body>
</html>