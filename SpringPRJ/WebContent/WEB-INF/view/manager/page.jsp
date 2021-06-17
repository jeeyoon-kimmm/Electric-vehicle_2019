<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="poly.dto.UserDTO"%>
<%
	String userId = (String) session.getAttribute("userId");
	String userName = (String) session.getAttribute("userName");
	String user_Rights = (String) session.getAttribute("user_Rights");
	UserDTO mDTO = (UserDTO) request.getAttribute("mDTO");
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
<title>관리자 페이지</title>
<!-- PLUGINS CSS STYLE -->
<link href="/mypage/plugins/jquery-ui/jquery-ui.min.css"
	rel="stylesheet">
<!-- Bootstrap -->
<link href="/mypage/plugins/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="/mypage/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Owl Carousel -->
<link href="/mypage/plugins/slick-carousel/slick/slick.css"
	rel="stylesheet">
<link href="/mypage/plugins/slick-carousel/slick/slick-theme.css"
	rel="stylesheet">
<!-- Fancy Box -->
<link href="/mypage/plugins/fancybox/jquery.fancybox.pack.css"
	rel="stylesheet">
<link href="/mypage/plugins/jquery-nice-select/css/nice-select.css"
	rel="stylesheet">
<link
	href="/mypage/plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css"
	rel="stylesheet">
<!-- CUSTOM CSS -->
<link href="/mypage/css/style2.css" rel="stylesheet">

<!-- FAVICON -->
<link href="/mypage/img/favicon.png" rel="shortcut icon">

<!-- Custom fonts for this template-->
<link rel="icon" href="img/favicon.ico">
<link href="/mypage/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
        CSS
        ============================================= -->
<link rel="stylesheet" href="/mypage/css/linearicons.css">
<link rel="stylesheet" href="/mypage/css/font-awesome.min.css">
<link rel="stylesheet" href="/mypage/css/bootstrap.css">
<link rel="stylesheet" href="/mypage/css/magnific-popup.css">
<link rel="stylesheet" href="/mypage/css/jquery-ui.css">
<link rel="stylesheet" href="/mypage/css/nice-select.css">
<link rel="stylesheet" href="/mypage/css/animate.min.css">
<link rel="stylesheet" href="/mypage/css/owl.carousel.css">
<link rel="stylesheet" href="/mypage/css/main.css">
<!-- Custom styles for this template-->
<link href="/mypage/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/mypage/css/reg_css.css" rel="stylesheet">
<link rel="stylesheet" href="/mypage/style.css">


<style>
body {
	background-image: url('/img/highway.jpg');
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
	<section class="relative about-banner6">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<section class="user-profile section">
						<div class="container">
							<div class="row">
								<div class="col-md-10 offset-md-1 col-lg-4 offset-lg-0">
									<div class="sidebar">

										<div class="widget user-dashboard-menu">
											<ul>
												<li><a href="/main/mypage.do"><i class="fa fa-user"></i>내
														정보</a></li>
												<hr>
												<li><a href="/manager/noticeList.do"><i class="fa fa-cog"></i>작성 공지사항 확인</a></li>
												<hr>
												<li><a href="/manager/boardList.do"><i class="fa fa-cog"></i>작성 게시물 확인</a></li>
												<hr>
												<li><a href="/manager/userManage.do"><i class="fa fa-power-off"></i>회원 관리</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
									<div class="widget personal-info">
										<h3 class="widget-header user" style="text-color: #848484;">내
											정보 수정</h3>

										<form method="post" action="/manager/pageProc.do">

											<!-- 이름 -->
											<div class="form-group">
												<label for="first-name">이름</label> <input type="text"
													class="form-control" id="first-name"
													placeholder="이름을 입력하세요." readonly name="userName"
													value="<%=userName%>">
											</div>

											<!-- 아이디 -->
											<div class="form-group">
												<label for="last-name">아이디</label> <input type="text"
													class="form-control" id="last-name"
													placeholder="아이디를 입력하세요." readonly name="userId" value="<%=userId%>">
											</div>

											<!-- 전화번호 -->
											<div class="form-group">
												<label for="last-name">전화번호</label> <input type="tel"
													class="form-control" id="last-name"
													placeholder="010-0000-0000" name="userTel" value="<%=mDTO.getUserTel()%>">
											</div>

											<!-- 이메일 -->
											<div class="form-group">
												<label for="current-email">이메일</label> <input type="email"
													class="form-control" id="current-email"
													placeholder="이메일을 입력하세요." name="userEmail" value="<%=mDTO.getUserEmail()%>">
											</div>

											<!-- Submit Button -->
											<div style="text-align: right">
												<input type="submit"
													class="genric-btn primary-border radius" value="수정">

											</div>
										</form>

										<form method="post" action="/manager/pageProc2.do">
											<!-- 새 비밀번호 -->
											<div class="form-group">
												<label for="new-password">새 비밀번호</label> <input
													type="password" class="form-control" id="new-password"
													name="userPassword">
											</div>
											<!-- 새 비밀번호 확인 -->
											<div class="form-group">
												<label for="confirm-password">새 비밀번호 확인</label> <input
													type="password" class="form-control" id="confirm-password"
													name="PasswordRepeat">
											</div>

											<!-- Submit Button -->
											<div style="text-align: right">
												<input type="submit"
													class="genric-btn primary-border radius" value="상세 수정">
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</section>

				</div>
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