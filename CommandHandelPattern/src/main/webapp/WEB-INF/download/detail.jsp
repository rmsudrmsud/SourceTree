<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	let win = open("${pageContext.request.contextPath }/data/openwin.jsp", "win", "width=300,height=200");
}
</script>
</head>
<body>
<c:if test="${sessionScope.loginId != vo.writer }">
<c:set var="str">readonly</c:set>
</c:if>

<h3>�ڷ� �� ������</h3>
<a href="${pageContext.request.contextPath }/data/getall.do">�������</a><br/>
<form action="${pageContext.request.contextPath }/data/edit.do" method="post" name="f">
<table border="1">
<tr><th>�۹�ȣ</th><td><input type="text" name="num" 
value="${vo.num }" readonly></td></tr>
<tr><th>�ۼ���</th><td><input type="text" name="writer" 
value="${vo.writer }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" 
value="${vo.title }" ${str }></td></tr>
<tr><th>content</th><td><input type="text" name="content"
value="${vo.content }" ${str }></td></tr>
<tr><th>�ڷ�</th>
<td>${vo.fname }<input type="button" value="�ٿ�" onclick="a()"></td></tr>
<tr><th>�ڷ� �ٿ��</th>
<td>${vo.hit }</td></tr>
<c:if test="${sessionScope.loginId == vo.writer }">
<tr><th>����</th><td><input type="submit" value="����"></td></tr>
</c:if>
</table>
<input type="hidden" name="fname" value="${vo.fname }">
</form>
</body>
</html>