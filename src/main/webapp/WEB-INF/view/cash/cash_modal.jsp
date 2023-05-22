<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">KM 캐시충전</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-4 text-secondary">충전안내 <i class=" bi bi-exclamation-circle"></i></div>
                        <div class="col-md-6"><b>결제 수단</b></div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-3 ms-auto">
                            <label for="exampleDataList" class="form-label"><b>KMGames 캐시충전</b></label>
                            <input class="form-control" list="datalistOptions" id="exampleDataList"
                                   placeholder="0&nbsp;원">
                            <datalist id="datalistOptions">
                                <option value="1,000원">
                                <option value="3,000원">
                                <option value="5,000원">
                                <option value="10,000원">
                                <option value="50,000원">
                                <option value="100,000원">
                            </datalist>
                        </div>
                        <div class="col-md-8 ms-auto">
                            <div style="margin: auto;">
                                <button class="btn btn-primary">카드</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary">휴대폰</button>
                            </div>
                        </div>
                        <div class="col-md-8 ms-auto">
                            <button class="btn btn-primary">간편결제</button>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-sm-9">
                            <b>보유 KM캐시</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="text-secondary">0</span>
                            <div class="row">
                                <div class="col-8 col-sm-6">
                                    <b>충전후 KM캐시</b>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="text-secondary"> 0</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">결제하기</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>