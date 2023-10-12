<%@ page import="ac.kmgames.model.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%--%>
<%--    User user = null;--%>
<%--    Object obj = session.getAttribute("user");--%>
<%--    if(obj instanceof User){--%>
<%--        user = (User) obj;--%>
<%--    }--%>
<%--    pageContext.setAttribute("user", user);--%>
<%--%>--%>
<div class="main-navbar navbar-expand-md navbar-light bg-white fixed-top shadow-sm">

    <button class="btn d-md-none" type="button" data-toggle="collapse" data-target="#main-menu"
            aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
    </button>


    <img src="resources/img/KM_GAMES_logo_admin" title="Morioh" class="navbar-logo d-md-none" style="height: 36px;">


    <button class="btn d-md-none" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto hidden-sm-down">

            <li class="nav-item mr-5">
                <a href="javascript://" class="nav-icon font-2xl" id="navbar-toggler">

                    <i class="mdi mdi-menu"></i>
                </a>
            </li>
        </ul>


        <ul class="navbar-nav my-2 my-lg-0">

            <li class="nav-item mr-10 dropdown">
                <a href="#" class="nav-icon avatar rounded-circle" id="PJXN7R" role="button"
                   data-toggle="dropdown" aria-expanded="false">
                    <i class="mdi mdi-account"></i>
                </a>

                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="PJXN7R">
                    <a class="dropdown-item" href="#">
                        <i class="mdi mdi-account-circle-outline"></i>내 정보</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#"><i class="mdi mdi-exit-to-app"></i>로그아웃</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-icon font-2xl rounded-circle" href="#" id="WJIK6R" role="button"
                   data-toggle="dropdown" aria-expanded="false">

                    <i class="mdi mdi-dots-horizontal"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="WJIK6R">
                    <a class="dropdown-item" href="#">회원페이지 이동</a>
                </div>
            </li>
        </ul>

    </div>
</div>

<div class="menubar menubar-dark" id="main-menu">

    <div class="menubar-header text-center bg-dark">
        <a class="menubar-brand" href="#">
            <img src="resources/img/KM_GAMES_logo_admin.png" title="KM_Games" class="menubar-logo" style="height: 100px;">
        </a>
    </div>

    <div class="menubar-body">
        <ul class="menu accordion">
            <li class="menu-item">
                <a href="javascript://" class="menu-link" data-toggle="collapse" data-target="#menu-90ba1a"
                   aria-expanded="true" aria-controls="menu-90ba1a">
                    <i class="menu-icon mdi mdi-account-group"></i>
                    <span class="menu-label">회원 정보</span>
                    <i class="menu-arrow mdi mdi-chevron-right"></i>
                </a>

                <ul class="menu collapse" data-parent="#main-menu" id="menu-90ba1a">
                    <li class="menu-item">
                        <a href="/member_searchs" class="menu-link">
                            <i class="menu-icon mdi mdi-account-search"></i>
                            <span class="menu-label">회원 관리</span>
                        </a>
                    </li>

<%--                    <li class="menu-item">--%>
<%--                        <a href="/member_stop" class="menu-link">--%>
<%--                            <i class="menu-icon mdi mdi-account-edit"></i>--%>
<%--                            <span class="menu-label">회원 정지</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>

<%--                    <li class="menu-item">--%>
<%--                        <a href="/member_withdrawal" class="menu-link">--%>
<%--                            <i class="menu-icon mdi mdi-account-remove"></i>--%>
<%--                            <span class="menu-label">회원 탈퇴</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>

<%--                    <li class="menu-item">--%>
<%--                        <a href="/member_manag_information" class="menu-link">--%>
<%--                            <i class="menu-icon mdi mdi-account-remove"></i>--%>
<%--                            <span class="menu-label">회원 수정</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>
                </ul>

            </li>

            <li class="menu-item">
                <a href="javascript:void(0)" class="menu-link" data-toggle="collapse" data-target="#menu-1fc88e"
                   aria-expanded="true" aria-controls="menu-1fc88e">
                    <i class="menu-icon mdi mdi-view-split-vertical"></i>
                    <span class="menu-label">주문 관리</span>
                    <i class="menu-arrow mdi mdi-chevron-right"></i>
                </a>
                <ul class="menu collapse" data-parent="#main-menu" id="menu-1fc88e">


                    <li class="menu-item">
                        <a href="/member_order" class="menu-link">
                            <i class="menu-icon mdi mdi-format-list-bulleted-square"></i>
                            <span class="menu-label">회원 별 주문 내역</span>
                        </a>
                    </li>

                </ul>
            </li>

            <li class="menu-item">
                <a href="javascript://" class="menu-link" data-toggle="collapse" data-target="#menu-96b24e"
                   aria-expanded="true" aria-controls="menu-96b24e">
                    <i class="menu-icon mdi mdi-format-float-left"></i>
                    <span class="menu-label">게임 관리</span>
                    <i class="menu-arrow mdi mdi-chevron-right"></i>
                </a>

                <ul class="menu collapse" data-parent="#main-menu" id="menu-96b24e">

                    <li class="menu-item">
                        <a href="/game_management" class="menu-link">
                            <i class="menu-icon mdi mdi-file-document-edit-outline"></i>
                            <span class="menu-label">게임 운영</span>
                        </a>
                    </li>

                    <li class="menu-item">
                        <a href="/game_statistics" class="menu-link">
                            <i class="menu-icon mdi mdi-file-document-edit-outline"></i>
                            <span class="menu-label">구매 통계</span>
                        </a>
                    </li>

                    <li class="menu-item">
                        <a href="/game_review" class="menu-link">
                            <i class="menu-icon mdi mdi-file-document-edit-outline"></i>
                            <span class="menu-label">리뷰 관리</span>
                        </a>
                    </li>

                </ul>
            </li>

            <li class="menu-item">
                <a href="#" class="menu-link" data-toggle="collapse" data-target="#menu-62d0a7"
                   aria-expanded="true" aria-controls="menu-62d0a7">
                    <i class="menu-icon mdi mdi-chart-timeline"></i>

                    <span class="menu-label">수익 관리</span>
                    <i class="menu-arrow mdi mdi-chevron-right"></i>
                </a>

                <ul class="menu collapse" data-parent="#main-menu" id="menu-62d0a7">

                    <li class="menu-item">
                        <a href="/monthly_sales" class="menu-link">
                            <i class="menu-icon mdi mdi-monitor-multiple"></i>
                            <span class="menu-label">월 별 판매량</span>
                        </a>
                    </li>

                    <li class="menu-item">
                        <a href="/monthly_refund" class="menu-link">
                            <i class="menu-icon mdi mdi-monitor-multiple"></i>
                            <span class="menu-label">월 별 환불량</span>
                        </a>
                    </li>

                </ul>
            </li>

        </ul>
    </div>

    <div class="menubar-footer bg-dark p-10">
        <a href="#" class="d-block text-truncate">&copy KMGames <span id="version"></span></a>
    </div>

</div>