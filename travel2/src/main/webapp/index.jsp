<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<script src="https://kit.fontawesome.com/f2754c19ed.js" crossorigin="anonymous"></script>
<script>
const a = () => {
	alert("고객센터로 연락주세요"+<br/>+"031-333-3333");
}
</script>

</head>

<body>
	<!-- header-section start -->
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-4 hidden-sm col-sm-12">
					<div class="call-info">
						<a href="/travel/index.jsp"><img
							src="${pageContext.request.contextPath }/Resources/images/travellogo.png"
							style="width: 250px;"
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
					<div class="col-lg-4 col-md-2 col-sm-12 col-xs-12">
						<!-- 						<a href="index.html"><img -->
						<!-- 							src="Resources/images/travellogo.png" -->
						<!-- 							style="width: 250px; height: 100px;" -->
						<!-- 							alt="Tour and Travel Agency - Responsive Website Template"></a> -->
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xl-12">
						<div class="navigation">
							<div id="navigation">
								<ul>
									<li class="active"><a href="index.jsp" title="Home">Home</a></li>
									<li><a
										href="${pageContext.request.contextPath }/cityinfo/getall.do"
										title="About us">도시 정보 </a></li>
									<!-- <li class="has-sub"><a href="tours.html" title="Tours">Tours</a>
										<ul>
											<li><a href="domestic-tour.html" title="Group Tours">Domestic
													Tours</a></li>
											<li><a href="international-tour.html"
												title="Couple Tours">International Tours</a></li>
										</ul></li> -->
									<!-- <li class="has-sub"><a href="blog-default.html"
										title="Blog ">Blog</a>
										<ul>
											<li><a href="blog-default.html" title="Blog">Blog
													Default</a></li>
											<li><a href="blog-single.html" title="Blog Single ">Blog
													Single</a></li>
										</ul></li> -->
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
									<li><form class="col-12 mb-3 mb-lg-0 me-lg-3 role="search">
											<input type="search"
												class="form-control form-control-dark text-bg-white"
												placeholder="도시검색..." aria-label="Search">
										</form></li>
									<li><a
										href="${pageContext.request.contextPath }/cityinfo/getall.do"><strong>검색</strong>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- header-section close -->
	<!-- hero-section start -->
	<div class="hero-section">
		<!-- <div class="container">
			<div class="row">
				<div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
				
					<div class="hero-section-caption pinside40">	
					
					
						<h1 class="hero-title">Discover The Places You’ve Never Been
							Before</h1>
						<a href="" class="btn btn-primary ">
						
							</a>
					</div>
				</div>
			</div>
		</div> -->
		<img
			src="${pageContext.request.contextPath }/Resources/images/mainimage.jpg">
	</div>
	<!-- hero-section close -->
	<!-- service-section start -->
	<!-- service-section start -->
	<div class="space-medium" >
		<div class="container" style="width:1300px">
			<div class="row">
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1><strong>트레블 스토리를 활용하세요 :D</strong></h1>
					</div>
				</div>
			</div>
			<div class="row">
		<!-- service start -->
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

			<section class="intro">
				<div class="cardo">
					<a href="index.jsp"><i class="fa-solid fa-earth-europe fa-bounce"
						style="font-size: 100px"></i></a>
					<h1><strong>유럽의 모든 정보</strong></h1>
					<p style="font-family: 견고딕; font-size: 15pt">
						다채로운<br/>
						유럽의 모습을<br/>
						느껴보세요!
					</p>
				</div>


			</section>

		</div>

		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

			<section class="intro">
				<div class="cardo">
					<i class="fa-solid fa-people-pulling fa-shake"
						style="-fa-animation-duration: 2s; font-size: 100px"></i>
					<h1><strong>함께 여행해요</strong></h1>
					<p style="font-family: 견고딕; font-size: 15pt">
						좋은 사람들과 함께<br/>
						유럽을 즐겨보세요!
					</p>
				</div>
			</section>

		</div>

		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

			<section class="intro">
				<div class="cardo">
					<i class="fa-solid fa-circle-question fa-flip"
						style="-fa-flip-x: 1; - -fa-flip-y: 0; - -fa-animation-duration: 2s; font-size: 100px"></i>
					<h1><strong>정보를 나눠요</strong></h1>
					<p style="font-family: 견고딕; font-size: 15pt">
					고민하지 말고<br/>
					자유롭게 이야기해요</p>
				</div>
			</section>

		</div>

	</div>
	<!-- service-section close -->
	<!-- Destination-section-start -->
	<div class="space-medium">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1>인기 도시</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- destination-one-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="destination-img">
						<a
							href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=1"
							> <img
							src="${pageContext.request.contextPath }/Resources/images/london.jpg"
							style="width: 360px; height: 300px;" alt "Tour and Travel
							Agency - Responsive Website Template" class="img-responsive"></a>
					</div>
					<div class="destination-content">
						<h3>
							<a
								href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=1"
								class="destination-title">London</a>
						</h3>
					</div>
				</div>
				<!-- destination-one-close -->
				<!-- destination-two-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="destination-img">
						<a
							href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=2"
							><img
							src="${pageContext.request.contextPath }/Resources/images/paris.jpg"
							style="width: 360px; height: 300px;" alt "Tour and Travel
							Agency - Responsive Website Template" class="img-responsive"></a>
					</div>
					<div class="destination-content">
						<h3>
							<a
								href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=2"
								class="destination-title">Paris</a>
						</h3>
					</div>
				</div>
				<!-- destination-two-close -->
				<!-- destination-three-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="destination-img">
						<a
							href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=3"><img
							src="${pageContext.request.contextPath }/Resources/images/barcelona.jpg"
							style="width: 360px; height: 300px;" Tour and Travel
							Agency - Responsive Website Template" class="img-responsive"></a>
					</div>
					<div class="destination-content">
						<h3>
							<a
								href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=3"
								class="destination-title">Barcelona</a>
						</h3>
					</div>
				</div>

				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<!-- <div class="section-title text-center"> -->

						<div class="row">
							<!-- destination-one-start -->
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="destination-img">
									<a
										href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=4"
										><img
										src="${pageContext.request.contextPath }/Resources/images/venice.jpg"
										style="width: 360px; height: 300px;" alt "Tour and Travel
										Agency - Responsive Website Template" class="img-responsive"></a>
								</div>
								<div class="destination-content">
									<h3>
										<a
											href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=4"
											class="destination-title">Venice</a>
									</h3>
								</div>
							</div>
							<!-- destination-one-close -->
							<!-- destination-two-start -->
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="destination-img">
									<a
										href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=5"
										><img
										src="${pageContext.request.contextPath }/Resources/images/rome.jpg"
										style="width: 360px; height: 300px;" alt "Tour and Travel
										Agency - Responsive Website Template" class="img-responsive"></a>
								</div>
								<div class="destination-content">
									<h3>
										<a
											href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=5"
											class="destination-title">Rome</a>
									</h3>
								</div>
							</div>
							<!-- destination-two-close -->
							<!-- destination-three-start -->
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="destination-img">
									<a
										href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=6">
										<img
										src="${pageContext.request.contextPath }/Resources/images/luxembourg.jpg"
										style="width: 360px; height: 300px;" alt "Tour and Travel
										Agency - Responsive Website Template" class="img-responsive">
									</a>
								</div>
								<div class="destination-content">
									<h3>
										<a
											href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=6"
											class="destination-title">Luxembourg</a>
									</h3>
								</div>
							</div>
							<!-- <!-- destination-three-close -->


							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<!-- <div class="section-title text-center"> -->

									<div class="row">
										<!-- destination-one-start -->
										<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
											<div class="destination-img">
												<a
													href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=7"
													> <img
													src="${pageContext.request.contextPath }/Resources/images/praha.jpg"
													style="width: 360px; height: 300px;" alt "Tour and Travel
													Agency - Responsive Website
													Template" class="img-responsive"></a>
											</div>
											<div class="destination-content">
												<h3>
													<a
														href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=7"
														class="destination-title">Praha</a>
												</h3>
											</div>
										</div>
										<!-- destination-one-close -->
										<!-- destination-two-start -->
										<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
											<div class="destination-img">
												<a href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=8"
													><img src="${pageContext.request.contextPath }/Resources/images/zurich.jpg"
													style="width: 360px; height: 300px;" alt "Tour and Travel
													Agency - Responsive Website
													Template" class="img-responsive"></a>
											</div>
											<div class="destination-content">
												<h3>
													<a
														href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=8"
														class="destination-title">Zurich</a>
												</h3>
											</div>
										</div>
										<!-- destination-two-close -->
										<!-- destination-two-start -->
										<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
											<div class="destination-img">
												<a
													href="${pageContext.request.contextPath }/travel/cityinfo/citymain.do?city_num=9"
													><img
													src="${pageContext.request.contextPath }/Resources/images/vienna.jpg"
													style="width: 360px; height: 300px;" alt "Tour and Travel
													Agency - Responsive Website
													Template" class="img-responsive"></a>
											</div>
											<div class="destination-content">
												<h3>
													<a
														href="${pageContext.request.contextPath }/cityinfo/citymain.do?city_num=9"
														class="destination-title">Vienna</a>
												</h3>
											</div>
										</div>
										<!-- destination-two-close -->
									</div>
								</div>
							</div>
							<!-- Destination-section-close -->

														</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	<!-- Testimonials-section start -->
	<div class="bg-default space-medium">
		<div class="container">
			<div class="row">
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1>이달의 추천도시!</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- Testimonials-one-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="testimonial-block">
						<div class="testimonial-img">
							<img
								src="${pageContext.request.contextPath }/Resources/images/best4.jpg"
								alt="잠시 오류입니다!">
						</div>
						<!-- <div class="testimonial-user-img">
							<img src="Resources/images/testimonial-user-img-1.jpg"
								alt="잠시 오류입니다!"
								class="img-circle">
						</div> -->
						<div class="testimonial-content">
							<h4>프라하</h4>
							<span class="location">체코</span>
							<div class="rating">
								<span> <i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i> </span> <span><i class="fa fa-star"></i>
								</span> <span><i class="fa fa-star"></i> </span> <span><i
									class="fa fa-star"></i> </span>
							</div>
							<div>
								<p class="testimonial-text">“프라하 인생샷 찍기 너무좋네요! 프라하는 풍경이 아름다운
									도시죠. 추천합니다!"</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Testimonials-one-close -->
				<!-- Testimonials-two-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="testimonial-block">
						<div class="testimonial-img">
							<img
								src="${pageContext.request.contextPath }/Resources/images/best2.jpg"
								alt="Tour and Travel Agency - Responsive Website Template">
						</div>
						<!-- <div class="testimonial-user-img">
							<img src="Resources/images/testimonial-user-img-2.jpg"
								alt="Tour and Travel Agency - Responsive Website Template"
								class="img-circle">
						</div> -->
						<div class="testimonial-content">
							<h4>런던</h4>
							<span class="location">영국</span>
							<div class="rating">
								<span> <i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i> </span> <span><i class="fa fa-star"></i>
								</span> <span><i class="fa fa-star"></i> </span> <span><i
									class="fa fa-star"></i> </span>
							</div>
							<div>
								<p class="testimonial-text">“탁 트인 파리시내와 아름다운 에펠탑! 꼭 한번 가보시길
									추천합니다!”</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Testimonials-two-start -->
				<!-- Testimonials-three-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="testimonial-block">
						<div class="testimonial-img">
							<img
								src="${pageContext.request.contextPath }/Resources/images/best3.jpg"
								alt="Tour and Travel Agency - Responsive Website Template">
						</div>
						<!-- <div class="testimonial-user-img">
							<img src="Resources/images/testimonial-user-img-3.jpg"
								alt="Tour and Travel Agency - Responsive Website Template"
								class="img-circle">
						</div> -->
						<div class="testimonial-content">
							<h4>베네치아</h4>
							<span class="location">이탈리아</span>
							<div class="rating">
								<span> <i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i> </span> <span><i class="fa fa-star"></i>
								</span> <span><i class="fa fa-star"></i> </span> <span><i
									class="fa fa-star"></i> </span>
							</div>
							<div>
								<p class="testimonial-text">“바다위에 지어진 예술의 도시 베네치아! 유럽 어느
									나라에서도 볼 수 없는 매력적인 도시!</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Testimonials-three-close -->
			</div>
		</div>
	</div>
	<!-- footer start -->
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
