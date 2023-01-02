<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<Script type="text/javascript">
//페이지 시작시 실행
//이름이없는 익명함수
$(document).ready(function(){
	alert('hello jquery');
	
	//onclick과 동일
	$('#b1').click(function(){
		let txt = $('#t1').val(); //입력양식의 값을 읽는 함수
		//값을 입력하는 여러가지 방법
		$('#memo').text(txt);
		/* $('#memo').html(txt);
		$('#memo').innerHTML = txt; */
		$('#t1').val(''); //읽기버튼 누르구 div가고 텍스트박스내용이 지워짐
	});
	
	$('#b2').click(function(){
		$('#t1').val('hello ');
		
	});
	
	$('#b3').click(function(){
		let txt = ''; //문자열변수선언
		//let arr = $('.c1');
		$('.c1').each(function(idx, item){
			//클래스이름이 c1인 요소선택하는 배열
			//each : 똑같은 배열등의 요소를 반복작업 처리하는 요소
			//for문의 idx값을 item에 담음
			
			//txt += idx+'번째 요소값 : '+item.innerHTML+'<br/>';
			txt += idx+'번째 요소값 : '+$(this).text()+'<br/>'; //this 현재의 객체
		});
		
		$('#memo').html(txt);
		//$('input[type=text]') 태그의속성값으로 골라내기
		
		/* 이벤트함수 동작
		$('#memo').click(function(){
			asdf등등
		});
		*/
		
		});
	
	
});

</Script>
</head>
<body>
<form>
	<input type="text" id="t1">
	<input type="button" id="b1" value="읽기">
	<input type="button" id="b2" value="쓰기">
	<input type="button" id="b3" value="h태그 읽기">
</form>
<div id="memo"></div>
<h3 class="c1">aaa</h3>
<h3 class="c2">bbb</h3>
<h3 class="c1">ccc</h3>
<h3 class="c2">ddd</h3>
<h3 class="c1">eee</h3>
</body>
</html>