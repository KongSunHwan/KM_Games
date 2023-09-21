<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="apple-touch-icon" sizes="180x180" href="resources/img/KM_GAMES_logo_icon">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/img/KM_GAMES_logo_icon">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/img/KM_GAMES_logo_icon">
    <link rel="manifest" href="https://i.morioh.com/favicon/site.webmanifest">
    <link rel="mask-icon" href="resources/img/KM_GAMES_logo_icon" color="#262521">
    <link rel="shortcut icon" href="resources/img/KM_GAMES_logo_icon">
    <meta name="msapplication-TileColor" content="#faa700">
    <meta name="theme-color" content="#ffffff">

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />

    <meta property="og:title" content="Morioh Responsive Template with Bootstrap 4, HTML5 and Vue.js">
    <meta property="og:image" content="resources/img/KM_GAMES_logo_icon">
    <meta property="og:description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta property="og:image:width" content="1280">
    <meta property="og:image:height" content="720">

    <title>관리자 페이지</title>
    <meta itemprop="description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta itemprop="image" content="resources/img/KM_GAMES_logo_icon">

    <meta name="description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta name="image" content="resources/img/KM_GAMES_logo_icon">


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/perfect-scrollbar@1.4.0/css/perfect-scrollbar.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font@4.7.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/animate.css@3.7.2/animate.min.css">
    <!-- jquery UI CSS파일 -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
    <!-- jquery 기본 js 파일 -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- jquery UI 라이브러리 js파일 -->
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="resources/css/morioh.css">

</head>

<body class="menubar-enabled navbar-top-fixed">

    <div class="wrapper">

        <jsp:include page="../include/admin_header.jsp"></jsp:include>

        <div class="row">
            <div class="col-lg-13 col-md-12">
                <div class="card mb-15">
                    <div class="table-responsive">
                        <br>
                        <h5 style="text-align:center"><b>회원 수정</b></h5>
                        <h6 style="font-size: 15px; color:gray; text-align:center">총 관리자 권한이 있는 대상만 회원 수정 할 수 있습니다.
                        </h6>
                        <br>
                        <form class="form-inline">
                            <div class="input-group">
                                <input class="form-control" type="search"
                                    placeholder="회원의 이메일 또는 닉네임으로 검색하여 추가할 수 있습니다." aria-label="Search">
                                <button class="btn btn-outline-primary" type="button">
                                    <i class="fas fa-search"></i>
                                </button>
                            </div>
                        </form>
                        <table class="table">

                            <thead>
                                <tr>
                                    <th class="text-center">권한</th>
                                    <th class="text-center">이메일</th>
                                    <th class="text-center">닉네임</th>
                                    <th class="text-center">날짜</th>
                                    <th class="text-center">설정</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="text-center">
                                        일반 회원
                                    </td>

                                    <td class="text-center">
                                        neha******@gmail.com
                                    </td>

                                    <td class="text-center">
                                        공선환
                                    </td>


                                    <td class="text-center">
                                        <span class="badge bg-primary">2023-05-16</span>
                                    </td>

                                    <td class="text-center">
                                        <div class="btn-group">
                                            <button type="button" class="btn" data-bs-toggle="dropdown"
                                                data-bs-display="static" aria-expanded="false">
                                                <i class="mdi mdi-dots-horizontal"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-lg-end">
                                                <li><button class="dropdown-item" type="button">수정</button></li>
                                                <li><button class="dropdown-item" type="button">삭제</button></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>


                                <tr>
                                    <td class="text-center">
                                        일반 회원
                                    </td>

                                    <td class="text-center">
                                        neha******@gmail.com
                                    </td>

                                    <td class="text-center">
                                        공선환
                                    </td>


                                    <td class="text-center">
                                        <span class="badge bg-primary">2023-05-16</span>
                                    </td>

                                    <td class="text-center">
                                        <div class="btn-group">
                                            <button type="button" class="btn" data-bs-toggle="dropdown"
                                                data-bs-display="static" aria-expanded="false">
                                                <i class="mdi mdi-dots-horizontal"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-lg-end">
                                                <li><button class="dropdown-item" type="button">수정</button></li>
                                                <li><button class="dropdown-item" type="button">삭제</button></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination" style="justify-content: center;">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/perfect-scrollbar@1.4.0/dist/perfect-scrollbar.min.js"></script>


        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-50750921-19"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() { dataLayer.push(arguments); }
            gtag('js', new Date());

            gtag('config', 'UA-50750921-19');
        </script>



        <script src="resources/js/morioh.js"></script>


</body>

</html>