// DataTable for categories
$(document).ready(function () {
    $("#categoryTable").DataTable({
        "processing": true,
        "serverSide": true,
        'ajax': {
            'url': '/api/category/all',
            'dataSrc': ''
        },
        'columns': [
            {"data": "id"},
            {"data": "title"}
        ]
    });
});

$("#addCategoryBtn").click(function (e) {
    e.preventDefault();

    var title = $('#titleField').val();

    $.post('/api/category/add', {
        title: title
    });
});





