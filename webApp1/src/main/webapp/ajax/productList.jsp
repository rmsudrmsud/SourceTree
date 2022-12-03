<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const xhttp = new XMLHttpRequest();

xhttp.onload = () => {
	//받은응답을 가지고 처리코드작성
  let val = xhttp.responseText;
  let arr = JSON.parse(val);
  let html = "<table border='1'><tr><th>num</th><th>name</th><th>price</th></tr>";

  for(let obj of arr){
	  html += "<tr><td>" + obj.num + "</td>";
	  html += "<td onmouseover='a("+obj.num+")' onmouseout='b()'>" + obj.name + "</td>";
	  html += "<td>" + obj.price + "</td></tr>";
  }
  
  html += "</table>";
  let div = document.getElementById("list");
  div.innerHTML = html; 
}

xhttp.open("GET", "/webApp1/ajax/productlist");

xhttp.send();

const a = (num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
		//받은응답을 가지고 처리코드작성
	  let val = xhttp.responseText;
	  let obj = JSON.parse(val);
	  let div = document.getElementById("detail");
	  let html = "";
	  for(let key in obj){
		  html += key+":"+obj[key]+"<br/>";
	  }
	  div.innerHTML = html;
	}
	xhttp.open("GET", "/webApp1/ajax/productdetail?num="+num);
	xhttp.send();
}

const b = () => {
	let div = document.getElementById("detail");
	div.innerHTML = "";
}
</script>
</head>
<body>
	<h3>상품목록</h3>
	<div id="list"></div>
	<div id="detail" style="position:absolute; top:100px; left:300px"></div>
</body>
</html>