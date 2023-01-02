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
<h3>${movieNm } 영화명</h3>
<table border="1">
<tr><th>러닝타임</th><td>${showTm }</td></tr>
<tr><th>개봉일</th><td>${openDt }</td></tr>
<tr><th>감독</th>
<td><c:forEach var="p" items="${directors}">
${p }<br/>
</c:forEach>
</td></tr>
<tr><th>배우</th>
<td><c:forEach var="p" items="${actors}">
<a href="${pageContext.request.contextPath }/movie/people.do?peopleNm=${p }">${p }</a><br/>
</c:forEach></td></tr>
</table>
</body>
</html>
