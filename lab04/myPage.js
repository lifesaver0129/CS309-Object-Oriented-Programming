function onClickLogin() {
    var str1 = new RegExp("^[a-zA-Z]+$");
    var str2 = new RegExp("^.{6,12}$");
    if (!str1.test(document.getElementById("username").value)) {
        alert("Invalid username: should only contains alphabets");
        document.getElementById("username").focus();
        return;
    }
    if (!str2.test(document.getElementById("password").value)) {
        alert("Invalid password: should only be six to twelve digits");
        document.getElementById("username").focus();
        return;
    }
    alert("Welcome!");
    window.location.href="table.html";
}
