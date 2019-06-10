$(document).on("click", "#front", function () {
    console.log('ss');
        var name = $('#number').val();
        console.log(name);
        $.get('ListServlet', {
            number : name,
        }, function(responseText) {
            $('#ajaxResponse').text(responseText);
    });
});