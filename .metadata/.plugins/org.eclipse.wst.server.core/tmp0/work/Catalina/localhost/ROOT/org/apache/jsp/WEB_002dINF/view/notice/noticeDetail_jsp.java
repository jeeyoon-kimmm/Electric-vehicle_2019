/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2019-12-08 23:56:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import poly.dto.NoticeDTO;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import poly.util.CmmUtil;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class noticeDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/view/include/TopbarLoginAdmin.jsp", Long.valueOf(1575836319688L));
    _jspx_dependants.put("/WEB-INF/view/include/TopbarLogout.jsp", Long.valueOf(1575700325099L));
    _jspx_dependants.put("/WEB-INF/view/include/TopbarLoginUser.jsp", Long.valueOf(1575836260503L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.util.HashMap");
    _jspx_imports_classes.add("poly.util.CmmUtil");
    _jspx_imports_classes.add("poly.dto.NoticeDTO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String userId = (String) session.getAttribute("userId");
	String user_Rights = CmmUtil.nvl((String) session.getAttribute("user_Rights")); //권한
	NoticeDTO nDTO = (NoticeDTO) request.getAttribute("nDTO");
	int seq = Integer.parseInt((String) request.getAttribute("seq"));
	String pgNum = (String) request.getAttribute("pgNum"); //pgNum을 가져옴

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zxx\" class=\"no-js\">\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Mobile Specific Meta -->\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<!-- Author Meta -->\r\n");
      out.write("<meta name=\"author\" content=\"colorlib\">\r\n");
      out.write("<!-- Meta Description -->\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<!-- Meta Keyword -->\r\n");
      out.write("<meta name=\"keywords\" content=\"\">\r\n");
      out.write("<!-- meta character set -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- Site Title -->\r\n");
      out.write("<title>공지사항</title>\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"/css/modern-business.css\" rel=\"stylesheet\">\r\n");
      out.write("<!--공통 css-->\r\n");
      out.write("<link href=\"/css/user-common.css\" rel=\"stylesheet\">\r\n");
      out.write("<!--추가 css-->\r\n");
      out.write("<link href=\"/css/user-notice.css\" rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!-- CSS ============================================= -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/linearicons.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/magnific-popup.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/jquery-ui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/nice-select.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/animate.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/main.css\">\r\n");
      out.write("<link href=\"/css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/css/mypage.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		if (userId == null) {
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("\t<header id=\"header\">\n");
      out.write("\t\t<div class=\"header-top\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row align-items-center\">\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-6 col-sm-6 col-6 header-top-left\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<!-- <li onclick=\"location.href='/main/llogin.do'\"  style=\"cursor: pointer;\"> -->\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/main/llogin.do\">로그인</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/main/add.do\">회원가입</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/main/mypage.do\">마이페이지</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"container main-menu\">\n");
      out.write("\t\t\t<div class=\"row align-items-center justify-content-between d-flex\">\n");
      out.write("\t\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"/index.do\"\n");
      out.write("\t\t\t\t\t\tstyle=\"color: aliceblue; font-size: 2em;\">Electric vehicle</a>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<nav id=\"nav-menu-container\">\n");
      out.write("\t\t\t\t\t<ul class=\"nav-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/index.do\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-has-children\"><a href=\"\">전기차 충전소</a>\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/car/carFind.do\">주변 전기차 충전소 위치 및 검색</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/car/money.do\">국가보조금</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/board/board.do\">게시판</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/notice/notice.do\">공지사항</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<!-- #nav-menu-container -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>");
      out.write('\r');
      out.write('\n');
      out.write('	');

		} else if (user_Rights.equals("1")) {
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("\t<header id=\"header\">\n");
      out.write("\t\t<div class=\"header-top\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row align-items-center\">\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-6 col-sm-6 col-6 header-top-left\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/Logoutbtn.do\">로그아웃</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/manager/page.do\">관리자 페이지</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"container main-menu\">\n");
      out.write("\t\t\t<div class=\"row align-items-center justify-content-between d-flex\">\n");
      out.write("\t\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"/index.do\"\n");
      out.write("\t\t\t\t\t\tstyle=\"color: aliceblue; font-size: 2em;\">Electric vehicle</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<nav id=\"nav-menu-container\">\n");
      out.write("\t\t\t\t\t<ul class=\"nav-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/index.do\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-has-children\"><a href=\"/car/carFind.do\">전기차 충전소</a>\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/car/carFind.do\">주변 전기차 충전소 위치 및 검색</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/car/money.do\">국가보조금</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/board/board.do\">게시판</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/notice/notice.do\">공지사항</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<!-- #nav-menu-container -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>");
      out.write('\r');
      out.write('\n');
      out.write('	');

		} else {
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("\t<header id=\"header\">\n");
      out.write("\t\t<div class=\"header-top\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row align-items-center\">\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-6 col-sm-6 col-6 header-top-left\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<!-- <li onclick=\"location.href='/main/llogin.do'\"  style=\"cursor: pointer;\"> -->\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/Logoutbtn.do\">로그아웃</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/main/mypage.do\">마이페이지</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"container main-menu\">\n");
      out.write("\t\t\t<div class=\"row align-items-center justify-content-between d-flex\">\n");
      out.write("\t\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"/index.do\"\n");
      out.write("\t\t\t\t\t\tstyle=\"color: aliceblue; font-size: 2em;\">Electric vehicle</a>\n");
      out.write("\t\t\t\t\t<!-- <a href=\"index.html\"><img src=\"img/logo.png\" alt=\"\" title=\"\" /></a> -->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<nav id=\"nav-menu-container\">\n");
      out.write("\t\t\t\t\t<ul class=\"nav-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/index.do\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-has-children\"><a href=\"/car/carFind.do\">전기차 충전소</a>\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/car/carFind.do\">주변 전기차 충전소 위치 및 검색</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/car/money.do\">국가보조금</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/board/board.do\">게시판</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/notice/notice.do\">공지사항</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<!-- #nav-menu-container -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>");
      out.write('\r');
      out.write('\n');
      out.write('	');

		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<section class=\"about-banner4 relative\" style=\"margin-top: -57px;\">\r\n");
      out.write("\t\t<div class=\"overlay overlay-bg\"></div>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row d-flex align-items-center justify-content-center\">\r\n");
      out.write("\t\t\t\t<div class=\"about-content col-lg-12\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"text-white\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-weight: lighter; font-size: xx-large;\">공지사항</h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<h4 class=\"mt-4 mb-3\">");
      out.print(nDTO.getTitle());
      out.write("</h4>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t");

				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(nDTO.getReg_dt());
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			
      out.write("\r\n");
      out.write("\t\t\t");
      out.print(format1.format(date));
      out.write(" | <small>작성자 : ");
      out.print(nDTO.getReg_id());
      out.write("</small>\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t<div style=\"width: 100%; height: 350px;\">");
      out.print(nDTO.getContent());
      out.write("</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"notice-btn\">\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t<a href=\"/notice/notice.do?pgNum=");
      out.print(pgNum);
      out.write("\"\r\n");
      out.write("\t\t\t\tclass=\"genric-btn primary-border medium\">목록</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				if (user_Rights.equals("1")) {
			
      out.write("\r\n");
      out.write("\t\t\t<a href=\"/notice/noticeModify.do?seq=");
      out.print(seq);
      out.write("\"\r\n");
      out.write("\t\t\t\tclass=\"genric-btn success-border medium\">수정하기</a> <a\r\n");
      out.write("\t\t\t\thref=\"/notice/NoticeDelete.do?seq=");
      out.print(seq);
      out.write("\"\r\n");
      out.write("\t\t\t\tclass=\"genric-btn success-border medium\">삭제하기</a>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"/js/vendor/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/popper.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/jquery-ui.js\"></script>\r\n");
      out.write("\t<script src=\"/js/easing.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/hoverIntent.js\"></script>\r\n");
      out.write("\t<script src=\"/js/superfish.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/jquery.ajaxchimp.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/owl.carousel.min.js\"></script>\r\n");
      out.write("\t<script src=\"/js/mail-script.js\"></script>\r\n");
      out.write("\t<script src=\"/js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
