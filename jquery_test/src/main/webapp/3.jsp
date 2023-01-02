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
$(document).ready(function(){
	$('#hide').click(function(){
		$('#res').hide();
	});
	
	$('#show').click(function(){
		$('#res').show();
	});
	
	$('#h').hover(function(){//아이디가#h인요소 this
		$(this).css('color','orange');
	},
			function(){
		$(this).css('color','blue');
	});
	
});
</script>
</head>
<body>
<div id="res">짜잔</div>
<input type="button" value="hide" id="hide">
<input type="button" value="show" id="show"><br/>
<h1 id="h">마우스를 올려보세요</h1>
</body>
</html>