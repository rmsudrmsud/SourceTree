<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	  let html = "<table border='1'><tr><th>num</th><th>name</th>
	  <th>price</th></tr>";
		 /*  for(let key in obj){
			  html += key + ":";
			  html += obj[key] + "<br/>";
		  } */
		  for(let obj of arr){
			  html += "<tr><td>" + obj.num + "</td>";
			  html += "<td>" + obj.name + "</td>";
			  html += "<td>" + obj.price + "</td></tr>";
	  }
	  html+= "</table>";
	  let div = document.getElementById("list");
	  div.innerHTML = html; 
	}

	
	xhttp.open("GET", "/webApp1/ajax/productlist");

	
	xhttp.send();
}
</script>
</head>
<body>
	<h3>상품목록</h3>
	<div id="list"></div>
</body>
</html>