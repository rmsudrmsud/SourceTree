<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const check = () => {
	let win = open("/webApp1/member/idCheck.jsp", "win", "width=300,height=200");
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
<form action="/webApp1/JoinController" method="post" name="f">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id" onclick="check()" readonly>
</td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
<tr><th>ȸ��Ÿ��</th>
<td>
<input type="radio" name="type" value="1">������
<input type="radio" name="type" value="2">�Ǹ���
</td>
</tr>
<tr><th>���ԿϷ�</th><td><input type="button" value="����" onclick="a()"></td></tr>
</table>
<input type="hidden" name="flag" value="false">
</form>
</body>
</html>