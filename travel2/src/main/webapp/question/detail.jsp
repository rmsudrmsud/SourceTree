<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<meta charset="UTF-8">
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
	href="${pageContext.request.contextPath }/Resourcescss/font-awesome.min.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">

const del = () => {
	location.href = "${pageContext.request.contextPath }/question/del.do?question_num=${vo.question_num }";
	
}

const mkDiv = (obj) => {
	let rDiv = document.createElement("div");
	rDiv.setAttribute("id", "r_"+obj.question_num);
	let html = "<span id='content_'"+obj.question_rep_num+">";
	html += obj.question_rep_num+". "+obj.content+"(id:"+obj.id+")</span>";
	let id = obj.id;
	let loginId = '${sessionScope.loginId}';
	if(id==loginId){
		html += "<input type='button' value='??????' onclick=redit("+obj.question_rep_num+",'"+obj.content+"')>";
		html += "<input type='button' value='??????' onclick=rdel("+obj.question_rep_num+")>";
	}
	html += "<br/>";
	rDiv.innerHTML = html;
	return rDiv;
}

const addrep = (question_num) => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
// 		alert(xhttp.responseText);
		let arr = JSON.parse(xhttp.responseText);//ajax ????????? ????????? ???????????? ?????????(?????????????????????)
// 		let div = document.getElementById("res_"+question_num);	//res_?????? question??? vo???????????? question_num??????
		//???????????? question_num??? ????????? ?????? ?????? ?????? ajax ??????.
		let div = document.getElementById("res_"+question_num);
		div.innerHTML = "";
		let html = "";
		for(let obj of arr){
// 			html += obj.question_rep_num+". "+obj.content+
// 			  "(id:"+obj.id+")<br/>";
			  let dd = mkDiv(obj);
			  div.appendChild(dd);  
		}
// 		div.innerHTML = html;
// ?????? ????????? ?????? for?????? ????????? ?????? ??????????????? ???????????? ??? ?????????. ????????? ?????? let html??? ""????????? 
	}
	
	let rep = document.getElementById("rep_"+question_num);
	let param = "question_num="+question_num;//????????? ?????? ????????? ???????????? ???????????? 
	param += "&id=${sessionScope.loginId}";
	param += "&content="+rep.value;
	rep.value="";
	xhttp.open("post", "${pageContext.request.contextPath }/question_rep/add.do");
	
	xhttp.setRequestHeader("Content-type", 
	"application/x-www-form-urlencoded");
	xhttp.send(param);
}

