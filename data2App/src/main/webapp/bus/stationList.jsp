<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.stations').hover(function(){
		let arsId = $(this).attr('num');
		$.ajax({
			url : "${pageContext.request.contextPath }/bus/stationtobus.do",
			type : 'post',
			data : {'arsId':arsId},
			dataType: 'json', //결과 형태			
			success : function(result) {//성공했을때 실행
				let txt = '';
				for(let s of result){
					txt += s+'<br/>';
				}
				$('#res_'+arsId).html(txt);
			},
			error: function(req, status, error){//에러 발생시 실행
				alert(status);
			}
		});
	}, function(){
		let arsId = $(this).attr('num');
		$('#res_'+arsId).html("");
	});
});
</script>
</head>
<body>
	<h3>${busRouteNm }의경유 정류장 목록</h3>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>정거장명</th>
			<th>x</th>
			<th>y</th>
			<th>진행방향</th>
		</tr>
		<c:forEach var="s" items="${list }">
			<tr>
				<td>${s.seq }</td>
				<td class="stations" num="${s.arsId}">${s.stationNm }
					<div id="res_${s.arsId}"></div>
				</td>
				<td>${s.gpsX }</td>
				<td>${s.gpsY }</td>
				<td>${s.direction }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>