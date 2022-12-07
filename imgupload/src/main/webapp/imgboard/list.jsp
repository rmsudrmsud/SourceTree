<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* const editrep = (num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_"+num);  //<td id="res_${vo.num }">
	  let html = "";
	  for(let obj of arr){
		  html += obj.num+". "+obj.content+"(writer:"+obj.writer+")<br/>";
	  }
	  div.innerHTML = html;
	}
	
	let rep = document.getElementById("rep_"+num); //<input type="text" id="rep_${vo.num }" >
	let param = "parent="+num;
	param += "&writer=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/rep/edit");
	
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(param);
} */
const addrep = (num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_"+num);  //<td id="res_${vo.num }">
	  let html = "";
	  for(let obj of arr){
		  html += obj.num+". "+obj.content+"(writer:"+obj.writer+")<br/>";
	  }
	  div.innerHTML = html;
	}

	let rep = document.getElementById("rep_"+num); //<input type="text" id="rep_${vo.num }" >
	let param = "parent="+num;
	param += "&writer=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/rep/add");

	
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhttp.send(param);
}
</script>
</head>
<body>
<h3>이미지 게시판</h3>
<a href="${pageContext.request.contextPath }/imgboard/add">글작성</a><br/>
<c:forEach var="vo" items="${list }">
<table border="1">
<tr><th>num</th><td>${vo.num }
<c:if test="${sessionScope.loginId ==vo.writer }">
<input type ="button" value="수정" onclick="javascript:location.href='${pageContext.request.contextPath }/imgboard/edit?num=${vo.num }'">
<input type ="button" value="삭제" onclick="javascript:location.href='${pageContext.request.contextPath }/imgboard/del?num=${vo.num }'">
</c:if>
</td></tr>
<tr><th>writer</th><td>${vo.writer }</td></tr>
<tr><th>w_date</th><td>${vo.w_date }</td></tr>
<tr><th>title</th><td>${vo.title }</td></tr>
<tr><th>이미지</th><td><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>
<tr><th>content</th><td>${vo.content }</td></tr>
<tr><th>댓글작성</th>
<td><input type="text" id="rep_${vo.num }" >
<input type="button" value="작성" onclick="addrep(${vo.num })"></td></tr>
<tr><th>댓글목록</th>
<td id="res_${vo.num }">
<c:forEach var="r" items="${vo.reps }"> <%-- \${vo.reps }:댓글목록 arraylist --%>
<c:if test="${sessionScope.loginId ==vo.writer }">
<input type ="button" value="수정" onclick="editrep(${vo.num})">
<input type ="button" value="삭제" onclick="javascript:location.href='${pageContext.request.contextPath }/rep/del?num=${vo.num }'">
</c:if>
<input type="text" name="edit" value="${r.num }. ${r.content }(writer:${r.writer })" readonly><br/>
</c:forEach>
</td></tr><!-- id 에 글번호를넣어서 중복되지않도록 -->
</table>
</c:forEach>
</body>
</html>