<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동행게시판 글 상세페이지</title>
<script>


const del = () => {
	location.href = "${pageContext.request.contextPath }/together/del.do?travel_num=${vo.travel_num }";
	
}

const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.travel_num);
	let html = "<span id='content_'"+obj.travel_rep_num+">";
	html += obj.travel_rep_num+". "+obj.content+"(id:"+obj.id+")</span>";
	let id = obj.id;
    
	let loginId = '${sessionScope.loginId }';
	if(id==loginId){
		html += "<input type='button' value='수정' onclick=redit("+obj.travel_rep_num+",'"+obj.content+"')>";
		html += "<input type='button' value='삭제' onclick=rdel("+obj.travel_rep_num+")>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	
	return rDiv;
}


const addrep = (travel_num) => {
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	
// 		alert(xhttp.responseText);
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_"+travel_num);
	  div.innerHTML = "";
	  let html = "";
	  for(let obj of arr){
       
           let dd = mkDiv(obj);
		   div.appendChild(dd);
          
	  }
	  
	}

	let rep = document.getElementById("rep_"+travel_num);
	let param = "travel_num="+travel_num;
	param += "&id=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/togetherRep/add.do");

	//request 헤더에 content type을 application으로 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	// 4. 요청보냄
	xhttp.send(param);
}


 const redit = (travel_rep_num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+travel_rep_num);
	rDiv.appendChild(editForm);
	editForm.style.display='';
	let editNum = document.getElementById("edit_num");
// alert(travel_rep_num);
	editNum.value = travel_rep_num;
// 	 alert(editNum);
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
	let param = "travel_rep_num=" + editNum.value;
	param += "&content=" + editContent.value;
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	 
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.travel_rep_num);
	  let html = "";
	  
	  html += obj.travel_rep_num+". "+obj.content+"(id:"+obj.id+")";
		 
	  span.innerHTML = html;
// 	  alert(html);
	  editNum.value = "";
	  editContent.value = ""; 
	 
	  cancel(); 
	  
	}
	
	xhttp.open("post", "${pageContext.request.contextPath }/togetherRep/edit.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send(param);
}

const rdel = (travel_rep_num, travel_num) => {
	let repsDiv = document.getElementById("res_"+travel_num);
	let rDiv = document.getElementById("r_"+travel_rep_num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	xhttp.open("post", "${pageContext.request.contextPath }/togetherRep/del.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send("travel_rep_num="+travel_rep_num+"&travel_num="+travel_num);
	
}
 
</script>

</head>
<body>
<c:if test="${sessionScope.loginId != vo.id }">
<c:set var="str">readonly</c:set>
</c:if>

<a href="${pageContext.request.contextPath }/together/getall.do?city_num=${sessionScope.city_num}"> 글 목록  </a><br/>
<form action="${pageContext.request.contextPath }/together/edit.do?city_num=${sessionScope.city_num}" method="post" name="f">

<table border ="1">

<tr><th>글 번호 </th><td><input type="text" name="travel_num" value="${vo.travel_num }" readonly></td></tr>
<tr><th>제목 </th><td><input type="text" name="title" value="${vo.title }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="id" value="${vo.id }" readonly></td></tr>
<tr><th>내용</th><td><input type="text" name="content" value="${vo.content }" ${str }></td></tr>
<tr><th>작성일</th><td><input type="text" name="wdate" value="${vo.wdate }" ${str }></td></tr>
<tr><th>인원수</th><td><input type="text" name="ppl" value="${vo.ppl }" ${str }></td></tr>

<c:if test="${sessionScope.loginId == vo.id }">
<tr><td> 수정/삭제 </td>
<td>
<input type ="submit" value="수정" >
<input type ="button" value="삭제" onclick ="del()">
</td></tr>
</c:if>
</table>

</form>

<table border="1">
<tr><th> 댓글 작성 </th>
<td><input type="text" id="rep_${vo.travel_num }">
<input type="button" value="작성" onclick="addrep(${vo.travel_num })"></td></tr>
<tr><th>댓글목록</th> 
<td id="res_${vo.travel_num }">

<c:forEach var="r" items="${vo.reps }">
<div id="r_${r.travel_rep_num }">
	<span id="content_${r.travel_rep_num }">
	${r.travel_rep_num }. ${r.content } (작성자: ${r.id })
	</span>
	<c:if test="${r.id == sessionScope.loginId }">
		<input type="button" value="수정" onclick="redit(${r.travel_rep_num }, '${r.content }')">
		<input type="button" value="삭제" onclick="rdel(${r.travel_rep_num }, ${vo.travel_num })">
	</c:if>
	<br/>
</div>
</c:forEach>
</td></tr> 
</table>


<div id="hidden">
<form style="display:none" id="edit_form">
num: <input type="text" id="edit_num" readonly>
content:<input type="text" id="edit_content"><br/>
<input type="button" value="수정완료" onclick="rep_edit()">
<input type="button" value="취소" onclick="cancel()"><br/>
</form>

</div>
</body>
</html>