<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <!-- 부트스트랩 css파일 참조 -->
    <link rel="stylesheet" href="resources/css/bootstrap.css">

    <!-- jquery 파일 참조 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- 부트스트랩 js파일 참조 -->
    <script src="resources/js/bootstrap.js"></script>

    <!-- 개인 커스텀 디자인 -->
    <link rel="stylesheet" href="resources/css/Order.css">
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />
    <title>상품 주문페이지</title>
    <script>
        $(document).ready(function () {
            $(".calulation1 thead input:checkbox[id=check]").click(function () {
                var bool = $(this).prop("checked");
                $(".calulation1 tbody input:checkbox[name=checkbox]").prop("checked", bool);
            });

            $(".calulation1 tbody input:checkbox[name=checkbox]").click(function () {
                var flag = false;
                $(".calulation1 tbody input:checkbox[name=checkbox]").each(function () {
                    var bool = $(this).prop("checked");

                    if (!bool) {
                        $(".calulation1 thead input:checkbox[id=check]").prop("checked", false);
                        flag = true;
                        return false;
                    }
                });
                if (!flag) {
                    $(".calulation1 thead input:checkbox[id=check]").prop("checked", true);
                }
            });
            $("#emailChoice").bind("change", function () {
                $("#domainName").val($(this).val());
            });
        });

        function openDaumPOST() {
            new daum.Postcode({
                oncomplete: function (data) {
                    document.getElementById("postnum1").value = data.postnum1; //우편번호의 첫번째 값 예 > 151
                    document.getElementById("postnum2").value = data.postnum2; // 우편번호의 두번째 값 예 > 019
                    document.getElementById("addr1").value = data.address; // 주소 예 > 서울특별시 양천구 목동동로 50
                    document.getElementById("addr2").focus();
                }
            }).open();
        }
    </script>
</head>

