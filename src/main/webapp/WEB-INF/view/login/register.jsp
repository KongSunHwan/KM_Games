<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입 - KMGames | 게임 플랫폼 사이트</title>

    <!-- og -->
    <meta property="og:type" content="website" />
    <meta property="og:title" content="회원가입 - KMGames | 게임 플랫폼 사이트" />
    <meta property="og:description" content="KMGames에서 신규가입하고 지금 다양한 게임을 만나보세요.- 회원가입 | KMGames..." />
    <meta property="og:site_name" content="KMGames" />

    <!-- twitter og -->
    <meta name="twitter:card" content="summary" />
    <meta name="twitter:title" content="회원가입 - KMGames | 게임 플랫폼 사이트" />
    <meta name="twitter:description" content="KMGames에서 신규가입하고 지금 다양한 게임을 만나보세요.- 회원가입 | KMGames..." />

    <link rel="icon" href="/resources/icon/KM_GAMES_logo_icon.png" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/resources/css/signup.css" />
    <link rel="stylesheet" href="/resources/css/signup_com.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
    <script src="https://kit.fontawesome.com/0bca6ce86d.js" crossorigin="anonymous"></script>
</head>
<body>
<main>
    <section class="signup">
        <h2 class="signup-title">회원가입</h2>
        <div class="signup-messages">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide"><p>다양한 게임을 찾고 싶으면, KMGames</p></div>
                    <div class="swiper-slide"><p>나만의 게임을 찾는 게임 플랫폼 사이트</p></div>
                    <div class="swiper-slide"><p>KMGames에서 나만의 게임을 찾아보세요!</p></div>
                </div>
            </div>
        </div>

        <div class="signup-main">
            <form action="/request_register" method="post" class="signup-form" onsubmit="return checkPassword()">
                <div class="form-input">
                    <label for="email" class="form-label">이메일</label>
                    <input class="text-input" id="email" type="text" name="email" minlength="5" required/>
                </div>
                <button type="button" class="btn" onclick="checkEmail(this)">중복 확인</button>
                <div class="form-input">
                    <label for="name" class="form-label">이름</label>
                    <input class="text-input" id="name" type="text" name="name" required/>
                </div>
                <div class="form-input">
                    <label for="nickname" class="form-label">닉네임</label>
                    <input class="text-input" id="nickname" type="text" name="nickname" required/>
                </div>
                <div class="form-input">
                    <label for="password" class="form-label">비밀번호</label>
                    <div class="text-input password-input">
                        <input type="password" id="password" name="password" minlength="5" required/>
                        <span class="password-eye">
                        <svg width="16" height="16" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16">
                            <path
                                    fill="#212529"
                                    d="M10.333 8c0 1.289-1.044 2.333-2.333 2.333C6.71 10.333 5.667 9.29 5.667 8 5.667 6.711 6.71 5.667 8 5.667c1.289 0 2.333 1.044 2.333 2.333z">
                            </path>
                            <path
                                    fill="#212529"
                                    fill-rule="evenodd"
                                    d="M8 2.333c-2.288 0-4.083 1.023-5.37 2.16C1.348 5.63.544 6.902.22 7.469.03 7.8.03 8.2.22 8.533c.323.566 1.127 1.838 2.41 2.973 1.287 1.138 3.082 2.16 5.37 2.16 2.288 0 4.083-1.022 5.37-2.16 1.283-1.135 2.087-2.407 2.41-2.973.19-.333.19-.733 0-1.065-.323-.567-1.127-1.839-2.41-2.974-1.287-1.138-3.082-2.16-5.37-2.16zm-6.912 5.63c.295-.516 1.035-1.685 2.205-2.72C4.461 4.21 6.03 3.333 8 3.333c1.97 0 3.54.877 4.707 1.91 1.17 1.035 1.91 2.204 2.205 2.72.008.015.01.028.01.037 0 .01-.002.022-.01.037-.295.516-1.035 1.685-2.205 2.72-1.168 1.033-2.737 1.91-4.707 1.91-1.97 0-3.54-.877-4.707-1.91-1.17-1.035-1.91-2.204-2.205-2.72-.008-.015-.01-.028-.01-.037 0-.01.002-.022.01-.037z"
                                    clip-rule="evenodd">
                            </path>
                        </svg>
                    </span>
                    </div>
                </div>
                <div class="form-input">
                    <label for="password-confirm" class="form-label">비밀번호 확인</label>
                    <div class="text-input password-input">
                        <input id="password-confirm" type="password" minlength="5" required/>
                        <span class="password-eye">
                        <svg width="16" height="16" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16">
                            <path
                                fill="#212529"
                                d="M10.333 8c0 1.289-1.044 2.333-2.333 2.333C6.71 10.333 5.667 9.29 5.667 8 5.667 6.711 6.71 5.667 8 5.667c1.289 0 2.333 1.044 2.333 2.333z">
                            </path>
                            <path
                                fill="#212529"
                                fill-rule="evenodd"
                                d="M8 2.333c-2.288 0-4.083 1.023-5.37 2.16C1.348 5.63.544 6.902.22 7.469.03 7.8.03 8.2.22 8.533c.323.566 1.127 1.838 2.41 2.973 1.287 1.138 3.082 2.16 5.37 2.16 2.288 0 4.083-1.022 5.37-2.16 1.283-1.135 2.087-2.407 2.41-2.973.19-.333.19-.733 0-1.065-.323-.567-1.127-1.839-2.41-2.974-1.287-1.138-3.082-2.16-5.37-2.16zm-6.912 5.63c.295-.516 1.035-1.685 2.205-2.72C4.461 4.21 6.03 3.333 8 3.333c1.97 0 3.54.877 4.707 1.91 1.17 1.035 1.91 2.204 2.205 2.72.008.015.01.028.01.037 0 .01-.002.022-.01.037-.295.516-1.035 1.685-2.205 2.72-1.168 1.033-2.737 1.91-4.707 1.91-1.97 0-3.54-.877-4.707-1.91-1.17-1.035-1.91-2.204-2.205-2.72-.008-.015-.01-.028-.01-.037 0-.01.002-.022.01-.037z"
                                clip-rule="evenodd">
                            </path>
                        </svg>
                        </span>
                    </div>
                </div>
                <button class="btn">가입하기</button>
            </form>
        </div>
    </section>
</main>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
<script src="/resources/js/register.js"></script>
</body>
</html>