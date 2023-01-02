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
<h3>대전 열차 복잡도측정</h3>
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