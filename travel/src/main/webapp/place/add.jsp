<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>관광명소 추가</h3>
<a href="${pageContext.request.contextPath }/place/getall.do?city_num=${sessionScope.city_num }">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/place/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>도시번호<input type="text" name="city_num" value="${sessionScope.city_num }" readonly></th></tr>
<tr><th>작성자</th><td><input type="text" name="id" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>관광지명</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><textarea  name="content" cols="15" rows="15"></textarea></td></tr>
<tr><th>사진</th><td><input type="file" name="file"></td></tr>
<tr><th>올리기</th><td><input type="submit" value="upload"></td></tr>
</table>
</form>
</body>
</html>