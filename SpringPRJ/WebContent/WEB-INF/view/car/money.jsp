<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>국가보조금</title>

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

<!-- 셀렉박스 2단 -->
<script>
var hobby0 = new Array("-선택-","");
var hobby1 = new Array("서울특별시");
var hobby2 = new Array("김포시","수원시","의정부시","고양시","부천시","파주시");
var hobby3 = new Array("인천광역시");
var hobby4 = new Array("없음");
var hobby5 = new Array("없음");
var hobby6 = new Array("없음");
var hobby4 = new Array("없음");
var hobby5 = new Array("없음");
var hobby6 = new Array("없음");

function hobbychange(item){
    var temp, i=0, j=0;
    var ccount, cselect;

    temp = document.signform.hobby;

    for (i=(temp.options.length-1) ; i>0 ; i--){ temp.options[i] = null; }
    eval('ccount = hobby' + item + '.length');
    for (j=0 ; j<ccount ; j++) {
        eval('cselect = hobby' + item + '[' + j + '];');
        temp.options[j]= new Option(cselect,cselect); 
    }
    temp.options[0].selected=true;
    return true;
}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
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
	%><!-- #header -->


	<!-- start banner Area -->
	<section class="about-banner2 relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white"
						style="font-weight: lighter; font-size: xx-large;">내 전기차 보조금
					</h1>

				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->


	<!-- Start price Area -->
	<section class="price-area section-gap">
		<div class="container">
			<div class="row">

				<div class="col-lg-3"></div>

				<div class="col-lg-6">
					<h3 style="text-align: center">전기차 보조금 알아보기</h3>
					<hr>
					<div class="container">
						<form name=signform action="/car/moneyfound.do">

							<br>
							<div>
								<div class="row">
									<div class="col-md-2">시도</div>
									<div class="col-md-3">지역구분</div>
									<div class="col-md-7">차종</div>
								</div>

								<div class="row">
									<div class="col-md-2 lg-content-st">
										<select name=bighobby id="c1"
											onChange=javascript:hobbychange(document.signform.bighobby.options.selectedIndex);>
											<option selected value="">-선택-</option>
											<option value=서울>서울</option>
											<option value=경기>경기</option>
											<option value=인천>인천</option>
											<option value=부산>부산</option>
											<option value=경북>경북</option>
											<option value=경남>경남</option>
											<option value=전북>전북</option>
											<option value=전남>전남</option>
											<option value=기타>기타</option>
										</select>
									</div>

									<div class="col-md-2 lg-content-st">
										<select name=hobby size=1 id="c2">
											<option selected value="">-선택-</option>
											<option value="c2"></option>
										</select>
									</div>
									<div class="col-md-2 lg-content-st">
										<select name=car id="c3">
											<option selected value="">-선택-</option>
											<option value="초소형">초소형</option>
											<option value="승용차">승용차</option>
											<option value="화물차">화물차</option>
										</select>
									</div>
									<div class="col-md-4 lg-content-st">
										<input type="submit" class="genric-btn primary small"
											value="검색">
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3"></div>
		<br>
		<hr>

		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="section-top-border">
						<h3 class="mb-30">보조금 지원 대상</h3>
						<div class="row">
							<div class="col-lg-12">
								<blockquote class="generic-blockquote">
									>중앙행정기관을 제외한 개인, 법인, 공공기관, 지방자치단체, 지방공기업 등 <br> <br>
									>국고보조금 외 지방보조금을 추가로 지원하는 지방자치단체는 관할 자치단체 내 거주 등 자격조건 부여 가능

								</blockquote>
							</div>
						</div>
					</div>
					<div class="section-top-border">
						<h3 class="mb-30">보조금 지원 차량</h3>
						<div class="row">
							<div class="col-lg-12">
								<blockquote class="generic-blockquote">
									>아래의 사항을 충족하는 전기자동차 <br> <br> - 「자동차관리법」, 「대기환경보전법」,
									「소음·진동관리법」 등 관계법령에 따라 자동차와 관련된 각종 인증을 모두 완료한 차량 <br> <br>
									- 「전기자동차 보급대상 평가에 관한 규정」에 따른 전기차의 평가항목 및 기준에 적합한 차량보조금 지원 차량
								</blockquote>
							</div>
						</div>
					</div>


				</div>
				<div class="col-lg-2"></div>
			</div>
		</div>
	</section>

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