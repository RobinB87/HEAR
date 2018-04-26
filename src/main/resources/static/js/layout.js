$('#loadMenuBtn').click(function(e) {
    $.get('pages/menu.html', function(data) {
            $("#content").html(data);
            });
});

