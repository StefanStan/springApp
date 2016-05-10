$(function() {
    var button = $('#loginButton');
    var box = $('#loginBox');
    var form = $('#loginForm');

    button.removeAttr('href');
    button.mouseenter(function(login) {
        box.toggle();
        button.toggleClass('active');
    });
    button.mouseleave(function(login) {
        box.toggle();
        button.toggleClass('active');
    });
    box.mouseenter(function()
    {
        box.toggle();
        button.toggleClass('active');
    });
    box.mouseleave(function()
    {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() {
        return false;
    });
    $(this).mouseup(function(login) {

        if(!($(login.target).parent('#loginButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });
});

function login() {

    var username = $('#username').val();
    var password = $('#password').val();

    $.ajax({
        url: "/springApp/login",
        type: "POST",
        beforeSend: function(xhr){
            xhr.setRequestHeader('X-Username', username);
            xhr.setRequestHeader('X-Password', password);
        },
        success: function(data, textStatus, request){

            var token = request.getResponseHeader('X-Auth-Token');

            if(token !== undefined) {

                var storage = window.sessionStorage;
                if(typeof(storage) !== undefined) {

                    storage.setItem("token", token);
                    window.location.href = "/springApp/home";
                } else {


                }
            }
        },
        error: function (request, status, error) {
            if (request.statusText == "Conflict") {

                $('#statusOfLogin').text('Status: cannot login, incorrect !!!');
                return;

            }
            console.error('Unexpected: ' + request.responseText);
        }
    });
}