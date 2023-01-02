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
<h3>검색된 버스 목록</h3>
<c:forEach var="b" items="${list }">
<a href="${pageContext.request.contextPath }/bus/infobyrouteid.do?busRouteId=${b.busRouteId}">${b.busRouteNm }</a><br/>
</c:forEach>
</body>
</html>