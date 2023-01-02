<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>동행글 작성 </h3>
<a href ="${pageContext.request.contextPath }/together/getall.do?city_num=${sessionScope.city_num}"> 글 목록으로 가기 </a><br/>

<form action ="${pageContext.request.contextPath }/together/add.do" method="post">
<table border ="1">

<tr><th>작성자</th><td><input type="text" name="id" value="${sessionScope.loginId }" readonly ></td></tr>
<tr><th>도시명</th><td><input type= "text" name = "city_num" value= "${sessionScope.city_num }" readonly></td></tr>
<tr><th> 제목 </th><td><input type="text" name="title"></td></tr>
<tr><th> 내용 </th><td><textarea name="content" cols="30" rows="30"></textarea></td></tr>
<tr><th> 인원  </th><td><input type="text" name="ppl"></td></tr>
  
<tr><th>업로드</th><td><input type="submit" value="등록하기"></td></tr>

</table>
</form>
</body>
</html>