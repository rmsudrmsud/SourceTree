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
<h3>��ӵ��� �ްԼ� �������� ���</h3>
<table border="1">
<tr><th>���ĸ�</th><th>����</th><th>������</th><th>��ӵ��θ�</th><th>����</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.menuName }</td><td>${vo.price }</td><td>${vo.area }</td>
<td>${vo.routeName }</td><td>${vo.direction }</td>
</tr>
</c:forEach>
</table>
</body>
</html>