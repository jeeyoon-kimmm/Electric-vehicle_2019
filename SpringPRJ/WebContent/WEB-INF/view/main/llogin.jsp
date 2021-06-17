<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Language" content="en" />
    <meta name="msapplication-TileColor" content="#2d89ef">
    <meta name="theme-color" content="#4188c9">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <link rel="icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" type="image/x-icon" href="./favicon.ico" />
    <!-- Generated: 2018-04-06 16:27:42 +0200 -->
    <title>로그인</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <script src="./assets/js/require.min.js"></script>
    <script>
      requirejs.config({
          baseUrl: '.'
      });
    </script>
    <!-- Dashboard Core -->
    <link href="/css/dashboard.css" rel="stylesheet" />
    <script src="./assets/js/dashboard.js"></script>
    <!-- c3.js Charts Plugin -->
    <link href="./assets/plugins/charts-c3/plugin.css" rel="stylesheet" />
    <script src="./assets/plugins/charts-c3/plugin.js"></script>

    <!-- Input Mask Plugin -->
    <script src="./assets/plugins/input-mask/plugin.js"></script>
  </head>
  <body class="">
    <div class="page">
      <div class="page-single">
        <div class="container">
          <div class="row">
            <div class="col col-login mx-auto">
              <div class="text-center mb-6">
                <img src="./assets/brand/tabler.svg" class="h-6" alt="">
              </div>
              <form class="card" method="post" action="/Loginbtn.do">
                <div class="card-body p-6">
                  <div class="card-title"> <a href="/index.do">Home</a></div>
                  <div class="form-group">
                    <label class="form-label">ID</label>
                    <input type="id" name="userId" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="아이디를 입력하세요">
                  </div>
                  <div class="form-group">
                    <label class="form-label">
                      Password
                      <a href="/main/userFind.do" class="float-right small">아이디/비밀번호 찾기</a>
                    </label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="userPassword" placeholder="비밀번호를 입력하세요">
                  </div>
                  <div class="form-group">
             <!--        <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" name="userCheck" />
                      <span class="custom-control-label">아이디 기억하기</span>
                    </label> -->
                  </div>
                  <div class="form-footer">
                    <button type="submit" class="btn btn-primary btn-block" value="로그인">로그인</button>
                  </div>
                </div>
              </form>
              <div class="text-center text-muted">
                Don't have account yet? <a href="/main/add.do">회원가입</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <script>
		window.onload = function() {
			var userInputId = getCookie("userInputId");//저장된 쿠기값 가져오기
			$('input[name=userId]').val(userInputId);

			if ($('input[name=userId]').val() != "") { // 그 전에 ID를 저장해서 처음 페이지 로딩
				// 아이디 저장하기 체크되어있을 시,
				$('input[name=userCheck]').attr("checked", true); // ID 저장하기를 체크 상태로 두기.
			}

			$('input[name=userCheck]').change(function() { // 체크박스에 변화가 발생시
				if ($('input[name=userCheck]').is(":checked")) { // ID 저장하기 체크했을 때,
					var userInputId = $('input[name=userId]').val();
					setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
				} else { // ID 저장하기 체크 해제 시,
					deleteCookie("userInputId");
				}
			});

			// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
			$('input[name=userId]').keyup(function() { // ID 입력 칸에 ID를 입력할 때,
				if ($('input[name=userCheck]').is(":checked")) { // ID 저장하기를 체크한 상태라면,
					var userInputId = $('input[name=userId]').val();
					setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
				}
			});
		};

		function setCookie(cookieName, value, exdays) {
			var exdate = new Date();
			exdate.setDate(exdate.getDate() + exdays);
			var cookieValue = escape(value)
					+ ((exdays == null) ? "" : "; expires="
							+ exdate.toGMTString());
			document.cookie = cookieName + "=" + cookieValue;
		}

		function deleteCookie(cookieName) {
			var expireDate = new Date();
			expireDate.setDate(expireDate.getDate() - 1);
			document.cookie = cookieName + "= " + "; expires="
					+ expireDate.toGMTString();
		}

		function getCookie(cookieName) {
			cookieName = cookieName + '=';
			var cookieData = document.cookie;
			var start = cookieData.indexOf(cookieName);
			var cookieValue = '';
			if (start != -1) {
				start += cookieName.length;
				var end = cookieData.indexOf(';', start);
				if (end == -1)
					end = cookieData.length;
				cookieValue = cookieData.substring(start, end);
			}
			return unescape(cookieValue);
		}
	</script>
	
  </body>
</html>