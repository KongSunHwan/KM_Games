<%@ page import="ac.kmgames.model.entity.User" %>
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
        body{
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        h2{
            color: #333;
        }
        form{
            width: 300px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            margin-left: 30px;
            margin-top: 10px;
        }
        label{
            display: block;
            margin-bottom: 10px;
            color: #555;
        }
        input[type="email"], input[type="password"]{
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-bottom: 20px;
        }
        input[type="submit"]{
            background-color: #4caf50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 3px;
        }
        input[type="submit"]:hover{
            background-color: #45a049;
        }
    </style>
</head>

<body>
    <%@ include file="../include/my_info_navbar.jsp" %>
    <div style="height: 100%; padding: 40px; padding-left: 300px;">
        <blockquote class="blockquote">
            <p>비밀번호 재설정</p>
        </blockquote>
        <form action="/password-reset" method="POST">
            <div>
                <label for="password">비밀번호 재설정</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <label for="password_check">비밀번호 확인</label>
                <input type="password" id="password_check" required>
            </div>
            <input type="submit" value="비밀번호 재설정">
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>