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
	<h3>웹앱</h3>
	<!-- 로그인하지 않았을 때 -->
	<c:if test="${sessionScope.loginId==null }">
		<!-- el로값을 접근할떄 default를 찾는곳이 request.request에 담은건 이름만쓰면되고 세션스코프에담은건 sessionScop.loginId -->
		<a href="${pageContext.request.contextPath }/member/add.do">회원가입</a>
		<%-- ${pageContext.request.contextPath } 프로젝트명 대신 사용하는 경로 --%>
		<a href="${pageContext.request.contextPath }/member/login.do">로그인</a>
	</c:if>
	<!-- 로그인 되었을때 -->
	<c:if test="${sessionScope.loginId!=null }"> 
${sessionScope.loginId}님 로그인중<br />
		<a href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">내정보 확인</a>
		<a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a>
		<a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId}">탈퇴</a>
		<a href="${pageContext.request.contextPath }/download/getall.do">자료실</a><br/>
	</c:if>
</body>
</html>