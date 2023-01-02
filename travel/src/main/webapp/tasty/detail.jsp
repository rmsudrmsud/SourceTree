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
<c:if test="${sessionScope.loginId != vo.id }">
<c:set var="str">readonly</c:set>
</c:if>
<h3>상세페이지</h3>
<a href="${pageContext.request.contextPath }/tasty/listAll.do?city_num=${sessionScope.city_num}">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/tasty/edit.do?city_num=${sessionScope.city_num}" method="post" name="f" enctype="multipart/form-data">

<table border="1">
<tr><th>글번호</th><td><input type="text" name="tasty_num" value="${vo.tasty_num }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="id" value="${vo.id }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" value="${vo.title }" ${str }></td></tr>
<tr><th>content</th><td><input type="text" name="content" value="${vo.content }"${str }></td></tr>
<tr><th>자료</th><td><input type="file" name="file"${str }><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>

<c:if test="${sessionScope.loginId == vo.id }">

<tr><th>수정</th><td><input type="submit" value="수정"></td></tr>
<tr><th>삭제</th><td><input type="button" value="삭제" onclick="javascript:location.href='${pageContext.request.contextPath }/tasty/del.do?tasty_num=${vo.tasty_num }'"></td></tr>
</c:if>
</table>
<input type="hidden" name="img_path" value="${vo.img_path }">
</form>
</body>
</html>