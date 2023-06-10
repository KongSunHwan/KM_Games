 <%@ page import="ac.kmgames.model.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    User user = null;
    Object obj = session.getAttribute("user");
    if(obj instanceof User){
        user = (User) obj;
    }
    pageContext.setAttribute("user", user);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
    <style>
        .card{
            -webkit-transition: all .4s ease;
            -moz-transition: all .4s ease;
            -ms-transition: all .4s ease;
            -o-transition: all .4s ease;
            transition: all .4s ease;
            vertical-align: middle;
        }

        .card:hover{
            cursor: pointer;
            transform: scale(1.12);
            -o-transform:scale(1.12); /* Opera */
            -ms-transform: scale(1.12); /* IE 9 */
            -moz-transform:scale(1.12); /* Firefox */
            -webkit-transform:scale(1.12); /* Safari and Chrome */
        }
    </style>
    <link rel="icon" href="/resources/icon/KM_GAMES_logo_icon.png" />
</head>
<body>
    <jsp:include page="include/header.jsp"></jsp:include>
    <main>
        <div class="d-flex justify-content-center bg-secondary">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true" style="width: 1000px;">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/resources/img/gameimg1.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/resources/img/gameimg2.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/resources/img/gameimg3.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </main>
    <br>
    <!-- 카드컨테이너시작 -->
    <div class="container">
        <c:choose>
            <c:when test="${empty user}">
            </c:when>
            <c:otherwise>
                <h2>${user.getName()} 님 환영합니다!</h2>
            </c:otherwise>
        </c:choose>
        <br>
        <div class="text-info" style="margin-bottom: 10px;">#인기있는 게임</div>
        <div class="row g-0">
            <c:forEach var="game" items="${game_list}">
                <div class="col-2" style="padding-right: 1rem">
                    <div class="card" style="height: 300px;" onclick="location.href='${game.url}'">
                        <img src="/resources/img/game/${game.imageUrl}" class="card-img-top" alt="${game.name}">
                        <div class="card-body">
                            <p class="card-text fw-bold">${game.name}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <c:choose>
                <c:when test="${empty user}">
                    <!-- 로그인 상태가 아니라면 -->
                    <div class="col-4" style="border: 1px solid black; padding: 6rem 1.8rem">
                        <div class="d-grid gap-2 align-content-center text-center">
                            <button class="btn btn-lg btn-dark p-3 fw-bold" onclick="location.href='/login'">KM 로그인</button>
                            <div class="d-flex justify-content-between">
                                <a href="/login" class="m-1 link-secondary" style="text-decoration: none;">비밀번호 찾기 </a>
                                <a href="/register" class="m-1 link-secondary" style="text-decoration: none;">회원가입</a>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- 로그인 상태라면 -->
                    <div class="col-4 p-4" style="border: 1px solid black">
                        <div class="d-grid gap-2">
                            <button class="btn btn-primary" onclick="location.href='/my_info'">내정보</button>
                            <button class="btn btn-primary" >쿠폰함</button>
                            <button class="btn btn-primary" onclick="location.href='/logout'">로그아웃</button>
                            <div class="d-flex justify-content-between" style="font-size:20px;">
                                <div><b>KM 캐시: </b></div>
                                <div class="fw-bold">${user.cash}</div>
                            </div>
                            <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#purchaseCash">캐시 충전</button>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <!-- 카드컨테이너종료 -->
    
      <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <jsp:include page="include/cash_modal.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</body>
</html>