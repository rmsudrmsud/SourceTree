<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>수정 폼</h3>
<a href="${pageContext.request.contextPath }/imgboard/list">목록</a><br/>
<form action="${pageContext.request.contextPath }/imgboard/edit" method="post">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="num" value="${vo.num }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="writer" value="${vo.writer }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" value="${vo.title }"></td></tr>
<tr><th>이미지</th><td><img src="${vo.img_path }" style="width:300px;height:200px"></td></tr>
<tr><th>content</th>
<td><textarea name="content" rows="15" cols="45">${vo.content }</textarea></td></tr>
<tr><th>수정</th><td><input type="submit" name="저장" value="저장"></td></tr>
</table>
</form>
</body>
</html>