$("#addCategoryBtn").click(function(e) {
    e.preventDefault();

    var title = $('#titleField').val();

    $.post('/api/category/add/', {
        title: title
    });
});





