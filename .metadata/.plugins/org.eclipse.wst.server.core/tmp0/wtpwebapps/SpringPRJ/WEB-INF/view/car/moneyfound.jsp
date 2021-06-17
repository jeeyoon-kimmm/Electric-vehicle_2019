<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="poly.dto.ev_CarDTO"%>

<%
	List<ev_CarDTO> cList = (List<ev_CarDTO>) request.getAttribute("cList");
%>
<%
	String userId = (String) session.getAttribute("userId");
	String user_Rights = (String) session.getAttribute("user_Rights");
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>국가보조금확인</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
        CSS
        ============================================= -->
<link rel="stylesheet" href="/css/linearicons.css">
<link rel="stylesheet" href="/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/magnific-popup.css">
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/nice-select.css">
<link rel="stylesheet" href="/css/animate.min.css">
<link rel="stylesheet" href="/css/owl.carousel.css">
<link rel="stylesheet" href="/css/main.css">
<style>
.lg-content-st {
	border-bottom: 1px solid #dbdbdb;
	padding: 10px 10px;
	line-height: 16px;
	text-align: center;
	font-size: 0.81rem;
	font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto,
      Helvetica Neue, Arial, sans-serif;
    
}
.table-title{
	margin-top: 10px;
	border-top: 2px solid black;
	border-bottom: 1px solid #dbdbdb;
	padding: 10px 10px;
	line-height: 16px;
	text-align: center;
	font-weight: bold;
	font-size: 0.81rem;
	font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto,
      Helvetica Neue, Arial, sans-serif;
	color: #212529;
}
</style>
</head>
<body>
	<%
		if (userId == null) {
	%>
	<%@include file="/WEB-INF/view/include/TopbarLogout.jsp"%>
	<%
		} else if (user_Rights.equals("1")) {
	%>
	<%@include file="/WEB-INF/view/include/TopbarLoginAdmin.jsp"%>
	<%
		} else {
	%>
	<%@include file="/WEB-INF/view/include/TopbarLoginUser.jsp"%>
	<%
		}
	%>
	<!-- #header -->


	<!-- start banner Area -->
	<section class="about-banner2 relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white"
						style="font-weight: lighter; font-size: xx-large";>내 전기차 보조금
						확인</h1>

				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->


	<!-- Start price Area -->
	<section class="price-area section-gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="rightContent" id="rightContent">
						<div>
							<div>
								<div>
									<div class="container">
										<div class="row">
											<div class="col-md-2 table-title">#</div>
											<div class="col-md-2 table-title">차종</div>
											<div class="col-md-2 table-title">자동차 회사명</div>
											<div class="col-md-2 table-title">자동차 모델명</div>
											<div class="col-md-2 table-title">국가 보조금</div>
											<div class="col-md-2 table-title">시비 보조금</div>
										</div>

										<%
											int i = 0;
										%>
										<%
											for (ev_CarDTO cDTO : cList) {
										%>
										<%
											i++;
										%>


										<div class="row">
											<div class="col-md-2 lg-content-st"><%=cDTO.getCar_no() %></div> 
											<div class="col-md-2 lg-content-st"><%=cDTO.getCar_type() %></div>
											<div class="col-md-2 lg-content-st"><%=cDTO.getCar_company() %></div>
											<div class="col-md-2 lg-content-st"><%=cDTO.getCar_name() %></div>
											<div class="col-md-2 lg-content-st"><%=cDTO.getMon_nation() %></div>
											<div class="col-md-2 lg-content-st"><%=cDTO.getMon_city() %></div>
										</div>
										<%
											}
										%>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</section>
	<!-- End price Area -->

	<script src="/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/vendor/bootstrap.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="/js/jquery-ui.js"></script>
	<script src="/js/easing.min.js"></script>
	<script src="/js/hoverIntent.js"></script>
	<script src="/js/superfish.min.js"></script>
	<script src="/js/jquery.ajaxchimp.min.js"></script>
	<script src="/js/jquery.magnific-popup.min.js"></script>
	<script src="/js/jquery.nice-select.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/mail-script.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>