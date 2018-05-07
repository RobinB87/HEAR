// DataTable for categories
$(document).ready(function () {
    var table = $("#categoryTable").DataTable({
        "processing": true,
        "serverSide": true,
        'ajax': {
            'url': '/api/category/all',
            'dataSrc': ''
        },
        "columns": [
            {"data": "id"},
            {"data": "title"},
            {
                "targets": -2,
                "data": null,
                "defaultContent": "<button class='btn btn-default editBtn'>Edit</button>"
            },
            {
                "targets": -1,
                "data": null,
                "defaultContent": "<button class='btn btn-default deleteBtn'>Delete</button>"
            }
            ]
    });

    $('#categoryTable tbody').on( 'click', '.editBtn', function () {
        var data = table.row( $(this).parents('tr') ).data();
        alert('You want to edit: ' + data.title + ' with id: ' + data.id );
    } );

    $('#categoryTable tbody').on( 'click', '.deleteBtn', function() {
        var data = table.row( $(this).parents('tr') ).data();
        alert('Delete Button: ' + data.title + ' with id: ' + data.id );


    })
});

$("#addCategoryBtn").click(function (e) {
    e.preventDefault();

    var title = $('#categoryTitleField').val();

    $.post('/api/category/add', {
        title: title
    });
});




