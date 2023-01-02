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
<h3>트레블스토리</h3>
<c:if test="${sessionScope.loginId==null }">
	<a href="${pageContext.request.contextPath }/member/add.do">회원가입</a>
	<a href="${pageContext.request.contextPath }/member/login.do">로그인</a><br/>
</c:if>
<c:if test="${sessionScope.loginId!=null }">
${sessionScope.loginId}님 로그인중 <br/>
<a href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">내정보</a>
<a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a>
<a href="${pageContext.request.contextPath }/cityinfo/getall.do">도시정보</a>
<a href="${pageContext.request.contextPath }/notice/getall.do">트레블스토리</a>
<a href="${pageContext.request.contextPath }/question/listAll.do">질문게시판</a>
<a href="${pageContext.request.contextPath }/그냥 이건 링크로!">고객센터</a>
<a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId}">탈퇴</a><br/>
</c:if>
</body>
</html>