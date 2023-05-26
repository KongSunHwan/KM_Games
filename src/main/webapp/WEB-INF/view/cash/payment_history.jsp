<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="ac.kmgames.model.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    User user;
    Object obj = session.getAttribute("user");
    if(!(obj instanceof User)){
        out.println(
            "<script>" +
                "alert('로그인 후 이용해주세요');" +
                "location.href = '/login';" +
            "</script>"
        );
        return;
    }
    user = (User) obj;
    pageContext.setAttribute("user", user);

    int startPage;
    int currentPage = (int) request.getAttribute("current_page");
    pageContext.setAttribute("start_page", startPage = ((currentPage - 1) / 5) * 5 + 1);
    pageContext.setAttribute("end_page", Math.min(startPage + 4, (int) request.getAttribute("page_count")));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 정보</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body>
    <div class="b-example-divider b-example-vr"></div>
    <div style="width: 100%;">
        <div class="flex-shrink-0 p-3" style="width: 280px; float: left; height: 100%;">
            <a href="/" class="d-flex align-items-center pb-3 mb-3 link-body-emphasis text-decoration-none border-bottom">
                <svg class="bi pe-none me-2" width="30" height="24">
                    <use xlink:href="#bootstrap" />
                </svg>
                <span class="fs-5 fw-semibold"> KMGames
            </span>
            </a>
            <ul class="list-unstyled ps-0">
                <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                            data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
                        내정보
                    </button>
                    <div class="collapse show" id="home-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">사용내역</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">캐시 충전 내역</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">비밀번호 재설정</a></li>
                        </ul>
                    </div>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                            data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
                        목록1
                    </button>
                    <div class="collapse" id="dashboard-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                        </ul>
                    </div>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                            data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
                        목록1
                    </button>
                    <div class="collapse" id="orders-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                        </ul>
                    </div>
                </li>
                <li class="border-top my-3"></li>
                <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                            data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
                        목록1
                    </button>
                    <div class="collapse" id="account-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">목록1-1</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

        <div style="height: 100%; padding: 40px; padding-left: 300px;">
            <div class="bd-example-snippet bd-code-snippet">
                <div class="bd-example">
                    <blockquote class="blockquote">
                        <p>KM 캐시 이용 내역</p>
                        <footer class="blockquote-footer">현재 보유중인 KM캐시
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-caret-right-fill" viewBox="0 0 16 16">
                                <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z" />
                            </svg>
                            <cite title="Source Title">${user.cash} 캐시</cite>
                        </footer>
                    </blockquote>
                </div>
            </div>
            <br>
            <br>
            <blockquote class="blockquote">
                <p>사용내역</p>
            </blockquote>
            <div>
                <table class="table">
                    <tr>
                        <th scope="col">순번</th>
                        <th scope="col">구매 내역</th>
                        <th scope="col">사용 금액</th>
                        <th scope="col">구매 날짜</th>
                    </tr>
                    <c:forEach var="payment" items="${payment_history}" varStatus="status">
                        <tr>
                            <td class="fw-bold">${(current_page - 1) * 10 + status.index + 1}</td>
                            <td>${payment.item.name}</td>
                            <td>${payment.item.price}캐시</td>
                            <td>${fn:substringBefore(payment.date, ".0")}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination" style="text-align: center;">
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
            </nav>
        </div>
    </div>
</body>
</html>