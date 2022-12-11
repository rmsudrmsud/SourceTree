<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	let win = open("${pageContext.request.contextPath }/download/openwin.jsp", "win", "width=300,height=200");
}
const b = () => {
	location.href = "${pageContext.request.contextPath }/download/del.do?num=${vo.num}";
}
</script>
</head>
<body>
<c:if test="${sessionScope.loginId != vo.writer }">
<c:set var="str">readonly</c:set>
</c:if>

<h3>자료 상세 페이지</h3>
<a href="${pageContext.request.contextPath }/download/getall.do">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/download/edit.do" method="post" name="f" enctype="multipart/form-data">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="num" 
value="${vo.num }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="writer" 
value="${vo.writer }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" 
value="${vo.title }" ${str }></td></tr>
<tr><th>content</th><td><input type="text" name="content"
value="${vo.content }" ${str }></td></tr>
<tr><th>자료</th>
<td>${vo.down_path }<input type="button" value="다운" onclick="a()"></td></tr>
<c:if test="${sessionScope.loginId == vo.writer }">
<tr><th>자료변경</th>
<td><input type="file" name="file"></td></tr>
</c:if>
<tr><th>자료 다운수</th>
<td>${vo.down_cnt }</td></tr>
<c:if test="${sessionScope.loginId == vo.writer }">
<tr><th>수정/삭제</th>
<td>
	<input type="submit" value="수정">
	<input type="button" value="삭제" onclick="b()">
</td></tr>
</c:if>
</table>
<input type="hidden" name="fname" value="${vo.down_path }">
</form>
</body>
</html>