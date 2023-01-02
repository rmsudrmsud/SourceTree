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
	<h3>대전열차 혼잡도</h3>
	<a href="${pageContext.request.contextPath }/data/csv/load.do">데이터로드</a>	<br />
	<a href="${pageContext.request.contextPath }/data/csv/list.do">대전열차혼잡도</a>	<br />
	<a href="${pageContext.request.contextPath }/data/json/load.do">고속도로 휴게소 음식메뉴</a>	<br />
	<a href="${pageContext.request.contextPath }/data/xml/load2.do">책목록</a>	<br />
	<a href="${pageContext.request.contextPath }/data/web/loadxml.do">날씨 웹연결</a>
	<a href="${pageContext.request.contextPath }/movie/loadxml.do">영화리스트(xml)</a>
	<a href="${pageContext.request.contextPath }/movie/loadjson.do">영화리스트(json)</a>
	<form action="${pageContext.request.contextPath }/bus/listbybusnm.do" method="post">
	정보 검색할 버스명 : <input type="text" name="busRouteNm"><input type="submit" value="검색">
	</form>
</body>
</html>