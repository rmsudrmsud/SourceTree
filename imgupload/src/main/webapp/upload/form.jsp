<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일 업로드</h3>
<!-- enctype="multipart/form-data" <<이거 빼먹으면 에러는없지만 이미지업로드가 안됨 -->
<form action="${pageContext.request.contextPath}/test/upload" method="post" enctype="multipart/form-data">
제목 : <input type="text" name="title"><br/>
파일 : <input type="file" name="uploadfile"><br/>
<input type="submit" value="upload">
</form>
</body>
</html>