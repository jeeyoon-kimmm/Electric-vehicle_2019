<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="poly.dto.BoardDTO"%>
<%@ page import="poly.dto.B_CommentDTO"%>
<%@ page import="poly.util.CmmUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.HashMap"%>
<%
	String userId = (String) session.getAttribute("userId");
	String user_Rights = CmmUtil.nvl((String) session.getAttribute("user_Rights")); //권한
	BoardDTO bDTO = (BoardDTO) request.getAttribute("bDTO");
	int seq = Integer.parseInt((String) request.getAttribute("seq"));
	String pgNum = (String) request.getAttribute("pgNum"); //pgNum을 가져옴

	List<B_CommentDTO> rList = (List<B_CommentDTO>) request.getAttribute("rList");
	if (rList == null) {
		rList = new ArrayList();
	}

	B_CommentDTO cDTO = (B_CommentDTO) request.getAttribute("cDTO");

	String no_seq = (String) request.getAttribute("no_seq");
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
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
<title>공지사항</title>
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/css/modern-business.css" rel="stylesheet">
<!--공통 css-->
<link href="/css/user-common.css" rel="stylesheet">
<!--추가 css-->
<link href="/css/user-board.css" rel="stylesheet">
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
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/css/mypage.css" rel="stylesheet">
</head>

