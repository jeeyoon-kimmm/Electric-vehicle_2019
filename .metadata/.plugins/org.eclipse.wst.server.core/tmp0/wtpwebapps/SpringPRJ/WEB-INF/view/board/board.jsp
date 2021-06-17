<%@page import="poly.dto.PagingDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="poly.dto.BoardDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String userId = (String) session.getAttribute("userId");
	String user_Rights = (String) session.getAttribute("user_Rights");
	List<BoardDTO> bList = (List<BoardDTO>) request.getAttribute("bList");
	PagingDTO paging = (PagingDTO) request.getAttribute("paging");
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
<title>게시판</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/modern-business.css" rel="stylesheet">
<!--공통 css-->
<link href="/css/user-common.css" rel="stylesheet">
<!--추가 css-->
<link href="/css/user-notice.css" rel="stylesheet">

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
	font-size: 0.85rem;
	font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto,
      Helvetica Neue, Arial, sans-serif;
    
}
.lg-content-st a {
	text-decoration: none;
	color: #212529;
}
.lg-content-st a:hover {
	text-decoration: none;
	color: #212529;
}
.table-title{
	margin-top: 10px;
	border-top: 2px solid black;
	border-bottom: 1px solid #dbdbdb;
	padding: 10px 10px;
	line-height: 16px;
	text-align: center;
	font-weight: bold;
	font-size: 0.85rem;
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
	<!-- background-size:100% 100%; -->
	<section class="about-banner3 relative" style="margin-top: -57px;">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white"
						style="font-weight: lighter; font-size: xx-large;">커뮤니티 게시판</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start hot-deal Area -->
	<section class="hot-deal-area section-gap">

		<div class="container">
			<div class="row">


				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="rightContent" id="rightContent">
						<div>
							<div>
								<div>
									<div class="container" style="min-height: 460px;">
										<div class="row">

											<div class="col-md-6 table-title">제목</div>
											<div class="col-md-3 table-title">작성자</div>
											<div class="col-md-3 table-title">등록일</div>

											<%
												if (bList.get(0).getTitle().equals("없음")) {
											%>
											<div class="col-md-12" style="height: 20em">
												<div class="inner_cell">
													<span class="txt_public">공지사항이 없습니다.</span>
												</div>
											</div>
											<%
												} else {
											%>
											<%
												for (int i = 0; i < bList.size(); i++) {
											%>

											<!-- 제목 -->
											<div class="col-md-6 lg-content-st">
												<span class="txt_public"> <a
													class="loss_word link_txt"
													href="/board/BoardDetail.do?seq=<%=bList.get(i).getSeq()%>&pgNum=<%=paging.getPage()%>">
														<%=bList.get(i).getTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;")%>
												</a>
												</span>
											</div>

											<!-- 작성자 -->
											<div class="col-md-3 lg-content-st"><%=bList.get(i).getReg_id()%></div>

											<!-- 등록일 -->
											<div class="col-md-3 lg-content-st">
												<%
													Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(bList.get(i).getReg_dt());
															SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
												%>
												<%=format1.format(date)%>
											</div>
											<%
												}
											%>
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

			<div>

				<!-- 글쓰기 버튼  -->
				<div class="row">
					<div class="col-md-9"></div>
					<div class="col-md-3">
						<a href="/board/boardWrite.do">
							<div class="genric-btn primary-border small"
								style="font-size: 0.7rem;">글쓰기</div>
						</a>
					</div>
				</div>
				<!-- 글쓰기 버튼 끝 -->

				<!-- 페이징 -->
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<%
											if (paging.isPrev() == true) {
										%>

						<li class="page-item"><a
							href="/board/board.do?pgNum=<%=paging.getStartPage() - 10%>"
							class="page-link" aria-label="Previous"> <span
								aria-hidden="true"> <span class="lnr lnr-chevron-left"></span>
							</span>
						</a></li>
						<%
											}
										%>
						<%
											for (int a = paging.getStartPage(); a <= paging.getEndPage(); a++) {
												if (paging.getPage() == a) {
										%>
						<li class="page-item  active"><a
							href="/board/board.do?pgNum=<%=a%>" class="page-link"><%=a%></a></li>
						<%
											} else {
										%>
						<li class="page-item"><a href="/board/board.do?pgNum=<%=a%>"
							class="page-link"><%=a%></a></li>
						<%
											}
										%>
						<%
											}
										%>
						<%
											if (paging.isNext() == true) {
										%>
						<li class="page-item"><a
							href="/board/board.do?pgNum=<%=paging.getEndPage() + 1%>"
							class="page-link" aria-label="Next"> <span aria-hidden="true">
									<span class="lnr lnr-chevron-right"></span>
							</span>
						</a></li>
						<%
											}
										%>
					</ul>
				</nav>
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