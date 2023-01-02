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
<h3>영화주간랭킹</h3>
type:${type }<br/>
showRange:${showRange }<br/>
<table border="1">
<tr><th>번호</th><th>순위</th><th>영화코드</th><th>영화명</th>
<th>개봉일</th><th>누적관객수</th><th>누적매출액</th></tr>
<c:forEach var="m" items="${movielist }">
<tr><td>${m.rnum }</td><td>${m.rank }</td><td>${m.movieCd }</td>
<td><a href="${pageContext.request.contextPath }/movie/detail.do?movieCd=${m.movieCd }">${m.movieNm }</a></td><td>${m.openDt }</td>
<td>${m.audiAcc }</td><td>${m.salesAcc }</td></tr>
</c:forEach>
</table>
</body>
</html>