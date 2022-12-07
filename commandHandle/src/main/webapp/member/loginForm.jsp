<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인</h3>
<form action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
<input type="hidden" name="url" value="/member/login">
<table border="1">
<tr><th>ID:<input type="text" name="id"><br/></th></tr>
<tr><th>PWD:<input type="password" name="pwd"><br/></th></tr>
<tr><th>Login</th><td><input type="submit" value="login">
<a href="${pageContext.request.contextPath}/DispatcherServlet">회원가입</a>
</td></tr>
</table>
</form>
</body>
</html>