<body>
	<!-- header -->
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

	<section class="about-banner3 relative" style="margin-top: -57px;">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white" style="font-weight: lighter; font-size: xx-large;">커뮤니티 게시판</h1>
				</div>
			</div>
		</div>
	</section>

	<div class="container">
		<h4 class="mt-4 mb-3"><%=bDTO.getTitle()%></h4>
		<div class="">
			<hr>
			<%
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(bDTO.getReg_dt());
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			%>
			<%=format1.format(date)%> | <small>작성자 : <%=bDTO.getReg_id()%></small>
			<hr>

			<div style="width: 100%; height: 350px;"><%=bDTO.getContent()%></div>
		</div>

		<!-- 댓글 영역 -->
		<div class="container comment-bottom">
			<hr>
			<!-- 댓글 작성 form 시작 -->
			<form action="/commentAddProc.do" method="POST">
				<div class="col-lg-12">
					<h6>댓글</h6>
					<input type="hidden" value="<%=no_seq%>" name="no_seq">
					<textarea name="content" id="" cols="30" rows="10" class="col-md-12" style="height: 100px;"></textarea>
					<input type="submit" class="btn board-btn form_control col-md-2" style="float: right;" value="등록">
				</div>
				<hr style="margin-top: 50px;">
			</form>
			<!-- 댓글 작성 form 종료 -->

			<%
				for (int i = 0; i < rList.size(); i++) {
			%>
							<script type="text/javascript">
					        var bDisplay = true;
					        function Display<%=rList.get(i).getCom_seq()%>() {
					            var display_1_<%=rList.get(i).getCom_seq()%> = document.getElementById("display_1_<%=rList.get(i).getCom_seq()%>"); // 수정 버튼 클릭 전 보여 줄 댓글
					            var display_2_<%=rList.get(i).getCom_seq()%> = document.getElementById("display_2_<%=rList.get(i).getCom_seq()%>"); // 수정 버튼 클릭 후 보여 줄 댓글
					            if (display_2_<%=rList.get(i).getCom_seq()%>.style.display == 'none') {
					            	display_1_<%=rList.get(i).getCom_seq()%>.style.display = 'none'; //보여지는거랑 숨겨진거랑 바꿔줌
					            	display_2_<%=rList.get(i).getCom_seq()%>.style.display = 'block';
					            } else {
					            	display_2.style.display = 'none';
					            }
					        }
					        //취소하기
					        function Display_2<%=rList.get(i).getCom_seq()%>() {
					            var display_1_<%=rList.get(i).getCom_seq()%> = document.getElementById("display_1_<%=rList.get(i).getCom_seq()%>"); // 수정 버튼 클릭 전 보여 줄 댓글
					            var display_2_<%=rList.get(i).getCom_seq()%> = document.getElementById("display_2_<%=rList.get(i).getCom_seq()%>"); // 수정 버튼 클릭 후 보여 줄 댓글
								if (display_1_<%=rList.get(i).getCom_seq()%>.style.display == 'none') {
									display_2_<%=rList.get(i).getCom_seq()%>.style.display = 'none';
									display_1_<%=rList.get(i).getCom_seq()%>.style.display = 'block';
								} else {
									display_1.style.display = 'none';
								}
							}
			                // 댓글 수정 완료 버튼
			                function Modify<%=rList.get(i).getCom_seq() %>(){
			                	if (confirm("댓글을 수정하시겠습니까?") == true) {
			                    document.location.href = "/commentModify.do?com_seq="+<%=rList.get(i).getCom_seq() %>
			                    +"&no_seq="+<%=rList.get(i).getNo_seq()%>
			                    +"&content="+$("#content"+<%=rList.get(i).getCom_seq() %>).val();
			                    return true;
			                    } else {
			                    	return false;
			                    }
			                 }
						</script>

			<!-- 댓글 리스트 form 시작 -->

			<!-- 숨겨져 있는 수정 부분 시작 -->
			<div id="display_2_<%=rList.get(i).getCom_seq()%>" style="display: none;">
				<div class="col-lg-12 user-comment">
						<input type="hidden" value="<%=rList.get(i).getNo_seq()%>" name="no_seq"> 
						<input type="hidden" value="<%=rList.get(i).getCom_seq()%>" name="com_seq">
						<div class="col-md-12 col-md-offset-0">
							<div class="row">
								<!-- 댓글 수정 textarea 부분 시작 -->
								<div class="forumText forumMax col-md-10">
									<input type="text" value="<%=rList.get(i).getContent()%>" name="content<%=rList.get(i).getCom_seq()%>" id="content<%=rList.get(i).getCom_seq()%>" class="comment-st">
								</div>
								<div class="col-md-2">
									<input type="button" class="btn comment-btn-free" value="완료" onclick="Modify<%=rList.get(i).getCom_seq()%>()">
									<a href="javascript:Display_2<%=rList.get(i).getCom_seq()%>();" class="btn comment-btn-free">취소</a>
								</div>
							</div>
							<div class="row">
								<div class="forumTagline col-md-10">
									<p class="forumName text-muted">
										<%=rList.get(i).getUser_id()%>
										/
										<%=rList.get(i).getReg_dt().substring(2, 16)%>
									</p>
								</div>
							</div>
						</div>
				</div>
				<hr style="margin-top: 0rem;">
			</div>
			<!-- 숨겨져 있는 수정 부분 종료 -->

			<!-- 기존 댓글이 보여줄 부분 display:block로 보여줌, 수정 버튼 클릭 시  javascript로 인해 display:none으로 바뀜  시작-->
			<!-- 댓글 리스트 -->
			<div id="display_1_<%=rList.get(i).getCom_seq()%>" style="display: block;">
				<div class="col-lg-12">
					<input type="hidden" value="<%=rList.get(i).getNo_seq()%>" name="no_seq"> 
					<input type="hidden" value="<%=rList.get(i).getCom_seq()%>" name="com_seq">
					<div class="col-md-12 col-md-offset-0">
						<div class="row">
							<div class="col-md-10">
								<p style="height: 30px;"><%=rList.get(i).getContent()%></p>
							</div>
							<div class="col-md-2">
								<%
									if (userId != null) {
								%>
								<%
									if (rList.get(i).getUser_id().equals(userId)) {
								%>
									<input type="hidden" value="<%=rList.get(i).getCom_seq()%>" name="com_seq"> 
									<input type="hidden" value="<%=rList.get(i).getNo_seq()%>" name="no_seq"> 
									<a href="javascript:Display<%=rList.get(i).getCom_seq()%>();" class="btn">수정</a> 
									<a href="/commentDelete.do?com_seq=<%=rList.get(i).getCom_seq()%>&no_seq=<%=rList.get(i).getNo_seq()%>" class="btn comment-btn-free">삭제</a>
								<%
									}
								%>
								<%
									}
								%>
							</div>
						</div>
						<div class="row">
							<div class="col-md-10">
								<p>
									<%=rList.get(i).getUser_id()%>
									/
									<%=rList.get(i).getReg_dt().substring(2, 16)%>
								</p>
							</div>
						</div>
					</div>
				</div>
				<hr style="margin-top: 0rem; margin-bottom: 0.5rem;">
			</div>
			<!-- 기존 댓글이 보여줄 부분 display:block로 보여줌, 수정 버튼 클릭 시  javascript로 인해 display:none으로 바뀜  종료-->
			<!-- 댓글 리스트 form 종료 -->
			<%
				}
			%>
		</div>
		<!-- /댓글 영역 -->

		<%
			if (user_Rights.equals("0") || user_Rights.equals("1")) {
		%>
		<div class="board-btn">
			<div style="display: inline-block;">
				<a href="/board/board.do?pgNum=<%=pgNum%>"
					class="genric-btn primary-border medium">목록</a>
			</div>
			<div style="display: inline-block; margin-left: 64%;">
				<a href="/board/boardModify.do?seq=<%=seq%>"
					class="genric-btn success-border medium">수정하기</a> <a
					href="/board/BoardDelete.do?seq=<%=seq%>"
					class="genric-btn success-border medium">삭제하기</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<!-- End hot-deal Area -->
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