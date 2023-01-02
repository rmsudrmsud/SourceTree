<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동행게시판 글 상세페이지</title>
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


<script>


const del = () => {
	location.href = "${pageContext.request.contextPath }/together/del.do?travel_num=${vo.travel_num }&city_num=${sessionScope.city_num}";
	
}

const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.travel_num);
	let html = "<span id='content_'"+obj.travel_rep_num+">";
	
	  html += obj.travel_rep_num+". "+"[ID : "+obj.id+"]  "+obj.content+"[작성일 : "+obj.date+"]  </span>";
	let id = obj.id;
    
	let loginId = '${sessionScope.loginId }';
	if(id==loginId){
		html += "<div style='text-align:right'><input type='button' class='btn btn-light' value='수정' onclick=redit("+obj.travel_rep_num+",'"+obj.content+"')>";
		html += "<input type='button'  class='btn btn-light' value='삭제' onclick=rdel("+obj.travel_rep_num+")></div>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	
	return rDiv;
}


const addrep = (travel_num) => {
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	
	  let arr = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("res_"+travel_num);
	  div.innerHTML = "";
	  let html = "";
	  for(let obj of arr){
       
           let dd = mkDiv(obj);
		   div.appendChild(dd);
          
	  }
	  
	}

	let rep = document.getElementById("rep_"+travel_num);
	let param = "travel_num="+travel_num;
	param += "&id=${sessionScope.loginId}";
	param += "&date="+rep.value;
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/togetherRep/add.do");

	//request 헤더에 content type을 application으로 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	// 4. 요청보냄
	xhttp.send(param);
}


 const redit = (travel_rep_num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+travel_rep_num);
	rDiv.appendChild(editForm);
	editForm.style.display="";
	let editNum = document.getElementById("edit_num");
	editNum.value = travel_rep_num;
	let editContent = document.getElementById("edit_content");
	editContent.value = content;
}


const cancel = () => {
	let hiddenDiv = document.getElementById("hidden");
	let editForm = document.getElementById("edit_form");
	hiddenDiv.appendChild(editForm);
	editForm.style.display='none';
}


const rep_edit = () => {
	let editNum = document.getElementById("edit_num");
	
	let editContent = document.getElementById("edit_content");
	let param = "travel_rep_num=" + editNum.value;
	
	param += "&content=" + editContent.value;
	
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  //받은 응답을 가지고 처리 코드 작성
  
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.travel_rep_num);
	  let html = "";
	  
	  html += obj.travel_rep_num+". "+"[작성자 : "+obj.id+"]  "+obj.content+"[작성일 : "+obj.wdate+"]  ";
	 
	  span.innerHTML = html;
	  
	  editNum.value = "";
	  editContent.value = ""; 
	  
	 
	  cancel(); 
	  
	}
	
	xhttp.open("post", "${pageContext.request.contextPath }/togetherRep/edit.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send(param);
}

