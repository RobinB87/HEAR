$(document).ready(function () {

$('#addDrinkBtn').click(function (e) {
        e.preventDefault();

        var title = $('#addDrinkTitleField').val();
        var costPrice = $('#addDrinkCostPriceField').val();
        var sellingPrice = $('#addDrinkSellingPriceField').val();

        $.post('/api/menuitem/drink/add', {
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

});
