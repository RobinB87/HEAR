$(document).ready(function () {
    var table = $("#dishTable").DataTable({
        'ajax': {
            'url': '/api/menuitem/dish/formatted/all',
            'dataSrc': ''
        },
        "columns": [
            {"data": "id"},
            {"data": "title"},
            {"data": "price"},
            {"data": "subCategoryTitle"},
            {
                "targets": -1,
                "data": null,
                "defaultContent": "<i class='fa fa-edit editBtn'></i> | <i class='fa fa-trash deleteBtn'></i>"
            }
        ]
    });

    var subCategoryArray = [];

    $.ajax({
        type: 'GET',
        url: '/api/subcategory/all',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (i, itemData) {
                subCategoryArray[i] = itemData;
            });
        }
    });

    console.log(subCategoryArray);

    $('#newDishModal').click(function () {
        for (var i = 0; i < subCategoryArray.length; i++) {
            $('#subCategoryListSelect2')
                .append($("<option></option>")
                    .attr("value", subCategoryArray[i].id)
                    .text(subCategoryArray[i].title));
        }
    });

    $('#closeDishBtn').click(function () {
        for (var i = 0; i < subCategoryArray.length; i++) {
            $('#subCategoryListSelect2').empty();
        }
    });

    $("#addDishBtn").click(function (e) {
        e.preventDefault();

        $.post('/api/menuitem/dish/add/' + $('#subCategoryListSelect2').val(), {
            dish: {
                title: $('#dishTitleField').val(),
                costPrice: $('#dishPriceField').val()
            }

        }, function () {
            table.clear().draw();
        });
    });

    $('#subCategoryListSelect2').select2();
});