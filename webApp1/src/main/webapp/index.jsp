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
<h3>ù��° �� ��</h3>
<c:if test="${sessionScope.loginId==null }">
	<a href="/webApp1/JoinController">ȸ������</a>
	<a href="/webApp1/login">�α���</a>
	<a href="/webApp1/guestbook/list">����</a><br/>
</c:if>
<c:if test="${sessionScope.loginId!=null }">
${sessionScope.loginId}�� �α�����<br/>
<a href="/webApp1/logout">�α׾ƿ�</a><br/>
<a href="/webApp1/out?id=${sessionScope.loginId}">Ż��</a><br/>

<c:if test="${sessionScope.type=1} }">������ȸ��</c:if>
<a href="/webApp1/product/list">���θ�</a><br/>
<c:if test="${sessionScope.type=2} }">�Ǹ���ȸ��</c:if><br/>
<a href="/webApp1/product/getbyseller?seller=$<sessionScope.loginId}">���� ����� ��ǰ ���</a><br/>

</c:if>
</body>
</html>