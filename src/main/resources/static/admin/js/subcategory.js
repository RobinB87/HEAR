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

    $('#newSubcategoryModal').click(function () {
        for (var i = 0; i < categoryArray.length; i++) {
            $('#categoryListSelect2')
                .append($("<option></option>")
                    .attr("value", categoryArray[i].id)
                    .text(categoryArray[i].title));
        }
    });

    $('#closeButton').click(function () {
        for (var i = 0; i < categoryArray.length; i++) {
            $('#categoryListSelect2').empty();
        }
    });

    $('.categoryListSelect2').select2();

    $('#subCategorySubmitBtn').click(function (e) {
        e.preventDefault();

        var title = $('#subCategoryTitleField').val();
        var categoryId = $('#categoryListSelect2').val();

        $.post('/api/subcategory/add/' + categoryId, {
            title: title
        }, function () {
            table.clear().draw();
        });

        $('#subCategoryTitleField').empty();
    });
});



