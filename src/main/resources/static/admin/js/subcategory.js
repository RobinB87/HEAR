$(document).ready(function () {
    var table = $("#subCategoryTable").DataTable({
        'ajax': {
            'url': '/api/subcategory/formatted/all',
            'dataSrc': ''
        },
        "columns": [
            {"data": "id"},
            {"data": "title"},
            {"data": "categoryTitle"},
            {
                "targets": -1,
                "data": null,
                "defaultContent": "<i class='fa fa-edit editBtn'></i> | <i class='fa fa-trash deleteBtn'></i>"
            }
        ]
    });

    var categoryArray = [];

    $.ajax({
        type: 'GET',
        url: '/api/category/all',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (i, itemData) {
                categoryArray[i] = itemData;
            });
        }
    });

    $('#addSubcategoryModal').click(function () {
        for (var i = 0; i < categoryArray.length; i++) {
            $('#categoryListSelect2')
                .append($("<option></option>")
                    .attr("value", categoryArray[i].id)
                    .text(categoryArray[i].title));
        }
    });

    $('#closeAddSubcategoryBtn').click(function () {
        for (var i = 0; i < categoryArray.length; i++) {
            $('#categoryListSelect2').empty();
        }
    });

    var index = 0;

    // Edit button
    $('#subcategoryTable tbody').on('click', '.editBtn', function () {
    $('#editSubcategoryModal').modal();
        var data = table.row($(this).parents('tr')).data();

        $('#editSubcategoryIdField').val(data.id);
        $('#editSubcategoryTitleField').val(data.title);

        console.table(data);

        $('#editSubcategoryBtn').click(function () {

            var title = $('#editDrinkTitleField').val();

            $.post('/api/subcategory/edit/' + data.categoryId, {
                id: data.id,
                title: title
            }, function() {
                table.clear().draw();
            });
        });
    });

    // Delete button
    $('#subcategoryTable tbody').on('click', '.deleteBtn', function () {
        $('#deleteSubcategoryModal').modal();

        var data = table.row($(this).parents('tr')).data();

        $('#deleteSubcategoryIdField').val(data.id);
        $('#deleteSubcategoryForm').val(data.title);

        $('#deleteSubcategoryBtn').click(function () {
           $.get('/api/subcategory/delete/' + data.id, {

           }, function() {
               table.clear().draw();
           });
        });
    });


    $('#addSubcategoryBtn').click(function (e) {
        e.preventDefault();

        var title = $('#subCategoryTitleField').val();

        $.post('/api/subcategory/add/' + $('#categoryListSelect2').val(), {
            title: title
        }, function () {
            table.clear().draw();
        });

        $('#subCategoryTitleField').empty();

    });

    $('#categoryListSelect2').select2();

});


