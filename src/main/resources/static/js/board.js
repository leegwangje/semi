const boardMessages = [
    '제목을 올바르게 입력하세요',
    '본문내용을 올바르게 입력하세요',
    '자동가입방지를 올바르게 클릭하세요',
];
// 모든 error message요소 초기화
function clearErrorMessages() {

    document.querySelectorAll(".error-message")
        .forEach(error => error.textContent = '');
}

// 로그인 폼 유효성 검사
const validBoard = (form) => {
    let isValid = true;

    //로그인 폼안의 모든 input 요소 수집
    const inputs = form.querySelectorAll('input:not([readonly]),textarea:not([readonly]) ');
    inputs.forEach((input, idx) => {    // input 요소를 하나씩 검사
        if (!input.checkValidity()) {   // html5 를 이용한 유혀성 검사
            displayErrorMessages(input,boardMessages[idx])
            isValid = false;
        }
    });
    const ggrecaptcha= grecaptcha.getResponse();
    if (ggrecaptcha ===""){
        const recaptcha=document.querySelector('#recaptcha');
        displayErrorMessages(recaptcha,boardMessages[2]);
        isValid = false;
    }
    alert(ggrecaptcha);


    return isValid;
}

// 게시글 폼 제출
const submitBoardfrm = async (frm) => {

    const formData = new FormData(frm);

    fetch('/board/write', {
        method: 'POST',
        body: formData
    }).then(async response => {
        if (response.ok) {
            alert('게시글이 등록되었습니다!!');
            location.href = '/board/list';
        } else if (response.status === 400) {
            alert(await response.text());
        } else {
            alert('게시글 등록에 실패했습니다!!');
        }
    }).catch(error => {
        console.error('board write error', error);
        alert('서버와 통신중 오류가 발생했습니다!! 관리자에게 문의하세요!')
    });
}

// 오류 메세지 출력
const displayErrorMessages = (input,message) => {
    let error = document.createElement('div');
    error.className='error-message';
    error.textContent = message;
    input.parentElement.appendChild(error);
}