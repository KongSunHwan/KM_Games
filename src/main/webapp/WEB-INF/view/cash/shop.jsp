<%@ page import="ac.kmgames.model.entity.User" %>
<%@ page import="ac.kmgames.model.entity.User" %>
<%@ page import="ac.kmgames.model.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>캐시 상점</title>
</head>

<script>
    function change(num, current, price = 100) {
        var x = document.forms[0];
        var y = Number(x.count.value) + num;
        if (y < 1) y = 1;
        x.count.value = y;

        document.getElementById("subtract_cash").innerText = "-" + price * y;
        document.getElementById("remaining_cash").innerText = "" + (current - price * y);
    }
</script>

<body>
    <jsp:include page="../include/header.jsp"></jsp:include>
     <main>
        <div class="album py-5 bg-body-tertiary">
          <div>
            <h2 style="text-align: center;">웹 상점
          </div>
          <br>
        </div>

        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

            <div class="col">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="resources/img/item1.png" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>100 장기알</title>
                <rect width="100%" height="100%" fill="#55595c" />
                </img>
                <div class="card-body">
                  <p class="card-text" style="text-align: center; font-size: 18px;">&nbsp;<b>100 장기알</b></p>
                  <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;100원</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group" style="margin: auto;">
                      <button type="button" class="btn btn-sm btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">구매</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">상세내용</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="resources/img/item02.png" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>500 장기알</title>
                <rect width="100%" height="100%" fill="#55595c" />
                </img>
                <div class="card-body">
                  <p class="card-text" style="text-align: center; font-size: 18px;">&nbsp;<b>500 장기알</b></p>
                  <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;500원</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group" style="margin: auto;">
                      <button type="button" class="btn btn-sm btn-outline-secondary">구매</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">상세내용</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="resources/img/item03.png" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>1,000 장기알</title>
                <rect width="100%" height="100%" fill="#55595c" />
                </img>
                <div class="card-body">
                  <p class="card-text" style="text-align: center; font-size: 18px;">&nbsp;<b>1,000 장기알</b></p>
                  <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;1,000원</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group" style="margin: auto;">
                      <button type="button" class="btn btn-sm btn-outline-secondary">구매</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">상세내용</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="resources/img/item05.png" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>추억의 왕게임</title>
                <rect width="100%" height="100%" fill="#55595c" />
                </img>
                <div class="card-body">
                  <p class="card-text" style="text-align: center; font-size: 18px;">&nbsp;<b>추억의 왕게임</b></p>
                  <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;10,000원</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group" style="margin: auto;">
                      <button type="button" class="btn btn-sm btn-outline-secondary">구매</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">상세내용</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="resources/img/item06.png" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>장기 달인 아바타</title>
                <rect width="100%" height="100%" fill="#55595c" />
                </img>
                <div class="card-body">
                  <p class="card-text" style="text-align: center; font-size: 18px;">&nbsp;<b>장기 달인 아바타</b></p>
                  <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;10,000원</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group" style="margin: auto;">
                      <button type="button" class="btn btn-sm btn-outline-secondary">구매</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">상세내용</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="resources/img/item07.png" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>장기 공주 아바타</title>
                <rect width="100%" height="100%" fill="#55595c" />
                </img>
                <div class="card-body">
                  <p class="card-text" style="text-align: center; font-size: 18px;">&nbsp;<b>장기 공주 아바타</b></p>
                  <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;10,000원</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group" style="margin: auto;">
                      <button type="button" class="btn btn-sm btn-outline-secondary">구매</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">상세내용</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div style="padding-top: 30px; margin: auto;" class="d-flex justify-content-center">
              <nav aria-label="Page navigation example">
                <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </main>
    <div style="z-index: 999999" class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
        <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center" id="bd-theme" type="button"
                aria-expanded="false" data-bs-toggle="dropdown" aria-label="Toggle theme (auto)">
            <svg class="bi my-1 theme-icon-active" width="1em" height="1em">
                <use href="/resources/img/item1.png"></use>
            </svg>
            <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
        </button>
        <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
            <li>
                <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light"
                        aria-pressed="false">
                    <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em">
                        <use href="#sun-fill"></use>
                    </svg>
                    Light
                    <svg class="bi ms-auto d-none" width="1em" height="1em">
                        <use href="#check2"></use>
                    </svg>
                </button>
            </li>
            <li>
                <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark"
                        aria-pressed="false">
                    <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em">
                        <use href="#moon-stars-fill"></use>
                    </svg>
                    Dark
                    <svg class="bi ms-auto d-none" width="1em" height="1em">
                        <use href="#check2"></use>
                    </svg>
                </button>
            </li>
            <li>
                <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto"
                        aria-pressed="true">
                    <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em">
                        <use href="#circle-half"></use>
                    </svg>
                    Auto
                    <svg class="bi ms-auto d-none" width="1em" height="1em">
                        <use href="#check2"></use>
                    </svg>
                </button>
            </li>
        </ul>
    </div>
    <jsp:include page="../include/footer.jsp"></jsp:include>

    <form>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="lblBuy" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="lblBuy">아이템 구매하기</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h4 style="text-align: center;"><b>100 장기알</b></h4>
                    <div style="text-align: center; font-size: 13px;" class="text-black-50">상품을 구매하시겠습니까?</div>
                    <hr>
                    <div class="d-flex">
                        * 구매수량
                        <div style="margin-top: -5px; margin-left: 50px;">
                            <button type="button" class="btn btn-dark btn-sm" onclick="change(-1, ${user.cash})">감소</button>
                            <input type="text" name="count" value="1" style="width: 30px;" />
                            <button type="button" class="btn btn-dark btn-sm" onclick="change(1, ${user.cash})">증가</button>
                        </div>
                        <div style="margin-left: 80px;" class="text-primary">100 KM 캐시</div>
                    </div>
                    <hr>
                    <table class="table table-striped-columns table-bordered">
                        <tr>
                            <th scope="row" style="width: 30%; text-align: center;">보유 캐시</th>
                            <td style="text-align: center;">${user.cash}</td>
                        </tr>
                        <tr>
                            <th scope="row" style="width: 30%; text-align: center;" class="text-danger">차감 캐시</th>
                            <td style="text-align: center;" class="text-danger" id="subtract_cash">-100</td>
                        </tr>
                        <tr>
                            <th scope="row" style="width: 30%; text-align: center;" class="text-primary">잔여 캐시</th>
                            <td style="text-align: center;" class="text-primary" id="remaining_cash">${user.cash - 100}</td>
                        </tr>
                    </table>
                    <div class="text-black-50">
                        <div style="font-size: 12px;">결제 완료 즉시 아이템 지급이 진행되며, 청약철회가 불가능합니다.</div>
                        <div style="font-size: 12px;">아이템은 게임 내 [아이템] 으로 지급되며, 최대 30분까지 지급이 지연될 수 있습니다.</div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="alert('현재 아이템 구매 기능은 준비중입니다.')">결제하기</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                </div>
            </div>
        </div>
    </div>
    </form>

    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</body>
</html>