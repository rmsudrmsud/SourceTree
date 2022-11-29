<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 지시자. foreach태그 쓰고싶어서 사용 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>방명록</h3>
	<a href="/webApp1/guestbook/add">글작성</a>
	<br />
	<c:if test="${empty list}">
		<!-- c:if test="조건" jstl에서 if는 else가없음 -->
	등록된 글이 없습니다.<br />
	</c:if>
	<c:if test="${not empty list}">
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<!-- var: 사용할변수이름 -->
				<tr>
					<td><a href="/webApp1/guestbook/edit?num=${vo.num }">${vo.num }</a></td> <!-- edit폼에 ? 파라메터로 num=${vo.num } 넘김 -->
					<td>${vo.writer }</td>
					<td>${vo.w_date }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>