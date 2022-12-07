<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const edit = () => {
	let pwd = prompt("글 비밀번호 입력:");
	if(${vo.pwd}==pwd){
		f.submit();//폼 submit 버튼 클릭과 동일하게 동작
	}else{
		alert('패스워드 불일치. 수정 취소')
	}
}

const del = () => {
	let pwd = prompt("글 비밀번호 입력:");
	if(${vo.pwd}==pwd){
		location.href="/webApp1/guestbook/del?num=${vo.num}";
	}else{
		alert('패스워드 불일치. 삭제 취소')
	}
}
</script>
</head>
<body>
<h3>상세 페이지</h3>
<a href="/webApp1/guestbook/list">글목록</a><br/>
<form action="/webApp1/guestbook/edit" method="post" name="f">
<table border="1">
<tr><th>글번호</th><td>${vo.num }</td></tr>
<tr><th>작성자</th><td>${vo.writer }</td></tr>
<tr><th>작성일</th><td>${vo.w_date }</td></tr>
<tr><th>내용</th><td><input type="text" name="content" value="${vo.content }"></td></tr>
<tr><th>수정/삭제</th>
<td><input type="button" value="수정" onclick="edit()">
<input type="button" value="삭제" onclick="del()">
</td></tr>
</table>
<input type="hidden" name="num" value="${vo.num }">
</form>
</body>
</html>