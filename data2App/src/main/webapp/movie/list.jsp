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
<h3>��ȭ�ְ���ŷ</h3>
type:${type }<br/>
showRange:${showRange }<br/>
<table border="1">
<tr><th>��ȣ</th><th>����</th><th>��ȭ�ڵ�</th><th>��ȭ��</th>
<th>������</th><th>����������</th><th>���������</th></tr>
<c:forEach var="m" items="${movielist }">
<tr><td>${m.rnum }</td><td>${m.rank }</td><td>${m.movieCd }</td>
<td><a href="${pageContext.request.contextPath }/movie/detail.do?movieCd=${m.movieCd }">${m.movieNm }</a></td><td>${m.openDt }</td>
<td>${m.audiAcc }</td><td>${m.salesAcc }</td></tr>
</c:forEach>
</table>
</body>
</html>