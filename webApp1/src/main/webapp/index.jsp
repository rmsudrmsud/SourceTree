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
<h3>첫번째 웹 앱</h3>
<c:if test="${sessionScope.loginId==null }">
	<a href="/webApp1/JoinController">회원가입</a>
	<a href="/webApp1/login">로그인</a>
	<a href="/webApp1/guestbook/list">방명록</a><br/>
</c:if>
<c:if test="${sessionScope.loginId!=null }">
${sessionScope.loginId}님 로그인중<br/>
<a href="/webApp1/logout">로그아웃</a><br/>
<a href="/webApp1/out?id=${sessionScope.loginId}">탈퇴</a><br/>

<c:if test="${sessionScope.type=1} }">구매자회원</c:if>
<a href="/webApp1/product/list">쇼핑몰</a><br/>
<c:if test="${sessionScope.type=2} }">판매자회원</c:if><br/>
<a href="/webApp1/product/getbyseller?seller=$<sessionScope.loginId}">내가 등록한 상품 목록</a><br/>

</c:if>
</body>
</html>