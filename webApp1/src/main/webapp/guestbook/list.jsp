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
<h3>����</h3>
<a href="/webApp1/guestbook/add">���ۼ�</a><br/>
<c:if test="${empty list }">
��ϵ� ���� �����ϴ�<br/>
</c:if>
<c:if test="${not empty list }">
<table border="1">
<tr><th>�۹�ȣ</th><th>�ۼ���</th><th>�ۼ���</th></tr>
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