<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.rep_class{
	border:2px solid black;
}
</style>
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

const mklist= () => {
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	  let arr = JSON.parse(xhttp.responseText); //제이슨보낸거 파싱해서 받은 배열
	  let div = document.getElementById("repList");
	  div.innerHTML=""; //댓글이 아래로 덧붙이도록
	  for(let obj of arr){ //객체를 하나씩 꺼낸
		  let chdiv = mkdiv(obj); // mkdiv로 만든div
	  	div.appendChild(chdiv); //div repList에 자식으로 chdiv추가
	  }
	}
	
	  let param = "parent=${vo.num}"; //파라메터로 원글에대한 번호
	  xhttp.open("post", "${pageContext.request.contextPath}/board/replist");
	  
	  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  
	  xhttp.send(param);
	
}
window.onload = () => {
	mklist();
}

const a = () => {
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = () =>{
		let obj = JSON.parse(xhttp.responseText); //obj 에 flag값밖에없음
		if(obj.flag){
			mklist();
			f.title.value = ""; //입력폼의내용 지우기
			f.content.value = ""; //입력폼의내용 지우기
		}else{
			alert('댓글추가실패');
		}
	}
	
	let param = "writer=${sessionScope.loginId}";
	param += "&title="+f.title.value; //전송할 폼파라메터가 여러개니까 연결하려고 &
	param += "&content="+f.content.value;
	param += "&parent=${vo.num}";
	
	xhttp.open("post", "${pageContext.request.contextPath }/board/repadd");
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(param);
}
</script>
</head>
<body>
<c:set var="str">readonly</c:set>
<c:if test="${sessionScope.loginId==vo.writer }">
<c:set var="str"></c:set>
</c:if>
<h3>상세페이지</h3>
<a href="${pageContext.request.contextPath }/board/list">글목록</a><br/>
<form action="${pageContext.request.contextPath }/board/detail" method="post" >
<table border="1">
<tr><th>글번호</th>
<td><input type="text" name="num" value="${vo.num }" readonly></td></tr>
<tr><th>작성자</th>
<td><input type="text" name="writer" value="${vo.writer }" readonly></td></tr>
<tr><th>작성일</th>
<td><input type="text" name="w_date" value="${vo.w_date }" readonly></td></tr>
<tr><th>제목</th>
<td><input type="text" name="title" value="${vo.title }" ${str }></td></tr>
<tr><th>내용</th>
<td><textarea cols="45" rows="15" name="content" ${str }>${vo.content }</textarea></td></tr>
<!-- 추가 -->
<c:if test="${sessionScope.loginId==vo.writer }">
<tr><th>수정/삭제</th>
<td>
	<input type="submit" value="edit">
	<input type="button" value="delete" onclick="del()">
</td></tr>
</c:if>
<!-- 추가 -->
</table>
</form><br/>
<h3>댓글</h3>
<form name="f">
제목: <input type="text" name="title"><br/>
내용: <input type="text" name="content"><br/>
<input type="button" value="댓글작성" onclick="a()">
</form>
<h3>댓글 목록</h3>
<div id="repList"></div>
</body>
</html>