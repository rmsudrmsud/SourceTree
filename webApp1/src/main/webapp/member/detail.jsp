<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>상세페이지</h3>
<form action="${pageContext.request.contextPath}/member/detail" method="post">
id:<input type="text" value="${vo.id }"><br/>
pwd:<input type="text" value="${vo.pwd }"><br/>
name:<input type="text" value="${vo.name }"><br/>
email:<input type="text" value="${vo.email }"><br/>
type:
<c:if test="${vo.type==1}">구매자</c:if>
<c:if test="${vo.type==2}">판매자</c:if>
<br/>
<input type="submit" value="수정">
</form>
</body>
</html>