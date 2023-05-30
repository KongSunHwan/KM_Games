<%@ page import="ac.kmgames.model.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내 정보 조회</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
    crossorigin="anonymous"></script>
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
      <a href="/" class="d-flex align-items-center pb-3 mb-3 link-body-emphasis text-decoration-none border-bottom">
        <svg class="bi pe-none me-2" width="30" height="24">
          <use xlink:href="#bootstrap" />
        </svg>
        <span class="fs-5 fw-semibold">KM Games</span>
      </a>
      <ul class="list-unstyled ps-0">
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
            data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
            내정보
          </button>
          <div class="collapse show" id="home-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/my_info2" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">내 정보
                    조회</a>
              </li>
              <li><a href="/cash_charge_detail" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">사용내역</a>
              </li>
              <li><a href="/cash_charge_detail" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">캐시 충전 내역</a>
              </li>
              <li><a href="/change_pw" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">비밀번호 재설정</a>
              </li>
            </ul>
          </div>
        </li>
    </div>
</body>

</html>