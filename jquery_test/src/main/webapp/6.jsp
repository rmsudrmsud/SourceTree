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

$(document).ready(function(){
	$('#b1').click(function(){
		//$.ajax():ajax 요청 함수 / $.get():get요청 / $.post(): post 요청
		$.ajax({
			//url: 요청받을 서버 페이지
			url : "${pageContext.request.contextPath }/Test2",
			//success:요청과 응답이 정상일 때 실행할함수 등록
			type : 'get', //전송방식 지정
			//data : 'name=aaa&tel=111', //서버로 보낼 데이터
			data : {name:'aaa', tel:'123'}, //서버로 보낼 전송파라메터 제이슨형태
			dataType : 'text', //결과형태
			success : function(result){ //응답 (파라메터) 이름이꼭 result일필요는 없다. 성공했을 때 실행
				$("#res").html(result);	
			},
			error: function(req, status, error){//에러 발생시 실행
				alert(status);
			}
		});
	});
	
	$('#b2').click(function(){
		//$.ajax():ajax 요청 함수 / $.get():get요청 / $.post(): post 요청
		$.ajax({
			//url: 요청받을 서버 페이지
			url : "${pageContext.request.contextPath }/Test3",
			//success:요청과 응답이 정상일 때 실행할함수 등록
			type : 'post', //전송방식 지정
			//data : 'name=aaa&tel=111', //서버로 보낼 데이터
			data : {name:'aaa', tel:'123'}, //서버로 보낼 전송파라메터 제이슨형태
			dataType : 'json', //결과형태
			success : function(result){ //응답 (파라메터) 이름이꼭 result일필요는 없다. 성공했을 때 실행
				let txt = '';
				for(let obj of result){
					txt += 'name:'+obj.name+' / tel:'+obj.tel+'<br/>';
				}
				$("#res").html(txt);
			},
			error: function(req, status, error){//에러 발생시 실행
				alert(status);
			}
		});
	});
	
	$('#b3').click(function(){
		$.ajax({
			//url: 요청받을 서버 페이지
			url : "${pageContext.request.contextPath }/Test4",
			//success:요청과 응답이 정상일 때 실행할함수 등록
			type : 'post', //전송방식 지정
			dataType : 'xml', //결과형태 원래자바스크립트에선 파싱해줘야함
			success : function(result){//성공시 실행. result : root element~
				let arr = $(result).find("person"); //find: 여러개검색되면 배열에담아서, 하나만검색되면 한개만 반환
				let txt = '';
				for(let p of arr){//ㅇㅣ부분 제이쿼리 each로 해도 적용됨
					let name = $(p).find("name").text();
					let tel = $(p).find("tel").text();
					
					txt += 'name:' + name + ' / tel:' + tel+'<br/>';
				}
				
				$('#res').html(txt);
			},
			error: function(req, status, error){//에러 발생시 실행
				alert(status);
			}
		});
	});
});
</script>
</head>
<body>
<h3>ajax 테스트</h3>
<a href="${pageContext.request.contextPath }/Test1">일반요청</a><br/>
<input type="button" id="b1" value="ajax txt"><br/>
<input type="button" id="b2" value="ajax json"><br/>
<input type="button" id="b3" value="ajax xml"><br/>
<div id='res'></div>
</body>
</html>