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
<h3>��������</h3>
<form action="${pageContext.request.contextPath }/member/detail.do" 
method="post">
id:<input type="text" value="${vo.id }" name="id" readonly><br/>
pwd:<input type="text" value="${vo.pwd }" name="pwd"><br/>
name:<input type="text" value="${vo.name }" readonly><br/>
email:<input type="text" value="${vo.email }" readonly><br/>
type:
<c:if test="${vo.type==1 }">������</c:if>
<c:if test="${vo.type==2 }">�Ǹ���</c:if>
<br/>
<input type="submit" value="����">
</form>
</body>
</html>