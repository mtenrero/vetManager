$(document).ready(function() {

    $("#newClient").hide();

    $("#client_switch").change(function () {
        if($('#client_switch').is(":checked")) {
            $("#existingClient").hide(200);
            $("#newClient").show(200);
        } else {
            $("#existingClient").show(200);
            $("#newClient").hide(200);

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

});

var fillResults = function (json) {
    for (var client in json) {
        $("#clientResultsTable tbody").append("<tr>" +
            "<td>" + json[client].firstName + "</td>" +
            "<td>" + json[client].lastName + "</td>" +
            "<td>Names</td>" +
            '<td><a id="client' + json[client].id + '" class="waves-effect waves-light btn clientSelector" clientID=' + json[client].id + '><i class="material-icons right">done</i>Choose</a></td>' +
            "</tr>");

    }

    $("a.clientSelector").click(function () {
        $("#clientDetails").show(200);
        $("#existingClient").hide(300);
        $("#switcher").hide(200);
        $("#clientIdInput").val(this.getAttribute("clientID"))

        console.log(this.getAttribute("clientID"));
    });

    $("#selectNewClient").click(function () {
        $("#clientDetails").hide(200);
        $("#existingClient").show(300);
        $("#switcher").show(200);
        $("#clientIdInput").val('');
    });
};

