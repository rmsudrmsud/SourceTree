<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {
	let down_path = opener.document.f1.down_path.value;
	let num = opener.document.f1.num.value;
	location.href="${pageContext.request.contextPath }/DispatcherServlet?url=/download/down&down_path="+down_path+"&num="+num;
}
const a = () => {
	opener.location.reload(); //location.reload() 새로고침
	window.close(); //현재윈도우창 닫음
}
</script>
</head>
<body>
<input type="button" value="다운완료" onclick="a()">
</body>
</html>