<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���� ������ Ȱ��</h3>
<a href="${pageContext.request.contextPath }/data/csv/load.do">�����ͷε�</a><br/>
<a href="${pageContext.request.contextPath }/data/csv/list.do">��������ȥ�⵵</a>
<a href="${pageContext.request.contextPath }/data/json/load.do">��ӵ��� �ްԼ� �޴�</a>
<a href="${pageContext.request.contextPath }/data/xml/load2.do">å���</a><br/>
<a href="${pageContext.request.contextPath }/movie/loadxml.do">�̹��� ��ȭ����(xml)</a><br/>
<a href="${pageContext.request.contextPath }/movie/loadjson.do">�̹��� ��ȭ����(json)</a><br/>
<form action="${pageContext.request.contextPath }/bus/listbybusnm.do" method="post">
���� �˻��� ������:<input type="text" name="busRouteNm">
<input type="submit" value="�˻�">
</form>
</body>
</html>