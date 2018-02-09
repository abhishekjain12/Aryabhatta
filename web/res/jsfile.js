function flip_username_card() {
    var username = document.forms["sign_in_form"]["username"].value;
    var fails = document.getElementById("checker").innerHTML;
    if (username == "") {
        document.getElementById("error_username").style.display = "block";
        document.forms["sign_in_form"]["username"].classList.add("error-input");
    }
    else {
        if (fails.localeCompare("fail") == 0) {
            document.getElementById("error_no_user").style.display = "block";
            document.getElementById("available").style.display = "none";
            document.getElementById("error_username").style.display = "none";
            document.forms["sign_up_form"]["username"].classList.add("error-input");
        }
        else {
            document.getElementById('username-card').style.display = "none";
            document.forms["sign_in_form"]["username"].removeAttribute('autofocus');
            document.getElementById('password-card').style.display = "block";
            document.forms["sign_in_form"]["password"].focus();
        }
    }

    var imgPath = "../res/user-img/" + username + ".jpg";
    document.getElementById('photo').src = imgPath;
}

function validateSignInForm() {
    var password = document.forms["sign_in_form"]["password"].value;
    if (password == "") {
        document.getElementById("error_password").style.display = "block";
        document.forms["sign_in_form"]["password"].classList.add("error-input");
        return false;
    }
}

function flip_password_card() {
    document.getElementById('username-card').style.display="block";
    document.getElementById('password-card').style.display="none";
}

function flip_more_card() {
    var name = document.forms["sign_up_form"]["name"].value;
    var email = document.forms["sign_up_form"]["email"].value;
    var username = document.forms["sign_up_form"]["username"].value;
    var password = document.forms["sign_up_form"]["password"].value;
    var cpassword = document.forms["sign_up_form"]["cpassword"].value;

    var checker = 0;

    if (name == "") {
        checker = 0;
        document.getElementById("error_name").style.display = "block";
        document.forms["sign_up_form"]["name"].classList.add("error-input");
    }
    else{
        checker++;
        document.getElementById("error_name").style.display = "none";
        document.forms["sign_up_form"]["name"].classList.remove("error-input");
    }

    if (email == "") {
        checker = 0;
        document.getElementById("error_email").style.display = "block";
        document.forms["sign_up_form"]["email"].classList.add("error-input");
    }
    else{
        var email_check = /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
        if (!email_check.test(email)) {
            checker =0;
            document.getElementById("error_email").style.display = "none";
            document.getElementById("error_email_invalid").style.display = "block";
            document.forms["sign_up_form"]["email"].classList.add("error-input");
        }
        else {
            checker++;
            document.getElementById("error_email").style.display = "none";
            document.getElementById("error_email_invalid").style.display = "none";
            document.forms["sign_up_form"]["email"].classList.remove("error-input");
        }
    }

    if (username == "") {
        checker = 0;
        document.getElementById("error_uname").style.display = "block";
        document.getElementById("error_available").style.display = "none";
        document.getElementById("error_uname_invalid").style.display = "none";
        document.forms["sign_up_form"]["username"].classList.add("error-input");
    }
    else{
        var username_check = /(?=.*[a-zA-Z0-9]).{3,}/;
        var fails = document.getElementById("checker").innerHTML;
        if (!username_check.test(username)) {
            checker = 0;
            document.getElementById("error_uname").style.display = "none";
            document.getElementById("error_available").style.display = "none";
            document.getElementById("error_uname_invalid").style.display = "block";
            document.forms["sign_up_form"]["username"].classList.add("error-input");
        }
        else {
            if (fails.localeCompare("fail") == 0) {
                document.getElementById("error_uname").style.display = "none";
                document.getElementById("error_available").style.display = "none";
                document.getElementById("error_uname_invalid").style.display = "none";
                document.forms["sign_up_form"]["username"].classList.add("error-input");
            }
            else {
                checker++;
                document.getElementById("error_uname").style.display = "none";
                document.getElementById("error_available").style.display = "none";
                document.getElementById("error_uname_invalid").style.display = "none";
                document.forms["sign_up_form"]["username"].classList.remove("error-input");
            }
        }
    }

    if (password == "") {
        checker = 0;
        document.getElementById("error_password").style.display = "block";
        document.forms["sign_up_form"]["password"].classList.add("error-input");
    }
    else {
        var password_check = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
        if (!password_check.test(password)){
            checker = 0;
            document.getElementById("error_password").style.display = "none";
            document.getElementById("error_password_invalid").style.display = "block";
            document.forms["sign_up_form"]["password"].classList.add("error-input");
        }
        else {
            checker++;
            document.getElementById("error_password").style.display = "none";
            document.getElementById("error_password_invalid").style.display = "none";
            document.forms["sign_up_form"]["password"].classList.remove("error-input");
        }
    }

    if (cpassword == "") {
        checker = 0;
        document.getElementById("error_cpassword").style.display = "block";
        document.forms["sign_up_form"]["cpassword"].classList.add("error-input");
    }
    else {
        if (password.localeCompare(cpassword) != 0) {
            checker = 0;
            document.getElementById("error_cpassword").style.display = "none";
            document.getElementById("error_check_password").style.display = "block";
            document.forms["sign_up_form"]["cpassword"].classList.add("error-input");
        }
        else {
            checker++;
            document.getElementById("error_check_password").style.display = "none";
            document.getElementById("error_cpassword").style.display = "none";
            document.forms["sign_up_form"]["cpassword"].classList.remove("error-input");
        }
    }
    if (checker == 5){
        document.getElementById('basic-detail-card').style.display = "none";
        document.forms["sign_up_form"]["name"].removeAttribute('autofocus');
        document.getElementById('more-detail-card').style.display = "block";
        document.forms["sign_up_form"]["birthday"].focus();
        SubmitForm();
    }
}

function SubmitForm() {
        document.forms['photo_form'].action='picSubmit';
        document.forms['photo_form'].target='frame_1';
        document.forms['photo_form'].submit();
        document.forms['photo_form'].style.display = "none";
}

function games() {
    document.getElementById('right-tab').style.display="none";
    document.getElementById('left-tab').style.display = "block";
    document.getElementById('profile').style.display="none";
    document.getElementById('games').style.display = "block";
}

function profile() {
    document.getElementById('left-tab').style.display="none";
    document.getElementById('right-tab').style.display = "block";
    document.getElementById('games').style.display="none";
    document.getElementById('profile').style.display = "block";
}

function update_card() {
    var name = document.forms["update_form"]["name"].value;
    if (name == "") {
        document.getElementById("error_name").style.display = "block";
        document.forms["update_form"]["name"].classList.add("error-input");
        return false;
    }
}