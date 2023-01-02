<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>상품 상세 페이지</h3>
<a href="/webApp1/product/getbyseller?seller=${sessionScope.loginId }">목록으로 돌아가기</a><br/>
<form action="/webApp1/product/detail" method="post">
<table border="1">
<tr><th>제품번호</th><td><input type="text" name="num" value="${vo.num }" readonly></td></tr>
<tr><th>제품명</th><td><input type="text" name="name" value="${vo.name }"></td></tr>
<tr><th>가격</th><td><input type="number" name="price" value="${vo.price }"></td></tr>
<tr><th>수량</th><td><input type="number" name="amount" value="${vo.amount }"></td></tr>
<tr><th>판매자</th>
<td><input type="text" name="seller" value="${vo.seller }" readonly></td></tr>
<tr><th>수정</th><td><input type="submit" value="수정"></td></tr>
</table>
</form>
</body>
</html>