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
</head>
<body>
    <jsp:include page="header/header.jsp"></jsp:include>
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
        <h2>추천게임</h2> <br>
        <div class="text-info" style="margin-bottom: 10px;">#인기있는 게임</div>
        <div class="row">
            <div class="col">
                <div class="card" style=" height: 350px;">
                    <a href="https://kartrush.nexon.com/2023/event_230303-launching">
                        <img src="/resources/img/kart.png" class="card-img-top" alt="카트라이더사진" style="width:100% ;"></a>
                    <div class="card-body">
                        <p class="card-text">카트라이더 </p>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="card" style="height: 350px;">
                    <a href="https://kartrush.nexon.com/2023/event_230303-launching">
                        <img src="/resources/img/kart.png" class="card-img-top" alt="카트라이더사진"></a>
                    <div class="card-body">
                        <p class="card-text">카트라이더 </p>
                    </div>
                </div>
            </div>


            <div class="col">
                <div class="card" style="height: 350px;">
                    <a href="https://kartrush.nexon.com/2023/event_230303-launching">
                        <img src="/resources/img/kart.png" class="card-img-top" alt="카트라이더사진"></a>
                    <div class="card-body">
                        <p class="card-text">카트라이더 </p>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="card" style="height: 350px;">
                    <a href="https://kartrush.nexon.com/2023/event_230303-launching">
                        <img src="/resources/img/kart.png" class="card-img-top" alt="카트라이더사진"></a>
                    <div class="card-body">
                        <p class="card-text">카트라이더 </p>
                    </div>
                </div>
            </div>

            <c:choose>
                <c:when test="${empty user}">
                    <!-- 로그인 상태가 아니라면 -->
                    <div class="col-5">
                        <!-- <div style="width:100%; height: 350px; border: 1px solid black;">
                            <div class="text-center">로그인</div>
                            <div class="d-flex">
                            <div>id찾기</div>
                            <div>pw찾기</div>
                            <div>회원가입</div>
                        </div> -->
                        <div style="width:470px; height: 350px; border: 1px solid black; font-size: 15px; font-weight: bold;">
                            <div style="width:350px; height:60px; background-color: black; color:aliceblue; display: flex; align-items: center; justify-content: center; margin-left: 13%; margin-top: 10%;">
                                <a>
                                    <div>KM GAMES 로그인</div>
                                </a>
                            </div>
                            <div class="d-flex">
                                <div style="width:174px; height:60px; background-color: black; color:aliceblue; margin-left: 13%;  margin-top:10px; display: flex; align-items: center; justify-content: center;">
                                    <a><div>KM ID 찾기</div></a>
                                </div>
                                <div style="width:174px; height:60px; background-color: black; color:aliceblue; margin-left: 1px; margin-top:10px; display: flex; align-items: center; justify-content: center;">
                                    <a><div>비밀번호 찾기</div></a>
                                </div>
                            </div>
                            <div style="width:350px; height:60px; background-color: black; color:aliceblue; display: flex; align-items: center; justify-content: center; margin-left: 13%; margin-top: 10px;">
                                <a><div>회원가입</div></a>
                            </div>
                            <div class="d-flex">
                                <div style="margin:auto; margin-top: 10px; font-style: italic;">아이디 찾기</div>
                                <div style="margin:auto; margin-top: 10px; font-style: italic;">비밀번호 찾기</div>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- 로그인 상태라면 -->
                    <div class="col-4">
                        <div style="width: 100%; height: 100%; border: 1px solid black; font-size: 15px;">
                            <div class="d-flex flex-row" style="margin-left: 50px; margin-top: 30px; font-size: 20px;">
                                <div>내정보</div>
                                <div style="padding-left:10%">쿠폰함</div>
                                <div style="padding-left:10%;">로그아웃</div>
                            </div>
                            <div>
                                <div style="padding-left: 50px; padding-top:25px;">
                                    <div class="d-flex flex-row"
                                         style="width: 100%; height: 175px; font-size:20px;">
                                        <div>넥슨 캐시</div>
                                        <div style="margin-left: 30px;">222</div>
                                    </div>

                                </div>
                            </div>
                            <div class="d-flex justify-content-center">
                                <button type="button" class="btn btn-secondary" style="width: 200px;">충전</button>
                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <!-- 카드컨테이너종료 -->
    <jsp:include page="footer/footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</body>
</html>