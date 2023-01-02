<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>트레블 스토리@_@</h2>
<a href="${pageContext.request.contextPath }/member/logout.do"><input type="button" value="로그아웃"></a>
<table border="1">
<tr>
<td><a href="${pageContext.request.contextPath }/notice/getall.do">공지사항</a></td>
<td><a href="${pageContext.request.contextPath }/notice/getall.do">여행기사</a></td>
<td><a href="${pageContext.request.contextPath }/notice/getall.do">이달의 여행지</a></td>
</tr>
</table>
</body>
</html>