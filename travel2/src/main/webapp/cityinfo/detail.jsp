<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도시 수정</title>
<script type="text/javascript">
const del = () => {
	location.href = "${pageContext.request.contextPath }/cityinfo/del.do?city_num=${vo.city_num}";
}
</script>
</head>
<body>
	<c:if test="${sessionScope.loginId != vo.id }">
		<c:set var="str">readonly</c:set>
	</c:if>
	<h3>도시정보</h3>
	<a href="${pageContext.request.contextPath }/cityinfo/getall.do">도시정보</a>
	<br />
	<form action="${pageContext.request.contextPath }/cityinfo/edit.do"
		method="post" name="f">
		<!-- enctype="multipart/form-data" -->
		<table border="1">
			<tr>
				<th>도시번호</th>
				<th>도시명</th>
				<th>작성자</th>
			</tr>
			<tr>
				<td><input type="number" name="city_num"
					value="${vo.city_num }" readonly></td>
				<td><input type="text" name="name" value="${vo.name }"></td>
				<td><input type="text" name="id"
					value="${sessionScope.loginId}" readonly></td>
				<c:if test="${sessionScope.loginId == vo.id }">
					<td><input type="submit" value="수정"> <input
						type="button" value="삭제" onclick="del()"></td>
				</c:if>
			</tr>
		</table>
	</form>
</body>
</html>