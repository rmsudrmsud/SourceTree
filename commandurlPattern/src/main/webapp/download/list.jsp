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
<h3>자료실</h3>
<a href="${pageContext.request.contextPath }/index.jsp">첫화면</a><br/>
<a href="${pageContext.request.contextPath }/download/add.do">글작성</a><br/>
<form action="${pageContext.request.contextPath }/download/getbyPath.do" method="post">
자료명으로 검색: <input type="text" name="fname"><input type="submit" value="검색"><br/>
</form>
<table border="1">
<tr><th>번호</th><th>제목</th><th>자료명</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.num }</td>
<td><a href="${pageContext.request.contextPath }/download/get.do?num=${vo.num}">${vo.title }</a></td>
<td>${vo.down_path }</td>
</tr>
</c:forEach>
</table>
</body>
</html>