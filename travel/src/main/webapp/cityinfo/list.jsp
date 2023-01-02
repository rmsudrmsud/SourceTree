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
	location.href = "${pageContext.request.contextPath }/cityinfo/get.do?city_num=${vo.city_num}";
}
</script>
</head>
<body>
<h2>도시정보</h2>
<a href="${pageContext.request.contextPath }/index.jsp">메인</a><br/>
<c:if test="${sessionScope.loginId == ${vo.id} }">
<a href="${pageContext.request.contextPath }/cityinfo/add.do">도시정보 추가</a><br/>
</c:if>
<table border="1">
<tr><th>글번호</th><th>도시이름</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.city_num }</td>
<td><a href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=${vo.city_num}">${vo.name }</a>
<a href= "${pageContext.request.contextPath }/cityinfo/get.do?city_num=${vo.city_num}"><input type="button" name="edit" value="상세"></a></td>
</tr>
</c:forEach>
</table>
</body>
</html>