<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">트레블스토리</a> 
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">도시정보</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Disabled</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<button type="button" class="btn btn-primary">Primary</button>
<div class="card" style="width: 18rem;">
  <img src="https://images.chosun.com/resizer/k6L-J7LOYHpzi7J0o6f-LAfbtVw=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/RWXHN2ZUBBXGLLFHBULDVSWBAA.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>

	<h3>댓글형 게시판</h3>
	<!-- 로그인하지 않았을 때 -->
	<c:if test="${sessionScope.loginId==null }">
		<!-- el로값을 접근할떄 default를 찾는곳이 request.request에 담은건 이름만쓰면되고 세션스코프에담은건 sessionScop.loginId -->
		<a href="${pageContext.request.contextPath }/member/join">회원가입</a>
		<%-- ${pageContext.request.contextPath } 프로젝트명 대신 사용하는 경로 --%>
		<a href="${pageContext.request.contextPath }/member/login">로그인</a>
	</c:if>
	<!-- 로그인 되었을때 -->
	<c:if test="${sessionScope.loginId!=null }"> 
${sessionScope.loginId}님 로그인중<br />
		<a href="${pageContext.request.contextPath }/member/detail?id=${sessionScope.loginId}">내정보 확인</a>
		<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
		<a href="${pageContext.request.contextPath }/member/out?id=${sessionScope.loginId}">탈퇴</a>
		<a href="${pageContext.request.contextPath}/board/list">게시판</a>
	</c:if>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>