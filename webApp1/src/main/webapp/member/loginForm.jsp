<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�α�����</h3>
<form action=${pageContext.request.contextPath}/member/login" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>LOGIN</th><td><input type="submit" value="login">
<a href="${pageContext.request.contextPath}/member/join">ȸ������</a>
</td></tr>
</table>
</form>
</body>
</html>