<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel='stylesheet' type="text/css" href="resources/css/table.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/KM_GAMES_logo_icon.png" />

    <!-- jquery UI CSS파일 -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
    <!-- jquery 기본 js 파일 -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- jquery UI 라이브러리 js파일 -->
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <title>게임 등록 페이지</title>
    <style>
        .tac {
            text-align: center;
        }

        .ta1 {
            width: 200px;
            background-color: darkgray;
        }

        .tamg {
            display: flex;
            justify-content: center;
        }
    </style>
</head>

<body>
<jsp:include page="../include/header.jsp"></jsp:include>
    <div class="container">

        <div class="py-5 text-center">
            <h2>게임 등록</h2>
        </div>
        <!-- 안내 테이블 -->
        <div class="row">
            <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
                class="table table-bordered .table-hover dt-responsive">

                <tbody>
                    <td>
                        <div>
                            <p>&nbsp;게임의 이름을 정확하게 입력하세요.</p>
                            <p>&nbsp;게임이 어떤 플랫폼에서 플레이 가능한지 명시하세요. (예: PC, 콘솔, 모바일)</p>
                            <p>&nbsp;게임을 개발한 개발자 또는 개발 회사의 정보를 제공하세요.</p>
                            <p>&nbsp;게임 파일 또는 설치 프로그램을 업로드해야 할 수도 있습니다.</p>
                        </div>
                    </td>
            </table>
        </div>
        <br><br>

        <!-- 게임정보 -->
        <div class="row">
            <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
                class="table table-bordered .table-hover dt-responsive">
                <thead>
                    <tr style="text-align: center">
                        <th class="email" colspan="2">등급분류 상세 정보</th>

                    </tr>
                </thead>
                <tbody>
                    <td class="text-center align-middle">이용 등급</td>
                    <td>
                        <input type="radio" class="btn-check" name="options" id="option1" autocomplete="off" checked>
                        <label class="btn btn-outline-primary" for="option1">전체 이용가</label>

                        <input type="radio" class="btn-check" name="options" id="option2" autocomplete="off">
                        <label class="btn btn-outline-primary" for="option2">만 12세 이상</label>

                        <input type="radio" class="btn-check" name="options" id="option3" autocomplete="off">
                        <label class="btn btn-outline-primary" for="option3">만 15세 이상</label>

                        <input type="radio" class="btn-check" name="options" id="option4" autocomplete="off">
                        <label class="btn btn-outline-primary" for="option4">만 19세 이상</label>
                    </td>

                </tbody>
            </table>
        </div>
        <br><br>

        <!-- 기본정보 -->
        <div class="row">
            <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
                class="table table-bordered .table-hover dt-responsive">
                <thead>
                    <tr style="text-align: center">
                        <th class="email" colspan="4">게임 정보</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td rowspan="1" style="width:15%;" class="align-middle text-center">
                            게임 제목
                        </td>
                        <td style="width: 35%;" class="align-middle"><input type="text" size="50" class="form-control"
                                placeholder="게임 제목을 입력해주세요.">
                        </td>
                        <td rowspan="1" class="align-middle text-center" style="width:15%;">
                            원작 국적</td>
                        <td style="width: 35%;" class="align-middle">
                            <select class="form-select">
                                <option value="대한민국">대한민국</option>
                                <option value="일본">일본</option>
                                <option value="미국">미국</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td rowspan="1" style="width:15%;" class="align-middle text-center">
                            개발사
                        </td>
                        <td style="width: 35%;" class="align-middle"><input type="text" size="50" class="form-control"
                                placeholder="개발사를 입력해주세요.">
                        </td>
                        <td rowspan="1" class="align-middle text-center" style="width:15%;">
                            게임 장르</td>
                        <td style="width: 35%;" class="align-middle">
                            <select class="form-select">
                                <option value="액션">액션</option>
                                <option value="아케이드">아케이드</option>
                                <option value="어드벤처">어드벤처</option>
                                <option value="RPG">RPG</option>
                                <option value="퍼즐">퍼즐</option>
                                <option value="스포츠">스포츠</option>
                                <option value="호러">호러</option>
                                <option value="음악">음악</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td rowspan="1" style="width:15%;" class="align-middle text-center">
                            빌드 버전
                        </td>
                        <td style="width: 35%;" class="align-middle"><input type="text" size="50" class="form-control"
                                placeholder="게임 버전을 입력해주세요.">
                        </td>
                        <td rowspan="1" class="align-middle text-center" style="width:15%;">
                            플랫폼 종류</td>
                        <td style="width: 35%;" class="align-middle">
                            <select class="form-select">
                                <option value="PC용">PC용</option>
                                <option value="모바일">모바일용</option>
                            </select>
                        </td>
                    </tr>

                </tbody>
            </table>
        </div>
        <br><br>
        <!-- 추가정보 -->
        <div class="row">
            <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
                class="table table-bordered .table-hover dt-responsive">
                <thead>
                    <tr style="text-align: center">
                        <th class="email" colspan="4">추가 정보</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td rowspan="2" style="width: 15%;" class="align-middle text-center">게임 가격
                        </td>
                        <td colspan="3">
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="item_price" name="item_price"
                                        placeholder="가격을 입력해주세요." value="" required>
                                </div>

                                <div style="font-size: 20px;">원</div>
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td colspan="3">
                            <div class="d-flex">
                                &nbsp;&nbsp;&nbsp;
                                <div class="input-group has-validation">
                                    <div>
                                        <input type="radio" class="btn-check" name="options" id="option10"
                                            autocomplete="off" checked>
                                        <label class="btn btn-outline-primary" for="option10">무료</label>

                                        <input type="radio" class="btn-check" name="options" id="option11"
                                            autocomplete="off">
                                        <label class="btn btn-outline-primary" for="option11">체험판</label>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle text-center">포함 태그</td>
                        <td colspan="3">
                            <div class="input-group has-validation">
                                <div>
                                    <input type="checkbox" class="btn-check" id="btn-check-9-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-9-outlined">인디</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-10-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-10-outlined">액션</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-11-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-11-outlined">어드벤처</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-12-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-12-outlined">캐주얼</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-13-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-13-outlined">RPG</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-14-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-14-outlined">시뮬레이션</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-15-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-15-outlined">전략</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-16-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-16-outlined">싱글 플레이</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-17-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-17-outlined">무료 플레이</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-18-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-18-outlined">2D</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-19-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-19-outlined">3D</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-20-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-20-outlined">분위기 있는</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-21-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-21-outlined">풍부한 스토리</label>

                                    <input type="checkbox" class="btn-check" id="btn-check-22-outlined"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btn-check-22-outlined">탐험</label>
                                </div>
                            </div>
                        </td>

                    </tr>
                </tbody>
            </table>
        </div>
        <!-- 상세설명 -->
        <br><br>
        <div class="row">
            <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
                class="table table-bordered .table-hover dt-responsive">
                <thead>
                    <tr style="text-align: center">
                        <th class="email" colspan="2">상세 정보</th>
                    </tr>
                </thead>
                <tbody>
                    <tr height="30px">
                        <td class="text-center align-middle" style="width: 150px;">게임 제목</td>
                        <td>
                            <input type="text" class="form-control" id="firstName" name="lec_title"
                                placeholder="예) 리그 오브 레전드" value="" style="width: 100%;">

                        </td>
                    </tr>
                    <tr height="300px">
                        <td class="text-center align-middle" style="width: 150px;">상세설명</td>
                        <td>
                            <textarea class="form-control" id="firstName" name="lec_title" placeholder="
                    [상세설명 작성 주의사항] &#13;&#10; 
                    -게임정보와 관련없는 홍보성 정보는 입력할 수 없습니다. &#13;&#10;
                    -게임등록규정에 위반되는금칙어는 입력할 수 없습니다. &#13;&#10; 
                     &#13;&#10;
                     위 주의사항 위반시 임의로 게임 삭제 혹은 서비스 이용이 제한될 수 있습니다." value=""
                                style="width: 100%; height: 300px;"></textarea>

                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- 사진등록 -->
        <br><br>
        <div class="row">
            <table summary="This table shows how to create responsive tables using Datatables' extended functionality"
                class="table table-bordered .table-hover dt-responsive">
                <thead>
                    <tr style="text-align: center">
                        <th class="email" colspan="2">사진등록</th>

                    </tr>
                </thead>
                <tbody>
                    <td>
                        <div>
                            <p>-사진은 가로로 찍은 사진을 권장합니다.(가로 사이즈 최소800px)</p>
                            <p>-사진용량은 사진 한 장당 10MB까지 등록이 가능합니다.</p>
                            <p>-사진은 최소 3장이상 등록해야하며, 최대 15장 까지 권장합니다. 그 이상 등록할 경우 업로드 시간이 다소 지연될 수 있습니다.</p>
                        </div>
                    </td>
                    <tr>
                        <td style="text-align: center;">
                            <div class="card p-2" style="display: inline-block;">
                                <div id="previewContainer">
                                    <img src="resources/img/img_null.png" class="img-thumbnail" alt="#"
                                        style="max-width: 800px; max-height: 800px; display: block; margin: 0 auto;">
                                </div>
                                <hr>
                                <input type="file" name="files" accept=".png, .jpg" multiple data-max-files="15"
                                    data-min-files="3" onchange="checkFileCount(this)" id="fileInput">
                                <span style="padding-top: 10px;"></span>
                                <!-- <button type="submit" class="btn btn-secondary">등록</button> -->
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br>
        <br>
        <div class="row gy-3">
        </div>

        <button type="submit" class="w-100 btn btn-primary btn-lg">등록하기</button>
    </div>
    <!-- 컨테이너 -->
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2023 KM_GAEMS</p>
    </footer>

    <script>
        function validateForm() {
            var fileInput = document.querySelector('input[type="file"]');
            var files = fileInput.files;
            var allowedExtensions = /(.png|.jpg)$/i;

            for (var i = 0; i < files.length; i++) {
                if (!allowedExtensions.test(files[i].name)) {
                    alert('올바른 파일 형식이 아닙니다. PNG 또는 JPG 파일만 업로드할 수 있습니다.');
                    return false;
                }
            }

            return true;
        }

        function checkFileCount(input) {
            var maxFiles = parseInt(input.getAttribute('data-max-files'));
            var minFiles = 3; // 최소 파일 개수
            var selectedFiles = input.files.length;

            if (selectedFiles > maxFiles) {
                alert(maxFiles + "개까지 파일을 업로드할 수 있습니다.");
                input.value = ''; // 선택된 파일 초기화
                return;
            }
            else if (selectedFiles < minFiles) {
                alert("적어도 3개의 파일을 업로드해주세요.");
                input.value = ''; // 선택된 파일 초기화
                return;
            }

            updateThumbnails(input); // 썸네일 업데이트 호출
        }

        function updateThumbnails(input) {
            var previewContainer = document.getElementById('previewContainer');
            previewContainer.innerHTML = ''; // 기존 썸네일 초기화

            var thumbnailContainer = document.createElement('div');
            thumbnailContainer.style.display = 'flex'; // 가로 정렬을 위해 flex 사용
            thumbnailContainer.style.flexWrap = 'wrap'; // 필요한 경우 줄바꿈
            thumbnailContainer.style.justifyContent = 'center'; // 가운데 정렬
            thumbnailContainer.style.margin = '10px auto'; // 가운데 정렬 및 여백
            previewContainer.appendChild(thumbnailContainer);

            for (var i = 0; i < input.files.length; i++) {
                var file = input.files[i];
                var reader = new FileReader();
                reader.onload = function (e) {
                    var thumbnail = document.createElement('img');
                    thumbnail.src = e.target.result;
                    thumbnail.className = 'img-thumbnail';
                    thumbnail.style.maxWidth = '300px'; // 미리보기 이미지의 너비 조정
                    thumbnail.style.margin = '5px'; // 이미지 간 간격
                    thumbnailContainer.appendChild(thumbnail);
                };
                reader.readAsDataURL(file);
            }
        }
    </script>


</body>

</html>