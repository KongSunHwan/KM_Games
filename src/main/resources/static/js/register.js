//SIGNUP SWIPER
const signupSwiper = new Swiper(".signup .swiper-container", {
  slidesPerView: 1,
  loop: true,
  centeredSlides: true,
  autoplay: {
    delay: 2000,
  },
});

/*for (let i = 0; i < signupSwiper.pagination.bullets.length; i++) {
  heroSwiper.pagination.bullets[i].innerText = bannerLists[i];
}*/

let existEmail = null;
const emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

function checkEmail(element){
    var email = document.getElementById('email');
    if(email.value.length < 5){
        alert('이메일 길이가 너무 짧습니다')
        return;
    }else if(email.value.match(emailRegExp) === null){
        alert('이메일 형식이 올바르지 않습니다')
        return;
    }

    $.ajax({
        type: 'POST',
        url: '/exists_user',
        data: {email: document.getElementById('email').value},
        success: function(data){
            if(data){
                alert('이미 사용중인 이메일입니다');
            }else{
                alert('사용 가능한 이메일입니다');
                email.disabled = element.disabled = true;
            }
        },
        error: function(request, status, thrown){
            console.log('error');
        }
    });
}
function checkPassword(){
    const pw = document.getElementById('password').value;
    if(pw.length < 5){
        alert("비밀번호가 너무 짧습니다");
        return false;
    }
    if(pw !== document.getElementById('password-confirm').value){
        alert("비밀번호를 확인 후 다시 입력해주세요");
        return false;
    }
    document.getElementById('email').disabled = false;
    return true;
}