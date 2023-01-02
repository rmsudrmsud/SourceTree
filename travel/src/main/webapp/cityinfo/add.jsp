<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도시정보 추가</h3>
<a href="${pageContext.request.contextPath }/cityinfo/getall.do">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/cityinfo/add.do" method="post">
<table border="1">
<tr><th>도시이름</th><td><input type="text" name="name"></td></tr>
<tr><th>아이디</th><td><input type="text" name="id" value="${sessionScope.loginId}" readonly></td></tr>
<tr><th>추가</th><td><input type="submit" value="upload"></td></tr>
</table>
</form>
</body>
</html>