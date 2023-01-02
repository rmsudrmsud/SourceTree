<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
<form action="${pageContext.request.contextPath }/imgboard/add" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>이미지</th><td><input type="file" name="file"></td></tr>
<tr><th>content</th>
<td><textarea name="content" rows="15" cols="45"></textarea></td></tr>
<tr><th>올리기</th><td><input type="submit" name="글작성"></td></tr>
</table>
</form>
</body>
</html>