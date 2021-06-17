<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="poly.dto.NoticeDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="poly.util.CmmUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String userId = (String) session.getAttribute("userId");
	String user_Rights = CmmUtil.nvl((String) session.getAttribute("user_Rights")); //권한
	NoticeDTO nDTO = (NoticeDTO) request.getAttribute("nDTO");
	int seq = Integer.parseInt((String) request.getAttribute("seq"));
	String pgNum = (String) request.getAttribute("pgNum"); //pgNum을 가져옴
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>공지사항</title>
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/css/modern-business.css" rel="stylesheet">
<!--공통 css-->
<link href="/css/user-common.css" rel="stylesheet">
<!--추가 css-->
<link href="/css/user-notice.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!-- CSS ============================================= -->
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

	<section class="about-banner4 relative" style="margin-top: -57px;">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white"
						style="font-weight: lighter; font-size: xx-large;">공지사항</h1>
				</div>
			</div>
		</div>
	</section>

	<div class="container">
		<h4 class="mt-4 mb-3"><%=nDTO.getTitle()%></h4>
		<div>
			<hr>
			<%
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(nDTO.getReg_dt());
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			%>
			<%=format1.format(date)%> | <small>작성자 : <%=nDTO.getReg_id()%></small>
			<hr>
			<div style="width: 100%; height: 350px;"><%=nDTO.getContent()%></div>
		</div>

		<div class="notice-btn">
			<hr>
			<a href="/notice/notice.do?pgNum=<%=pgNum%>"
				class="genric-btn primary-border medium">목록</a>

			<%
				if (user_Rights.equals("1")) {
			%>
			<a href="/notice/noticeModify.do?seq=<%=seq%>"
				class="genric-btn success-border medium">수정하기</a> <a
				href="/notice/NoticeDelete.do?seq=<%=seq%>"
				class="genric-btn success-border medium">삭제하기</a>
			<%
				}
			%>
			<%-- <%
				if (userId.equals(nDTO.getReg_id()) || user_Rights.equals("1")) {
			%>
			<a href="#" class="genric-btn success-border medium">삭제하기</a>
			<%
				}
			%> --%>
		</div>
	</div>
	
	<script src="/js/vendor/jquery-2.2.4.min.js"></script>
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
</body>
</html>