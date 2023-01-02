<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3>질문게시판</h3>
<a href="${pageContext.request.contextPath }/index.jsp">목록으로</a><br/>
<a href="${pageContext.request.contextPath }/question/add.do">글작성</a><br/>
<table border="1">
<tr><th>num</th><th>title</th><th>작성자</th><th>작성일</th><th>이미지</th></tr>
<c:forEach var="vo" items="${list }">
<tr>
<td>${vo.question_num }</td>
<td><a href="${pageContext.request.contextPath }/question/detail.do?question_num=${vo.question_num }">${vo.title }</a></td>
<%-- <td>${vo.img_path }</td> --%>
<td>${vo.id }</td>
<td>${vo.wdate }</td>
<td><img src="${vo.img_path }" style="width:200px;height:150px"></td></tr>
</c:forEach>
</table>

<h3>검색</h3>
<form action="${pageContext.request.contextPath }/question/listTitle.do" method="post" >

<input type="text" name="title">
<input type="submit" value="검색">

</form>

</body>
</html>