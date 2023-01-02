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
<h3>고속도로 휴게소 지역음식 목록</h3>
<table border="1">
<tr><th>음식명</th><th>가격</th><th>지역명</th><th>고속도로명</th><th>방향</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.menuName }</td><td>${vo.price }</td><td>${vo.area }</td>
<td>${vo.routeName }</td><td>${vo.direction }</td>
</tr>
</c:forEach>
</table>
</body>
</html>