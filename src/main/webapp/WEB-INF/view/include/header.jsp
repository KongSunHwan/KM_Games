<%@ page import="ac.kmgames.model.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    User user = null;
    Object obj = session.getAttribute("user");
    if(obj instanceof User){
        user = (User) obj;
    }
    pageContext.setAttribute("user", user);
%>
<header class="p-6 mb-3 border-bottom">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/home" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                <img src="/resources/img/KM_GAMES_logo.png" style="width: 120px; height: 120px; margin-top: -10px;">
            </a>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-4 link-dark">
                    <i class="bi bi-grid-3x3-gap-fill"></i>&nbsp;전체게임
                </a></li>
                <li><a href="/shop" class="nav-link px-4 link-dark">캐시 상점</a></li>
                <li><a href="/qna" class="nav-link px-4 link-dark">Q&A</a></li>
                <li><a href="/support" class="nav-link px-4 link-dark">고객지원</a></li>
            </ul>

            <div class="dropdown text-end">
                <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown"
                   aria-expanded="false">
                    <img src="/resources/img/user.png" alt="user" width="32" height="32" class="rounded-circle">
                    <c:choose>
                        <c:when test="${empty user}">
                            <span class="fs-6">비회원</span>
                        </c:when>
                        <c:otherwise>
                            <span class="fs-6">${user.getName()}</span>
                        </c:otherwise>
                    </c:choose>
                </a>
                <ul class="dropdown-menu text-small">
                <c:choose>
                    <c:when test="${empty user}">
                        <li>
                            <a class="dropdown-item" href="/login"><i class="bi bi-box-arrow-left"></i> 로그인</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a class="dropdown-item" href="/my_info"><i class="bi bi-house-fill"></i> 마이페이지</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/wip"><i class="bi bi-cash-coin"></i> 캐시 충전</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/cash_history"><i class="bi bi-cash-coin"></i> 충전 내역</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/payment_history"><i class="bi bi-cart-check"></i> 결제 내역</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/logout"><i class="bi bi-box-arrow-left"></i> 로그아웃</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                </ul>
            </div>
        </div>
    </div>
</header>