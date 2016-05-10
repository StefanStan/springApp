var token = undefined;

function init() {

    var storage = window.sessionStorage;
    if(typeof(storage) !== undefined) {

        token = storage.getItem("token");
    } else {

        window.location.href = "/springApp/login";
    }
    checkToken();
}

function addStudent() {

    var name = $('#name').val();
    var email = $('#email').val();

    $.ajax({
        url: "/springApp/api/rest/students",
        type: "POST",
        data:
            JSON.stringify({
                name : name,
                email : email}
            ),
        contentType: "application/json",
        beforeSend: function(xhr){
            xhr.setRequestHeader('X-Auth-Token', token);
        },
        success: function(data, textStatus, request){

            $('#statusOfAdd').text('Status: added with id:' + data.id);
        },
        error: function (request, status, error) {
            if (request.statusText == "Conflict") {

                $('#statusOfAdd').text('Status: cannot add, conflict !!!');
                return;

            }
            console.error('Unexpected: ' + request.responseText);
        }
    });
}

function getStudents() {

    getStudentsREST();
    getStudentsSOAP();
}

function getStudentsREST() {

    $.ajax({
        url: "/springApp/api/rest/students",
        type: "GET",
        beforeSend: function(xhr){
            xhr.setRequestHeader('X-Auth-Token', token);
        },
        success: function(data, textStatus, request){

            var studentsListREST = $("#studentsListREST");
            studentsListREST.empty();

            data.forEach(function(value, index){
                studentsListREST.append('Student nr '+index+ '<br>');
                studentsListREST.append('<div><ul> <li>Id: '+value.id+'</li> <li>Name: '+value.name+'</li> <li>Email: '+value.email+'</li> </ul></div> <br>');
            });
        },
        error: function (request, status, error) {
            if (request.statusText == "Unauthorized") {

                window.location.href = "/springApp/login";
            }
            console.error('Unexpected: ' + request.responseText);
        }
    });
}
function getStudentsSOAP() {

    $.ajax({
        url: "/springApp/api/soap/students",
        type: "POST",
        data:
        "<x:Envelope xmlns:x=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:s=\"http://springApp.com/schemas\">\n" +
        "    <x:Header/>\n" +
        "    <x:Body>\n" +
        "        <s:getStudents/>\n" +
        "    </x:Body>\n" +
        "</x:Envelope>",
        beforeSend: function(xhr){
            xhr.setRequestHeader('Content-Type', 'text/xml');
            xhr.setRequestHeader('X-Auth-Token', token);
        },
        success: function(data, textStatus, request){

            var studentsListSOAP = $("#studentsListSOAP");
            studentsListSOAP.empty();

            data = [].slice.call(data.getElementsByTagName("student"));

            data.forEach(function(value, index){
                var id = value.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                var name = value.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                var email = value.getElementsByTagName("email")[0].childNodes[0].nodeValue;

                studentsListSOAP.append('Student nr '+index+ '<br>');
                studentsListSOAP.append('<div><ul> <li>Id: '+id+'</li> <li>Name: '+name+'</li> <li>Email: '+email+'</li> </ul></div> <br>');
            });
        },
        error: function (request, status, error) {
            if (request.statusText == "Unauthorized") {

                window.location.href = "/springApp/login";
            }
            console.error('Unexpected: ' + request.responseText);
        }
    });
}
function checkToken() {

    $.ajax({
        url: "/springApp/api/rest/students",
        type: "GET",
        beforeSend: function(xhr){
            xhr.setRequestHeader('X-Auth-Token', token);
        },
        success: function(data, textStatus, request){

        },
        error: function (request, status, error) {
            if (request.statusText == "Unauthorized") {

                window.location.href = "/springApp/login";
            }
            console.error('Unexpected: ' + request.responseText);
        }
    });
}