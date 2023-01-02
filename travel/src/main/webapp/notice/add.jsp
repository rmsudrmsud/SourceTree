<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지사항 업로드</h3>
<a href="${pageContext.request.contextPath }/notice/getall.do">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/notice/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="id" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><input type="text" name="content"></td></tr>
<tr><th>사진</th><td><input type="file" name="file"></td></tr>
<tr><th>올리기</th><td><input type="submit" value="upload"></td></tr>
</table>
</form>
</body>
</html>