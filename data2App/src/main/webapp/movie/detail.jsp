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
<h3>${movieNm } �� ������</h3>
<table border="1">
<tr><th>�󿵽ð�</th><td>${showTm }</td></tr>
<tr><th>������</th><td>${openDt }</td></tr>
<tr><th>����</th>
<td><c:forEach var="p" items="${directors}">
${p }<br/>
</c:forEach>
</td></tr>
<tr><th>���</th>
<td><c:forEach var="p" items="${actors}">
<a href="${pageContext.request.contextPath }/movie/people.do?peopleNm=${p }">${p }</a><br/>
</c:forEach></td></tr>
</table>
</body>
</html>
