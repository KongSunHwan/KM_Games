<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>header_detail</title>
</head>

<body>

    <header class="p-6 mb-3 border-bottom">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                    <img src="resources/img/KM_GAMES_logo.png" style="height: 80px;">
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-4 link-dark">게임 방법</a></li>
                    <li><a href="#" class="nav-link px-4 link-dark">랭킹</a></li>
                    <li><a href="#" class="nav-link px-4 link-dark">개발자 노트</a></li>
                    <li><a href="#" class="nav-link px-4 link-dark">운영정책</a></li>
                    <li><a href="#" class="nav-link px-4 link-dark">도움말</a></li>
                </ul>

                <div class="dropdown text-end">
                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        <img src="resources/img/user.png" alt="user" width="32" height="32" class="rounded-circle">
                        <span class="fs-6">${user.getName()}</span>
                    </a>
                    <ul class="dropdown-menu text-small">
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="bi bi-house-fill"></i> 마이페이지
                            </a>
                        </li>
                        <li><a class="dropdown-item" href="#">
                                <i class="bi bi-cash-coin"></i> 캐시 충전
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="bi bi-cart-check"></i> 결제 내역
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="bi bi-box-arrow-in-right"></i> 로그인
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="bi bi-box-arrow-left"></i> 로그아웃
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="bi bi-person-plus-fill"></i> 회원가입
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
</body>

</html>