<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>${vo.busRouteNm } ���� ������</h3>
bus id:${vo.busRouteId }<br/>
������:${vo.busRouteNm }<br/>
���ȸ��:${vo.corpNm }<br/>
����:${vo.stStationNm }<br/>
����:${vo.edStationNm }<br/>
ù���ð�:${vo.firstBusTm }<br/>
�����ð�:${vo.lastBusTm }<br/>
��������:${vo.term }<br/>
<a href="${pageContext.request.contextPath }/bus/routepath.do?busRouteId=${vo.busRouteId }">�뼱����Ȯ��</a>

</body>
</html>