<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품등록</h3>
<a href="/webApp1/product/list">목록으로 돌아가기</a><br/>
<form action="/webApp1/product/add" method="post">
<table border="1">
<tr><th>상품이름</th><td><input type="text" name="name"></td></tr>
<tr><th>가격</th><td><input type="number" name="price"></td></tr>
<tr><th>수량</th><td><input type="number" name="amount"></td></tr>
<tr><th>판매자</th><td><input type="text" name="seller" value="${sessionScope.loginId}" readonly></td></tr>
<tr><th>저장</th><td><input type="submit" value="작성"></td></tr>
</table>
</form>
</body>
</html>