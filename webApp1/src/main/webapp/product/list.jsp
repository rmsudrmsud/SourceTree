<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ǰ���</h3>
<c:if test="${empty list }">
��ϵ� ��ǰ�� ����<br/>
</c:if>
<c:if test="${not empty list }">
<form action="/webApp1/product/getbyname" method="post">
��ǰ��:<input type="text" name="name">
<input type="submit" value="�̸����� �˻�">
</form><br/>
<form action="/webApp1/product/getbyprice" method="post">
���ݹ���:<input type="number" name="pr1">~<input type="number" name="pr2">
<input type="submit" value="�������� �˻�">
</form><br/>
<form action="/webApp1/product/getbyseller" method="post">
�Ǹ��ڸ�:<input type="text" name="seller">
<input type="submit" value="�Ǹ��ڷ� �˻�">
</form><br/>
<table border="1">
<tr><th>��ȣ</th><th>��ǰ��</th><th>����</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.num }</td>
<td><a href="/webApp1/product/detail?num=${vo.num }">${vo.name }</a></td>
<td>${vo.price }</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>