// DataTable for categories
$(document).ready(function () {
    var myEditor;
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
        ],
        'buttons': [
            { extend: 'create', editor: myEditor },
            { extend: 'edit',   editor: myEditor },
            { extend: 'remove', editor: myEditor }
        ]
    });
});

$("#addCategoryBtn").click(function (e) {
    e.preventDefault();

    var title = $('#categoryTitleField').val();

    $.post('/api/category/add', {
        title: title
    });
});




