<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//������ �ε� ���ڸ��� ����
window.onload = () => {
	let msg = "�ߺ��� ���̵�";
	if(${flag}){
		msg = "��밡���� ���̵�";
		msg += "<input type='button' value='���' onclick='a()'>";
		f.id.value = '${id}';
	}
 	let div = document.getElementById("res");
 	div.innerHTML = msg;
}

const a = () => {
	//�ߺ�üũ�� ���̵� ȸ������ â id�Է¶��� �ۼ�
	opener.document.f.id.value = window.document.f.id.value;
	opener.document.f.flag.value="true";
	//���� â�� �ݾƶ�
	window.close();
}
</script>
</head>
<body>
<form action="/webApp1/idcheck" method="post" name="f">
id:<input type="text" name="id">
<input type="submit" value="�ߺ�üũ">
</form>
<div id="res"></div>
</body>
</html>