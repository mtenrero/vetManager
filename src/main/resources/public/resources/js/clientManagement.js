$(document).ready(function() {

    $("#newClient").hide();

    $("#client_switch").change(function () {
        if($('#client_switch').is(":checked")) {
            $("#existingClient").hide();
            $("#newClient").show();
        } else {
            $("#existingClient").show();
            $("#newClient").hide();

        }
    });

});

