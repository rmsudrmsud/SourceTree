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
<h3>첫번째 웹 앱</h3>
<!-- 로그인하지 않았을 때 -->
<c:if test="${sessionScope.loginId==null }"> 
<!-- el로값을 접근할떄 default를 찾는곳이 request.request에 담은건 이름만쓰면되고 세션스코프에담은건 sessionScop.loginId -->
	<a href="/webApp1/JoinController">회원가입</a> <!-- joincontroller에 get방식으로 요청 -->
	<a href="/webApp1/login">로그인</a>
<a href="/webApp1/guestbook/list">방명록</a>
</c:if>
<!-- 로그인 되었을때 -->
<c:if test="${sessionScope.loginId!=null }"> 
${sessionScope.loginId}님 로그인중<br/>

<a href="/webApp1/logout">로그아웃</a>
<a href="/webApp1/out?id=${sessionScope.loginId}">탈퇴</a>
<c:if test="${sessionScope.type==1 }">
구매자 : <a href="/webApp1/product/list">쇼핑몰</a>
</c:if>
<c:if test="${sessionScope.type==2 }">
판매자 : <a href="/webApp1/product/getbyseller?seller=${sessionScope.loginId }">내가 등록한 상품목록</a> 
<!-- 자신이 등록한아이디로 보기위해 ?seller=${sessionScope.loginId} -->
</c:if>
</c:if>
</body>
</html>