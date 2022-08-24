window.addEventListener('load', () => {
    const menuBtn = document.querySelector('.menu-btn');
    const leftMenu = document.querySelector('.left-menu');
    menuBtn.addEventListener('click', () => {
        leftMenu.classList.toggle('show');
    });
});