<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ǰ �� ������</h3>
<a href="/webApp1/product/getbyseller?seller=${sessionScope.loginId }">������� ���ư���</a><br/>
<form action="/webApp1/product/detail" method="post">
<table border="1">
<tr><th>��ǰ��ȣ</th><td><input type="text" name="num" value="${vo.num }" readonly></td></tr>
<tr><th>��ǰ��</th><td><input type="text" name="name" value="${vo.name }"></td></tr>
<tr><th>����</th><td><input type="number" name="price" value="${vo.price }"></td></tr>
<tr><th>����</th><td><input type="number" name="amount" value="${vo.amount }"></td></tr>
<tr><th>�Ǹ���</th>
<td><input type="text" name="seller" value="${vo.seller }" readonly></td></tr>
<tr><th>����</th><td><input type="submit" value="����"></td></tr>
</table>
</form>
</body>
</html>