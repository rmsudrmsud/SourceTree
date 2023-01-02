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
<h3>맛집게시판</h3>
<a href="${pageContext.request.contextPath }/cityinfo/getall.do">목록으로</a><br/>
<a href="${pageContext.request.contextPath }/tasty/add.do">글작성</a><br/>
<table border="1">
<tr><th>num</th><th>city_num</th><th>title</th><th>작성자</th><th>작성일</th><th>이미지</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.tasty_num }</td>
<td>${vo.city_num }</td>
<td><a href="${pageContext.request.contextPath }/tasty/detail.do?tasty_num=${vo.tasty_num }">${vo.title }</a></td>
<%-- <td>${vo.img_path }</td> --%>
<td>${vo.id }</td>
<td>${vo.wdate }</td>
<td><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>
</c:forEach>
</table>

<h3>검색</h3>
<form action="${pageContext.request.contextPath }/tasty/listTitle.do?city_num=${sessionScope.city_num}">
<!-- <input type="hidden" name="url" value="/data/getbyfname.do"> -->
제목으로 검색 : <input type="text" name="title"><br/>
<input type="hidden" name="city_num" value="${sessionScope.city_num }">
<input type="submit" value="검색하기">
</form>



</body>
</html>