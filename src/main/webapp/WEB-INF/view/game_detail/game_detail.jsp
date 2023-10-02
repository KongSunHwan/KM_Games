<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>게임 상세</title>
  <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />
  <script src="https://kit.fontawesome.com/0bca6ce86d.js" crossorigin="anonymous">
  </script>

  <link rel="stylesheet" href="resources/css/footer.css" />
  <link rel="stylesheet" href="resources/css/evaluation.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>

<jsp:include page="../include/header.jsp"></jsp:include>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
    <div class="col-md-8 p-lg-4 mx-auto">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
            aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
            aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
            aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="resources/img/game/game_img1.jpg" class="d-block w-100" alt="..." style="width: 500px; height: 600px;">
        </div>
        <div class="carousel-item">
            <img src="resources/img/game/game_img1.jpg" class="d-block w-100" alt="..." style="width: 500px; height: 600px;">
        </div>
        <div class="carousel-item">
            <img src="resources/img/game/game_img1.jpg" class="d-block w-100" alt="..." style="width: 500px; height: 600px;">
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
    <div class="product-device shadow-sm d-none d-md-block"></div>
    <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
</div>
<div>
    <div class="row">
    <div class="col-1"></div>
    <div class="col-7">
        <div class="rounded-3" style="height: 80px; background-color:rgb(71, 133, 240);">
        <div class="text-center fw-bolder" style="color: white; padding-top: 10px;">게임을 소개하자면?<br>
            ⭐ 다이나믹한 슈팅게임 입니다. ⭐
        </div>
        </div>
        <br>
        <ul style="list-style-type: none;">
        <!-- 최근 이벤트 및 공지 시작 -->
        <h2><b>최근 이벤트 및 공지</b></h2>
        <hr>
        <br><br>
        <li>
            <h5>
            <div class="d-flex">
                <div class="row row-cols-1 row-cols-md-3 g-4">

                <div class="col">
                    <div class="card h-100">
                    <img src="resources/img/game/game_img1.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">GM과 함께하는 데스매치 이벤트</h5>
                        <p class="card-text text-secondary">2023년 9월 5일 (화)</p>
                    </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card h-100">
                    <img src="resources/img/game/game_img1.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">GM과 함께하는 데스매치 이벤트</h5>
                        <p class="card-text text-secondary">2023년 9월 5일 (화)</p>
                    </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card h-100">
                    <img src="resources/img/game/game_img1.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">GM과 함께하는 데스매치 이벤트</h5>
                        <p class="card-text text-secondary">2023년 9월 5일 (화)</p>
                    </div>
                    </div>
                </div>

                </div>
            </div>
        </li>
        <!-- 최근 이벤트 및 공지 끝 -->

        <br><br><br>

        <!-- 게임정보 시작 -->
        <h2><b>게임에 대해</b></h2>
        <hr>
        <br><br>
        <li>

            <div class="card text-bg-dark">
            <img src="resources/img/game/game_img1.jpg" class="card-img" alt="...">
            <div class="card-img-overlay">
                <h5 class="card-title text-center">현실감 있는 FPS</h5>
                <p class="card-text text-center">출시 당시 개척한 팀 기반 액션 게임플레이의 수준을 한층 더 끌어올렸습니다..</p>
                <p class="card-text text-center"><small>새 맵, 캐릭터, 무기 및 게임 모드를 도입했고, 기존의 클래식 CS
                    콘텐츠(de_dust2
                    등)의 개선된 버전을
                    제공합니다.</small></p>
            </div>
            </div>

            <br><br><br>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">게임 제목</div>
                <div class="justify-content-center fs-6" style="margin-left: 50px;"><b>FPS 레전드</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">게임 장르</div>
                <div class="justify-content-center fs-6" style="margin-left: 50px;"><b>슈팅 게임</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">개발자</div>
                <div class="justify-content-center fs-6" style="margin-left: 70px;"><b>KM_GAMES</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">배급사</div>
                <div class="justify-content-center fs-6" style="margin-left: 70px;"><b>경민대학교</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">프랜차이즈</div>
                <div class="justify-content-center fs-6" style="margin-left: 40px;"><b>경민</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">출시일</div>
                <div class="justify-content-center fs-6" style="margin-left: 70px;"><b>2023.09.05</b></div>
            </div>
            <hr>
            </h5>
            <br><br>
            <!-- 상세정보 시작 -->
        <li>

            <div class="card text-dark bg-light mb-3" style="max-width: 60rem;">
            <div class="card-body">
                <h5 class="card-title fw-bolder">게임에 대해 상세 설명</h5>
                <p class="card-text">
                Counter-Strike: Global Offensive(CS: GO)는 19년 전 출시 당시 개척한 팀 기반 액션 게임플레이의 수준을 한층 더 끌어올렸습니다.
                <br>
                CS: GO는 새 맵, 캐릭터, 무기 및 게임 모드를 도입했고, 기존의 클래식 CS 콘텐츠(de_dust2 등)의 개선된 버전을 제공합니다.
                <br>
                <br>
                Valve의 Doug Lombardi는 "그 당시에는 모드였던 Counter-Strike가 1999년 8월에 처음 나오자마자 전 세계에서 가장 많이 플레이된 온라인 PC 액션 게임의
                자리를 꿰차면서 게임 업계의 감탄을 이끌어냈던 것을 기억합니다."라며
                <br>
                <br> "지난 12년간, CS: GO 시리즈는 전 세계적으로 2,500만 장 이상이 판매됐고, 대대적인 경쟁률을 보인
                토너먼트가 개최되는 등 전 세계적으로 가장 많이 플레이된 게임 중 하나의 자리를 굳건히 지켜왔습니다.
                <br>
                CS: GO는 오리지널 CS가 자랑하는, 상까지 받은 게임플레이 방식을 한 단계
                <br>
                발전시키고, Mac과 PC뿐만 아니라 차세대 콘솔 게임기를 이용하는 모든 게이머에게 이 향상된 게임플레이를 제공할 것입니다."라고 말했습니다.
                </p>
            </div>
            </div>

        </li>
        <!-- 상세정보 끝 -->

        </li>
        <!-- 게임정보 끝 -->

        <br><br><br><br><br><br><br><br>
        <!-- 시스템 요구사항 시작 -->
        <li>
            <h2><b>시스템 요구사항 (최소사양)</b></h2>
            <hr>
            <br>
            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">운영체제</div>
                <div class="justify-content-center fs-6" style="margin-left: 50px;"><b>Windows® 7/Vista/XP</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">프로세스</div>
                <div class="justify-content-center fs-6" style="margin-left: 50px;"><b>Intel® Core™ 2 Duo E6600 또는 AMD
                    Phenom™ X3 8750</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">메모리</div>
                <div class="justify-content-center fs-6" style="margin-left: 67px;"><b>2 GB RAM</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">그래픽</div>
                <div class="justify-content-center fs-6" style="margin-left: 67px;"><b>비디오 카드는 256MB 이상에 DirectX 9와 호환
                    가능해야 하며 Pixel Shader 3.0을 지원해야 합니다.</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">DirectX</div>
                <div class="justify-content-center fs-6" style="margin-left: 63px;"><b>버전 9.0c</b></div>
            </div>
            <hr>
            </h5>

            <h5>
            <div class="d-flex">
                <div class="fs-6 justify-content-start">저장공간</div>
                <div class="justify-content-center fs-6" style="margin-left: 50px;"><b>15 GB 사용 가능 공간</b></div>
            </div>
            <hr>
            </h5>

        </li>
        <!-- 시스템 요구사항 끝 -->
        <br><br><br>
        </ul>
        <!-- 총평리뷰 시작 -->
        <hr>
        <div>
        <h4><b>총 평점</b></h2>
        </div>

        <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
            <div class="col-md-4">
            <div style="margin-top: 60px;">
                <div class="fs-1 fw-bolder" style="text-align: center;">${average_rate}
                <div class="fs-5">&#x2B50&#x2B50&#x2B50&#x2B50&#x2B50</div>
                <div class="fs-6">${review_count}개의 평가</div>
                </div>
            </div>
            </div>
            <div class="col-md-8">
            <div class="card-body" style="margin-top: 5px;">
                <div class="card-text">5점
                <div class="progress">
                    <div class="progress-bar" style="width: 95%;">
                    </div>
                </div>
                </div>
                <div class="card-text">4점
                <div class="progress">
                    <div class="progress-bar" style="width: 5%;">
                    </div>
                </div>
                </div>

                <div class="card-text">3점
                <div class="progress">
                    <div class="progress-bar" style="width: 0%;">
                    </div>
                </div>
                </div>
                <div class="card-text">2점
                <div class="progress">
                    <div class="progress-bar" style="width: 0%;">
                    </div>
                </div>
                </div>
                <div class="card-text">1점
                <div class="progress">
                    <div class="progress-bar" style="width: 0%;">
                    </div>
                </div>
                </div>
            </div>
            </div>
        </div>
        </div>

        <div class="card mb-2">
        <div class="card-header bg-light">
            <i class="fa fa-comment fa"></i>&nbsp;리뷰 남기기
        </div>
        <div class="card-body">
            <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <div class="form-inline mb-2">

                </div>
                <form name="myform" id="myform" method="#" action="#">
                <fieldset>
                    <legend>별점을 선택해주세요</legend>
                    <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
                    <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
                    <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
                    <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
                    <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
                </fieldset>
                </form>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                <button type="button" class="btn btn-dark mt-3">등록</button>
            </li>
            </ul>
        </div>
        </div>

        <hr>

        <div class="card mb-2">
        <div class="card-header bg-light">
            <i class="fa fa-comment fa"></i> 리뷰 목록
        </div>
        <div class="card-body">
            <ul class="list-group list-group-flush">
                <c:forEach var="review" items="${review_list}" varStatus="status">
                    <li class="list-group-item">
                        <div class="form-inline mb-2">
                            <label for="replyId" class="fw-bolder">
                                <i class="fa fa-user-circle-o fa-2x"></i>
                                <span style="color:gray;">&nbsp; ${review.user.nickname}</span>
                                <div class="fs-6">&#x2B50&#x2B50&#x2B50&#x2B50&#x2B50</div>
                            </label>
                        </div>
                        <div class="fw-bolder">${review.comment}</div>
                        <div class="fw-bolder" style="color:gray; padding-top: 10px;">${fn:substringBefore(review.date, ".0")}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        </div>
        <!-- 총평리뷰 끝 -->

    </div>
    <div class="col">
        <div class="rounded-3"
        style="width: 400px; padding: 10px 10px; position: -webkit-sticky; position: sticky; top: 50px; text-align: center; margin-top: 50px; border: 1px solid rgb(194, 193, 193); box-shadow:2px 3px 5px 0px;">
        <div>
            <h4>FPS 레전드</h4>
        </div>
        <button type="button" style="width: 200px; margin-top: 10px;" class="btn btn-primary" onclick="location.href='/order_detail'">게임 구매</button>
        <div style="margin-top: 10px;">
            <button type="button" style="width: 200px;" class="btn btn-outline-secondary">장바구니 추가</button>
        </div>
        <hr>
        <div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item"><i class="bi bi-chat-heart"></i> 최근평가 : <b>매우 긍정적</b><span
                class="text-secondary"> (92,100)</span></li>
            <li class="list-group-item"><i class="bi bi-chat-square-heart"></i> 모든평가 : <b>매우 긍정적</b><span
                class="text-secondary"> (92,100)</span></li>
            <li class="list-group-item"><i class="bi bi-controller"></i> 게임종류 : <b>슈팅게임</b></li>
            <li class="list-group-item"><i class="bi bi-chat-text-fill"></i>개발자 : <b>KM_GAMES</b></li>
            <li class="list-group-item"><i class="bi bi-cash-coin"></i> 가격 : <b>30,000원</b></li>
            </ul>
        </div>
        </div>
    </div>
    </div>
    <!--첫번째 줄-->
    <!-- FOOTER -->


    <!--컨테이너-->
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