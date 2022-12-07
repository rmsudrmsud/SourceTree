<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="str">readonly</c:set>
<c:if test="${sessionScope.loginId==vo.writer }">
<c:set var="str"></c:set>
</c:if>
<h3>댓글수정</h3>
<form action="${pageContext.request.contextPath }/rep/edit" method="post" >
<table border="1">
<tr><th>글번호</th>
<td><input type="text" name="num" value="${vo.num }" readonly></td></tr>
<tr><th>작성자</th>
<td><input type="text" name="writer" value="${vo.writer }" readonly></td></tr>
<tr><th>내용</th>
<td><textarea cols="45" rows="15" name="content" ${str }>${vo.content }</textarea></td></tr>
<c:if test="${sessionScope.loginId==vo.writer }">
<tr><th>수정/삭제</th>
<td>
	<input type="submit" value="edit">
	<input type="button" value="delete" onclick="del()">
</td></tr>
</c:if>
</table>
</form>
</body>
</html>