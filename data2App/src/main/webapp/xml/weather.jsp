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
<h3>${title }</h3>
<table border="1">
<c:forEach var="loc" items="${list }">
<tr>
<td>${loc.city }</td>
<td>
<table border="1">
<tr>
<th>��¥/�ð�</th><th>����</th><th>�ְ�µ�</th><th>�����µ�</th>
</tr>
<c:forEach var="data" items="${loc.list }">
<tr>
<td>${data.date }</td><td>${data.weather }</td>
<td>${data.tmx }</td><td>${data.tmn }</td>
</tr>
</c:forEach>
</table>
</td>
</tr>
</c:forEach>

</table>
</body>
</html>