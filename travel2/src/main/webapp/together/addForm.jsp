<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동행구해요 글 작성 페이지</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description"
	content="Want to start your travel agency online and need website for your travel business? Start with travel agency responsive website template. Its absolutely free.">
<meta name="keywords"
	content="travel, tour, tourism, honeymoon pacakage, summer trip, exotic vacation, destination, international, domestic website template, holiday, travel agecny responsive website template">
<title>Tour and Travel Agency - Responsive Website Template</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath }/Resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Style CSS -->
<link href="${pageContext.request.contextPath }/Resources/css/style.css"
	rel="stylesheet">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- FontAwesome CSS -->
<link
	href="${pageContext.request.contextPath }/Resources/css/font-awesome.min.css"
	rel="stylesheet">

</head>




<body>
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-4 hidden-sm col-sm-12">
					<div class="call-info">
						<a href="${pageContext.request.contextPath }/index.jsp"><img
							src="${pageContext.request.contextPath }/Resources/images/travellogo.png"
							style="width: 230px; height: 80;"
							alt="Tour and Travel Agency - Responsive Website Template"></a>
					</div>
				</div>
				<div class="col-md-8 hidden-sm hidden-xs">


					<div class="text-end">
						<c:if test="${sessionScope.loginId == null }">
							<a href="${pageContext.request.contextPath }/member/login.do">

								<button type="button" style="color: black; background: white;"
									class="btn btn-outline-light me-2">Login</button>
							</a>
							<a href="${pageContext.request.contextPath }/member/add.do"><button
									type="button" style="color: black; background: white;"
									class="btn btn-warning">Sign-up</button></a>
						</c:if>

						<c:if test="${sessionScope.loginId != null}">
							<a href="${pageContext.request.contextPath }/member/logout.do">
								<button type="button" style="color: black; background: white;"
									class="btn btn-outline-light me-2">Logout</button>
							</a>
						</c:if>



					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="header-wrapper">
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-2 col-sm-12 col-xs-12"></div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xl-12">
						<div class="navigation">
							<div id="navigation">
								<ul>

									<li class="active"><a
										href="${pageContext.request.contextPath }/index.jsp"
										title="Home">Home</a></li>

									<li><a
										href="${pageContext.request.contextPath }/cityinfo/getall.do"
										title="About us">도시 정보 </a></li>

									<li><a
										href="${pageContext.request.contextPath }/notice/getall.do"
										title="Testimonials">트레블스토리 </a>
									<li><a
										href="${pageContext.request.contextPath }/question/listAll.do"
										title="Contact Us">질문게시판 </a></li>
									<li><a
										href="${pageContext.request.contextPath }/contact.jsp"
										title="Contact Us">고객센터 </a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									<li><a href=""></a></li>
									
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- header-section close -->



	<div class="row">
                      
	 <form action="${pageContext.request.contextPath }/together/add.do" method="post">

		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="id" >작성자</label> 
				<input id="id" name="id" type="text" class="form-control" required="" value="${sessionScope.loginId }" readonly>
			</div>
		</div>
		<div class="col-md-6"> 
			<div class="form-group">
				<label class="control-label" for="city_name"
					value="${sessionScope.city_num }">도시명</label> <input id="city_num"
					name="city_num" type="text" class="form-control" required="" value="${sessionScope.city_num }" readonly>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="title">제목</label> <input
					id="title" name="title" type="text" class="form-control"
					required="" >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="ppl">인원</label> 
				<select name="ppl" class="form-control">
					<option value="1" selected>1명</option>
					<option value="2">2명</option>
					<option value="3">3명</option>
					<option value="4">4명</option>
					<option value="5">5명</option>
					<option value="6">6명</option>
				</select> 
					
			</div>
		</div>
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label" for="content">내용</label>
				<textarea class="form-control" id="content" name="content" rows="6"></textarea>
			</div>
		</div>
		<div class="col-md-12">
			<div class="form-group">
				<button id="submit" name="singlebutton" class="btn btn-primary">작성하기</button>
			</div>
		</div>
	</form>


<%-- <%-- 	<div style ="text-align:center; margin:50px">
<h3>동행구해요 글 작성하기</h3>
</div>

<a href ="${pageContext.request.contextPath }/together/getall.do?city_num=${sessionScope.city_num}"> 글 목록으로 가기 </a><br/>

<div style ="text-align:center">

<form action ="${pageContext.request.contextPath }/together/add.do" method="post">
<table border ="3" align = "left" style=width:1000px;>

<tr><th>작성자</th><td><input type="text" name="id" value="${sessionScope.loginId }" readonly ></td></tr>
<tr><th>도시명</th><td><input type= "text" name = "city_num" value= "${sessionScope.city_num }" readonly></td></tr>
<tr><th> 제목 </th><td><input type="text" name="title"></td></tr>
<tr><th> 내용 </th><td><textarea name="content" cols="100px" rows="15px"></textarea></td></tr>

<tr><th>인원수</th><td>
<select name = "ppl"> 
<option value="1" selected> 1명  </option>
<option value ="2"> 2명 </option>
<option value ="3"> 3명 </option>
<option value ="4"> 4명 </option>
<option value ="5"> 5명 </option>
<option value ="6"> 6명 </option>
</select>
<tr><th>업로드</th><td><input type="submit" value="등록하기"></td></tr>


</table>
</form>
</div> --> --%>
                    </div>
                </div>
                <!-- contact form close -->
            </div>
        </div>
    </div>
   <!-- footer start -->
	<div class="footer">
		<div class="container">
			<div class="row">
				<!-- footer-about-start -->
				<div class=" col-lg-3 col-md-3 col-sm-3 col-xs-12">
					<div class="footer-widget">
						<h3 class="footer-title ">트레블스토리는...</h3>
						<p>트레블스토리는 여행 관련 컨텐츠 서비스를 제공하는 커뮤니티 사이트입니다.</p>
						
					</div>
				</div>
				<!-- footer-about-close -->
				<!-- footer-location-start -->
				<div class=" col-lg-3 col-md-3 col-sm-3 col-xs-12">
					<div class="footer-widget">
						<h3 class="footer-title">서비스</h3>
						<ul class="arrow arrow-chevron-circle-right">
							<li><a href="#">도시 정보</a></li>
							<li><a href="#">트레블스토리</a></li>
							<li><a href="#">질문게시판</a></li>
							<li><a href="#">고객센터</a></li>
							
						</ul>
					</div>
				</div>
				<!-- footer-location-close -->
				<!-- footer-contact-start -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 ">
					<div class="footer-widget">
						<h3 class="footer-title">(주)트레블스토리</h3>
						<div class="contact-info">
							<ul>
								<li>경기도 분당구 성남시 코스타 6층 </li>
								<li>Tel : 5555-5555</li> <li>(평일 09:00 ~ 18:00)</li>
								<li>info@travelstory.com</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- footer-contact-close -->
				<!-- footer-social-start -->
				<div class="col-lg-3 col-md-3 col-sm-2 col-xs-12 ">
					<div class="footer-widget">
						<h3 class="footer-title">Follow us on</h3>
						<div class="footer-social">
							<ul>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- footer-social-close -->
			</div>
		</div>
	</div>
	<!-- tiny-footer-start -->
	<div class="tiny-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					(주)트레블스토리 <i class="fa fa-love"></i>
				</div>
			</div>
		</div>
		<!-- tiny-footer-start -->
	</div>
	<!-- footer close -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/menumaker.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.sticky.js"></script>
	<script type="text/javascript" src="js/sticky-header.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
		integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
		crossorigin="anonymous"></script>
		</body>
</html>