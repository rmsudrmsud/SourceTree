<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인폼</h3>
<form action="${pageContext.request.contextPath }/member/login.do" method="post">

<table border="1">
<tr><th>ID</th><td><input type="text" name="id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>LOGIN</th><td><input type="submit" value="login">
<a href="${pageContext.request.contextPath }/member/add.do">회원가입</a>
</td></tr>
</table>
</form>
</body>
</html>