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
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>충전소 위치</title>
<!-- 카카오 맵 JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf58b7faff4b572116a6381dc1d66a6d&libraries=services"></script>

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
<link rel="stylesheet" href="/css/kakao_map.css">
<!-- 셀렉박스 2단 -->
<script>
	function doChange1() {
		var val = $("#addr_1 option:selected").text();
		var targetE = document.getElementById('addr_2');
		removeAll(targetE);

		if (val == '서울') {
			addOption('강남구', targetE);
			addOption('강동구', targetE);
			addOption('강서구', targetE);
			addOption('강북구', targetE);
			addOption('종로구', targetE);
		} else if (val == '경상남도') {
			addOption('경상남도', targetE);
		} else if (val == '경상북도') {
			addOption('경상북도', targetE);
		} else if (val == '부산광역시') {
			addOption('부산', targetE);
		}
	}
	function addOption(value, e) {
		var o = new Option(value);
		try {
			e.add(o);
		} catch (ee) {
			e.add(o, null);
		}
	}

	function removeAll(e) {
		for (var i = 0, limit = e.options.length; i < limit - 1; ++i) {
			e.remove(1);
		}
	}
	function test() {
		var val1 = $("#addr_1 option:selected").text();
		var val2 = $("#addr_2 option:selected").text();//셀렉트 박스 선택된 글자 들고오기
		var geocoder = new kakao.maps.services.Geocoder();

		var callback = function(result, status) {
		    if (status === kakao.maps.services.Status.OK) {
		    	function setCenter() {
					var moveLatLon = new kakao.maps.LatLng(result.y, result.x);
					map.setCenter(moveLatLon);
				}
		    }
		};

		geocoder.addressSearch(val1+' '+val2, callback);
		

	}
</script>

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
	<section class="relative about-banner">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white"
						style="font-weight: lighter; font-size: xx-large";>주변 전기차 충전소
						위치</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start contact-page Area -->
	<section class="contact-page-area section-gap">
	
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div style="display: inline-block; padding-left: 400px; padding-bottom: 20px;">
						<select name=addr_1 id="addr_1" onChange="doChange1()">
							<option selected value="">--선택--</option>
							<option value="서울특별시">서울</option>
							<option value="경상남도">경상남도</option>
							<option value="경상북도">경상북도</option>
							<option value="부산광역시">부산광역시</option>
							<option value="인천광역시">인천광역시</option>
							<option value="강원도">강원도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="제주">제주</option>
							<option value="대구광역시">대구광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="충청남도">충청남도</option>
							<option value="충청북도">충청북도</option>
							<option value="경기도">경기도</option>
							<option value="울산광역시">울산광역시</option>
						</select>
					</div>
					<div style="display: inline-block;">
						<select name=hobby size=1 id="addr_2">
							<option value="default">-선택-</option>
						</select>
					</div>
					<div style="display: inline-block;">
						<input type="button" id="Search" class="genric-btn primary small"
							onclick="test()" value="검색">
					</div>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- Map -->
					<div id="map" style="width: 100%; height: 780px;"></div>
				</div>
			</div>
		</div>
	</section>
	<!-- End contact-page Area -->

	<script src="/js/popper.min.js"></script>
	<script src="/js/vendor/bootstrap.min.js"></script>
	<script src="/js/jquery-ui.js"></script>
	<script src="/js/easing.min.js"></script>
	<script src="/js/hoverIntent.js"></script>
	<script src="/js/superfish.min.js"></script>
	<script src="/js/jquery.ajaxchimp.min.js"></script>
	<script src="/js/jquery.magnific-popup.min.js"></script>
	<script src="/js/jquery.nice-select.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/mail-script.js"></script>
	<script src="/js/kakao_map.js"></script>

</body>
</html>