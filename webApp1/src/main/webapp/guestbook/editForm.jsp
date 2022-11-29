<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
const edit = () => {
	let pwd = prompt("글 비밀번호 입력: ");//글비밀번호확인하기 위해서. prompt :alert에입력박스하나 더
	if(${vo.pwd}==pwd){
		f.submit(); //폼에서 sbumit버튼 누른것과 같은동작. 제출
	}else{
		alert('패스워드 불일치. 수정취소')
	}
}
const del = () => {
	let pwd = prompt("글 비밀번호 입력: ");//글비밀번호확인하기 위해서. prompt :alert에입력박스하나 더
	if(${vo.pwd}==pwd){
		location.href="/webApp1/guestbook/del?num=${vo.num}"; //guestbook/del에 요청(링크 get방식) ?num=${vo.num}
	}else{
		alert('패스워드 불일치. 수정취소')
	}
}
</script>
</head>
<body>
<h3>상세페이지</h3>
<a href="/webApp1/guestbook/list">글 목록</a>
<form name="f" action="/webApp1/guestbook/edit" method="post">
<table border="1">
<tr><th>글번호</th><td>${vo.num }</td></tr>
<tr><th>작성자</th><td>${vo.writer }</td></tr>
<tr><th>작성일</th><td>${vo.w_date }</td></tr>
<tr><th>내용</th><td><input type="text" name="content" value="${vo.content }"></td></tr> <!--원래글 내용을 박스에넣어서 실행 -->
<tr><th>수정/삭제</th>
<td><input type="button" value="수정" onclick="edit()">
	<input type="button" value="삭제" onclick="del()">
</td></tr>
</table>
<input type="hidden" name="num" value="${vo.num }"> <!--글번호 히든에담아서 보내기용도-->
</form>
</body>
</html>