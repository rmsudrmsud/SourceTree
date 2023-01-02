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
<%-- <table border="1">
<tr><th>영화명</th><th>러닝타임</th><th>개봉</th><th>감독</th><th>배우1</th><th>배우2</th><th>역할</th></tr>
<c:forEach var="m" items="${movielist }">
<tr><td>${m.movieNm }</td><td>${m.showTm }</td>
<td>${m.openDt }</td><td>${m.director}</td>
<td>${m.actor }</td><td>${m.actor2 }</td>
<td>${m.cast }</td></tr>
</c:forEach>
</table> --%>
<h3>영화 상세 페이지</h3>
<table border="1">
<tr><th>영화명</th><th>러닝타임</th><th>개봉</th><th>감독</th><th>배우1</th><th>배우2</th><th>역할</th></tr>
<c:forEach var="m" items="${movielist }">
<tr><td>${m.movieNm }</td><td>${m.showTm }</td>
<td>${m.openDt }</td><td>${m.director}</td>
<td>${m.actor }</td><td>${m.actor2 }</td>
<td>${m.cast }</td></tr>
</c:forEach>
</table>
</body>
</html>