<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

const check = () => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  let obj = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("ch_res");
	  div.innerHTML = obj.msg; //���� �ؽ�Ʈ
	  if(obj.flag){
		  f.flag.value='true';
	  }
	}
	
	let param = "id="+f.id.value;
	
	//���۹��, ���������� ����
	xhttp.open("post", "${pageContext.request.contextPath }/member/idcheck.do");
	
	//post header ����
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	//��û ����
	xhttp.send(param);
}
const a = () =>{
	if(f.flag.value!='true'){
		alert('���̵� �ߺ�üũ �Ͻÿ�');
		return;
	}
	
	if(f.pwd.value==''){
		alert('�н����� �ʼ�');
		return;
	}
	
	f.submit();//����
}
</script>
</head>
<body>
<h3>ȸ������</h3>
<form action="${pageContext.request.contextPath }/member/add.do" method="post" name="f">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id">
<input type="button" value="�ߺ�üũ" onclick="check()">
<span id="ch_res"></span>
</td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
<tr><th>ȸ��Ÿ��</th>
	<td>
		<input type="radio" name="type" value="1" checked>������
		<input type="radio" name="type" value="2">�Ǹ���
	</td>
</tr>
<tr><th>���ԿϷ�</th><td><input type="button" value="����" onclick="a()"></td></tr>
</table>
<input type="hidden" name="flag" value="false">
</form>
</body>
</html>