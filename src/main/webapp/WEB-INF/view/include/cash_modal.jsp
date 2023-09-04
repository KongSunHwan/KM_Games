<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Modal -->
<script>
    function purchaseCash(){
        let amount = parseInt($('#amount').val());
        if(typeof amount !== 'number' || !isFinite(amount) || isNaN(amount) || amount <= 0){
            alert('충전할 값을 올바르게 입력해주세요');
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/purchase_cash',
            data: {
                amount: amount,
                method: $('input[name="payment_type"]:checked').val()
            },
            success: function(data){
                if(data){
                    alert('충전이 완료되었습니다');
                    location.reload();
                }else{
                    alert('충전에 실패했습니다');
                }
            },
            error: function(request, status, thrown){}
        });
    }
</script>
<div class="modal fade" id="purchaseCash" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">KM 캐시충전</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <%--<div class="row">
                        <div class="col">
                            <b>보유 KM캐시</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="text-secondary"><b>${user.cash}</b>&nbsp;KM 캐시</span>
                            <div class="row">
                                <div class="col-8 col-sm-6">
                                    <b>충전후 KM캐시</b>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="text-secondary"> 0</span>
                                </div>
                            </div>
                        </div>
                    </div>--%>
                    <div class="row">
                        <div class="text-secondary">충전안내 <i class=" bi bi-exclamation-circle"></i></div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-3">
                            <label for="amount" class="form-label"><b>KM 캐시</b></label>
                            <div>&nbsp;</div>
                            <input class="form-control" list="price_list" id="amount">
                            <datalist id="price_list">
                                <option value="1000">
                                <option value="3000">
                                <option value="5000">
                                <option value="10000">
                                <option value="50000">
                                <option value="100000">
                            </datalist>
                        </div>
                        <div class="col-2"></div>
                        <div class="col-3">
                            <b>결제 수단</b>
                            <div>&nbsp;</div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="payment_type" id="type_km_pay" value="KM pay" checked>
                                <label class="form-check-label" for="type_km_pay"><b>[간편]</b> KM Pay</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="payment_type" id="type_card" value="카드">
                                <label class="form-check-label" for="type_card">카드</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="payment_type" id="type_bank" value="계좌 이체">
                                <label class="form-check-label" for="type_bank">계좌 이체</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="payment_type" id="type_phone" value="휴대폰 소액결제">
                                <label class="form-check-label" for="type_phone">휴대폰 소액결제</label>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="purchaseCash()">결제하기</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>