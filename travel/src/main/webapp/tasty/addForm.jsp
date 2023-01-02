<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>맛집 업로드</h3>
<a href="${pageContext.request.contextPath }/tasty/listAll.do?city_num=${sessionScope.city_num}">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/tasty/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="id"
value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>도시명</th><td><input type= "text" name = "city_num"
value= "${sessionScope.city_num }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>content</th>
<td><textarea name="content" rows="20" cols="45"></textarea></td></tr>
<tr><th>이미지</th><td><input type="file" name="file"></td></tr>
<!-- <tr><th>올리기</th><td><input type="submit" name="upload"></td></tr> -->
<!-- <tr><th>자료</th><td><input type="text" name="file2"></td></tr> -->
<tr><th>올리기</th><td><input type="submit" name="upload"></td></tr>
</table>

</form>
</body>
</html>