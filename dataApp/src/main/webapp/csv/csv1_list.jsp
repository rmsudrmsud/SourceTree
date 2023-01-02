<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>대전 열차 어쩌고저쩌고</h1>
	<table border="1">
	<tr>
	<c:forEach var="t" items="${titles }">
		<td>${t }</td>
	</c:forEach>
	</tr>
	<c:forEach var="vo" items="${list }">
	<tr>
	<td>${vo.yy_mon }</td><td>${vo.cday }</td><td>${vo.derection }</td><td>${vo.num }</td>
	<td>${vo.cstart }</td><td>${vo.start_time }</td><td>${vo.cend }</td><td>${vo.end_time }</td>
	<td>${vo.clevel }</td><td>${vo.people_num }</td><td>${vo.date2 }</td><td>${vo.station }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>