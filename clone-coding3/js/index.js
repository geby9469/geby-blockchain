window.addEventListener('load', () => {
    const like = document.querySelector('#like');
    const disLike = document.querySelector('#dislike');
    const disLikeNum = disLike.childNodes[1];
    const upAndDown = document.querySelectorAll('.upAndDown');
    const moreTxt = document.querySelector('.more_txt');
    const more = document.querySelector('.more');

    like.addEventListener('click', (e) => {
        e.preventDefault(); // Don't move new link and execution.

        if (like.classList.contains('selected')) {
            like.classList.remove('selected');
            like.title = '좋아요';
            upAndDown.forEach(e => {
                e.style.borderColor = '#909090';
            });
        }
        else if (disLike.classList.contains('selected')) {
            disLike.classList.remove('selected');
            disLike.title = '싫어요';
            disLikeNum.textContent = parseInt(disLikeNum.textContent) - 1;
            like.classList.add('selected');
            like.title = '좋아요취소';
        }
        else {
            like.classList.add('selected');
            like.title = '좋아요취소';
            upAndDown.forEach(e => {
                e.style.borderColor = '#3ea6ff';
            });
        }
    });

    disLike.addEventListener('click', (e) => {
        e.preventDefault(); // Don't move new link and execution.

        if (like.classList.contains('selected')) {
            like.classList.remove('selected');
            like.title = '좋아요';
            disLike.classList.add('selected');
            disLike.title = '싫어요취소';
            disLikeNum.textContent = parseInt(disLikeNum.textContent) + 1;
        }
        else if (disLike.classList.contains('selected')) {
            disLike.classList.remove('selected');
            disLike.title = '싫어요';
            disLikeNum.textContent = parseInt(disLikeNum.textContent) - 1;
            upAndDown.forEach(e => {
                e.style.borderColor = '#909090';
            });
        }
        else {
            disLike.classList.add('selected');
            disLike.title = '싫어요취소';
            disLikeNum.textContent = parseInt(disLikeNum.textContent) + 1;
            upAndDown.forEach(e => {
                e.style.borderColor = '#3ea6ff';
            });
        }
    });

    moreTxt.addEventListener('click', () => {
        if (moreTxt.textContent === '더보기') {
            more.style.display = 'block';
            moreTxt.textContent = '간략히'
        }
        else {
            more.style.display = 'none';
            moreTxt.textContent = '더보기';
        }
    });

});