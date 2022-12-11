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
<h3>자료실</h3>
<a href="${pageContext.request.contextPath }/data/add.do">글작성</a><br/>
<table border="1">
<h3>자료명으로검색</h3>
<form action="${pageContext.request.contextPath }/data/getbyfname.do" method="post">
<input type="text" name="fname">
<input type="submit" value="검색">
</form>
<tr><th>num</th><th>title</th><th>자료명</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.num }</td>
<td><a href="${pageContext.request.contextPath }/data/get.do?num=${vo.num }">${vo.title }</a></td>
<td>${vo.fname }</td>
</tr>
</c:forEach>
</table>
</body>
</html>