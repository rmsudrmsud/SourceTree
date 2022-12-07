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
<a href="${pageContext.request.contextPath }/download/add">글작성</a><br/>
<c:forEach var="vo" items="${list }">
<table border="1">
<tr><th>번호</th><td>${vo.num }
<c:if test="${sessionScope.loginId ==vo.writer }">
<input type ="button" value="수정" onclick="javascript:location.href='${pageContext.request.contextPath }/imgboard/edit?num=${vo.num }'">
<input type ="button" value="삭제" onclick="javascript:location.href='${pageContext.request.contextPath }/imgboard/del?num=${vo.num }'">
</c:if>
</td></tr>
<tr><th>작성자</th><td>${vo.writer }</td></tr>
<tr><th>날짜</th><td>${vo.w_date }</td></tr>
<tr><th>제목</th><td>${vo.title }</td></tr>
<c:forEach var="f" items="${files }">
<ul>
<li><a href="${pageContext.request.contextPath }/DownFile?fname=${f }">${f }</a></li>
</ul>
</c:forEach>
<tr><th>내용</th><td>${vo.content }</td></tr>
</table>
</c:forEach>
</body>
</html>