<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

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

    <meta property="og:title" content="Morioh Responsive Template with Bootstrap 4, HTML5 and Vue.js">
    <meta property="og:image" content="resources/img/KM_GAMES_logo_icon">
    <meta property="og:description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta property="og:image:width" content="1280">
    <meta property="og:image:height" content="720">


    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />

    <title>관리자 페이지</title>
    <meta itemprop="description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta itemprop="image" content="resources/css/morioh.css_icon.png">

    <meta name="description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta name="image" content="resources/css/morioh.css_icon.png">


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/perfect-scrollbar@1.4.0/css/perfect-scrollbar.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font@4.7.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/animate.css@3.7.2/animate.min.css">

    <link rel="stylesheet" href="resources/css/morioh.css">


</head>

<body class="menubar-enabled navbar-top-fixed">

    <div class="wrapper">

        <jsp:include page="../include/admin_header.jsp"></jsp:include>

        <div class="container-fluid mt-15">
            <div class="card mb-15">
                <div class="card-body">
                    <h4 class="card-title"><b>회원 별 리뷰내역</b></h4>
                    <div class="row">
                        <div class="col-12">
                            <div class="col-12">
                                <div class="row no-gutters">
                                    <div class="col-12">
                                        <div class="card-body">
                                            <table class="table text-center">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">리뷰 번호</th>
                                                        <th scope="col">게임 제목</th>
                                                        <th scope="col">회원 이메일</th>
                                                        <th scope="col">회원 리뷰내용</th>
                                                        <th scope="col">평점</th>
                                                        <th scope="col">날짜</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <th scope="row">1</th>
                                                        <td>휴먼 폴 플랫</td>
                                                        <td>tjsghks78@gmail.com</td>
                                                        <td>정말 좋아요!</td>
                                                        <td>&#x2B50&#x2B50&#x2B50&#x2B50&#x2B50 (5.0)</td>
                                                        <td>2023-05-16 AM 11:05</td>
                                                    </tr>

                                                    <tr>
                                                        <th scope="row">1</th>
                                                        <td>휴먼 폴 플랫</td>
                                                        <td>tjsghks78@gmail.com</td>
                                                        <td>정말 좋아요!</td>
                                                        <td>&#x2B50&#x2B50&#x2B50&#x2B50&#x2B50 (5.0)</td>
                                                        <td>2023-05-16 AM 11:05</td>
                                                    </tr>

                                                    <tr>
                                                        <th scope="row">1</th>
                                                        <td>휴먼 폴 플랫</td>
                                                        <td>tjsghks78@gmail.com</td>
                                                        <td>정말 좋아요!</td>
                                                        <td>&#x2B50&#x2B50&#x2B50&#x2B50&#x2B50 (5.0)</td>
                                                        <td>2023-05-16 AM 11:05</td>
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
                        </div>
                    </div>
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