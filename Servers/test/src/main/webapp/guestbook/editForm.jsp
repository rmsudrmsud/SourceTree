<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const edit = () => {
	let pwd = prompt("�� ��й�ȣ �Է�:");
	if(${vo.pwd}==pwd){
		f.submit();//�� submit ��ư Ŭ���� �����ϰ� ����
	}else{
		alert('�н����� ����ġ. ���� ���')
	}
}

const del = () => {
	let pwd = prompt("�� ��й�ȣ �Է�:");
	if(${vo.pwd}==pwd){
		location.href="/webApp1/guestbook/del?num=${vo.num}";
	}else{
		alert('�н����� ����ġ. ���� ���')
	}
}
</script>
</head>
<body>
<h3>�� ������</h3>
<a href="/webApp1/guestbook/list">�۸��</a><br/>
<form action="/webApp1/guestbook/edit" method="post" name="f">
<table border="1">
<tr><th>�۹�ȣ</th><td>${vo.num }</td></tr>
<tr><th>�ۼ���</th><td>${vo.writer }</td></tr>
<tr><th>�ۼ���</th><td>${vo.w_date }</td></tr>
<tr><th>����</th><td><input type="text" name="content" value="${vo.content }"></td></tr>
<tr><th>����/����</th>
<td><input type="button" value="����" onclick="edit()">
<input type="button" value="����" onclick="del()">
</td></tr>
</table>
<input type="hidden" name="num" value="${vo.num }">
</form>
</body>
</html>