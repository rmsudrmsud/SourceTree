<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
/* $('#memo').keydown();
 		textarea에 최대 입력 글자수 100글자
		글자 입력시 마다 박스위에 남은입력글자수 출력
*/
$(document).ready(function(){
	$('#txt').keyup(function(){ //id가 txt인요소의 keyup 이벤트 발생시 안의함수 실행
		//alert($(this).text());
		let txt = $('#txt').val();//id가 txt인요소의 입력값 읽기 입력양식이기때문에 val.
		let cnt = 100 - txt.length;
		if(cnt<0){
			$('#txt').val(txt.substring(0,100)); //문자열 잘라내는 자바스크립트함수 substring (0,100) 시작위치0부터 100개만
			cnt=0;
		}
		$('#res').text(cnt+'글자남음');
		$('#res').css('color','red');
	});
});
</script>
</head>
<body>
<div id='res'>100글자까지 입력가능</div>
<textarea rows="20" cols="45" id="txt"></textarea>
</body>
</html>