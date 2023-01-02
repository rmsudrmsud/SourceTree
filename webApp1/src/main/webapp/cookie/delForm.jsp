<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
const del = (key) =>{
	location.href="/webApp1/DelCookie?key="+key;
}
</script>

</head>
<body>
<h3>쿠키삭제</h3>
<form action="/webApp1/DelCookie" method="post">
<input type="radio" value="${cookie.key1.name } name="ra">
${cookie.key1.name } / ${cookie.key1.value }<br/>
<input type="radio" value="${cookie.key2.name } name="ra">
${cookie.key2.name } / ${cookie.key2.value }<br/>

<input type="submit" value="삭제"> <br/>
</form>
</body>
</html>