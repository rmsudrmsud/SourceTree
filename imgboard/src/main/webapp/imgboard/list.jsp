<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	//처음에 작성폼 안보이게설정
	$('#writeform').hide();
	$('#editf').hide();
	
	//글작성버튼 클릭시 보이게
	$('#add').click(function(){
		$('#writeform').show();
	});
	
	//작성완료 버튼 클릭하면 서버에폼데이터 전달하고 응답으로 추가된 글정보 json으로 받음
	$('#wbtn').click(function(){
		//FormData : 폼안에있는 입력양식의 값들을 ajax로전달할때 값들을 하나하나 읽어서 전달하기 불편해서
		//추가된녀석. 폼입력값을 묶어서 처리할 수 있는 객체
		let formData = new FormData($('#writeform')[0]);
		$.ajax({
			url : "${pageContext.request.contextPath }/imgboard/add.do",
			type : 'post',//전송방식파일까지 해야하므로 멀티파트로 해줘야함. 기존에 폼타입에 enctype: 멀티파트~~ 어쩌고하던거
			processData:false, //true : string query, flase:헤더에 담아서 전송
			contentType:false, //true :디폴트값. application, false : mulitipart. 파일이아닌 일반방식은 true로 사용. 디폴트값이니까 안써도됨 평소에는
			data : formData,
			dataType: 'json', //요청에대한 응답의 결과형태 json.
			success : function(result) {//성공시 실행. result:제이슨형태로 받아오기
				let tbl = $.mktbl(result);
				//prepend(): 첫번째 자식으로 추가 <-> append
				$("#imgboardList").prepend(tbl);
			},
			error: function(req, status, error){
				alert(status);
			}
		});
		$('#writeform').hide();
	});
	
	$('.edit').click(function(){		
		let num = $(this).attr("num"); //속성을 설정하거나 넣어주는 attr. 클래스이름이 edit인애들중에 클릭이발생한 this
		//수정폼에 각각 값을넣어주는 작업
		$('#edit_num').val(num);
		$('#edit_title').val($('#title_'+num).text());
		$('#edit_content').val($('#content_'+num).text());
		//바디의자식에있던 수정폼을 줄을만들어서 붙여줌
		let txt = '<tr><th>수정폼</th><td id=edit_td></td></tr>';
		$('#tbl_'+num).append(txt);
		//새로추가된 edit_td에 수정폼 추가
		$('#edit_td').append($('#editf'));
		$('#editf').show();
	});
	
	$('#editbtn').click(function(){	
		let formData = new FormData($('#editf')[0]);
		$.ajax({
			url : "${pageContext.request.contextPath }/imgboard/edit.do",
			type : "post",
			processData:false, //true:string query, false:
			contentType:false,//true:application, false:multipart
			data : formData,
			dataType: 'json', 
			success : function(result) { //result : 수정이완료된 글하나객체
				//원래글의제목,아이디,이미지경로 자리에
				$('#title_'+result.num).text(result.title);
				$('#content_'+result.num).text(result.content);
				$('#img_'+result.num).attr('src', result.img_path); //이미지 src속성값변경위해 attr
			},
			error: function(req, status, error){
				alert(status);
			}
		});
		
		$('body').append($('#editf'));
		$('#editf').hide();
		$('#edit_tr').remove();
	});
	
	$('.addrep').click(function(){
		let num = $(this).attr("num");
		let rcontent = $('#rep_'+num).val()
		//let rnum
		$.ajax({
			url : "${pageContext.request.contextPath }/rep/repadd.do",
			type : 'post',
			data : {"content": rcontent, "parent": num, "writer": "${sessionScope.loginId}"},
			dataType: 'json', //결과 형태
			success : function(result) {
				//그 원글에 대한 댓글이니 parent는 다똑같으니..
				let parent = result[0].parent;
				let txt = '';
				for(let obj of result){
					txt += obj.num+"."+obj.content+"(작성자:"+obj.writer+')<br/>';
					 if(obj.writer =='${sessionScope.loginId}'){
					txt += '<input type=button value=댓글수정 class=repedit num='+obj.num+'>';
					txt += '<input type=button value=댓글삭제 class=repdel num='+obj.num+'>';
					txt += '<br/>';
					} 
				}
				$('#replist_'+parent).html(txt);
				$('#rep_'+num).val(''); //댓글작성이후 작성폼비우기
				//$('.repdel').on('click', $.test);
			},
			error: function(req, status, error){//에러 발생시 실행
				alert(status);
			}
		});
	});
	
	$('#cancel2btn').click(function(){
		//수정폼을 다시 바디의 자식으로 보내고
		$('body').append($('#editf'));
		$('#editf').hide();
		//추가된 수정폼 줄 삭제
		$('#edit_tr').remove();
	});
	
	$('.del').click(function(){
		let num = $(this).attr("num");
		$('#tbl_'+num).remove();//화면에서 테이블영역 지우기
		$.ajax({
			url : "${pageContext.request.contextPath }/imgboard/del.do",
			type : 'get',
			data : {'num':num} //삭제할글번호
		});
	});
	
	$('.rdel').click(function(){
		let num = $(this).attr("num");
		$('#r_'+num).remove();
		$.ajax({
			url : "${pageContext.request.contextPath }/rep/del.do",
			type : 'get',
			data : {'num':num}
		});
	});
	
});

