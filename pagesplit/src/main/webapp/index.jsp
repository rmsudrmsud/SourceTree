<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지분할</title>
</head>
<body>
<table border="1">
<tr style="height: 200px">
   <td colspan="2">
   <%@include file="a.jsp"%>
   </td>
</tr>

<tr style="height: 400px">
   <td style="width:200px">
   <%@include file="b.jsp"%>  <%-- 고정된페이지 인클루드지시자 <%@include file="b.jsp"%>  --%>
   </td>  
   
   <td style="width:400px">
   <jsp:include page="${view }"/> <%-- 인클루드 액션태그 jsp:include page="${view }"컴파일해서 가져와서 동적이니페이지에서 사용가능  --%>
   </td>
</tr>
</table>
</body>
</html>