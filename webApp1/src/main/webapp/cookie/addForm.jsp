<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키추가</h3>
<form action="/webApp1/AddCookie" method="post">
key1:<input type="text" name="key1">
val1:<input type="text" name="val1"><br/>
key2:<input type="text" name="key2">
val2:<input type="text" name="val2"><br/>
<input type="submit" value="add">
</form>
</body>
</html>