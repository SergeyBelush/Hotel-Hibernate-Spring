

function proverkaBrouzer() {

    var userName = document.getElementById("index-name").value;
    var surName = document.getElementById("index-surname").value;
    var userEmail = document.getElementById("index-email").value;
    var oshibkaRegistration  = document.getElementById("oshibka");
    var textOshibki = "";


    if (userName.length < 4) {
        textOshibki += "Enter Name More 4 Symbols <br>";
    }

    if (surName.length < 4) {
        textOshibki += "Enter Surname More 4 Symbols <br>";
    }

    if (userEmail.indexOf("@") === -1) {
        textOshibki += "Enter e-mail";
    }


    if (textOshibki === "") {
        var form = document.getElementById("index-form");
        form.submit();
    } else {
        oshibkaRegistration.innerHTML = textOshibki;
    }
}