<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 - KMGames | 게임 플랫폼 사이트</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <style>
    		.error-wrapper {
    			color: red;
    			text-align: center;
    			margin-bottom: 20px;
    		}

    		body {
    			font-family: Arial, sans-serif;
    		}

    		.form-group {
    			margin-bottom: 15px;
    		}

    		label {
    			display: block;
    			font-weight: bold;
    			margin-bottom: 5px;
    		}

    		#emailok {
    			width: 100%;
    			padding: 10px;
    			border-radius: 3px;
    			border: 1px solid #ccc;
    			box-sizing: border-box;
    		}

    		#emailok {
    			background-color: #4caf50;
    			color: #fff;
    			cursor: pointer;
    		}

    		#emailok:hover {
    			background-color: #45a049;
    		}
    	</style>

</head>
<body>
<main>
    <section class="login-wrapper">
        <form action="/request_login" method="post" class="login-wrap">
            <h1 class="title">
                <a href="home"> <img src="/resources/img/KM_GAMES_logo.png" width="250" height="250" /></a>
            </h1>
            <div class="input-wrapper">
                <div class="input-wrap">
                    <input type="email" class="login-input" name="email" placeholder="이메일" value='${email}' required>
                </div>
                <div class="input-wrap">
                    <input type="password" class="login-input" name="password" placeholder="비밀번호" required>
                </div>
            </div>

            <div class="button-wrapper">
                <div class="button-wrap">
                    <button class="login-button" type="submit">
                        <span>로그인</span>
                    </button>
                </div>
                <div class="button-wrap">
                    <button class="login-button" type="button" onclick="location.href='/register'">
                        <span>회원가입</span>
                    </button>
                </div>
            </div>
        </form>
        <br>
        <div class="d-flex justify-content-center">
            <div style="margin-right: 8px">
                <button type="button" class="btn btn-primary">아이디 찾기</button>
            </div>
            <div>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                data-bs-whatever="@mdo">비밀번호 찾기</button>
            </div>
        </div>
        <div class="text-wrapper">
            <span> &copy; 2023 - KMGames </span>
        </div>
    </section>
</main>

<!-- 모달 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호 찾기</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">이름 :</label>
							<input type="text" class="form-control" id="password">
						</div>
						<div class="mb-3">
							<label for="recipient-email" class="col-form-label">이메일 :</label>
							<input type="text" class="form-control" id="recipient-email">
						</div>

						<div class="form-group">
							<input type="submit" id="emailok" value="이메일 중복 확인">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">확인</button>
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 모달 종료 -->

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>