const redit = (question_rep_num, content) => {
	let editForm = document.getElementById("edit_form");
	let rDiv = document.getElementById("r_"+question_rep_num);
	rDiv.appendChild(editForm);
	editForm.style.display='';
	let editNum = document.getElementById("edit_num");
	editNum.value = question_rep_num;
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
	let param = "question_rep_num=" + editNum.value;
	param += "&content=" + editContent.value;
	
	const xhttp = new XMLHttpRequest();	
	xhttp.onload = () => {
	  //?????? ????????? ????????? ?????? ?????? ??????
	 
	  let obj = JSON.parse(xhttp.responseText);
	  let span = document.getElementById("content_"+obj.question_rep_num);
	  let html = "";
	  
	  html += obj.question_rep_num+". "+obj.content+"(id:"+obj.id+")";
	 
	  span.innerHTML = html;
// 	  alert(html);
	  editNum.value = "";
	  editContent.value = ""; 
	 
	  cancel(); 
	  
	}
	
	xhttp.open("post", "${pageContext.request.contextPath }/question_rep/edit.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	xhttp.send(param);
}

const rdel = (question_rep_num, question_num) => {
// 	alert(question_rep_num);
// 	let repsDiv = document.getElementById("res_"+question_num);
	//?????? ?????? ????????????
// 	alert(question_rep_num);
	let repsDiv = document.getElementById("res_"+question_num);
	let rDiv = document.getElementById("r_"+question_rep_num);
	repsDiv.removeChild(rDiv);
	const xhttp = new XMLHttpRequest();
	xhttp.open("post", "${pageContext.request.contextPath }/question_rep/del.do");
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
// 	xhttp.send("question_rep_num="+question_rep_num);
// ????????? ???????????? ??????. ???????????? ?????????..
	xhttp.send("question_rep_num="+question_rep_num+"&question_num="+question_num);
}



</script>
</head>
<body>

<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-4 hidden-sm col-sm-12">
					<div class="call-info">
						<a href="/travel/index.jsp"><img
							src="${pageContext.request.contextPath }/Resources/images/finallogo.png"
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
									<li class="active"><a href="/travel/index.jsp"
										title="Home">Home</a></li>
									<li><a
										href="${pageContext.request.contextPath }/cityinfo/getall.do"
										title="About us">?????? ?????? </a></li>
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
										title="Testimonials">?????????????????? </a>
									<li><a
										href="${pageContext.request.contextPath }/question/listAll.do"
										title="Contact Us">??????????????? </a></li>
									<li><a
										href="${pageContext.request.contextPath }/contact.jsp"
										title="Contact Us">???????????? </a></li>
									<%-- <li><a
										href="${pageContext.request.contextPath }/cityinfo/add.do">??????????????????</a></li> --%>
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
												placeholder="????????????..." aria-label="Search">
										</form></li>
									<li><a
										href="${pageContext.request.contextPath }/cityinfo/getall.do"><strong>??????</strong>
									</a></li> --%>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


<div class="questionlistall" style="margin-left: 1135px; margin-bottom:10px;">
		<input class="btn btn-light" type="button" value="?????? ??????"
			onclick="location.href='${pageContext.request.contextPath }/question/listAll.do'"
			style="color: black; font-family: sans-serif;">
	</div>


	<div class="question" style="width: 1000px; margin: 0 auto;">
		<div class="questioninfo"
			style="display: flex; border: 2px solid #666; margin-bottom: 10px;">
			<div class="questionimg"
				style="width: 600px; height: 375px; overflow: hidden;">
				<img src="${vo.img_path }" style="width: 100%; height: 100%;">
			</div>
			<div class="questioncont"
				style="width: 100%; margin-left: 20px; padding-top: 10px;">
				<form action="${pageContext.request.contextPath }/question/edit.do"
					method="post" name="f" enctype="multipart/form-data" 
					style="display: flex; flex-direction: column-reverse; justify-content: flex-start;">
					<table>
						<tr style="line-height: 2;">
							<th style="width: 90px;">?????????&nbsp;:&nbsp;</th>
							<td>${vo.id }</td>
						</tr>
						<tr style="line-height: 2;">
							<th style="width: 90px;">????????????&nbsp;:&nbsp;</th>
							<td><input style="width:500px;"type="text" name="title" value="${vo.title }"></td>
						</tr>
						<tr style="line-height: 2;">
							<th style="width: 90px;">????????????&nbsp;:&nbsp;</th>
							<td style="width: 90px;"><textarea style="width: 500px; margin-top:10px;"name="content" rows="6">${vo.content }</textarea></td>
						</tr>
						<tr style="line-height: 2;">
							<th style="width: 90px; margin-bottom:10px">??????&nbsp;:&nbsp;</th>
							<td style="margin-bottom:10px; margin-top:10px"><input type="file" name="file" ${str }></td>
						</tr>
						<tr style="line-height: 2; margin-top:10px;">
							<th style="width: 90px;">?????????&nbsp;:&nbsp;</th>
							<td>${vo.wdate }</td>
						</tr>
						<c:if test="${sessionScope.loginId == vo.id }">
							<div class="tastyedit" style="margin-top:40px; margin-bottom:60px">
								<input class="btn btn-secondary" type="submit" value="??????" style="color:black; font-family: sans-serif; margin-bottom:10px;"> 
								<input class="btn btn-secondary" type="button"value="??????" onclick="del()" style="color:black; font-family: sans-serif; margin-bottom:10px;">
							</div>
						</c:if>
						
						
						
					</table>
					


					<input type="hidden" name="img_path" value="${vo.img_path }">
					<input type="hidden" name="question_num" value="${vo.question_num }">
					
				</form>
				<br/>
				<br/>
				<br/>
									<table border="0">
<tr><th>????????????&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
<%-- ????????? ${vo.num }??? ?????????????????? ????????? ?????????. --%>
<td><input type="text" id="rep_${vo.question_num }">
<input class="btn btn-dark" type="button" value="??????" onclick="addrep(${vo.question_num })" style=margin-left:100px;></td></tr>
<tr><th>????????????&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
<td id="res_${vo.question_num }">

<c:forEach var="r" items="${vo.reps }">
<div id="r_${r.question_rep_num }">
	<span id="content_${r.question_rep_num }">
	${r.question_rep_num }. ${r.content }(?????????:${r.id })
	</span>
	<c:if test="${r.id == sessionScope.loginId }">
		<input type="button" value="??????" onclick="redit(${r.question_rep_num }, '${r.content }')">
		<input type="button" value="??????" onclick="rdel(${r.question_rep_num }, ${vo.question_num })">
	</c:if>
	<br/>
</div>
<br/>
</c:forEach>
</td></tr>
</table>
				
			</div>
		
		
		</div>
		

	
	</div>



<div id="hidden">
<form style="display:none" id="edit_form">
num:<input type="text" id="edit_num" readonly><br/>
content:<input type="text" id="edit_content"><br/>
<input type="button" value="????????????" onclick="rep_edit()">
<input type="button" value="??????" onclick="cancel()"><br/>
</form>
</div>



<div class="footer">
		<div class="container">
			<div class="row">
				<!-- footer-about-start -->
				<div class=" col-lg-3 col-md-3 col-sm-3 col-xs-12">
					<div class="footer-widget">
						<h3 class="footer-title ">?????????????????????...</h3>
						<p>????????????????????? ?????? ?????? ????????? ???????????? ???????????? ???????????? ??????????????????.</p>
						
					</div>
				</div>
				<!-- footer-about-close -->
				<!-- footer-location-start -->
				<div class=" col-lg-3 col-md-3 col-sm-3 col-xs-12">
					<div class="footer-widget">
						<h3 class="footer-title">?????????</h3>
						<ul class="arrow arrow-chevron-circle-right">
							<li><a href="#">?????? ??????</a></li>
							<li><a href="#">??????????????????</a></li>
							<li><a href="#">???????????????</a></li>
							<li><a href="#">????????????</a></li>
							
						</ul>
					</div>
				</div>
				<!-- footer-location-close -->
				<!-- footer-contact-start -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 ">
					<div class="footer-widget">
						<h3 class="footer-title">(???)??????????????????</h3>
						<div class="contact-info">
							<ul>
								<li>????????? ????????? ????????? ????????? 6??? </li>
								<li>Tel : 5555-5555</li> <li>(?????? 09:00 ~ 18:00)</li>
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
					(???)?????????????????? <i class="fa fa-love"></i>
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