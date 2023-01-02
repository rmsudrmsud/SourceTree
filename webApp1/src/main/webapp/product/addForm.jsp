<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>상품등록</h3>
<a href="/webApp1/product/list">목록으로 돌아가기</a><br/>
<form action="/webApp1/product/add" method="post">
<table border="1">
<tr><th>제품명</th><td><input type="text" name="name"></td></tr>
<tr><th>가격</th><td><input type="number" name="price"></td></tr>
<tr><th>수량</th><td><input type="number" name="amount"></td></tr>
<tr><th>판매자</th>
<td><input type="text" name="seller" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>등록</th><td><input type="submit" value="등록"></td></tr>
</table>
</form>
</body>
</html>