<%@ page import="ac.kmgames.model.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    int currentPage = (int) request.getAttribute("current_page");
    int startPage = ((currentPage - 1) / 5) * 5 + 1;
    pageContext.setAttribute("start_page", startPage);
    pageContext.setAttribute("end_page", Math.min(startPage + 4, (long) request.getAttribute("game_page")));
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="resources/css/footer.css" />
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />
    <title>메인 페이지</title>
</head>
<body>
<jsp:include page="../include/header.jsp"></jsp:include>
    <div class="container">
        <div class="row">

            <div class="col-lg-3" style=" max-width: 240px;">
                <div class="accordion" id="accordionPanelsStayOpenExample">

                    <div class="accordion-item">
                        <button type="button" class="btn"
                            style="width:214px; height:52px; text-align: left; padding:16px 20px;">전체 찜목록</button>
                    </div>

                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingOne">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseOne">
                                액션
                            </button>
                        </h2>

                        <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse"
                            aria-labelledby="panelsStayOpen-headingOne">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">1인칭 슈팅</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">3인칭 슈팅</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">격투 및 무술</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">숏뎀업</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">아케이드 및 리듬</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">플랫폼 게임 및 러너</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">핵 앤 슬래시 게임</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">어드벤처</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">메트로배니아</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">비주얼 노벨</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">어드벤처 RPG</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">캐주얼</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">퍼즐</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">풍부한 스토리</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">히든 오브젝트</li>
                            </ul>
                        </div>

                    </div>

                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingTwo">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseTwo">
                                특별 세선
                            </button>
                        </h2>

                        <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse"
                            aria-labelledby="panelsStayOpen-headingTwo">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">무료</li>
                                <li class="list-group-item list-group-item-action" name="category"
                                    style="cursor:pointer">체험판</li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>

            <div class="col" style="margin-right: 10px; min-height: 818px;">
                <div class="row py-2">
                    <div class="col-lg-8"></div>
                    <form>
                        <div class="input-group col-lg-4 mt-2" style="width:350px">
                            <select name="keyWord">
                                <option value="#">제목</option>
                                <option value="#">태그</option>
                            </select>
                            <input type="text" class=" form-control" name="searchWord">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit">검색</button>
                            </span>
                        </div>
                    </form>
                </div>

                <div>
                    <hr style="margin:5px 0px;">
                    <div style="font-weight:bold; font-size:20px;">전체 목록</div>

                    <select class="form-select form-select-sm mt-2" style="width: 100px;"
                        aria-label=".form-select-sm example">
                        <option selected>정렬</option>
                        <option value="1">인기순</option>
                        <option value="2">최신순</option>
                        <option value="3">가격순</option>
                    </select>
                </div>

                <c:forEach var="game" items="${game_list}" varStatus="status">
                    <c:if test="${status.index % 4 == 0}">
                        <div class="row" style="margin-top:10px;">
                    </c:if>
                    <div class="card-back mb-2 col-lg-3" style="cursor:pointer;" onclick="location.href = '/game_detail?id=${game.id}'">
                        <div class="card-img">
                            <img src="/resources/img/game/${game.thumbUrl}" style="width: 230px; height:150px;" onerror="this.onerror=null; this.src='/resources/img/game/wip.png';">
                        </div>
                        <!--div class="card-teacher">
                            <b class="text-muted" style="font-size: 13px;">${game.genre}</b>
                        </div>-->
                        <div class="card-title">
                            <div class="fw-bold fs-5">${game.name}</div>
                        </div>
                        <!--div class="card-text">
                            <c:choose>
                                <c:when test="${game.age < 1}">
                                    <b style="font-size: 12px;">전체이용가</b>
                                </c:when>
                                <c:otherwise>
                                    <b style="font-size: 12px;">${game.age}세 이상</b>
                                </c:otherwise>
                            </c:choose>
                        </div>-->
                        <div class="card-text2">
                            <b style="font-size: 17px;">${game.price}원</b>
                        </div>
                        <div class="card-text2">&#x2B50&#x2B50&#x2B50&#x2B50&#x2B50 (48)</div>
                    </div>
                    <c:if test="${status.index % 4 == 3}">
                        </div>
                    </c:if>
                </c:forEach>

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
    <!--컨테이너종료-->
    </div>

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