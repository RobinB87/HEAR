$(document).ready(function () {

    var table = $("#drinkTable").DataTable({
        'ajax': {
            'url': '/api/menuitem/drink/formatted/all',
            'dataSrc': ''
        },
        "columns": [
            {"data": "id"},
            {"data": "title"},
            {"data": "costPrice"},
            {"data": "sellingPrice"},
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

    $('#addDrinkModal').click(function () {
        for (var i = 0; i < subCategoryArray.length; i++) {
            $('#subCategoryListSelect2')
                .append($("<option></option>")
                    .attr("value", subCategoryArray[i].id)
                    .text(subCategoryArray[i].title));
        }
    });

    $('#closeAddDrinkBtn').click(function () {
        for (var i = 0; i < subCategoryArray.length; i++) {
            $('#subCategoryListSelect2').empty();
        }
    });

    var index = 0;

	// Edit button
    $('#drinkTable tbody').on('click', '.editBtn', function () {
    $('#editDrinkModal').modal();
        var data = table.row($(this).parents('tr')).data();

        $('#editDrinkIdField').val(data.id);
        $('#editDrinkTitleField').val(data.title);
        $('#editDrinkCostPriceField').val(data.costPrice);
        $('#editDrinkSellingPriceField').val(data.sellingPrice);

        console.table(data);

        $('#editDrinkBtn').click(function () {

            var title = $('#editDrinkTitleField').val();
            var costPrice = $('#editDrinkCostPriceField').val();
            var sellingPrice = $('#editDrinkSellingPriceField').val();

            $.post('/api/menuitem/drink/edit/' + data.subCategoryId, {
                id: data.id,
                title: title,
                costPrice: costPrice,
                sellingPrice: sellingPrice
            }, function() {
                table.clear().draw();
            });
        });
    });

    // Delete button
    $('#drinkTable tbody').on('click', '.deleteBtn', function () {
        $('#deleteDrinkModal').modal();

        var data = table.row($(this).parents('tr')).data();

        $('#deleteDrinkIdField').val(data.id);
        $('#deleteDrinkForm').val(data.title);

        $('#deleteDrinkBtn').click(function () {
           $.get('/api/menuitem/drink/delete/' + data.id, {

           }, function() {
               table.clear().draw();
           });
        });
    });

    $('#addDrinkBtn').click(function (e) {
            e.preventDefault();

            var title = $('#addDrinkTitleField').val();
            var costPrice = $('#addDrinkCostPriceField').val();
            var sellingPrice = $('#addDrinkSellingPriceField').val();

            $.post('/api/menuitem/drink/add/' + $('#subCategoryListSelect2').val(), {
                title: title,
                costPrice: costPrice,
                sellingPrice: sellingPrice
            }, function () {
                table.clear().draw();
            });

            $('#addDrinkTitleField').empty();
            $('#addDrinkCostPriceField').empty();
            $('#addDrinkSellingPriceField').empty();
    });

    $('#subCategoryListSelect2').select2();

});
