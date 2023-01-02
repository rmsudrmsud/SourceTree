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
<h1>고속도로 휴게소 음식</h1>
	<table border="1">
	<tr><th>음식명</th><th>가격</th><th>지역</th><th>고속도로명</th><th>방향</th></tr>
	<c:forEach var="vo" items="${list }">
	<tr>
	<td>${vo.menuName }</td>
	<td>${vo.price }</td>
	<td>${vo.area }</td>
	<td>${vo.routeName }</td>
	<td>${vo.direction }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>