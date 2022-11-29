<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
const edit = () => {
	f.submit();
}
const del = () => {
	location.href="/webApp1/product/del?num=${vo.num}";
}
</script>
</head>
<body>
<h3>상세페이지</h3>
<a href="/webApp1/product/list">상품 목록</a>
<form name="f" action="/webApp1/product/edit" method="post">
<table border="1">
<tr><th>상품번호</th><td>${vo.num }</td></tr>
<tr><th>상품명</th><td><input type="text" name="name" value="${vo.name }"></td></tr>
<tr><th>상품가격</th><td><input type="number" name="amount" value="${vo.price }"></td></tr>
<tr><th>수량</th><td><input type="number" name="price" value="${vo.amount }"></td></tr>
<tr><th>수정/삭제</th>
<td><input type="button" value="수정" onclick="edit()">
	<input type="button" value="삭제" onclick="del()">
</td></tr>
</table>
<input type="hidden" name="num" value="${vo.num }"> <!--글번호 히든에담아서 보내기용도-->
</form>
</body>
</html>