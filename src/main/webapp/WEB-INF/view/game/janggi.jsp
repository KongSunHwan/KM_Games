<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>KM_Games 장기게임</title>
	<link rel="icon" href="img/KM_GAMES_logo.png" type="image/x-icon" sizes="36x36" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="/resources/css/styles.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

	<link href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css"
		rel="stylesheet" type="text/css" />

	<link rel="stylesheet" type="text/css" href="resources/css/datail.css" />
	<style>
    		.game_start {
    			transition: transform 0.2s ease-in-out;
    		}

    		.game_start:hover {
    			transform: scale(1.1);
    		}
    	</style>

    	<script>
    		$(document).ready(function () {
    			$(".game_start").click(function () {
    				$(this).toggleClass("blur");
    			});
    		});
    	</script>
</head>

<body>
<jsp:include page="../include/header_detail.jsp"></jsp:include>
	<div id="wrapper">
		<section id="main">
		<a class="games_logo" href="#">장기왕</a>

			<div class="login">
				<ul>
					<li>
						<a href="#">회원가입</a>
					</li>
					<li>
						<a href="#">로그인</a>
					</li>
					<li>
						<a href="#">고객센터</a>
					</li>
				</ul>
			</div>

			<div class="tree1"></div>

			<div class="main_logo center">
				<div class="logo center">KM Games :: 장기게임</div>
				<div class="video">장기 영상</div>
				<iframe class="video_frame center" width="450" height="253"
					src="https://www.youtube.com/embed/ioE59L4WlyQ" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					allowfullscreen>
				</iframe>
				<div>
					<a class="game_start center" onclick="alert('오픈 준비중입니다'); return false;">
						게임 시작
					</a>
				</div>
			</div>

	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>

</body>

</html>