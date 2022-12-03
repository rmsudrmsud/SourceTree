<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {

	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = () => {
		//받은응답을 가지고 처리코드작성
	  let val = xhttp.responseText;
	  let arr = JSON.parse(val);
	  let html = "";
	 /*  for(let key in obj){
		  html += key + ":";
		  html += obj[key] + "<br/>";
	  } */
	  for(let obj of arr){
		  html += "name:" + obj.name + "/";
		  html += "tel:" + obj.tel + "/";
		  html += "age:" + obj.age + "<br/>";
	  }
	  
	  let div = document.getElementById("res");
	  div.innerHTML = html; 
	}

	
	xhttp.open("GET", "/webApp1/ajax/jsontest");

	
	xhttp.send();
}
</script>
</head>
<body>
<div id="res"></div>
</body>
</html>