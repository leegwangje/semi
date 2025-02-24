const errorMessages = [
    '아이디는 소문자로 시작하고, 영문자와 숫자만 사용 가능합니다 (최소 6자 ~ 최대 18자)',
    '비밀번호는 영문 대소문자, 숫자, 특수문자를 포함해야 합니다 (최소 6자 ~ 최대 18자)',
    '비밀번호가 일치하지 않습니다',
    '이름은 한글 또는 영문자만 사용 가능합니다',
    '올바른 이메일 형식이 아닙니다',
    '자동가입방지를 확인하세요'];
const patterns = [
    /^[a-z][a-z0-9]{5,17}$/,
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,18}$/,
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,18}$/,
    /^[가-힣]{2,5}|[a-zA-Z]{2,10}$/,
    /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/
];
function clearErrorMessages() {

    document.querySelectorAll(".error-message")
        .forEach(error => error.textContent = '');
}

// 입력 요소 유효성 검사
const validInputs = (form) => {
    let isValid = true;

    //회원가입 폼안의 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');
    inputs.forEach((input, idx) => {    // input 요소를 하나씩 검사
        if (!input.checkValidity()) {   // html5 를 이용한 유혀성 검사
            displayErrorMessages(input,errorMessages[idx])
            isValid = false;
        }
    });
    // 비밀번호 일치 여부 검사
    if(inputs[1].value !== inputs[2].value){
        displayErrorMessages(inputs[2],errorMessages[2])
        isValid = false;
    }

    return isValid;
}

// 오류 메세지 출력
const displayErrorMessages = (input,message) => {
    let error = document.createElement('div');
    error.className='error-message';
    error.textContent = message;
    input.parentElement.appendChild(error);
}