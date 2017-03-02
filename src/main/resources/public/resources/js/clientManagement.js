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

    $("#autocomplete-lastname").keyup(function (e) {
        var searchContent = $("#autocomplete-lastname").val();
        $.ajax({
            url: "/dashboard/clients/filter",
            type: "get",
            data: {
                content: searchContent
            },
            success: function (response) {
                $("#clientResultsTable tbody tr").each( function(){
                    this.remove();
                });
                console.log(response);
                fillResults(response);
            },
            error: function (xhr) {
                
            }
        });
    });
    
    $("a.clientSelector").click(function () {
        alert("PULSADOOOOO");
    });

});

var fillResults = function (json) {
    for (var client in json) {
        $("#clientResultsTable tbody").append("<tr>" +
            "<td>" + json[client].firstName + "</td>" +
            "<td>" + json[client].lastName + "</td>" +
            "<td>Names</td>" +
            '<td><a id="client' + json[client].id + '" class="waves-effect waves-light btn clientSelector"><i class="material-icons right">done</i>Choose</a></td>' +
            "</tr>");

    }
}

