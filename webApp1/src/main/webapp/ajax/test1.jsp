<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	// 1. �񵿱� request��ü ����
	const xhttp = new XMLHttpRequest();

	// 2. ������ �޾����� �ڵ� ȣ��� �Լ��� ���
	xhttp.onload = () => {
	  //���� ������ ������ ó�� �ڵ� �ۼ�
	  let div = document.getElementById("res");
	  div.innerHTML = xhttp.responseText; //���� �ؽ�Ʈ
	}

	// 3. �񵿱� ��û ����
	//param1:���۹��. post, get, patch, update, delete
	//param2: ��û���� ���������� ���
	let param = "?name="+f.name.value
	xhttp.open("GET", "/webApp1/ajax/test1"+param);

	// 4. ��û����
	xhttp.send();
}

const b = () => {
	// 1. �񵿱� request��ü ����
	const xhttp = new XMLHttpRequest();

	// 2. ������ �޾����� �ڵ� ȣ��� �Լ��� ���
	xhttp.onload = () => {
	  //���� ������ ������ ó�� �ڵ� �ۼ�
	  let div = document.getElementById("res");
	  div.innerHTML = xhttp.responseText; //���� �ؽ�Ʈ
	}

	// 3. �񵿱� ��û ����
	//param1:���۹��. post, get, patch, update, delete
	//param2: ��û���� ���������� ���
	let param = "name="+f.name.value
	xhttp.open("post", "/webApp1/ajax/test1");

	//request ����� content type�� application���� ����
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	// 4. ��û����
	xhttp.send(param);
}
</script>
</head>
<body>
<form action="" name="f">
name:<input type="text" name="name"><br/>
<input type="button" value="get����" onclick="a()">
<input type="button" value="post����" onclick="b()">
</form><br/>
<div id="res"></div>
</body>
</html>