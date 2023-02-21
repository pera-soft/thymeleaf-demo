(function () {
    //Show Loading Modal JS
    const saveMessageBtn = document.querySelector('#saveMessageBtn'),
        messageForm = document.querySelector('#message-form'),
        modalExample = document.querySelector('#loadingModal');

    let modalPlacement;

    if (saveMessageBtn) {
        saveMessageBtn.onclick = function () {
            if (messageForm.checkValidity()) {
                modalPlacement = new bootstrap.Modal(modalExample);
                modalPlacement.show();
            }
        };
    }
})();