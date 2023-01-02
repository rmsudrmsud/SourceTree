<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${vo.name }소개!</h2>
${vo.name } 사진~~~~<br/>
설명~~~~~~<br/>
<a href="${pageContext.request.contextPath }/review/getall.do?city_num=${vo.city_num}"><input type="button" name="reivew" value="여행기"></a>
<a href="${pageContext.request.contextPath }/tasty/listAll.do?city_num=${vo.city_num}"><input type="button" name="tasty" value="맛집"></a>
<a href="${pageContext.request.contextPath }/together/getall.do?city_num=${vo.city_num}"><input type="button" value="동행"></a>
<a href="${pageContext.request.contextPath }/place/getall.do?city_num=${vo.city_num}"><input type="button" value="관광명소"></a><br/>
</body>
</html>