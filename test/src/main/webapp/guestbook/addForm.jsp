<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���� �ۼ���</h3>
<a href="/webApp1/guestbook/list">�۸��</a>
<form action="/webApp1/guestbook/add" method="post">
<table border="1">
<tr><th>�ۼ���</th><td><input type="text" name="writer"></td></tr>
<tr><th>�ۺ�й�ȣ</th><td><input type="password" name="pwd"></td></tr>
<tr><th>����</th><td><input type="text" name="content"></td></tr>
<tr><th>����</th><td><input type="submit" value="�ۼ�"></td></tr>
</table>
</form>
</body>
</html>