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
<h3>상품목록</h3>
<c:if test="${empty list }">
등록된 상품이 없음<br/>
</c:if>
<c:if test="${not empty list }">
<form action="/webApp1/product/getbyname" method="post">
제품명:<input type="text" name="name">
<input type="submit" value="이름으로 검색">
</form><br/>
<form action="/webApp1/product/getbyprice" method="post">
가격범위:<input type="number" name="pr1">~<input type="number" name="pr2">
<input type="submit" value="가격으로 검색">
</form><br/>
<form action="/webApp1/product/getbyseller" method="post">
판매자명:<input type="text" name="seller">
<input type="submit" value="판매자로 검색">
</form><br/>
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
</c:if>
</body>
</html>