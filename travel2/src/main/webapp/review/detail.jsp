<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>


const b = () =>{
	location.href = "${pageContext.request.contextPath }/review/del.do?review_num=${vo.review_num}&city_num=${sessionScope.city_num}";
}



const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.review_num);
	let html = "<span id='content_'"+obj.review_rep_num+">";
	html += "번호: "+obj.review_rep_num+". "+obj.content+"(id: "+obj.id+")"+"작성일: "+obj.date+"</span>";
	let id = obj.id;
	let loginId = '${sessionScope.loginId }';
	if(id==loginId){
		html += "<div style='text-align:right;'><input type='button' value='수정' onclick=redit("+obj.review_rep_num+",'"+obj.content+"')>";
		html += "<input type='button' value='삭제' onclick=rdel("+obj.review_rep_num+")></div>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	return rDiv;
}

const addrep = (review_num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	  
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_");
	  div.innerHTML = "";
	  let html = "";
	  for(let obj of arr){
		
		  let dd = mkDiv(obj);
		  div.appendChild(dd);
	  }
	 //div.innerHTML = html;
	}

	let rep = document.getElementById("rep_"+review_num);
	let param = "review_num="+review_num;
	param += "&id=${sessionScope.loginId}";
	param += "&date="+rep.value;
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/review_rep/add.do");

	//request 헤더에 content type을 application으로 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	// 4. 요청보냄
	xhttp.send(param);
}
const redit = (review_rep_num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+review_rep_num);
	rDiv.appendChild(editForm);
	editForm.style.display='';
	let editNum = document.getElementById("edit_num");
	editNum.value = review_rep_num;
	let editContent = document.getElementById("edit_content");
	editContent.value = content;
}



const rep_edit = () => {
	let editNum = document.getElementById("edit_num");
	let editContent = document.getElementById("edit_content");
	let param = "review_rep_num=" + editNum.value;
	param += "&content=" + editContent.value;
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
	 
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.review_rep_num);
	  let html = "";
	  
	  html += obj.review_rep_num+". "+obj.content+"(id:"+obj.id+")";
	 
	  span.innerHTML = html;
	  editNum.value = "";
	  editContent.value = ""; 
	 
	  cancel(); 
	  
	}
	
	xhttp.open("post", "${pageContext.request.contextPath }/review_rep/edit.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send(param);
}
const rdel = (review_rep_num, review_num) => {
	
	let repsDiv = document.getElementById("res_");
	let rDiv = document.getElementById("r_"+review_rep_num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	xhttp.open("post", "${pageContext.request.contextPath }/review_rep/del.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send("review_rep_num="+review_rep_num+"&review_num="+review_num);
}
const cancel = () => {
	let hiddenDiv = document.getElementById("hidden");
	let editForm = document.getElementById("edit_form");
	hiddenDiv.appendChild(editForm);
	editForm.style.display='none';
}
</script>
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
</head>
<body>
	<!-- header-section start -->
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-4 hidden-sm col-sm-12">
					<div class="call-info">
						<a href="${pageContext.request.contextPath }/index.jsp"><img
							src="${pageContext.request.contextPath }/Resources/images/travellogo.png"
							style="width: 250px; height: 100px;"
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
									<li class="active"><a
										href="${pageContext.request.contextPath }/index.jsp"
										title="Home">Home</a></li>
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

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- header-section close -->
	<!-- 디테일 start -->

	<div style="padding: 0px 300px 200px 300px;">
		<c:if test="${sessionScope.loginId != vo.id }">
			<c:set var="str">readonly</c:set>
		</c:if>
		<h3>리뷰 글 상세페이지</h3>
		<a
			href="${pageContext.request.contextPath }/review/getall.do?city_num=${sessionScope.city_num}">목록으로</a><br />
		<form action="${pageContext.request.contextPath }/review/edit.do"
			method="post" name="f">
			<table class="table table-bordered" style="text-align: center;">

				<tr>
					<th style="width: 200px;">글번호</th>
					<td colspan="2"><input type="text" name="review_num"
						value="${vo.review_num }"
						style="width: 700px; text-align: center;" readonly></td>
				</tr>
				<tr>
					<th>도시번호</th>
					<td colspan="2"><input type="text" name="city_num"
						value="${vo.city_num }" style="width: 700px; text-align: center;"
						readonly></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td colspan="2"><input type="text" name="id" value="${vo.id }"
						style="width: 700px; text-align: center;" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="2"><input type="text" name="title"
						value="${vo.title }" ${str }
						style="width: 700px; text-align: center;"></td>
				</tr>

				<tr>
					<td colspan="2">

						<div style="text-align: center;">
							<img src="${vo.img_path } "
								style="max-width: 100%; height: auto;">
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="3"><textarea rows="15" cols="100" name="content"
							${str }>${vo.content }</textarea></td>
				</tr>

				<c:if test="${sessionScope.loginId == vo.id}">
					<tr>
						<td colspan="3"><input type="submit" value="수정"> <input
							type="button" value="삭제" onclick="b()"></td>
					</tr>
				</c:if>
			</table>
		</form>

		<table border="1" style="width: 900px;">
			<tr>
				<th colspan="3" style="text-align: center; background: silver;"><span>댓글목록</span>
				</th>
			</tr>

			<td colspan="2" id="res_${review_num}"><c:forEach var="r"
					items="${vo.reps }">
					<table border="1" style="width: 900px;">
						<div id="r_${r.review_rep_num }" style="text-align: center;">

							<span id="content_${r.review_rep_num }"> 번호.
								${r.review_rep_num }. ID: ${r.id } 작성일: ${r.date }
								</tr>
								<tr>
									<td>${r.content }</td>
								</tr>

							</span>

							<c:if test="${r.id == sessionScope.loginId }">

								<tr>
									<td><input type="button" value="수정"
										onclick="redit(${r.review_rep_num }, '${r.content }')">
										<input type="button" value="삭제"
										onclick="rdel(${r.review_rep_num }, ${vo.review_num })">
									</td>
								</tr>
							</c:if>
							<br />
					</table>
				</c:forEach></td>
		</table>


		</table>

		<div style="text-align: right; padding: 30px 40px 0px 0px;">

			<table border="1">
				<tr>
					<th colspan="3"><input type="text" id="rep_${vo.review_num }"
						style="width: 840px; margin: 30px 30px 30px 30px;"
						placeholder="댓글을 입력해주세요">
						<div style="text-align: right;">
							<input type="button" value="댓글작성"
								onclick="addrep(${vo.review_num })"
								style="margin: 0px 20px 20px 0px;">
						</div></th>
				</tr>
			</table>

		</div>


		<div id="hidden">
			<form style="display: none" id="edit_form">
				<input type="hidden" id="edit_num" readonly><br /> 수정할 내용을
				입력하세요<input type="text" id="edit_content"><br /> <input
					type="button" value="수정완료" onclick="rep_edit()"> <input
					type="button" value="취소" onclick="cancel()"><br />
			</form>
		</div>
	</div>
	<!-- 디테일 close -->
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
								<li>경기도 분당구 성남시 코스타 6층</li>
								<li>Tel : 5555-5555</li>
								<li>(평일 09:00 ~ 18:00)</li>
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