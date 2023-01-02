<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = (num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	  let div = document.getElementById("msg");
	  div.innerHTML = xhttp.responseText;
	}
	xhttp.open("GET", 
	"${pageContext.request.contextPath }/board/detail?type=1&num="+num);
	xhttp.send();
}
const b = () => {
	let div = document.getElementById("msg");
	div.innerHTML = "";
}
</script>
</head>
<body>
	<h3>게시판</h3>
	<a href="${pageContext.request.contextPath }/board/add">글작성</a>
	<br />
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.num }</td>
				<td onmouseover="a(${b.num })" onmouseout="b()"><a
					href="${pageContext.request.contextPath }/board/detail?type=2&num=${b.num }">
						${b.title }</a></td>
				<td>${b.writer }</td>
			</tr>
		</c:forEach>
	</table>
	<div id="msg"
		style="position: absolute; top: 100px; left: 300px; color: blue"></div>
</body>
</html>