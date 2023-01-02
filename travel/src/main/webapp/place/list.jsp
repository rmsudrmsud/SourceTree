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
<h3>관광명소!</h3>
<a href="${pageContext.request.contextPath }/index.jsp">메인</a><br/>
<c:if test="${sessionScope.loginId == 'admin' }">
<a href="${pageContext.request.contextPath }/place/add.do">명소 추가</a><br/>
</c:if>
<form action="${pageContext.request.contextPath }/place/getbyTitle.do?city_num=${sessionScope.city_num}" method="post">
<input type="text" name="fname">
<input type="hidden" name="city_num" value="${sessionScope.city_num }">
<input type="submit" value="검색">
</form>

<table border="1">
<tr><th>글번호</th><th>관광지명</th><th>설명</th><th>사진</th><th>작성일</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.place_num }</td>
<td><a href="${pageContext.request.contextPath }/place/get.do?place_num=${vo.place_num}">${vo.title }</a></td>
<td>${vo.content }</td>
<td><img src="${vo.img_path }" style="width:500px; height:100px;"></td>
<td>${vo.wdate }</td>
</tr>
</c:forEach>
</table>
</body>
</html>