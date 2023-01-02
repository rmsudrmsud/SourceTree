<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동행구해요 글 목록 </title>

</head>
<body>
<h3> 글 목록 </h3>
<a href="${pageContext.request.contextPath }/together/add.do"> 글 작성 </a><br/>

<h3> 제목으로 검색 </h3>
<form action="${pageContext.request.contextPath }/together/get.do?city_num=${sessionScope.city_num}" method="post" >
<input type="text" name="title">
<input type="hidden" name="city_num" value="${sessionScope.city_num}">
<input type="submit" value="검색">

</form>

<table border="1">
<tr><th>글 번호</th><th>작성자</th><th>글 제목</th><th>작성일</th></tr>
<c:forEach var="vo" items="${list }">
<tr><td>${vo.travel_num }</td>
<td>${vo.id }</td>
<td><a href="${pageContext.request.contextPath }/together/detail.do?travel_num=${vo.travel_num }"> ${vo.title }</a></td>
<td>${vo.wdate }</td>
</tr> 
</c:forEach> 
</table>
</body>
</html>