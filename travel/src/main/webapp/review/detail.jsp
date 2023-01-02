<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
const b = () =>{
	location.href = "${pageContext.request.contextPath }/review/del.do?review_num=${vo.review_num}";
}



const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.review_num);
	let html = "<span id='content_'"+obj.review_rep_num+">";
	html += "번호: "+obj.review_rep_num+". "+obj.content+"(id: "+obj.id+")"+"작성일: "+obj.date+"</span>";
	let id = obj.id;
	let loginId = '${sessionScope.loginId }';
	if(id==loginId){
		html += "<input type='button' value='수정' onclick=redit("+obj.review_rep_num+",'"+obj.content+"')>";
		html += "<input type='button' value='삭제' onclick=rdel("+obj.review_rep_num+")>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	return rDiv;
}

const addrep = (review_num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	  
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_");
	  div.innerHTML = "";
	  let html = "";
	  for(let obj of arr){
		
		  let dd = mkDiv(obj);
		  div.appendChild(dd);
	  }
	 //div.innerHTML = html;
	}

	let rep = document.getElementById("rep_"+review_num);
	let param = "review_num="+review_num;
	param += "&id=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/review_rep/add.do");

	//request 헤더에 content type을 application으로 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	// 4. 요청보냄
	xhttp.send(param);
}
const redit = (review_rep_num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+review_rep_num);
	rDiv.appendChild(editForm);
	editForm.style.display='';
	let editNum = document.getElementById("edit_num");
	editNum.value = review_rep_num;
	let editContent = document.getElementById("edit_content");
	editContent.value = content;
}



const rep_edit = () => {
	let editNum = document.getElementById("edit_num");
	let editContent = document.getElementById("edit_content");
	let param = "review_rep_num=" + editNum.value;
	param += "&content=" + editContent.value;
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	 
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.review_rep_num);
	  let html = "";
	  
	  html += obj.review_rep_num+". "+obj.content+"(id:"+obj.id+")";
	 
	  span.innerHTML = html;
	  editNum.value = "";
	  editContent.value = ""; 
	 
	  cancel(); 
	  
	}
	
	xhttp.open("post", "${pageContext.request.contextPath }/review_rep/edit.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send(param);
}
const rdel = (review_rep_num, review_num) => {
	
	let repsDiv = document.getElementById("res_");
	let rDiv = document.getElementById("r_"+review_rep_num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	xhttp.open("post", "${pageContext.request.contextPath }/review_rep/del.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send("review_rep_num="+review_rep_num+"&review_num="+review_num);
}
const cancel = () => {
	let hiddenDiv = document.getElementById("hidden");
	let editForm = document.getElementById("edit_form");
	hiddenDiv.appendChild(editForm);
	editForm.style.display='none';
}
</script>
</head>
<body>
<c:if test="${sessionScope.loginId != vo.id }">
<c:set var="str">readonly</c:set>
</c:if>
<h3>리뷰 글 상세페이지</h3>
<a href="${pageContext.request.contextPath }/review/getall.do?city_num=${sessionScope.city_num}">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/review/edit.do" method="post" name="f" >
<table border="1">
<tr><th>글번호</th><td colspan="2"><input type="text" name="review_num" 
value="${vo.review_num }" readonly></td></tr>
<tr><th>도시번호</th><td colspan="2"><input type="text" name="city_num" 
value="${vo.city_num }" readonly></td></tr>
<tr><th>작성자</th><td colspan="2"><input type="text" name="id" 
value="${vo.id }" readonly></td></tr>
<tr><th>제목</th><td colspan="2"><input type="text" name="title" 
value="${vo.title }" ${str }></td></tr>
<div>
<tr><th>이미지</th><td colspan="2"><img src="${vo.img_path }" 
style="width:200px;height:150px"></td></tr>
</div>
<tr><td colspan="3"><textarea rows="15" cols="50" name="content" ${str }>${vo.content }</textarea></td></tr>

<c:if test="${sessionScope.loginId == vo.id}">
<tr>
<td colspan="3">
	<input type="submit" value="수정">
	<input type="button" value="삭제" onclick="b()">
</td></tr>
</c:if>
</table>
</form>

<table border="1">
<tr><th colspan="3" width="220">댓글목록 </th></tr>


<td colspan="3" id="res_${review_num}">
<c:forEach var="r" items="${vo.reps }">
<div id="r_${r.review_rep_num }">
	<span id="content_${r.review_rep_num }">
	번호:${r.review_rep_num }. ${r.content }(아이디:${r.id }) 작성일:${r.date } 
	</span>
	<c:if test="${r.id == sessionScope.loginId }">
		<input type="button" value="수정" onclick="redit(${r.review_rep_num }, '${r.content }')">
		<input type="button" value="삭제" onclick="rdel(${r.review_rep_num }, ${vo.review_num })">
	</c:if>
	<br/>
</div>
</c:forEach>
</td>

<tr><th colspan="3"><input type="text" id="rep_${vo.review_num }" style="width:330px;">
<input type="button" value="댓글작성" onclick="addrep(${vo.review_num })"></th></tr>



</table>
<div id="hidden">
<form style="display:none" id="edit_form">
<input type="hidden" id="edit_num" readonly><br/>
수정할 내용을 입력하세요<input type="text" id="edit_content"><br/>
<input type="button" value="수정완료" onclick="rep_edit()">
<input type="button" value="취소" onclick="cancel()"><br/>
</form>
</div>

</body>
</html>