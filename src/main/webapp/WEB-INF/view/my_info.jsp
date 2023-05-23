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
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded"><b>내 정보
                    조회</b></a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">사용내역</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">캐시 충전 내역</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">비밀번호 재설정</a>
              </li>
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
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
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
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
              <li><a href="#" class="link-body-emphasis d-inline-flex text-decoration-none limagin rounded">목록1-1</a>
              </li>
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
              <li><a href="#" class="link-dark d-inline-flex text-decoration-none limagin rounded">목록1-1</a></li>
              <li><a href="#" class="link-dark d-inline-flex text-decoration-none limagin rounded">목록1-1</a></li>
              <li><a href="#" class="link-dark d-inline-flex text-decoration-none limagin rounded">목록1-1</a></li>
              <li><a href="#" class="link-dark d-inline-flex text-decoration-none limagin rounded">목록1-1</a></li>
            </ul>
          </div>
        </li>
      </ul>
    </div>

    <div style="height: 100%; padding: 40px; padding-left: 300px;">
      <blockquote class="blockquote">
        <p>내 정보 조회</p>

      </blockquote>

      <div class="d-flex">
        <img src="/resources/img/item06.png" class="img-thumbnail" alt="..." style="width: 250px; height: 250px;">
        &nbsp;&nbsp;
        <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
          class="table table-bordered .table-hover dt-responsive">
          <thead>
            <tr style="text-align: center">
              <th class="email" colspan="4">개인정보 조회 & 변경</th>
            </tr>
          </thead>
          <tbody>

            <tr>
              <td style="width: 20%; text-align: center;"><b>이메일</b></td>
              <td>
                a**@gmail.com
                <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal"
                  data-bs-whatever="@mdo">변경</button>
                <button class="btn btn-primary btn-sm">삭제</button>
              </td>
            </tr>
            <tr>
              <td style="width: 20%; text-align: center;"><b>이름</b></td>
              <td>
                김경민&nbsp;
                <button class="btn btn-primary btn-sm">개명</button>
              </td>
            </tr>
            <tr>
              <td style="width: 20%; text-align: center;"><b>닉네임</b></td>
              <td>
                경민게임즈&nbsp;
                <button class="btn btn-primary btn-sm">변경</button>
                <button class="btn btn-primary btn-sm">삭제</button>
              </td>
            </tr>

            <tr>
              <td style="width: 20%; text-align: center;"><b>개인정보 유효기간</b></td>
              <td>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                    value="option1">
                  <label class="form-check-label" for="inlineRadio1">5년</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                    value="option2">
                  <label class="form-check-label" for="inlineRadio2">1년</label>
                </div>
                <button class="btn btn-primary btn-sm">변경</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">이메일 변경하기</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label for="recipient-email" class="col-form-label">이메일 :</label>
              <input type="text" class="form-control" id="recipient-email" placeholder="asd@gmail.com">
            </div>

            <div class="mb-3">
              <label for="recipient-password" class="col-form-label">비밀번호 :</label>
              <input type="password" class="form-control" id="recipient-password">
            </div>

            <div class="mb-3">
              <label for="recipient-password-check" class="col-form-label">비밀번호 확인 :</label>
              <input type="password" class="form-control" id="recipient-password-check">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary">확인</button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
</body>

</html>