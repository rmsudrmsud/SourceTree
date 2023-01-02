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
<h3>방명록</h3>
<a href="/webApp1/guestbook/add">글작성</a><br/>
<c:if test="${empty list }">
등록된 글이 없습니다<br/>
</c:if>
<c:if test="${not empty list }">
<table border="1">
<tr><th>글번호</th><th>작성자</th><th>작성일</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td><a href="/webApp1/guestbook/edit?num=${vo.num }">${vo.num }</a></td>
<td>${vo.writer }</td>
<td>${vo.w_date }</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>