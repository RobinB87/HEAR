$('#loadMenuBtn').click(function(e) {
    $.get('pages/menu.html', function(data) {
            $("#content").html(data);
            });
});

$('#gotToAdminBtn').click(function(e) {
   $.get('admin/index.html', function(data) {
       $('#content').html(data);
   });
});