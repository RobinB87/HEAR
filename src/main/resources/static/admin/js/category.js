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

    $('#categoryTable tbody').on('click', '.editBtn', function () {
        var data = table.row($(this).parents('tr')).data();

        $('#categoryIdField').val(data.id);
        $('#editCategoryTitleField').val(data.title);

        $("#editCategoryModal").modal();

        $('#editCategoryBtn').click(function () {
            var title = $('#editCategoryTitleField').val();
            $.post('/api/category/edit', {
                id: data.id,
                title: title
            });
        });
    });
});

$("#addCategoryBtn").click(function (e) {
    e.preventDefault();

    var title = $('#categoryTitleField').val();

    $.post('/api/category/add', {
        title: title
    });
});




