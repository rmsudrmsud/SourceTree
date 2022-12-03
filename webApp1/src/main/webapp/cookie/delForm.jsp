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
<h3>쿠키삭제</h3>
<form action="/webApp1/DelCookie" method="post">
<input type="radio" value="${cookie.key1.name }" name="ra">
<!-- el로 쿠키값 접근하는 방법 -->
${cookie.key1.name } / ${cookie.key1.value }<br/>
<input type="radio" value="${cookie.key2.name }" name="ra">
${cookie.key2.name } / ${cookie.key2.value }
<input type = "submit" value="삭제"><br/>
</form>
</body>
</html>