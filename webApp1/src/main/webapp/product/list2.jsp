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
<h3>���� ����� ��ǰ</h3>
<a href="/webApp1/product/add">��ǰ���</a><br/>
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
</body>
</html>