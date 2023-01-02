<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<h3>${busRouteNm }의 경유 정류장</h3>
<table border="1">
	<tr>
		<th>버스정류장</th>
		<th>방향</th>
	</tr>
<c:forEach var="v" items="${list }">
	<tr>
		<td>${v.stationNm}</td>
		<td>${v.direction }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>