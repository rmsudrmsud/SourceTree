<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ǰ���</h3>
<a href="/webApp1/product/list">������� ���ư���</a><br/>
<form action="/webApp1/product/add" method="post">
<table border="1">
<tr><th>��ǰ��</th><td><input type="text" name="name"></td></tr>
<tr><th>����</th><td><input type="number" name="price"></td></tr>
<tr><th>����</th><td><input type="number" name="amount"></td></tr>
<tr><th>�Ǹ���</th>
<td><input type="text" name="seller" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>���</th><td><input type="submit" value="���"></td></tr>
</table>
</form>
</body>
</html>