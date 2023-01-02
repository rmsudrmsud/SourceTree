<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>리뷰글 작성폼</h3>
<a href="${pageContext.request.contextPath }/review/getall.do?city_num=${sessionScope.city_num}">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/review/add.do" method="post" name="f"  enctype="multipart/form-data">
<table border="1">
<tr><th>제목</th><td><input type="text" name="title" placeholder="제목을 입력해주세요" style="width: 340px; height: 30px;"></td></tr>
<tr><th>본문</th><td><textarea name="content" cols="50" rows="30" placeholder="본문을 입력해주세요"></textarea></td></tr>
<tr><th>이미지</th><td><input type="file" name="file"></td></tr>
<tr><th></th><td><input type="submit" value="작성"></td></tr>
</table>
<input type="hidden" name="id" value="${sessionScope.loginId }">
<input type="hidden" name="city_num" value="${sessionScope.city_num }">
</form>
</body>
</html>