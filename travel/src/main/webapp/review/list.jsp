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


<h3>리뷰게시판</h3>
<form action="${pageContext.request.contextPath }/review/getbytitle.do" method="post">
제목으로 검색<input type="text" name="title"><input type="submit" value="검색">
</form>

<a href="${pageContext.request.contextPath }/index.jsp">처음으로 돌아가기</a><br/>
<a href="${pageContext.request.contextPath }/review/add.do">글작성</a><br/>

<table border="1">
<tr><th width="70">글번호</th><th width="200">제목</th><th width="70">작성자</th><th width="100">작성일</th></tr>
<c:forEach var="vo" items="${list }">
<tr><td>${vo.review_num }</td><td><a href="${pageContext.request.contextPath }/review/detail.do?review_num=${vo.review_num}">${vo.title }</a></td><td>${vo.id }</td><td>${vo.date }</td></tr>
<
</c:forEach>
</table>

</body>
</html>