$(document).ready(function () {

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

    $('#addDrinkBtn').click(function (e) {
            e.preventDefault();

            var title = $('#addDrinkTitleField').val();
            var costPrice = $('#addDrinkCostPriceField').val();
            var sellingPrice = $('#addDrinkSellingPriceField').val();

            $.post('/api/menuitem/drink/add/' + $('#subCategoryListSelect2').val(), {
                drink: {
                title: title,
                costPrice: costPrice,
                sellingPrice: sellingPrice
                }
            }, function () {
                table.clear().draw();
            });

            $('#addDrinkTitleField').empty();
            $('#addDrinkCostPriceField').empty();
            $('#addDrinkSellingPriceField').empty();
    });

    $('#subCategoryListSelect2').select2();

});
