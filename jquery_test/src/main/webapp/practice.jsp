<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	border:2px solid blue;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
let articles = [];
let cnt = 1;
$(document).ready(function(){
	$('#writebtn').click(function(){
		let obj = {};
		obj.num = cnt ++;
		obj.writer = $('#writer').val();
		obj.content = $('#content').val();
		obj.pwd = $('#pwd').val();
		
		articles.push(obj);
		let txt = $.mkdiv(obj);
		$('#list').append(txt);
	});
});

$.mkdiv = (article) =>{
	let txt = '<div id=div_'+article.num+'>';
	txt += 'writer:'+article.writer+'<br/>';
	txt += 'content:'+article.content+'<br/>';
	txt += '<input type=button value=수정 onclick=editForm('+article.num+')>';
	txt += '<input type=button value=삭제 onclick=del('+article.num+')>';
	txt += '</div>';
	
	return txt;
}
</script>
</head>
<body>
<form action="">
<h3>글작성</h3>
작성자 : <input type="text" id="writer" name="writer"><br/>
내용 : <input type="text" id="content" name="content"><br/>
비밀번호 : <input type="password" id="pwd" name="pwd"><br/>
<input type="button" value="작성"id="writebtn">
</form><br/>
<div id="list"></div>
</body>
</html>