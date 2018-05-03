$('#catSubmitBtn').click(function(e) {
   e.preventDefault();

   var title = $('#catTitle').val();

   $.post('/api/category/add', {
       title: title
   });
});

$('#createCategory').click(function(e) {
e.preventDefault();
   $.get('category/create.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

$('#viewCategory').click(function(e) {
e.preventDefault();
    $.get('category/index.html', function(data) {
        $('#content-box-hear').html(data);

        });

        });
