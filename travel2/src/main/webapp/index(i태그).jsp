<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description"
	content="Want to start your travel agency online and need website for your travel business? Start with travel agency responsive website template. Its absolutely free.">
<meta name="keywords"
	content="travel, tour, tourism, honeymoon pacakage, summer trip, exotic vacation, destination, international, domestic website template, holiday, travel agecny responsive website template">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Tour and Travel Agency - Responsive Website Template</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath }/Resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Style CSS -->
<link href="${pageContext.request.contextPath }/Resources/css/style.css" rel="stylesheet">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- FontAwesome CSS -->
<link href="${pageContext.request.contextPath }/Resources/css/font-awesome.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
const a = () => {
	alert("고객센터로 연락주세요"+<br/>+"031-333-3333");
}
</script>

<script src="https://kit.fontawesome.com/f2754c19ed.js" crossorigin="anonymous"></script>
</head>

<body>
	<!-- header-section start -->
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-4 hidden-sm col-sm-12">
					<div class="call-info">
												<a href="index.jsp"><img
							src="${pageContext.request.contextPath }/Resources/images/travellogo.png"
							style="width: 250px; height: 100px;"
							alt="Tour and Travel Agency - Responsive Website Template"></a>
					</div>
				</div>
				<div class="col-md-8 hidden-sm hidden-xs">
					<div class="text-end">

						<a href="${pageContext.request.contextPath }/member/login.do"><button
								type="button" style="color: black; background: white;"
								class="btn btn-outline-light me-2">Login</button></a> <a
							href="${pageContext.request.contextPath }/member/add.do"><button
								type="button" style="color: black; background: white;"
								class="btn btn-warning">Sign-up</button></a>

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
									<li><a href="${pageContext.request.contextPath }/cityinfo/getall.do" title="About us">도시 정보 </a></li>
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
									<li><a href="${pageContext.request.contextPath }/notice/getall.do" title="Testimonials">트레블스토리 </a>
									<li><a href="${pageContext.request.contextPath }/question/listAll.do" title="Contact Us">질문게시판 </a></li>
									<li><a href="${pageContext.request.contextPath }/contact.jsp" title="Contact Us" >고객센터  </a></li>
									<li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li><li>
									<a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li>
									<li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li>
									<li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li>
									<li><form class="col-12 mb-3 mb-lg-0 me-lg-3 role="search">
										<input type="search" 
											class="form-control form-control-dark text-bg-white"
											placeholder="도시검색..." aria-label="Search">
									</form></li>
									<li><a href="${pageContext.request.contextPath }/cityinfo/getall.do"><strong>검색</strong> </a></li>
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
		<img src="${pageContext.request.contextPath }/Resources/images/mainimage.jpg">
	</div>
	
	<!-- hero-section close -->
	<!-- service-section start -->
<!-- 	<div class="space-medium"> -->
<!-- 		<div class="container"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12"> -->
<!-- 					<div class="section-title text-center"> -->
<!-- 						<h1>트레블 스토리를 활용하세요</h1> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				service start -->
<!-- 				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12"> -->
<!-- 					<div class="service-block"> -->
<!-- <section class="intro"> -->
<!-- 		<div class="card"> -->
<!-- 		<i class="fa-solid fa-book fa-bounce" style="font-size:100px"></i> -->
<!-- 			<h1>RECIPE</h1> -->
<!-- 			<p style="font-family:견고딕;font-size:15pt">쉬우면서도 맛있는<br/> 요리를 선보입니다. -->
<!-- 			</p> -->
<!-- 		</div> -->
		

