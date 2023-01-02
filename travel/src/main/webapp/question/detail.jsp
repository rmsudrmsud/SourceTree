<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

const del = () => {
	location.href = "${pageContext.request.contextPath }/question/del.do?question_num=${vo.question_num }";
	
}

const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.question_num);
	let html = "<span id='content_'"+obj.question_rep_num+">";
	html += obj.question_rep_num+". "+obj.content+"(id:"+obj.id+")</span>";
	let id = obj.id;
	let loginId = '${sessionScope.loginId}';
	if(id==loginId){
		html += "<input type='button' value='수정' onclick=redit("+obj.question_rep_num+",'"+obj.content+"')>";
		html += "<input type='button' value='삭제' onclick=rdel("+obj.question_rep_num+")>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	return rDiv;
}

const addrep = (question_num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
// 		alert(xhttp.responseText);
		let arr = JSON.parse(xhttp.responseText);//ajax 검색된 결과를 받아오는 명령어(리스폰스텍스트)
// 		let div = document.getElementById("res_"+question_num);	//res_니까 question의 vo객체라서 question_num써줌
		//받아오는 question_num이 없어서 저걸 갖고 가면 ajax 안됨.
		let div = document.getElementById("res_"+question_num);
		div.innerHTML = "";
		let html = "";
		for(let obj of arr){
// 			html += obj.question_rep_num+". "+obj.content+
// 			  "(id:"+obj.id+")<br/>";
			  let dd = mkDiv(obj);
			  div.appendChild(dd);  
		}
// 		div.innerHTML = html;
// 이게 있으면 기껏 for문을 통해서 댓글 추가해주고 화면에서 다 없애줌. 왜냐면 위에 let html이 ""이니까 
	}
	
	let rep = document.getElementById("rep_"+question_num);
	let param = "question_num="+question_num;//원글에 대한 번호를 파람으로 가져가서 
	param += "&id=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/question_rep/add.do");
	
	xhttp.setRequestHeader("Content-type", 
	"application/x-www-form-urlencoded");
	xhttp.send(param);
}

const redit = (question_rep_num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+question_rep_num);
	rDiv.appendChild(editForm);
	editForm.style.display='';
	let editNum = document.getElementById("edit_num");
	editNum.value = question_rep_num;
	let editContent = document.getElementById("edit_content");
	editContent.value = content;
}

const cancel = () => {
	let hiddenDiv = document.getElementById("hidden");
	let editForm = document.getElementById("edit_form");
	hiddenDiv.appendChild(editForm);
	editForm.style.display='none';
}

const rep_edit = () => {
	let editNum = document.getElementById("edit_num");
	let editContent = document.getElementById("edit_content");
	let param = "question_rep_num=" + editNum.value;
	param += "&content=" + editContent.value;
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	 
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.question_rep_num);
	  let html = "";
	  
	  html += obj.question_rep_num+". "+obj.content+"(id:"+obj.id+")";
	 
	  span.innerHTML = html;
// 	  alert(html);
	  editNum.value = "";
	  editContent.value = ""; 
	 
	  cancel(); 
	  
	}
	
	xhttp.open("post", "${pageContext.request.contextPath }/question_rep/edit.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send(param);
}

const rdel = (question_rep_num, question_num) => {
// 	alert(question_rep_num);
// 	let repsDiv = document.getElementById("res_"+question_num);
	//얘도 위와 마찬가지
// 	alert(question_rep_num);
	let repsDiv = document.getElementById("res_"+question_num);
	let rDiv = document.getElementById("r_"+question_rep_num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	xhttp.open("post", "${pageContext.request.contextPath }/question_rep/del.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
// 	xhttp.send("question_rep_num="+question_rep_num);
// 파람이 두개여야 된다. 왜인지는 까먹음..
	xhttp.send("question_rep_num="+question_rep_num+"&question_num="+question_num);
}



</script>
</head>
<body>
<c:if test="${sessionScope.loginId != vo.id }">
<c:set var="str">readonly</c:set>
</c:if>
<h3>상세페이지</h3>
<a href="${pageContext.request.contextPath }/question/listAll.do?city_num=${sessionScope.city_num}">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/question/edit.do" method="post" name="f" enctype="multipart/form-data">

<table border="1">
<tr><th>글번호</th><td><input type="number" name="question_num" value="${vo.question_num }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="id" value="${vo.id }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" value="${vo.title }"></td></tr>
<tr><th>content</th><td><input type="text" name="content" value="${vo.content }"></td></tr>
<tr><th>자료</th><td><input type="file" name="file"${str }><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>

<c:if test="${sessionScope.loginId == vo.id }">
<tr><td>수정삭제</td>
<td>
<input type="submit" value="수정" >
<input type="button" value="삭제" onclick="del()">
</td></tr>
</c:if>
</table>
<input type="hidden" name="img_path" value="${vo.img_path }">
</form>
<br/>

<table border="1">
<tr><th>댓글작성</th>
<%-- 글번호 ${vo.num }을 달아줌으로써 중복을 방지함. --%>
<td><input type="text" id="rep_${vo.question_num }">
<input type="button" value="작성" onclick="addrep(${vo.question_num })"></td></tr>
<tr><th>댓글목록</th>
<td id="res_${vo.question_num }">

<c:forEach var="r" items="${vo.reps }">
<div id="r_${r.question_rep_num }">
	<span id="content_${r.question_rep_num }">
	${r.question_rep_num }. ${r.content }(작성자:${r.id })
	</span>
	<c:if test="${r.id == sessionScope.loginId }">
		<input type="button" value="수정" onclick="redit(${r.question_rep_num }, '${r.content }')">
		<input type="button" value="삭제" onclick="rdel(${r.question_rep_num }, ${vo.question_num })">
	</c:if>
	<br/>
</div>
</c:forEach>
</td></tr>
</table>

<div id="hidden">
<form style="display:none" id="edit_form">
num:<input type="text" id="edit_num" readonly><br/>
content:<input type="text" id="edit_content"><br/>
<input type="button" value="수정완료" onclick="rep_edit()">
<input type="button" value="취소" onclick="cancel()"><br/>
</form>
</div>

</body>
</html>