<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>영화인상세페이지</h3>
<table border="1">
<tr><th>pcode</th><th>name</th><th>filmos</th></tr><tr>
<c:forEach var="p" items="${list }">
<tr>
<td>${p.pcode }</td><td>${p.name }</td>
<td><c:forEach var="f" items="${p.filmos }">
${f }
</c:forEach></td>
</tr>
</c:forEach>
</table>
</body>
</html>