<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>내가 등록한 상품</h3>
<a href="/webApp1/product/add">상품등록</a><br/>
<table border="1">
<tr><th>번호</th><th>상품명</th><th>가격</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.num }</td>
<td><a href="/webApp1/product/detail?num=${vo.num }">${vo.name }</a></td>
<td>${vo.price }</td>
</tr>
</c:forEach>
</table>
</body>
</html>