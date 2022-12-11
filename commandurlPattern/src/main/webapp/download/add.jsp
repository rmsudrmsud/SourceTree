<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자료 업로드</h3>
<a href="${pageContext.request.contextPath }/download/getall.do">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/download/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><input type="text" name="content"></td></tr>
<tr><th>자료</th><td><input type="File" name="file"></td></tr>
<tr><th>올리기</th><td><input type="submit" value="upload"></td></tr>
</table>
</form>
</body>
</html>