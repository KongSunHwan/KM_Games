<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>장바구니</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="resources/css/footer.css" />
    <link href="resources/css/contract_in.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>


</head>

<body>

<jsp:include page="../include/header.jsp"></jsp:include>

    <main>
        <div class="container py-4">
            <div class="p-3 mb-4 bg-light rounded-3">
                <div class="container-fluid py-5">
                    <div class="d-flex">
                        <div class="p-2 w-75 fs-3 fw-bold">장바구니 내역 (1)</div>
                        <div class="p-2 flex-shrink-1">
                            <span class="fs-5 fw-bold">장바구니</span>
                            <span class="text-muted">></span>
                            <span class="text-muted">주문/결제</span>
                            <span class="text-muted">></span>
                            <span class="text-muted">완료</span>
                        </div>
                    </div>
                    <hr>

                    <div class="d-flex">
                        <div class="p-2 w-75 fs-3 fw-bold">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                <label class="form-check-label" for="inlineCheckbox1" style="margin-top: 10px;">전체
                                    선택</label>
                            </div>
                        </div>
                        <div class="p-2 flex-shrink-1">
                            <button type="button" class="btn btn-outline-secondary" style="margin-left: 120px;"><i
                                    class="bi bi-x-lg"></i>
                                선택 삭제
                            </button>
                        </div>
                    </div>
                    <div>&nbsp;</div>

                    <%-- col 시작--%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="well-left">
                                <div class="single-well">
                                    <div class="d-flex">
                                        <div class="form-check form-check-inline align-self-center">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox2"
                                                value="option2" style="width: 20px; height: 20px;">
                                        </div>
                                        <a href="#">
                                            <img src="resources/img/game/game_img2.jpg">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="well-middle">
                                <div class="single-well">
                                    <a href="#">
                                        <h4 class="sec-head">게임 정보</h4>
                                    </a>
                                    <hr>
                                    <ul>
                                        <li>
                                            <i class="bi bi-check"></i> <b>게임 제목 :</b> 휴먼 폴 플랫
                                        </li>
                                        <li>
                                            <i class="bi bi-check"></i> <b>게임 장르 :</b> 아케이드
                                        </li>
                                        <li>
                                            <i class="bi bi-check"></i> <b>가격 :</b> 10,000 원
                                        </li>
                                        <li>
                                            <i class="bi bi-check"></i> <b>등급 분류 :</b> 만 12세 이상
                                        </li>
                                        <li>
                                            <i class="bi bi-check"></i> <b>개발사 :</b> KM_GAMES
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%-- col End--%>

                    <div>&nbsp;</div>
                    <hr>

                    <div class="d-flex justify-content-evenly">
                        <div class="p-2 w-75 fs-4 fw-bold" style="margin-top: 10px;">총 주문 금액 : <span
                                class="text-primary">10,000원</span></div>
                        <div class="p-2 flex-shrink-1">
                            <button type="button" class="btn btn-primary btn-lg">총 주문하기 <span
                                    class="badge text-bg-light">1</span>
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </main>

<!--footer 시작-->
<jsp:include page="../include/footer.jsp"></jsp:include>
<!--footer 종료-->



    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>

</html>