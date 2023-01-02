<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script type="text/javascript">
const del = () => {
	location.href = "${pageContext.request.contextPath }/notice/del.do?notice_num=${vo.notice_num}";
}
</script>
</head>
<body>
<c:if test="${sessionScope.loginId == 'admin' }">
<c:set var="str">readonly</c:set>
</c:if>
<h3>공지사항~</h3>
<a href="${pageContext.request.contextPath }/notice/getall.do">공지사항</a><br/>
<form action="${pageContext.request.contextPath }/notice/edit.do" method="post" name="f" enctype="multipart/form-data">
<table border="1">
<tr><th>글번호</th><th>작성자</th><th>제목</th><th>내용</th><th>사진</th><th>작성일</th></tr><tr>
<tr>
<td><input type ="number" name="notice_num" value="${vo.notice_num }" readonly></td>
<td><input type="text" name="id" value="${vo.id }" readonly></td>
<td><input type="text" name="title" value="${vo.title }" ${str }></td>
<td><textarea name="content">${vo.content } ${str }</textarea></td>
<td><input type="file" name="file" ${str }><img src="${vo.img_path}" style="width:500px;height:300px;"></td>
<td><input type="text" name="wdate" value="${vo.wdate }" readonly>
<c:if test="${sessionScope.loginId == 'admin' }">
	<input type="submit" value="수정">
	<input type="button" value="삭제" onclick="del()">
</c:if><br/></tr>
</table>
<input type="hidden" name="img_path" value="${vo.img_path }">
</form>
</body>
</html>