$.mktbl = (obj) => {
	let txt = '<table id=tbl_'+obj.num+' border="1">';
	txt += '<tr><th>num</th><td>'+obj.num;
	if(obj.writer=='${sessionScope.loginId}'){
		txt += '<input type=button value=수정 class="edit" num='+obj.num+'>';
		txt += '<input type=button value=삭제 class="del" num='+obj.num+'>';
	}
	txt += '</td></tr>';
	txt += '<tr><th>writer</th><td>'+obj.writer+'</td></tr>';
	txt += '<tr><th>w_date</th><td>'+obj.w_date+'</td></tr>';
	txt += '<tr><th>title</th><td id=title_'+obj.num+'>'+obj.title+'</td></tr>';
	txt += '<tr><th>이미지</th><td><img src="'+obj.img_path;
	txt += '" style="width:200px;height:150px"></td></tr>';
	txt += '<tr><th>content</th><td id=content_'+obj.num+'>'+obj.content+'</td></tr>';
	txt += '</table>';
	return txt;
}

</script>
</head>
<body>
<h3>이미지게시판</h3>
<input type="button" value="글작성" id="add"><br/>
<form id="writeform">
writer:<input type="text" name="writer" value="${sessionScope.loginId }" readonly><br/>
title:<input type="text" name="title"><br/>
content:<input type="text" name="content"><br/>
img:<input type="file" name="file"><br/>
<input type="button" value="작성완료" id="wbtn">
<input type="button" value="취소" id="cancelbtn"><br/>
</form>
<div id="imgboardList">
<c:forEach var="vo" items="${list }">
<table id="tbl_${vo.num }" border="1">
<tr><th>num</th>
<td>${vo.num }
<c:if test="${sessionScope.loginId == vo.writer }">
<input type="button" value="수정" class="edit" num="${vo.num }"> <!-- 수정삭제버튼이 여러개가나올수있어서 id="edit"로하면 중복이되기때문에 class로줬음 -->
<input type="button" value="삭제" class="del" num="${vo.num }"> <!-- input태그에 몇번글에대한 수정,삭제작업을 하기위햇 임의의 num속성 부여 -->
</c:if>
</td></tr>
<tr><th>writer</th><td>${vo.writer }</td></tr>
<tr><th>w_date</th><td>${vo.w_date }</td></tr>
<tr><th>title</th><td id="title_${vo.num }">${vo.title }</td></tr>
<tr><th>이미지</th><td><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>
<tr><th>content</th><td id="content_${vo.num }">${vo.content }</td></tr>
<tr><th>댓글작성</th>

<td><input type="text" id="rep_${vo.num }" num="${vo.num }">
<input type="button" value="작성" class="addrep" num="${vo.num }"></td></tr>

<tr><th>댓글목록</th>
<td id="replist_${vo.num }">
<c:forEach var="r" items="${vo.reps }">
<div id="r_${r.num }">
	<span id="rcontent_${r.num }">
	${r.num }. ${r.content }(writer:${r.writer })
	</span>
	<c:if test="${r.writer == sessionScope.loginId }">
		<input type="button" value="수정" class="redit" num="${r.num }">
		<input type="button" value="삭제" class="rdel" num="${r.num }">
	</c:if>
	<br/>
</div>
</c:forEach>
</td></tr>
</table>
</c:forEach>
</div>
<form id="editf">
num:<input type="text" name="num" id="edit_num" readonly><br/>
new title:<input type="text" name="title" id="edit_title"><br/>
new content:<input type="text" name="content" id="edit_content"><br/>
new img:<input type="file" name="file"><br/>
<input type="button" value="수정완료" id="editbtn">
<input type="button" value="취소" id="cancel2btn"><br/>
</form>
</body>
</html>