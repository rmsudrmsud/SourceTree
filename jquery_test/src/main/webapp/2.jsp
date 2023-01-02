<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	let arr = [ {
		"name" : "daum",
		"addr" : "http://www.daum.net"
	}, {
		"name" : "naver",
		"addr" : "http://www.naver.com"
	}, {
		"name" : "google",
		"addr" : "http://www.google.com"
	} ];

	$(document).ready(function() {
		//배열이나 같은거여러개를 처리하는과정 each. 루프와 비슷
		let txt = '';
		//선택자가 없는 전역함수 each
		//파람1 arr배열의 요소. 객체하나하나를 꺼내어 item에 넣기
		$.each(arr, function(idx, item) { // item:{"name":"daum", "addr":"http://www.daum.net"}
			/* txt += 'name : ' + item.name + '/href:'+item.addr + '<br/>'; */
			txt += '<a href=' + item.addr + '>' + item.name + '</a><br/>';
		});
		$('#web').html(txt);
	});
	
	$(document).ready(function(){
		let txt = '';
		//태그이름이 td인걸 몽땅골라서 각 요소에 대해서 function함수 반복적으로 적용
		//idx방번호를 파람으로 받아서
		$('td').each(function(idx, item){ //item: <td>aaa</td>
			txt += idx+'. '+$(this).text()+'<br/>';
		});
		$('#web2').html(txt);
		$('td').css('color','red'); //.css : css적용한 함수
	});
	
</script>
</head>
<body>
	<div id="web"></div>
	<div id="web2"></div>
	<table border="1">
		<tr>
			<td>aaa</td>
			<td>bbb</td>
			<td>ccc</td>
		</tr>
		<tr>
			<td>ddd</td>
			<td>eee</td>
			<td>fff</td>
		</tr>
	</table>
</body>
</html>