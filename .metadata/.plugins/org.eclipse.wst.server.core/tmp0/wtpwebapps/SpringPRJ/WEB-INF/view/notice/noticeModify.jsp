<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="poly.dto.NoticeDTO"%>
<%
	String userId = (String) session.getAttribute("userId");
	String user_Rights = (String) session.getAttribute("user_Rights");
	NoticeDTO nDTO = (NoticeDTO) request.getAttribute("nDTO");
	String seq = (String) request.getAttribute("seq");
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<!-- 썸머노트  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/suno/summernote-bs4.min.js"></script>
<script src="/suno/summernote-bs4.js"></script>
<script src="/suno/lang/summernote-ko-KR.js"></script>

<script>
	// 필수값 Check
	function ckc() {
		var title = regform.title;
		var content = regform.content;

		if (title.value == '' || document.regform.title.value == '') {
			window.alert("제목을 입력해주세요");
			document.regform.title.focus();
			document.getElementById('title').select();
			return false;
		} else if (content.value == '' || document.regform.content.value == '') {
			window.alert("내용을 입력해주세요");
			document.regform.content.focus();
			document.getElementById('content').select();
			return false;
		}

		if (confirm("수정하시겠습니까?") == true) {
			return true;
		} else {
			return false;
		}

	}
</script>

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
<title>커뮤니티 게시판</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/css/modern-business.css" rel="stylesheet">
<!--공통 css-->
<link href="/css/user-common.css" rel="stylesheet">
<!--추가 css-->
<link href="/css/user-notice.css" rel="stylesheet">
<link href="/css/mngrNotice.css" rel="stylesheet">
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
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/css/mypage.css" rel="stylesheet">
<link rel="stylesheet" href="/suno/summernote-bs4.css">
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
	<section class="about-banner4 relative" style="margin-top: -57px;">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white"
						style="font-weight: lighter; font-size: xx-large";>공지사항</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<!-- Start hot-deal Area -->
	<div class="container">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10" style="margin-top: 50px;">
				<div>
					<div class="help_cont"></div>
				</div>
				<hr class="board_hr">
				
				<form method="post" id="regform" action="/notice/noticeModifyProc.do"
					name="regform" onsubmit="return ckc();">
					<div class="board_box">
						<div class="board_title_box">
							<div class="board_title">제목</div>
							<input type="text" class="board_input_text form_control"
								name="title" id="title" placeholder="제목을 입력해주세요" value='<%=nDTO.getTitle()%>'>
						</div>
						<input type="hidden" name="seq" value="<%=seq%>">

						<hr class="board_hr">

						<div class="board_cont_box">
							<div class="board_title" id="smarteditor">내용</div>
							<textarea id="summernote" name="content"></textarea>
							<script>
								document.querySelector('#summernote').value = '<%=nDTO.getContent()%>';
								$(document)
										.ready(
												function() {
													$('#summernote')
															.summernote(
																	{
																		height : 500,
																		lang : 'ko-KR',
																		fontNames : [
																				'맑은고딕',
																				'Arial',
																				'Arial Black',
																				'Comic Sans MS',
																				'Courier New', ],
																		fontNamesIgnoreCheck : [ '맑은고딕' ],
																		placeholder : '내용을 입력해주세요.',
																	});
												});
							</script>
						</div>


						<hr class="board_hr">
						<div class="board_btn_box">
							<div class="board_btn" style="padding-bottom: 30px;">
								<input type="button"
									onclick="location.href='/notice/notice.do?pgNum=1'"
									class="genric-btn primary-border" value="취소하기"> <input
									type="submit" id="reg_btn" class="genric-btn primary-border"
									value="수정하기">
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
	<!-- End Area -->

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
	<script src="/js/main.js"></script>
	<script src="/SE2/js/HuskyEZCreator.js"></script>
	<script src="/js/popper.min.js"></script>

</body>
</html>