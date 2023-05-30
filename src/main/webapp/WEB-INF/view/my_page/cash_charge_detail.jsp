<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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

    int currentPage = (int) request.getAttribute("current_page");
    int startPage = ((currentPage - 1) / 5) * 5 + 1;
    int pageCount = (int) Math.ceil((int) request.getAttribute("history_count") / 20.0);
    pageContext.setAttribute("page_count", pageCount);
    pageContext.setAttribute("start_page", startPage);
    pageContext.setAttribute("end_page", Math.min(startPage + 4, pageCount));
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
<%@ include file="my_page_nav.jsp"%>
   <div style="height: 100%; padding: 40px; padding-left: 300px;">
            <div class="bd-example-snippet bd-code-snippet">
                <div class="bd-example">
                    <blockquote class="blockquote">
                        <p>KM 캐시 이용 내역</p>
                        <footer class="blockquote-footer">현재 보유중인 KM캐시 :
                            <cite title="Source Title">${user.cash} 캐시</cite>
                        </footer>
                    </blockquote>
                </div>
            </div>
            <br>
            <br>
            <blockquote class="blockquote">
                <p>사용내역</p>
            </blockquote>
            <div>
                <table class="table">
                    <tr>
                        <th scope="col">순번</th>
                        <th scope="col">구매 내역</th>
                        <th scope="col">사용 금액</th>
                        <th scope="col">구매 날짜</th>
                    </tr>
                    <c:forEach var="payment" items="${payment_history}" varStatus="status">
                        <tr>
                            <td class="fw-bold">${history_count - (current_page - 1) * 20 - status.index}</td>
                            <td>${payment.item.name}</td>
                            <td><span class="fw-bold"><fmt:formatNumber type="number" value="${payment.item.price}"/></span> 캐시</td>
                            <td>${fn:substringBefore(payment.date, ".0")}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination" style="text-align: center;">
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
            </nav>
        </div>
    </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
</body>

</html>