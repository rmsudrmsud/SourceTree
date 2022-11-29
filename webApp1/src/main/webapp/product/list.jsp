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
<h3>상품목록</h3>

<a href="/webApp1/product/add">상품등록</a><br /><!-- 클릭시 상품등록  폼으로 -->
<c:if test="${empty list }">
등록된 상품이 없음<br/>
</c:if>
<c:if test="${not empty list }">
<form action="/webApp1/product/getbyname" method="post">
상품명:
<input type ="text" name ="name">
<input type ="submit" value="이름으로검색">
</form><br/>

<form action="/webApp1/product/getbyprice" method="post">
상품가격:
<input type ="number" name="pr1">~<input type ="number" name="pr2">
<input type ="submit" value="가격으로검색">
</form><br/>
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<!-- var: 사용할변수이름 -->
				<tr>
					<td><a href="/webApp1/product/edit?num=${vo.num }">${vo.num }</a></td><!-- edit폼에 ? 파라메터로 num=${vo.num } 넘김 -->
					<td>${vo.name }</td>
					<td>${vo.price }</td>
				</tr>
			</c:forEach>
		</table>
</c:if>
</body>
</html>