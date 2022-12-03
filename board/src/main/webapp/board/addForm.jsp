<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글 작성</h3>
<a href="${pageContext.request.contextPath }/board/list">글 목록</a> <!-- 목록으로 돌아갈 때 list.jsp로 가면안됨. .jsp는 서블릿을 거쳐와야출력되는게 있음 -->
<!-- Guestbook의 list서블릿으로 가야함 -->
<form action="${pageContext.request.contextPath }/board/add" method="post">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }"readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><textarea rows=15 cols=45  name="content"></textarea></td></tr>
<tr><th>저장</th><td><input type="submit" value="작성"></td></tr>
</table>
</form>
</body>
</html>