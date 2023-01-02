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
<h3>공지사항</h3>
<a href="${pageContext.request.contextPath }/index.jsp">메인</a><br/>
<c:if test="${sessionScope.loginId == 'admin' }">
<a href="${pageContext.request.contextPath }/notice/add.do">공지사항 작성</a><br/>
</c:if>
<form action="${pageContext.request.contextPath }/notice/getbyTitle.do" method="post">
<input type="text" name="fname">
<input type="submit" value="검색">
</form>
<table border="1">
<tr><th>글번호</th><th>제목</th><th>작성일</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.notice_num }</td>
<td><a href="${pageContext.request.contextPath }/notice/get.do?notice_num=${vo.notice_num}">${vo.title }</a></td>
<td>${vo.wdate }</td>
</tr>
</c:forEach>
</table>
</body>
</html>