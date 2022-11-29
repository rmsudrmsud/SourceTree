<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 페이지 디렉티브. jsp페이지의 현재설정 -->
    <!-- jsp도 html 과비슷하게 하지만 자바언어를 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입</h3>
<form action="/webApp1/JoinController" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
<tr><th>가입완료</th><td><input type="submit" value="가입"></td></tr>
</table>
</form>
</body>
</html>