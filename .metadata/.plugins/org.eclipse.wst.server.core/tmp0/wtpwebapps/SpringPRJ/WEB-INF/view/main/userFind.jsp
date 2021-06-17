<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = (String) session.getAttribute("userId");
	String user_Rights = (String) session.getAttribute("user_Rights");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>아이디/비밀번호 찾기</title>
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">

<link rel="stylesheet" href="/css/linearicons.css">
<link rel="stylesheet" href="/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/magnific-popup.css">
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/nice-select.css">
<link rel="stylesheet" href="/css/animate.min.css">
<link rel="stylesheet" href="/css/owl.carousel.css">
<link rel="stylesheet" href="/css/main.css">
<!-- Custom styles for this template-->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/css/reg_css.css" rel="stylesheet">
<link rel="stylesheet" href="style.css">
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
	<section class="relative about-banner5">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12"></div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start contact-page Area -->
	<section class="contact-page-area section-gap">

		<div class="container">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-2"></div>
						<div class="col-lg-8">
							<div class="p-5">
								<div class="text-left">
									<div class="title_text">아이디 찾기</div>
								</div>
								<div class="text-left"></div>
								<form class="user" method="post" action="/findID.do"
									onsubmit='return checkIdFind()'>
									<div class="text_left inner_text">성명</div>
									<div class="form-group">
										<input type="text" class="form_control form_control_user"
											name="IdUserName" maxlength="20">
									</div>

									<div class="text_left inner_text">생년월일</div>
									<div class="form-group">
										<input type="date" class="form_control form_control_user"
											name="IdUserDate" maxlength="20">
									</div>


									<div class="text_left inner_text">이메일</div>
									<div class="form-group">
										<input type="email" class="form_control form_control_user"
											name="IdUserEmail">
									</div>

									<hr>
									
									<div style="margin-left: 75%;">
										<input type="submit" value="아이디찾기→"
											class="genric-btn primary-border circle arrow">
									</div>
								</form>
							</div>

							<hr>

							<div class="p-5">
								<div class="text-left">
									<div class="title_text">비밀번호 찾기</div>
								</div>
								<div class="text-left">
									<div class="sub_title_text"></div>
								</div>
								<form class="user" method="post" action="/findPW.do"
									onsubmit='return checkPwFind()'>
									<div class="text_left inner_text">성명</div>
									<div class="form-group">
										<input type="text" class="form_control form_control_user"
											name="PwUserName" maxlength="20">
									</div>

									<div class="text_left inner_text">생년월일</div>
									<div class="form-group">
										<input type="date" class="form_control form_control_user"
											name="PwUserDate" maxlength="20">

									</div>

									<div class="text_left inner_text">ID</div>
									<div class="form-group">
										<input type="text" class="form_control form_control_user"
											name="PwUserId" placeholder="입력하세요." maxlength="20">
									</div>
									<div class="text_left inner_text">이메일</div>
									<div class="form-group">
										<input type="email" class="form_control form_control_user"
											name="PwUserEmail">
									</div>

									<hr>
									
									<div style="margin-left: 75%;">
										<input type="submit" value="비밀번호찾기→"
											class="genric-btn primary-border circle arrow">
									</div>
								</form>
							</div>
						</div>
						<div class="col-lg-2"></div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- End contact-page Area -->

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

	<script type="text/javascript">
		function checkIdFind() {
			if ($("input[name=IdUserName]").val() == "") {
				alert("이름을 입력해 주세요.");
				$("input[name=IdUserName]").focus();
				return false;
			} else if ($("input[name=IdUserDate]").val() == "") {
				alert("생년월일을 입력해 주세요.");
				$("input[name=IdUserDate]").focus();
				return false;
			} else if ($("input[name=IdUserEmail]").val() == "") {
				alert("이메일을 입력해 주세요.");
				$("input[name=IdUserEmail]").focus();
				return false;
			} else {
				return true;
			}
		}

		function checkPwFind() {
			if ($("input[name=PwUserName]").val() == "") {
				alert("이름을 입력해 주세요.");
				$("input[name=PwUserName]").focus();
				return false;
			} else if ($("input[name=PwUserDate]").val() == "") { 
				alert("생년월일을 입력해 주세요.");
				$("input[name=PwUserDate]").focus();
				return false;
			} else if ($("input[name=PwUserId]").val() == "") {
				alert("아이디를 입력해 주세요.");
				$("input[name=PwUserId]").focus();
				return false;
			} else if ($("input[name=PwUserEmail]").val() == "") {
				alert("이메일을 입력해 주세요.");
				$("input[name=PwUserEmail]").focus();
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>