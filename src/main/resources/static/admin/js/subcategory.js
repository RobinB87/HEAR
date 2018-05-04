$("#addSubCategoryBtn").click(function(e) {
    e.preventDefault();

    var title = $('#titleField').val();

    $.post('/api/subcategory/add/', {
        title: title
    });
});