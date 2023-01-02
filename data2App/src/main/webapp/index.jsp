<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>공공 데이터 활용</h3>
<a href="${pageContext.request.contextPath }/data/csv/load.do">데이터로드</a><br/>
<a href="${pageContext.request.contextPath }/data/csv/list.do">대전열차혼잡도</a>
<a href="${pageContext.request.contextPath }/data/json/load.do">고속도로 휴게소 메뉴</a>
<a href="${pageContext.request.contextPath }/data/xml/load2.do">책목록</a><br/>
<a href="${pageContext.request.contextPath }/movie/loadxml.do">이번주 영화순위(xml)</a><br/>
<a href="${pageContext.request.contextPath }/movie/loadjson.do">이번주 영화순위(json)</a><br/>
<form action="${pageContext.request.contextPath }/bus/listbybusnm.do" method="post">
정보 검색할 버스명:<input type="text" name="busRouteNm">
<input type="submit" value="검색">
</form>
</body>
</html>