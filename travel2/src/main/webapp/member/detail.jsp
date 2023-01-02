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
<form action="${pageContext.request.contextPath }/member/detail.do" method="post">

id:<input type="text" value="${vo.id }" name="id" readonly><br/>
pwd:<input type="text" value="${vo.pwd }" name="pwd"><br/>
name:<input type="text" value="${vo.name }" readonly><br/>
tel:<input type="text" value="${vo.tel }" ><br/>
email:<input type="text" value="${vo.email }" readonly><br/>
birth:<input type="text" value="${vo.birth }" readonly><br/>

<br/>
<input type="submit" value="수정">
</form>
</body>
</html>