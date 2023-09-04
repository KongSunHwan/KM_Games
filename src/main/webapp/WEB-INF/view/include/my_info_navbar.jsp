<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <style>
        .limagin {
            margin-left: 40px;
        }
    </style>
</head>
<body>
<div class="b-example-divider b-example-vr"></div>
<div style="width: 100%;">
    <div class="flex-shrink-0 p-3" style="width: 280px; float: left; height: 100%;">
        <a href="/home" class="d-flex align-items-center pb-3 mb-3 link-body-emphasis text-decoration-none border-bottom">
            <svg class="bi pe-none me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
            <span class="fs-5 fw-semibold">KM Games</span>
        </a>
        <ul class="list-unstyled ps-0">
            <li class="mb-1">
                <!-- TODO: Current Page Bold -->
                <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                        data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
                    내정보
                </button>
                <div class="collapse show" id="home-collapse">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li>
                            <a href="/my_info" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">내 정보 조회</a>
                        </li>
                        <li>
                            <a href="/cash_history" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">캐시 충전 내역</a>
                        </li>
                        <li>
                            <a href="/payment_history" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">아이템 구매 내역</a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
