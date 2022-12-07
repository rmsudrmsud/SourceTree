<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 작성폼</h3>
<a href="/webApp1/guestbook/list">글목록</a>
<form action="/webApp1/guestbook/add" method="post">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer"></td></tr>
<tr><th>글비밀번호</th><td><input type="password" name="pwd"></td></tr>
<tr><th>내용</th><td><input type="text" name="content"></td></tr>
<tr><th>저장</th><td><input type="submit" value="작성"></td></tr>
</table>
</form>
</body>
</html>