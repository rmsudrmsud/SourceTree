<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.num);
	let html = "<span id='content_'"+obj.num+">";
	html += obj.num+". "+obj.content+"(writer:"+obj.writer+")</span>";
	let writer = obj.writer;
	let loginId = '${sessionScope.loginId }';
	if(writer==loginId){
		html += "<input type='button' value='수정' onclick=redit("+obj.num+",'"+obj.content+"')>";
		html += "<input type='button' value='삭제' onclick=rdel("+obj.num+")>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	return rDiv;
}

const addrep = (num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
		
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_"+num);
	  div.innerHTML = "";
	  let html = "";
	  for(let obj of arr){
		  //html += obj.num+". "+obj.content+"(writer:"+obj.writer+")<br/>";
		  let dd = mkDiv(obj);
		  div.appendChild(dd);
	  }
	  alert("2");
	}

	let rep = document.getElementById("rep_"+num);
	let param = "parent="+num;
	param += "&writer=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	alert("1");
	xhttp.open("post", "${pageContext.request.contextPath }/rep/add");

	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(param);
}

const redit = (num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+num);
	rDiv.appendChild(editForm);
	editForm.style.display='';
	let editNum = document.getElementById("edit_num");
	editNum.value = num;
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
	let param = "num=" + editNum.value;
	param += "&content=" + editContent.value;
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.num);
	  let html = "";
	  html += obj.num+". "+obj.content+"(writer:"+obj.writer+")";
	  span.innerHTML = html;
	  editNum.value = "";
	  editContent.value = "";
	  cancel();
	}
	xhttp.open("post", "${pageContext.request.contextPath }/rep/edit");
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(param);
}

const rdel = (num, parent) => {
	let repsDiv = document.getElementById("res_"+parent);
	let rDiv = document.getElementById("r_"+num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	//바로삭제할거라서 응답 onload 필요없음
	xhttp.open("post", "${pageContext.request.contextPath }/rep/del");
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("num="+num);
}
</script>
</head>
<body>
<h3>이미지게시판</h3>
<a href="${pageContext.request.contextPath }/imgboard/add">글작성</a><br/>
<c:forEach var="vo" items="${list }">
<table border="1">
<tr><th>num</th>
<td>${vo.num }
<c:if test="${sessionScope.loginId == vo.writer }">
<input type="button" value="수정" onclick="javascript:location.href='${pageContext.request.contextPath }/imgboard/edit?num=${vo.num }'">
<input type="button" value="삭제" onclick="javascript:location.href='${pageContext.request.contextPath }/imgboard/del?num=${vo.num }'">
</c:if>
</td></tr>
<tr><th>writer</th><td>${vo.writer }</td></tr>
<tr><th>w_date</th><td>${vo.w_date }</td></tr>
<tr><th>title</th><td>${vo.title }</td></tr>
<tr><th>자료</th><td><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>
<tr><th>content</th><td>${vo.content }</td></tr>
<tr><th>댓글작성</th>
<td><input type="text" id="rep_${vo.num }">
<input type="button" value="작성" onclick="addrep(${vo.num })"></td></tr>
<tr><th>댓글목록</th>
<td id="res_${vo.num }">
<c:forEach var="r" items="${vo.reps }">
<div id="r_${r.num }">
	<span id="content_${r.num }">
	${r.num }. ${r.content }(writer:${r.writer })
	</span>
	<c:if test="${r.writer == sessionScope.loginId }">
		<input type="button" value="수정" onclick="redit(${r.num }, '${r.content }')">
		<input type="button" value="삭제" onclick="rdel(${r.num }, ${vo.num })">
	</c:if>
	<br/>
</div>
</c:forEach>
</td></tr>
</table>
</c:forEach>
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