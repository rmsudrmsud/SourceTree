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
<h3>책목록</h3>
<table border="1">
<tr><th>id</th><th>title</th><th>author</th><th>price</th></tr>
<c:forEach var="vo" items="${list }">
<tr><td>${vo.bookid }</td><td>${vo.title }</td><td>${vo.author }</td>
<td>${vo.price }</td></tr>
</c:forEach>
</table>
</body>
</html>