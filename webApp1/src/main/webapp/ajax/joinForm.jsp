<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//�����û: ������ �̵�
const a = () => {
	location.href="/webApp1/IdCheck2?id="+f.id.value;
}

//�񵿱��û: ������ �̵� ����
const b = () => {
	//�񵿱� ��û ��ü ����
	const xhttp = new XMLHttpRequest();
	
	//�����κ��� ������ ������ ȣ��� �Լ� ���
	xhttp.onload = () => {
	let div = document.getElementById("res");
	div.innerHTML = xhttp.responseText; //���� �ؽ�Ʈ

	}
	
	//��û �Ķ����
	let param = "id="+f2.id.value;
	
	//���۹��, ���������� ����
	xhttp.open("post", "/webApp1/ajax/idcheck");
	
	//post header ����
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	//��û ����
	xhttp.send(param);
}
</script>
</head>
<body>
<h3>ȸ������</h3>
<form name="f">
id:<input type="text" name="id" value="${id }">
<input type="button" value="�ߺ�üũ" onclick="a()"><span>${msg }</span><br/>
pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name"><br/>
<input type="submit" value="����">
</form><br/>

<form name="f2">
id:<input type="text" name="id">
<input type="button" value="�ߺ�üũ" onclick="b()"><span id="res"></span><br/>
pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name"><br/>
<input type="submit" value="����">
</form>
</body>
</html>