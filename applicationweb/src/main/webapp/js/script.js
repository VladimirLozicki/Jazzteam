$(document).on("click", "#front", function () {
        var name = $('#number').val();
        $.get('ListServlet', {
            number : name,
        }, function(responseText) {
            $('#ajaxResponse').text(responseText);
    });
});