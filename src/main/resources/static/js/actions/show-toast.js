(function () {
    const toastMessage = document.querySelector('.toast-placement-ex'),
        toastTitle = document.querySelector('#toast-title'),
        toastBody = document.querySelector('#toast-body');

    let toastPlacement;

    if (visible != null && visible === true) {
        switch (type.toString()) {
            case "INFO":
                toastMessage.classList.add("bg-success");
                break;
            case "WARNING":
                toastMessage.classList.add("bg-danger");
                break;
            case "SUCCESS":
                toastMessage.classList.add("bg-success");
                break;
        }

        toastTitle.innerHTML = title.toString();
        toastBody.innerHTML = content.toString();

        DOMTokenList.prototype.add.apply(toastMessage.classList, "bottom-0 end-0".split(' '));
        toastPlacement = new bootstrap.Toast(toastMessage);
        toastPlacement.show();
    }
})();