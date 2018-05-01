$('#catSubmitBtn').click(function(e) {
   e.preventDefault();

   var title = $('#catTitle').val();

   $.post('/api/category/add', {
       title: title
   });
});