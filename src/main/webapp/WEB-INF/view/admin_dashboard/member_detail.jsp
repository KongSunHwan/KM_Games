<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
//    int currentPage = (int) request.getAttribute("current_page");
//    int startPage = ((currentPage) / 5) * 5 +1;
//    pageContext.setAttribute("start_page", startPage);
//    pageContext.setAttribute("end_page", Math.min(startPage + 4, (long) request.getAttribute("payment_page")));
%>
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

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />


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
    <link rel="stylesheet" href="/css/style.css" />



</head>

<body class="menubar-enabled navbar-top-fixed">

<div class="wrapper">

    <jsp:include page="../include/admin_header.jsp"></jsp:include>

            <!-- header 시작 -->
<%--            <header th:replace="~{header/header}"></header>--%>
            <!-- header 끝 -->


    <div class="container-fluid mt-15">
        <div class="card mb-15">
            <div class="card-body">
                <h4 class="card-title"><b>회원 상세</b></h4>
                <div class="row">
                    <div class="col-12">
                        <div class="col-12">
                            <div class="row no-gutters">
                                <div class="col-12">
                                    <div class="card-body">
                                        <div class="row row-cols-1 row-cols-md-2 g-4">

                                            <div class="col">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h5 class="card-title">회원 정보</h5>
                                                        <br>
                                                        <form>

                                                            <div class="mb-3">
                                                                <label for="emailText" class="form-label">Email</label>
                                                                <input type="text" id="emailText" class="form-control" value="${select_user.email}" disabled>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="name_text" class="form-label">Name</label>
                                                                <input id="name_text" type="text" class="form-control" name="name" value="${select_user.name}" aria-describedby="emailHelp">
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="nickName_text" class="form-label">NickName</label>
                                                                <input type="text" id="nickName_text" class="form-control" value="${select_user.nickname}">
                                                            </div>

                                                            <button type="submit" class="btn btn-primary">수정</button> &nbsp;    <button type="submit" class="btn btn-primary">비밀번호 초기화</button>
                                                        </form>

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h5 class="card-title">구매 내역</h5>
                                                        <table class="table text-center">
                                                            <thead>
                                                            <tr>
                                                                <th scope="col">결제 번호</th>
                                                                <th scope="col">게임</th>
                                                                <th scope="col">장르</th>
                                                                <th scope="col">개발자</th>
                                                                <th scope="col">가격</th>
                                                                <th scope="col">날짜</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <c:forEach var="user_payment" items="${user_payment}" varStatus="status">
                                                            <tr>
                                                                <th scope="row">${user_payment.id}</th>
                                                                <td>${user_payment.game.name}</td>
                                                                <td>${user_payment.game.genre}</td>
                                                                <td>${user_payment.game.developer}</td>
                                                                <td>${user_payment.game.price}원</td>
                                                                <td>${user_payment.date}</td>
                                                            </tr>
                                                            </c:forEach>
                                                            </tbody>
                                                        </table>


                                                        <nav aria-label="Page navigation example">
                                                            <ul class="pagination mt-2" style="justify-content : center;">
<%--                                                                <c:if test="${current_page > 5}">--%>
<%--                                                                    <li class="page-item"><a class="page-link" href="?page=${start_page - 1}">Prev</a></li>--%>
<%--                                                                </c:if>--%>
<%--                                                                <c:forEach var="item" begin="${start_page}" end="${end_page}">--%>
<%--                                                                    <c:choose>--%>
<%--                                                                        <c:when test="${item == current_page}">--%>
<%--                                                                            <li class="page-item"><a class="page-link disabled" href="#">${item}</a></li>--%>
<%--                                                                        </c:when>--%>
<%--                                                                        <c:otherwise>--%>
<%--                                                                            <li class="page-item"><a class="page-link" href="?page=${item}">${item}</a></li>--%>
<%--                                                                        </c:otherwise>--%>
<%--                                                                    </c:choose>--%>
<%--                                                                </c:forEach>--%>
<%--                                                                <c:if test="${page_count - start_page > 5}">--%>
<%--                                                                    <li class="page-item"><a class="page-link" href="?page=${end_page+ 1}">Next</a></li>--%>
<%--                                                                </c:if>--%>
                                                            </ul>
                                                        </nav>
                                                    </div>
                                                </div>
                                            </div>

                                            <br>

                                            <div class="col">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h5 class="card-title">장바구니</h5>

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h5 class="card-title">리뷰 내역</h5>

                                                        <c:forEach var="user_review" items="${user_review}" varStatus="status">

                                                        <div class="card mb-3" style="max-width: 540px;">
                                                            <div class="row g-0">
                                                                <div class="col-md-4">
                                                                    <img src="/resources/img/game/${user_review.game.thumbUrl}" style="width: 150px; height:125px;" onerror="this.onerror=null; this.src='/resources/img/game/wip.png';">
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <div class="card-body">
                                                                        <h5 class="card-title">${user_review.game.name} &nbsp; &#x2B50(${user_review.rate}점)
                                                                       </h5>
                                                                        <p class="card-text">${user_review.comment}</p>
                                                                        <p class="card-text"><small class="text-body-secondary">${user_review.date}</small></p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        </c:forEach>

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