<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
<body>
    <jsp:include page="../include/header.jsp"></jsp:include>
    <main>
        <div class="album py-5">
            <h2 style="text-align: center;">캐시 상점</h2>
        </div>
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <div class="col">
                    <div class="card shadow-sm">
                        <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="/resources/img/item1.png" role="img"
                             aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>100 장기알</title>
                        <rect width="100%" height="100%" fill="#55595c" />
                        </img>
                        <div class="card-body">
                            <p class="card-text" style="text-align: center;"><i class="bi bi-cash-coin"></i>&nbsp;100원</p>
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
                        <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="/resources/img/item02.png" role="img"
                             aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>500 장기알</title>
                        <rect width="100%" height="100%" fill="#55595c" />
                        </img>
                        <div class="card-body">
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
                        <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="/resources/img/item03.png" role="img"
                             aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>1,000 장기알</title>
                        <rect width="100%" height="100%" fill="#55595c" />
                        </img>
                        <div class="card-body">
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
                        <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="/resources/img/item05.png" role="img"
                        aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>추억의 왕게임</title>
                        <rect width="100%" height="100%" fill="#55595c" />
                        </img>
                        <div class="card-body">
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
                        <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="/resources/img/item06.png" role="img"
                             aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>장기 달인 아바타</title>
                        <rect width="100%" height="100%" fill="#55595c" />
                        </img>
                        <div class="card-body">
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
                        <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="/resources/img/item07.png" role="img"
                             aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>장기 공주 아바타</title>
                        <rect width="100%" height="100%" fill="#55595c" />
                        </img>
                        <div class="card-body">
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
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</body>
</html>