<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�ڷ� ���ε�</h3>
<a href="${pageContext.request.contextPath }/data/getall.do">�������</a><br/>
<form action="${pageContext.request.contextPath }/data/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>�ۼ���</th><td><input type="text" name="writer" 
value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>content</th><td><input type="text" name="content"></td></tr>
<tr><th>�ڷ�</th><td><input type="file" name="file"></td></tr>
<tr><th>�ø���</th><td><input type="submit" value="upload"></td></tr>
</table>
</form>
</body>
</html>