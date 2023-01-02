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
<h3>${vo.busRouteNm } 버스 상세정보</h3>
bus id :${vo.busRouteId }<br/>
버스명 :${vo.busRouteNm }<br/>
운수회사 :${vo.corpNm }<br/>
기점 :${vo.stStationNm }<br/>
종점 :${vo.edStationNm }<br/>
첫차시간 :${vo.firstBusTm }<br/>
막차시간 :${vo.lastBusTm }<br/>
배차간격 : ${vo.term }<br/>
<a href="${pageContext.request.contextPath }/bus/routepath.do?busRouteId=${vo.busRouteId }">노선정보확인</a>
</body>
</html>