<body>
    <div id="backbody">
        <div id="frame">
            <form>
                <div id="frame2">
                    <span style="font-size: 16pt; font-weight: bold;">상품 주문하기</span>
                    <span class="home"> 홈 > 상품 주문하기</span>

                    <span> </span>
                </div>
                <br />

                <!-- 상품정보 테이블 -->
                <div>
                    <table class="calculation1">
                        <thead>
                            <tr>
                                <th colspan="10" style="text-align: left; padding-left : 10px;">일반상품(1)</th>
                            </tr>
                            <tr>
                                <th><input type="checkbox" name="checkbox" id="check" /></th>
                                <th><span>이미지</span></th>
                                <th style="width: 400px;"><span>상품정보</span></th>
                                <th style="width: 100px;">판매가</th>
                                <th>수량</th>
                                <th style="width: 100px;">적립금</th>
                                <th style="width: 100px;">게임 종류</th>
                                <th style="width: 100px;">등급 분류</th>
                                <th style="width: 100px;">합계</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr style="height: 90px; background-color: #fff;">
                                <td style="text-align: left; text-align: center; border-right: none;">
                                    <input type="checkbox" name="checkbox" />
                                </td>
                                <td style="border-left: none; border-right: none;"><img style="width: 100%;"
                                        src="resources/img/game/game_img2.jpg"></td>
                                <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">
                                    휴먼 폴 플랫</td>

                                <td><span>0</span>원</td>

                                <td style="width: 80px;">
                                    <span>1</span>
                                </td>

                                <td>-</td>
                                <td>아케이드</td>
                                <td>만 12세 이상</td>
                                <td><span>0</span>원</td>
                            </tr>

                        </tbody>
                    </table>

                    <div
                        style="border: solid 1px #e0e0eb; border-right:none; border-left:none; padding: 11px 0; background-color:rgb(255, 203, 203);">
                        <img src="resources/img/주의.png" style="margin-left: 5px; position: relative; top: -2px; width: 20px;">
                        <span style="font-size: 10pt; color: red;">상품의 옵션 및 수량 변경은 상품상세 또는 장바구니에서 가능합니다.</span>
                    </div>
                </div>

                <div style="margin: 10px 0; padding-bottom: 50px; border-bottom: solid 1px gray;">
                    <span style="margin: 0 10px;" class="btnfloat">선택상품</span>
                    <button type="button" class="btn default btnfloat" style="background-color: gray; color: #fff;">x
                        삭제하기</button>

                    <button type="button" class="btn default btnfloat2" onclick="javascript:history.back()">이전페이지
                        ></button>
                </div>
                <br /><br />

                <!-- 주문자 정보 -->
                <span style="font-size: 12pt; display: inline-block; padding-bottom: 10px; ">&nbsp;주문자 정보</span>
                <table class="delivery">
                    <thead>

                        <tr>
                            <td class="deliverytd">받으시는 분&nbsp;<span style="color:red;">*</span></td>
                            <td><input type="text" /></td>
                        </tr>

                        <tr>
                            <td class="deliverytd">휴대전화&nbsp;<span style="color: red;">*</span></td>
                            <td><input type="text" size="5" />-<input type="text" size="5" />-<input type="text"
                                    size="5" /></td>
                        </tr>

                        <tr>
                            <td class="deliverytd">이메일&nbsp;<span style="color : red;">*</span></td>
                            <td><input type="text" />@<input id="domainName" type="text" />&nbsp;
                                <select id="emailChoice" style="height: 20px;">
                                    <option>-이메일 선택-</option>
                                    <option>daum.net</option>
                                    <option>naver.com</option>
                                    <option>nate.com</option>
                                    <option>hotmail.com</option>
                                    <option>yahoo.com</option>
                                    <option>empas.com</option>
                                    <option>korea.com</option>
                                    <option>gmail.com</option>
                                </select>
                                <span style="font-size: 10pt; color:gray;">
                                    <p>이메일을 통해 주문처리과정을 보내드립니다.<br />
                                        이메일 주소란에는 반드시 수신가능한 이메일주소를 입력해 주세요.</p>
                                </span>
                            </td>
                        </tr>
                    </thead>
                </table>
                <br /><br />
                <!-- 결제예정금액 테이블 -->
                <table class="calculation2">
                    <tr>
                        <th>총 상품금액</th>
                        <th style="width: 750px; padding: 22px 0;"><span>결제예정금액</span></th>
                    </tr>

                    <tr style="background-color: #fff;">
                        <td style="padding: 23px 0;"><span class="price">0</span>원</td>
                        <td><span class="price">0</span>원</td>
                    </tr>
                </table>
                <br /><br />

                <!-- 결제하기 -->
                <div class="payArea">
                    <div class="payment">
                        <div style="padding: 18px 10px; font-size: 10pt; border-bottom: solid 1px #e0e0eb;">
                            <input type="radio" name="cardradio" checked />&nbsp;<label>카드결제</label>&nbsp;&nbsp;
                            <input type="radio" name="cardradio" checked />&nbsp;<label>실시간 계좌이체</label>&nbsp;&nbsp;
                            <input type="radio" name="cardradio" checked />&nbsp;<label>휴대폰 결제</label>&nbsp;&nbsp;
                            <input type="radio" name="cardradio" checked />&nbsp;<label>무통장 입금</label>&nbsp;&nbsp;
                            <input type="radio" name="cardradio" checked />&nbsp;<label>에스크로(가상계좌)</label>&nbsp;&nbsp;
                        </div>

                        <div align="left">
                            <img src="resources/img/주의.png" style="margin-left: 5px; position : relative; top: 6px; width: 20px;">
                            <span style="font-size: 10pt; color: gray;">최소 결제 금액은 결제금액에서 수수료를 제외한
                                금액입니다.</span><br />
                            <img src="resources/img/주의.png" style="margin-left: 5px; position : relative; top: 6px; width: 20px;">
                            <span style="font-size: 10pt; color: gray;">소액 결제의 경우 PG사 정책에 따라 결제 금액 제한이 있을 수
                                있습니다.</span>
                        </div>
                    </div>

                    <div class="total">
                        <span style="display: inline-block; padding: 20px 10px;">카드결제 최종결제 금액</span><br />
                        <span style="font-size: 25pt; font-weight: bold; padding: 0px  10px;">0원</span><br /><br />
                        <button type="button" class="btn default"
                            style="width: 90%; height: 60px; margin-right: 10px; font-size: 20px;" onclick="location.href='/order_receipt'">결제하기</button>
                    </div>
                </div>
                <br /><br />


                <!-- 이용안내 -->
                <div
                    style="border: solid 1px #e0e0eb; padding: 10px 0; font-size: 12pt; background-color: #f5f5f0; padding-left: 10px;">
                    무이자할부 이용안내
                </div>

                <div style="border: solid 1px #e0e0eb; font-size: 12pt; padding-left: 10px;">
                    <span>-</span> <span style="font-size: 10pt; color:gray;">무이자할부가 적용되지 않은 상품과 무이자할부가 가능한 상품을
                        동시에 구매할 수 없습니다.</span><br>
                    <span>-</span> <span style="font-size: 10pt; color:gray;">무이자할부를 원하시는 경우 장바구니에서 무이자할부 상품만
                        선택하여 주문하여 주세요.</span>
                </div>

                <div
                    style="border: solid 1px #e0e0eb; padding: 10px 0; font-size: 12pt; background-color: #f5f5f0; padding-left: 10px">
                    이용안내
                </div>
                <div style="border: solid 1px #e0e0eb; height: 500px; font-size: 12pt; padding-left: 10px;">
                    <br />세금계산서 발행 안내
                    <ol style="padding-left: 30px; padding-top : 8px">
                        <li class="lifont"> 부가가치세법 제 54조에 의거하여 세금계산서는 주문완료일로부터 다음날 10일까지만 요청하실 수 있습니다.</li>
                        <li class="lifont"> 세금계산서는 사업자만 신청할 수 있습니다.</li>
                        <li class="lifont"> 주문이 완료된 주문에 한하여 세금계산서 발행신청이 가능합니다.</li>
                        <li class="lifont"> [세금계산서 신청]버튼을 눌러 세금계산서 신청양식을 작성한 후 팩스로 사업자등록증사본을 보내셔야 세금계산서 발행이
                            가능합니다.</li>
                        <li class="lifont"> [세금계산서 인쇄]버튼을 누르면 발행된 세금게산서를 인쇄할 수 있습니다.</li>
                    </ol><br />
                    부가가치세법 변경에 따른 신용카드매출전표 및 세금계산서 변경안내
                    <ol style="padding-left: 30px; padding-top: 8px;">
                        <li class="lifont"> 변경된 부가가치세법에 의거, 2004.7.1 이후 신용카드로 결제하신 주문에 대해서는 세금계산서 발행이 불가하며</li>
                        <li class="lifont"> 신용카드매출전표로 부가가치세 신고를 하셔야 합니다.(부가가치세법 시행령 57조)</li>
                        <li class="lifont"> 상기 부가가치세법 변경내용에 따라 신용카드 이외의 결제건에 대해서만 세금계산서 발행이 가능함을 양지하여 주시기 바랍니다.
                        </li>
                    </ol><br />
                    현금영수증 이용안내
                    <ol style="padding-left: 30px; padding-top: 8px;">
                        <li class="lifont"> 현금영수증은 1원 이상의 현금성거래(무통장입금, 실시간계좌이체, 에스크로, 예치금)에 대해 발행이 됩니다.</li>
                        <li class="lifont"> 현금영수증 발행 금액에는 수수료는 포함되고, 적립금사용액은 포함되지 않습니다.</li>
                        <li class="lifont"> 발행신청 기간제한 현금영수증은 입금확인일로 부터 48시간안에 발행을 해야 합니다.</li>
                        <li class="lifont"> 현금영수증 발행 취소의 경우는 시간 제한이 없습니다. (국세청의 정책에 따라 변경 될 수 있습니다.)</li>
                        <li class="lifont"> 현금영수증이나 세금계산서 중 하나만 발행 가능 합니다.</li>
                    </ol><br />
                </div>
            </form>
        </div>
    </div>
</body>

</html>