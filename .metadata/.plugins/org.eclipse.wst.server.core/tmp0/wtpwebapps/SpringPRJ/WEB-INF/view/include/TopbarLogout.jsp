<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header id="header">
		<div class="header-top">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-6 col-sm-6 col-6 header-top-left">
						<ul>
							<!-- <li onclick="location.href='/main/llogin.do'"  style="cursor: pointer;"> -->
							<li><a href="/main/llogin.do">로그인</a></li>
							<li><a href="/main/add.do">회원가입</a></li>
							<li><a href="/main/mypage.do">마이페이지</a></li>

						</ul>
					</div>

				</div>
			</div>
		</div>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a class="navbar-brand" href="/index.do"
						style="color: aliceblue; font-size: 2em;">Electric vehicle</a>
					
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="/index.do">Home</a></li>
						<li class="menu-has-children"><a href="">전기차 충전소</a>
							<ul>
								<li><a href="/car/carFind.do">주변 전기차 충전소 위치 및 검색</a></li>
							</ul></li>
						<li><a href="/car/money.do">국가보조금</a></li>
						<li><a href="/board/board.do">게시판</a></li>
						<li><a href="/notice/notice.do">공지사항</a></li>

					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>