// DataTable for categories
$(document).ready(function () {
    var table = $("#categoryTable").DataTable({
        'ajax': {
            'url': '/api/category/all',
            'dataSrc': ''
        },
        "columns": [
            {"data": "id"},
            {"data": "title"},
            {
                "targets": -1,
                "data": null,
                "defaultContent": "<i class='fa fa-edit editBtn'></i> | <i class='fa fa-trash deleteBtn'></i>"
            }
            ]
    });

    // Edit button
    $('#categoryTable tbody').on('click', '.editBtn', function () {
        var data = table.row($(this).parents('tr')).data();

        $('#categoryIdField').val(data.id);
        $('#editCategoryTitleField').val(data.title);

        // gebruik modal() om modal te openen

        $('#editCategoryBtn').click(function () {
            var title = $('#editCategoryTitleField').val();
            $.post('/api/category/edit', {
                id: data.id,
                title: title
            }, function() {
                table.clear().draw();
            });
        });
    });


    // delete button
    $('#categoryTable tbody').on('click', '.deleteBtn', function () {       //categoryTable is de tabel
        var data = table.row($(this).parents('tr')).data();                 //get data of this row

        // get the values of this Id category:
        $('#categoryIdField').val(data.id);         //get id
        // gebruik modal() om modal te openen

        $('#deleteCategoryBtn').click(function () {           //button function
            $.get('/api/category/delete/' + data.id, {

            }, function() {
                table.clear().draw();
            });
        });
    });

    $("#addCategoryBtn").click(function (e) {
        e.preventDefault();

        var title = $('#categoryTitleField').val();
        console.log("plek 1");

        $.post('/api/category/add', {
            title: title
        }, function() {
            table.clear().draw();
        });

        console.log("plek 2");
    });

});
