<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>업로드</h3>
<form action="${pageContext.request.contextPath }/download/add" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>파일</th><td><input type="file" name="file"></td></tr>
<tr><th>내용</th>
<td><textarea name="content" rows="15" cols="45"></textarea></td></tr>
<tr><th>업로드</th><td><input type="submit" name="업로드"></td></tr>
</table>
</form>
</body>
</html>