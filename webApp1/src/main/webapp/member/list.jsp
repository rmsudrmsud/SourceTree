<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl 여러가지 기능이 들어있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>회원명단</h3>
<table border="1">
<tr><th>ID</th><th>PWD</th><th>NAME</th><th>EMAIL</th></tr>
<c:forEach var="vo" items="${list }"> <!-- 컨트롤러에서 request.setAttribute(a,b) a 자리 -->
<tr>
	<!-- 모든 id에 링크걸림 --> <!-- id클릭시 상세페이지 보내고싶으면 이것도 요청이니까 서블릿으로.-->
	<td><a href="/webApp1/MemDetail?id=${vo.id }">${vo.id }</a></td> <!-- MemDetail로 갈때 id가 $vo.id인? ?다음: 파라메터 -->
	<td>${vo.pwd }</td>
	<td>${vo.name }</td>
	<td>${vo.email }</td>
</tr>
</c:forEach>
</table>
</body>
</html>