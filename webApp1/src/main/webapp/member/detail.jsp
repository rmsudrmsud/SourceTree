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
<h3>상세페이지</h3>
id:${vo.id }<br/>
pwd:${vo.pwd }<br/>
name:${vo.name }<br/>
email:${vo.email }<br/>
type:
<c:if test="${vo.type==1 }">구매자</c:if>
<c:if test="${vo.type==2 }">판매자</c:if>
<br/>
</body>
</html>