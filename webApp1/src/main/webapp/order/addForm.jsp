<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	let payment = ${vo.price} * parseInt(f.amount.value);
	f.payment.value=payment;
	let span = document.getElementById("res");
	span.innerHTML = payment;
}
</script>
</head>
<body>
<h3>구매 페이지</h3>
<a href="/webApp1/product/list">목록으로 돌아가기</a>
<form action="/webApp1/order/add" method="post" name="f" >
<table border="1">
<tr><th>상품명</th><td><input type="text"  value="${vo.name }" readonly></td></tr>
<tr><th>상품가격</th><td><input type="text" value="${vo.price } " readonly></td></tr>
<tr><th>재고수량</th><td><input type="number" value="${vo.amount }" readonly></td></tr>
<tr><th>판매자</th>
	<td><input type="text" name="seller" value="${vo.seller}" readonly></td></tr>
<tr><th>주문수량</th>
	<td>
	<input type="number" name="amount" onchange="a()"><br/>
	결제금액:<span id="res"></span>
	</td></tr>
<tr><th>구매</th>
<td><input type="submit" value="즉시결제">
	<input type="button" value="장바구니">
</td></tr>
</table>
<input type="hidden" name="num" value="${vo.num }"> <!--글번호 히든에담아서 보내기용도-->
<input type="hidden" name="payment"> <!-- 결제금액 -->
<input type="hidden" name="pay" value="ture"><!-- 즉시결제와 장바구니를 구분하기위한 true ㄹ민 -->
</form>
</body>
</html>