<!-- 	</section> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				service close -->
<!-- 				service start -->
<!-- 				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12"> -->
<!-- 					<div class="service-block"> -->
<!-- 						<section class="intro"> -->
<!-- 						<div class="card"> -->
<!-- 			<i class="fa-solid fa-kitchen-set fa-shake" style="--fa-animation-duration: 2s;font-size:100px"></i> -->
<!-- 			<h1>Cooking Class</h1> -->
<!-- 			<p style="font-family:견고딕;font-size:15pt">전세계 유명 셰프들의<br/>쿠킹클래스를 들어보세요!</p> -->
<!-- 							</div></section> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				service close -->
<!-- 				service start -->
<!-- 				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12"> -->
<!-- 					<div class="service-block"> -->
<!-- 								<section class="intro"> -->
<!-- 								<div class="card"> -->
<!-- 			<i class="fa-solid fa-comments fa-flip" style="--fa-flip-x: 1; --fa-flip-y: 0; --fa-animation-duration: 2s; font-size:100px"></i> -->
<!-- 			<h1>Free Board</h1> -->
<!-- 			<p style="font-family:견고딕;font-size:15pt">자유롭게 이야기해요</p> -->
<!-- 		</div></section> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				service close -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

	
		
			<div class="row">
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1>트레블 스토리를 활용하세요</h1>
					</div>
				</div>
			</div>
	<div class="row">
		<!-- service start -->
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

			<section class="intro">
				<div class="card">
					<a href="index.jsp"><i class="fa-solid fa-earth-europe fa-bounce"
						style="font-size: 100px"></i></a>
					<h1>유럽의 모든 정보</h1>
					<p style="font-family: 견고딕; font-size: 15pt">
						쉬우면서도 맛있는<br /> 요리를 선보입니다.
					</p>
				</div>


			</section>

		</div>

		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

			<section class="intro">
				<div class="card">
					<i class="fa-solid fa-people-pulling fa-shake"
						style="-fa-animation-duration: 2s; font-size: 100px"></i>
					<h1>함께 여행해요</h1>
					<p style="font-family: 견고딕; font-size: 15pt">
						전세계 유명 셰프들의<br />쿠킹클래스를 들어보세요!
					</p>
				</div>
			</section>

		</div>

		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

			<section class="intro">
				<div class="card">
					<i class="fa-solid fa-circle-question fa-flip"
						style="-fa-flip-x: 1; - -fa-flip-y: 0; - -fa-animation-duration: 2s; font-size: 100px"></i>
					<h1>모르는 건 물어봐요</h1>
					<p style="font-family: 견고딕; font-size: 15pt">자유롭게 이야기해요</p>
				</div>
			</section>

		</div>

	</div>





	<!-- service-section close -->
	<!-- about-section start -->
	<div class="bg-default space-medium">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1>Why Choose Our Travel Agency?</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- feature start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="feature-block">
						<div class="feature-icon">
							<i class="fa fa-building"></i>
						</div>
						<div class="feature-content">
							<h3 class="feature-title">Accommodation</h3>
							<p>Lorem ipsum dolor sitamet consec tetur adipiscing elied rs
								tristi quetur etullam corper viver.</p>
						</div>
					</div>
				</div>
				<!-- feature close -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="feature-block">
						<div class="feature-icon">
							<i class="fa fa-plane"></i>
						</div>
						<div class="feature-content">
							<h3 class="feature-title">Transportation</h3>
							<p>Vivamus tincidunt varius arcu vitaeli ac fringilla
								nioamile just oetbi once bendum dapibus.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="feature-block">
						<div class="feature-icon">
							<i class="fa fa-star"></i>
						</div>
						<div class="feature-content">
							<h3 class="feature-title">Easy Trip Planning</h3>
							<p>Apretium imperdie is nullam facili sis elit velest blandit
								ultri ciesras atvar ac ius lorem sitamet velerat.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- about-section close -->
	<!-- Destination-section-start -->
	<div class="space-medium">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1>Top Destinations</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- destination-one-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="destination-img">
						<a href="#" class="imghover"><img
							src="${pageContext.request.contextPath }/Resources/images/destination-1.jpg" alt "Tour and Travel
							Agency - Responsive Website Template" class="img-responsive"></a>
					</div>
					<div class="destination-content">
						<h3>
							<a href="#" class="destination-title">Singapore</a>
						</h3>
					</div>
				</div>
				<!-- destination-one-close -->
				<!-- destination-two-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="destination-img imghover">
						<a href="#" class="imghover"><img
							src="${pageContext.request.contextPath }/Resources/images/destination-2.jpg" alt "Tour and Travel
							Agency - Responsive Website Template" class="img-responsive"></a>
					</div>
					<div class="destination-content">
						<h3>
							<a href="#" class="destination-title">Greece</a>
						</h3>
					</div>
				</div>
				<!-- destination-two-close -->
				<!-- destination-three-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="destination-img imghover">
						<a href="#"><img src="${pageContext.request.contextPath }/Resources/images/destination-3.jpg"
							alt "Tour and Travel Agency - Responsive Website
							Template" class="img-responsive"></a>
					</div>
					<div class="destination-content">
						<h3>
							<a href="#" class="destination-title">Thailand</a>
						</h3>
					</div>
				</div>
				<!-- destination-three-close -->
			</div>
		</div>
	</div>
	<!-- Destination-section-close -->
	<!-- Testimonials-section start -->
	<div class="bg-default space-medium">
		<div class="container">
			<div class="row">
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="section-title text-center">
						<h1>Our Happy Travelers Reviews</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- Testimonials-one-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="testimonial-block">
						<div class="testimonial-img">
							<img src="${pageContext.request.contextPath }/Resources/images/testimonial-img-1.jpg"
								alt="Tour and Travel Agency - Responsive Website Template">
						</div>
						<div class="testimonial-user-img">
							<img src="${pageContext.request.contextPath }/Resources/images/testimonial-user-img-1.jpg"
								alt="Tour and Travel Agency - Responsive Website Template"
								class="img-circle">
						</div>
						<div class="testimonial-content">
							<h4>Paul Hasburg</h4>
							<span class="location">Kerala</span>
							<div class="rating">
								<span> <i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i> </span> <span><i class="fa fa-star"></i>
								</span> <span><i class="fa fa-star"></i> </span> <span><i
									class="fa fa-star"></i> </span>
							</div>
							<div>
								<p class="testimonial-text">“I love this tour. We have
									enough time to fully experience the Kerala. I have the
									opportunity to show my region, thank you"</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Testimonials-one-close -->
				<!-- Testimonials-two-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="testimonial-block">
						<div class="testimonial-img">
							<img src="${pageContext.request.contextPath }/Resources/images/testimonial-img-2.jpg"
								alt="Tour and Travel Agency - Responsive Website Template">
						</div>
						<div class="testimonial-user-img">
							<img src="${pageContext.request.contextPath }/Resources/images/testimonial-user-img-2.jpg"
								alt="Tour and Travel Agency - Responsive Website Template"
								class="img-circle">
						</div>
						<div class="testimonial-content">
							<h4>Plisa Moody</h4>
							<span class="location">Kullu-manali</span>
							<div class="rating">
								<span> <i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i> </span> <span><i class="fa fa-star"></i>
								</span> <span><i class="fa fa-star"></i> </span> <span><i
									class="fa fa-star"></i> </span>
							</div>
							<div>
								<p class="testimonial-text">“You were an excellent Travel
									Agency for us! It was invaluable trip to kullu-manali & You
									considered our unique needs, thank you ”</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Testimonials-two-start -->
				<!-- Testimonials-three-start -->
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<div class="testimonial-block">
						<div class="testimonial-img">
							<img src="${pageContext.request.contextPath }/Resources/images/testimonial-img-3.jpg"
								alt="Tour and Travel Agency - Responsive Website Template">
						</div>
						<div class="testimonial-user-img">
							<img src="${pageContext.request.contextPath }/Resources/images/testimonial-user-img-3.jpg"
								alt="Tour and Travel Agency - Responsive Website Template"
								class="img-circle">
						</div>
						<div class="testimonial-content">
							<h4>Christine Smith</h4>
							<span class="location">Turkey</span>
							<div class="rating">
								<span> <i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i> </span> <span><i class="fa fa-star"></i>
								</span> <span><i class="fa fa-star"></i> </span> <span><i
									class="fa fa-star"></i> </span>
							</div>
							<div>
								<p class="testimonial-text">“Suspendisse vitaea enim dictum
									fringilla ullam interdum atelit id vestibulum TURKEY aecenas
									viverra risusit amet quam consectetu, thank you”</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Testimonials-three-close -->
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
