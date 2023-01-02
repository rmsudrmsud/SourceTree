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
</head>
<body>
<script type="text/javascript">
const mkdiv = (obj) => {//obj받은걸 화면에 뿌려줌
	let el = document.createElement("div"); //요소하나만드는것 div태그만들기
	el.setAttribute("id", obj.num); //div의 id속성으로 obj.num줬음 == <div id="obj.num">
	el.setAttribute("class", "rep_class"); //"rep_class style="" 용도로 사용"
	let html="";
	for(let key in obj){ //key : num write w_date , title, ~ 
		html += key+":" + obj[key] + "<br/>"; //멤버변수이름 : 키의값 <br/>로 div안에 출력
	}
	el.innerHTML = html;
	return el; //생성한 div박스 return;
	
}
$(document).ready(function(){
	$('#delbtn').click(function(){
		location.href="${pageContext.request.contextPath }/board/del.do?num=${vo.num }";
	});
	
	$('#repbtn').click(function(){
		let title = $('#reptitle').val();
		let content = $('#repcontent').val();
		$.ajax({
			//url: 요청받을 서버페이지
			url : "${pageContext.request.contextPath }/board/addrep.do",
			type : 'post',
			data : {'parent':${vo.num}, 'writer':'${sessionScope.loginId}', 
				'title':title, 'content':content}, //json.파싱
			dataType: 'json', //
			success : function(result) {//성공시 실행
				let txt = '<table border=1>';
				txt += '<tr><th>번호</th><th>제목</th><th>내용</th><th>작성자</th></tr>';
				for(let obj of result){ //result가 배열이니까 객체를 하나씩 꺼내어서
					txt += '<tr>';
					txt += '<td>'+obj.num+'</td>';
					txt += '<td>'+obj.title+'</td>';
					txt += '<td>'+obj.content+'</td>';
					txt += '<td>'+obj.writer+'</td>';
					txt += '</tr>';
				}
				txt += '</table>';
				$("#repList").html(txt);
				$('#reptitle').val('');
				$('#repcontent').val('');
			},
			error: function(req, status, error){
				alert(status);
			}
		});
	});
	
	$('#editrep').click(function(){
		let title = $('#reptitle').val();
		let content = $('#repcontent').val();
		$.ajax({
			//url: 요청받을 서버페이지
			url : "${pageContext.request.contextPath }/board/addrep.do",
			type : 'post',
			data : {'parent':${vo.num}, 'writer':'${sessionScope.loginId}', 
				'title':title, 'content':content}, //json.파싱
			dataType: 'json', //
			success : function(result) {//성공시 실행
				let txt = '<table border=1>';
				txt += '<tr><th>번호</th><th>제목</th><th>작성자</th><th>내용</th></tr>';
				for(let obj of result){ //result가 배열이니까 객체를 하나씩 꺼내어서
					txt += '<tr>';
					txt += '<td>'+obj.num+'</td>';
					txt += '<td>'+obj.title+'</td>';
					txt += '<td>'+obj.writer+'</td>';
					txt += '<td>'+obj.content+'</td>';
					txt += '</tr>';
				}
				txt += '</table>';
				$("#repList").html(txt);
				$('#reptitle').val('');
				$('#repcontent').val('');
			},
			error: function(req, status, error){
				alert(status);
			}
		});
	});
});

</script>
</head>
<body>
	<c:set var="str">readonly</c:set>
	<c:if test="${sessionScope.loginId==vo.writer }">
		<c:set var="str"></c:set>
	</c:if>
	<h3>상세페이지</h3>
	<a href="${pageContext.request.contextPath }/board/getall.do">글목록</a>
	<br />
	<form action="${pageContext.request.contextPath }/board/edit.do?num=${vo.num}"
		method="post">
		<table border="1">
			<tr>
				<th>글번호</th>
				<td><input type="text" name="num" value="${vo.num }" readonly></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${vo.writer }"
					readonly></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><input type="text" name="w_date" value="${vo.w_date }"
					readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${vo.title }"
					${str }></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="45" rows="15" name="content" ${str }>${vo.content }</textarea></td>
			</tr>
			<!-- 추가 -->
			<c:if test="${sessionScope.loginId==vo.writer }">
				<tr>
					<th>수정/삭제</th>
					<td><input type="submit" value="edit"> <input
						type="button" value="delete" id="delbtn"></td>
				</tr>
			</c:if>
			<!-- 추가 -->
		</table>
	</form>
	<br />
	<h3>댓글</h3>
	<form name="f">
		제목: <input type="text" name="title" id="reptitle"><br /> 
		내용: <input type="text" name="content" id="repcontent"><br /> 
		<input type="button" value="댓글작성" id="repbtn">
	</form>
	<h3>댓글 목록</h3>
	<div id="repList">
	<table border="1">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>내용</th></tr>
	<c:forEach var="r" items="${vo.reps }">
	<tr><td>${r.num }</td><td>${r.title }</td><td>${r.content }</td><td>${r.writer }</td>
	</tr>
	</c:forEach>
	</table>
	</div>
</body>


</html>