const rdel = (travel_rep_num, travel_num) => {
	let repsDiv = document.getElementById("res_"+travel_num);
	let rDiv = document.getElementById("r_"+travel_rep_num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	xhttp.open("post", "${pageContext.request.contextPath }/togetherRep/del.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send("travel_rep_num="+travel_rep_num+"&travel_num="+travel_num);
}
 
</script>

</head>
<body>

	<div class="top-bar" style="background: #fff">
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
									<%-- <li><form class="col-12 mb-3 mb-lg-0 me-lg-3 role="search">
											<input type="search"
												class="form-control form-control-dark text-bg-white"
												placeholder="도시검색..." aria-label="Search">
										</form></li>
									<li><a
										href="${pageContext.request.contextPath }/cityinfo/getall.do"><strong>검색</strong>
									</a></li> --%>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- header-section close -->




	<c:if test="${sessionScope.loginId != vo.id }">
		<c:set var="str">readonly</c:set>
	</c:if>

	<div class="placelistall"
		style="margin-left: 1135px; margin-bottom: 10px;">
		<input type="button" value="글 목록" class="btn btn-light"
			onclick="location.href='${pageContext.request.contextPath }/together/getall.do?city_num=${sessionScope.city_num}'"
			style="color: black; font-family: sans-serif;">
	</div>

	<div class="place"
		style="width: 1000px; margin: 0 auto; margin-bottom: 100px;">
		<div class="placeinfo"
			style="display: flex; border: 1px solid #666; margin-bottom: 10px;">



			<div class="placecont" style="width: 100%; padding-top: 10px;">

				<form
					action="${pageContext.request.contextPath }/together/edit.do?city_num=${sessionScope.city_num}"
					method="post" name="f"
					style="display: flex; flex-direction: column-reverse; justify-content: flex-end;">

					<table style="margin-left: 20px; margin-bottom: 50px;">

						<tr>
							<th style="width: 200px;">글번호</th>
							<td colspan="2"><input type="text" name="travel_num"
								value="${vo.travel_num }"
								style="width: 700px; text-align: center; margin-top: 10px;"
								readonly></td>
						</tr>

						<tr>
							<th style="width: 200px;">제목</th>
							<td colspan="2"><input type="text" name="title"
								value="${vo.title }"
								style="width: 700px; text-align: center; margin-top: 10px;"
								${str }></td>
						</tr>

						<tr>
							<th style="width: 200px;">작성자</th>
							<td colspan="2"><input type="text" name="id"
								value="${sessionScope.loginId}"
								style="width: 700px; text-align: center; margin-top: 10px;"
								readonly></td>
						</tr>



						<tr>
							<th style="width: 200px;">내용</th>
							<td colspan="2"><input type="text" name="content"
								value="${vo.content}"
								style="width: 700px; text-align: center; margin-top: 10px;"
								${str }></td>
						</tr>


						<tr>
							<th style="width: 200px;">작성일</th>
							<td colspan="2"><input type="text" name="wdate"
								value="${vo.wdate}"
								style="width: 700px; text-align: center; margin-top: 10px;"
								readonly></td>
						</tr>

						<tr>
							<th style="width: 200px;">인원수</th>
							<td colspan="2"><input type="text" name="ppl"
								value="${vo.ppl }"
								style="width: 700px; text-align: center; margin-top: 10px;"
								readonly></td>
						</tr>




						<c:if test="${sessionScope.loginId == vo.id }">
							<div class="placeedit" style="margin-top: 10px;">
								<input type="submit" value="수정" class="btn btn-light"
									style="color: black; font-family: sans-serif; margin-bottom: 10px;">
								<input type="button" value="삭제" class="btn btn-light"
									onclick="del()"
									style="color: black; font-family: sans-serif; margin-bottom: 10px;">
							</div>
						</c:if>
					</table>
				</form>




				<!-- 댓글 시작 -->

				<table class="table table-striped" style="width: 1000px;">

					<tr>
						<th colspan="3" width="700px;" style="text-align: center;">댓글작성</th>
					</tr>


					<tr>
						<th colspan="3"><input type="text" id="rep_${vo.travel_num }"
							style="width: 800px;"> <input
							type="button" value="댓글작성" class="btn btn-light"
							onclick="addrep(${vo.travel_num })"></th>
					</tr>
					<tr>
						<th colspan="3" width="700px;" style="text-align: center;">댓글목록</th>
					</tr>
					<tr>
						
						<td id="res_${vo.travel_num }"><c:forEach var="r" items="${vo.reps }">
								<div id="r_${r.travel_rep_num }">
									<span id="content_${r.travel_rep_num }">
										${r.travel_rep_num }.&nbsp; [작성자 : ${r.id }] ${r.content } [작성일 : ${vo.wdate }] </span>
										
										<div style="text-align:right">
									<c:if test="${r.id == sessionScope.loginId }">
										<input type="button" value="수정" class="btn btn-light"
											onclick="redit(${r.travel_rep_num }, '${r.content }')">
										<input type="button" value="삭제" class="btn btn-light"
											onclick="rdel(${r.travel_rep_num }, ${vo.travel_num })">
									</c:if>
									
									<br />
								</div>
								</div>
							</c:forEach>
						</td>
					</tr>

				</table>
			</div>
			<div id="hidden">
				<form style="display: none" id="edit_form">
				댓글 번호 : <input type="text" id="edit_num" readonly> 내용 :<input
						type="text" id="edit_content"><br /> <input type="button"
						class="btn btn-light" value="수정완료" onclick="rep_edit()"> <input
						type="button" class="btn btn-light" value="취소" onclick="cancel()"><br />
				</form>


			</div>



		</div>
	</div>
	<!-- contact form close -->

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
	<div class="tiny-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					Shared by <i class="fa fa-love"></i><a
						href="https://bootstrapthemes.co">BootstrapThemes</a>
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
</body>

</html>