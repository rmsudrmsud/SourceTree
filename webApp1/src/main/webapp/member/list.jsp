<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl �������� ����� ������� -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>ȸ�����</h3>
<table border="1">
<tr><th>ID</th><th>PWD</th><th>NAME</th><th>EMAIL</th></tr>
<c:forEach var="vo" items="${list }"> <!-- ��Ʈ�ѷ����� request.setAttribute(a,b) a �ڸ� -->
<tr>
	<!-- ��� id�� ��ũ�ɸ� --> <!-- idŬ���� �������� ����������� �̰͵� ��û�̴ϱ� ��������.-->
	<td><a href="/webApp1/MemDetail?id=${vo.id }">${vo.id }</a></td> <!-- MemDetail�� ���� id�� $vo.id��? ?����: �Ķ���� -->
	<td>${vo.pwd }</td>
	<td>${vo.name }</td>
	<td>${vo.email }</td>
</tr>
</c:forEach>
</table>
</body>
</html>