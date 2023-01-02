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
<th>날짜/시간</th><th>날씨</th><th>최고온도</th><th>최저온도</th>
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