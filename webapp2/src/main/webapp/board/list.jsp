<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.tds').hover(function(){
		//현재 이벤트가 발생한 객체의 속성 id 값 읽어서 num에 저장
		let num = $(this).attr('id').split('_')[1];//attr: 속성을 설정하거나 읽는함수(제이쿼리)
		//alert(num);
		
		$.ajax({
			//url: 요청받을 서버 페이지
			url : "${pageContext.request.contextPath }/board/get.do",
			//success:요청과 응답이 정상일 때 실행할함수 등록
			type : 'post',//전송방식
			data : {'num':num}, 
			dataType: 'json', //json. 파싱해줘야함
			success : function(result) {//성공시 실행. result : root element~
				let txt = '';
				txt += 'num:'+result.num+'<br/>';
				txt += 'writer:'+result.writer+'<br/>';
				txt += 'w_date:'+result.w_date+'<br/>';
				txt += 'title:'+result.title+'<br/>';
				txt += 'content:'+result.content+'<br/>';
				$("#msg").html(txt);
			},
			error: function(req, status, error){//���� �߻��� ����
				alert(status);
			}
		});
	}, function(){
		$("#msg").html('');
	});
	
	$('#searchbtn').click(function(){
		let type = $("#sel").val(); //작성자인지 제목인지 선택
		let action_txt = '${pageContext.request.contextPath }/board/';
		if(type=="1"){
			action_txt +='getbywriter.do';
		}else if(type=="2"){
			action_txt +='getbytitle.do';
		}
		let searchval = $("#searchval").val();
		action_txt += '?searchval='+searchval;
		$("#f").attr('action', action_txt);
		$("#f").submit();
	});
});
</script>
</head>
<body>
	<h3>게시판</h3>
	<a href="${pageContext.request.contextPath }/board/add.do">글작성</a>
	<br />
	<form action="" method="post" id="f">
	<select id="sel">
	<option value="1" selected>작성자</option>
	<option value="2">제목</option>
	</select>
	<input type="text" id="searchval">
	<input type="button" value="검색" id="searchbtn">
	</form><br/>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.num }</td>
				<td class="tds" id="td_${b.num }"><a
					href="${pageContext.request.contextPath }/board/get.do?num=${b.num }">
						${b.title }</a></td>
				<td>${b.writer }</td>
			</tr>
		</c:forEach>
	</table>
	<div id="msg"
		style="position: absolute; top: 100px; left: 300px; color: blue"></div>
</body>
</body>
</html>