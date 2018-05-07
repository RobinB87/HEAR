$('#catSubmitBtn').click(function(e) {
   e.preventDefault();

   var title = $('#catTitle').val();

   $.post('/api/category/add', {
       title: title
   });
});

$('#createCategory').click(function(e) {
e.preventDefault();
   $.get('category/index.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

$('#viewCategory').click(function(e) {
e.preventDefault();
    $.get('category/index.html', function(data) {
        $('#content-box-hear').html(data);
     });
});

$('#createSubcategory').click(function(e) {
e.preventDefault();
   $.get('subcategory/create.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

$('#viewSubcategory').click(function(e) {
e.preventDefault();
    $.get('subcategory/index.html', function(data) {
        $('#content-box-hear').html(data);
    });
});

$('#createMenuItem').click(function(e) {
e.preventDefault();
   $.get('menuitem/create.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

$('#viewMenuItem').click(function(e) {
e.preventDefault();
   $.get('menuitem/index.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

$('#createIngredient').click(function(e) {
e.preventDefault();
   $.get('ingredients/create.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

$('#viewIngredient').click(function(e) {
e.preventDefault();
   $.get('ingredients/index.html', function(data) {
       $('#content-box-hear').html(data);
   });
});

