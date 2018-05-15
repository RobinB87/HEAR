$('#loadMenuBtn').click(function(e) {
    $.get('customer/index.html', function(data) {
            $("#content").html(data);
            });
});

$('#gotToAdminBtn').click(function(e) {
   $.get('admin/index.html', function(data) {
       $('#content').html(data);
   });
});