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
<title>로그인</title>

<!-- Custom fonts for this template-->
<link rel="icon" href="img/favicon.ico">
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<!-- <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet"> -->

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">

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
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-2"></div>
					<div class="col-lg-8">
						<!-- style="padding-left:10%;" -->
						<div class="inner_box">
							<div class="text-left">
								<div class="title_text"
									style="font-size: x-large; font-weight: normal;">Sign Up</div>
							</div>
							<br>
							<!-- =========================================================================================================================================================================== -->
							<form action="/userRegProc.do" class="user" method="POST"
								onsubmit="return check();">
								<div class="text_left inner_text" style="color: black;">
									이름</div>
								<div class="form_group">
									<input type="text" class="form_control form_control_user"
										id="InputName" name="userName" maxlength="20">
								</div>
								<!-- =========================================================================================================================================================================== -->
								<div class="text_left inner_text" style="color: black;">
									ID</div>
								<div class="text_left error_text">5~20자의 영문 소문자, 숫자와
									특수기호(_),(-)만 사용 가능합니다.</div>

								<div class="form_group">
									<input type="text" class="form_control form_control_user"
										id="user_id" name="user_id"
										placeholder="5~20자 영문 소문자, 숫자와 특수기호(_),(-)만 사용" maxlength="20">
								</div>
								<div>
									<input type="hidden" id="id_Check" value="0"> <input
										type="button" class="btn btn-primary btn-user btn-block"
										id="idck" value="중복확인"
										style="background-color: #2f3333; border-style: none;">
								</div>
								<br>
								<!-- =========================================================================================================================================================================== -->
								<div class="text_left inner_text" style="color: black;">
									비밀번호</div>
								<div class="text_left error_text">8~20자 영문 대 소문자, 숫자,
									특수문자를 사용하세요.</div>
								<div class="form_group">
									<input type="password" class="form_control form_control_user"
										id="InputPassword" name="userPassword"
										placeholder="8~20자 영문 대 소문자, 숫자, 특수문자 사용" maxlength="20">
									<input type="password" class="form_control form_control_user"
										id="RepeatPassword" name="userPassword2"
										placeholder="비밀번호 재확인" maxlength="20">
								</div>
								<!-- =========================================================================================================================================================================== -->
								<div class="text_left inner_text" style="color: black;">
									생년월일</div>
								<div class="form_group">
									<input type="date" class="form_control form_control_user"
										id="InputBirth" name="userDate" maxlength="20">
								</div>
								<!-- =========================================================================================================================================================================== -->
								<div class="text_left inner_text" style="color: black;">
									전화번호</div>
								<div class="form_group">
									<input type="tel" class="form_control form_control_user"
										id="InputTel" name="userTel" placeholder="010-0000-0000"
										maxlength="11">
								</div>
								<!-- =========================================================================================================================================================================== -->
								<div class="text_left inner_text" style="color: black;">
									이메일</div>
								<div class="form_group">
									<input type="email" class="form_control form_control_user"
										id="InputEmail" name="userEmail">
								</div>
								<!-- =========================================================================================================================================================================== -->
								<div class="text_left inner_text" style="color: black;">
									성별</div>
								<div class="form_group">
									<div class="custom-control custom-checkbox small"
										style="display: inline-block; margin-right: 1em;">
										<input type="radio" class="custom-control-input"
											name="userGen" id="gender_check1" value="남자" checked>
										<label class="custom-control-label" for="gender_check1">남자</label>
									</div>

									<div class="custom-control custom-checkbox small"
										style="display: inline-block; margin-right: 1em;">
										<input type="radio" class="custom-control-input"
											name="userGen" id="gender_check2" value="여자"> <label
											class="custom-control-label" for="gender_check2">여자</label>
									</div>
									<!-- =========================================================================================================================================================================== -->
								</div>
								<hr>
								<button id="sbm" type="submit"
									class="btn btn-user btn-el btn-block">가입하기</button>
							</form>
							<hr>
						</div>
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
	<script src="/js/RegCheck.js"></script>

	<!-- 	<script type="text/javascript">
		$('#sbm').click(function() {
			//function checkId() {
			if ($("input[name=userName]").val() == "") {
				alert("이름을 입력해 주세요.");
				$("input[name=userName]").focus();
				return false;
			} else if ($("input[name=userId]").val() == "") {
				alert("아이디를 입력해 주세요.");
				$("input[name=userId]").focus();
				return false;
			} else if ($("input[name=userPw]").val() == "") {
				alert("비밀번호를 입력해 주세요.");
				$("input[name=userPw]").focus();
				return false;
			} else if ($("input[name=userPw]").val() == "") {
				alert("비밀번호를 재입력해 주세요.");
				$("input[name=userPw]").focus();
				return false;
			} else if ($("input[name=userDate]").val() == "") {
				alert("생년월일을 입력해 주세요.");
				$("input[name=userDate]").focus();
				return false;
			} else if ($("input[name=userEmail]").val() == "") {
				alert("이메일을 입력해 주세요.");
				$("input[name=userEmail]").focus();
				return false;
			} else {
				return true;
			}
			//}
		});
	</script> -->
</body>
</html>