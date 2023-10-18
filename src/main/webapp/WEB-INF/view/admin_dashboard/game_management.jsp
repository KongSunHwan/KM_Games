<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    int currentPage = (int) request.getAttribute("current_page");
    int startPage = ((currentPage - 1) / 5) * 5 + 1;
    pageContext.setAttribute("start_page", startPage);
    pageContext.setAttribute("end_page", Math.min(startPage + 4, (long) request.getAttribute("game_page")));
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

    <meta property="og:title" content="Morioh Responsive Template with Bootstrap 4, HTML5 and Vue.js">
    <meta property="og:image" content="resources/img/KM_GAMES_logo_icon">
    <meta property="og:description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta property="og:image:width" content="1280">
    <meta property="og:image:height" content="720">

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />

    <title>관리자 페이지</title>
    <meta itemprop="description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta itemprop="image" content="resources/img/KM_GAMES_logo_icon">

    <meta name="description" content="Morioh Theme is Bootstrap responsive template free download">
    <meta name="image" content="resources/img/KM_GAMES_logo_icon">


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
                    <h4 class="card-title"><b>게임 운영 관리</b></h4>
                    <div class="row">
                        <div class="col-12">
                            <div class="col-12">
                                <div class="row no-gutters">
                                    <div class="col-12">
                                        <div class="card-body">
                                            <form class="form-inline" action="/game_management">
                                                <div class="input-group">
                                                    <input class="form-control" type="text" name="keyword"
                                                           placeholder="게임 이름으로 검색이 가능합니다." aria-label="Search">
                                                    <button class="btn btn-outline-primary" type="submit">
                                                        <i class="fas fa-search"></i>
                                                    </button>
                                                </div>
                                            </form>

                                            <br>

                                            <c:forEach var="game" items="${game_list}" varStatus="status">
                                                <c:if test="${status.index % 4 == 0}">
                                                    <div class="row" style="margin-top:10px;">
                                                </c:if>
                                                <div class="card-back mb-2 col-lg-3" style="cursor:pointer;">

                                                    <div class="card-img">
                                                        <img src="/resources/img/game/${game.thumbUrl}" style="width: 230px; height:150px;" onerror="this.onerror=null; this.src='/resources/img/game/wip.png';"  onclick="location.href = '/game_manage?id=${game.id}'">
                                                    </div>

                                                    <div class="card-title">
                                                        <div class="fw-bold fs-5">${game.name}</div>
                                                    </div>

                                                </div>
                                                <c:if test="${status.index % 4 == 3}">
                                                    </div>
                                                </c:if>
                                            </c:forEach>


                                        </div>
                                        <ul class="pagination mt-2" style="justify-content : center;">
                                            <c:if test="${current_page > 5}">
                                                <li class="page-item"><a class="page-link" href="?page=${start_page - 1}">Prev</a></li>
                                            </c:if>
                                            <c:forEach var="item" begin="${start_page}" end="${end_page}">
                                                <c:choose>
                                                    <c:when test="${item == current_page}">
                                                        <li class="page-item"><a class="page-link disabled" href="#">${item}</a></li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li class="page-item"><a class="page-link" href="?page=${item}">${item}</a></li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            <c:if test="${page_count - start_page > 5}">
                                                <li class="page-item"><a class="page-link" href="?page=${end_page+ 1}">Next</a></li>
                                            </c:if>
                                        </ul>
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