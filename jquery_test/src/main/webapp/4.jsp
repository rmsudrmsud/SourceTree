<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	border:2px solid black;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

let articles = []; //articles: 배열하나 전역으로 선언
let cnt = 1; //글번호로 사용할함수

$.mkdiv = (article) => {
	let txt = '<div id=div_'+article.num+'>';
	txt += 'writer:'+article.writer+'<br/>';
	txt += 'content:'+article.content+'<br/>';
	txt += '<input type=button value=수정 onclick=editForm('+article.num+')>';
	txt += '<input type=button value=삭제 onclick=del('+article.num+')>';
	txt += '</div>';
	
	return txt;
}

$(document).ready(function(){
	$('#writebtn').click(function(){
		let obj = {};//빈객체 생성. 글작성을 위함
		obj.num = cnt++;
		obj.writer = $('#writer').val();
		obj.content = $('#content').val();
		obj.pwd = $('#pwd').val();
		
		//push(): 배열의 끝에 요소를 추가하는 함수
		articles.push(obj);
		
// 		for(obj of articles){
// 			for(key in obj){
// 				alert(key+":"+obj[key]);
// 			}
// 		}
		let txt = $.mkdiv(obj);
		$('#list').append(txt);//append 끝에 자식노드추가 == dom에서 appendchild
	});
});

$.refresh=()=>{
	$.each(articles, function(idx, item){ //each : 각각의 목록에 적용 articles배열에서 요소하나씩 꺼내어서 적용
		$('#list').append($.mkdiv(item)); //div로 만들어 리스트에 추가
		//전체목록
	});
}

$.delall=()=>{
	$('#list').html('');
}


$.getbynum=(num)=>{
	for(i=0;i<articles.length;i++){
		if(articles[i].num==num){
			return i;
		}
	}
	return -1;
}


/* const editForm = (num) => { */
function editForm(num){
 	alert('edit form:'+num);
	let idx = $.getbynum(num); //번호로 배열에서 몇번째 글인지 꺼내주는 함수
	if(idx<0){
		alert('없는 글번호');
		return;
	}
	//수정폼(바디의자식이었던)을 수정을 선택한 글의div 로 가져오기
	$('#div_'+num).append($('#editf')); //글수정폼을 자식으로 붙임
	//수정폼의 작성자와 글내용을 원글의 내용으로 출력
	$('#editwriter').val(articles[idx].writer); //articles[idx] : 사용자가 배열에서 꺼낸 부분(getbynum)
	$('#editcontent').val(articles[idx].content);
	//수정할 글의 articles배열에서의 위치 값을 히든객체에 저장
	$('#editidx').val(idx);
	//수정폼을 화면에 보여줌
	$('#editf').show();
	}
	
function del(num) {
// 	alert('del:'+num);
/* 부모.remove($('$div_글번호')) */
	let idx = $.getbynum(num);
	if(idx<0){
		alert('없는 글번호');
		return;
	}
	let pwd = prompt("비밀번호");
	if(pwd==articles[idx].pwd){
		articles.splice(idx, 1);
		$('#div_'+num).remove();
	}else{
		alert('비밀번호 불일치');
	}
	
}

$(document).ready(function(){
	//이벤트 핸들러 등록
	$('#re').click($.refresh);
	$('#delall').on('click', $.delall);
	$('#editbtn').click(function(){
		//수정할 글의 방번호
		let idx = parseInt($('#editidx').val());
		
		if($('#editpwd').val()!=articles[idx].pwd){//수정폼에입력한 글 비밀번호와 idx의pwd와 다르다면
			alert('글 비밀번호 불일치. 수정취소')
			return;
		}
		//배열의 원본글의 작성자와 내용을 새 입력값으로 변경-
		articles[idx].writer = $('#editwriter').val();
		articles[idx].content = $('#editcontent').val();
		
		//수정폼을 다시 body의 자식으로 보냄
		$('body').append($('#editf'));
		//화면에 안보이게 설정
		$('#editf').hide();
		//div에 출력되는 내용 바꾸기. articles[idx] 변경된방번호
		//요소1.replacewith(요소2) : dom요소를 교체하는함수. 요소1->요소2
		$('#div_'+articles[idx].num).replaceWith($.mkdiv(articles[idx]));
	});
	
	$('#cancelbtn').click(function(){
		$('body').append($('#editf'));
		//화면에 안보이게 설정
		$('#editf').hide();
	});
	

});
</script>
</head>
<body>
<form action="">
작성자:<input type="text" id="writer" name="writer"><br/>
내용:<input type="text" id="content" name="content"><br/>
비밀번호:<input type="password" id="pwd" name="pwd"><br/>
<input type="button" value="작성" id="writebtn">
</form><br/>
<h3>댓글목록</h3>
<input type="button" value="다시출력" id="re">
<input type="button" value="목록지우기" id="delall">
<div id="list"></div>

<form action="" style="display:none" id="editf"> 
<h4>수정폼</h4>
작성자:<input type="text" id="editwriter" name="editwriter"><br/>
내용:<input type="text" id="editcontent" name="editcontent"><br/>
글비밀번호:<input type="password" id="editpwd" name="editpwd"><br/>
<input type="hidden" id="editidx"> <!-- 수정으로선택한 글의 방번호(articles) 가져가는 hidden) -->
<input type="button" value="수정" id="editbtn">
<input type="button" value="취소" id="cancelbtn">
</form>
</body>
</html>