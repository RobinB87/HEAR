$(document).ready(function () {
        var table = $("#ingredientTable").DataTable({
            'ajax': {
                'url': '/api/ingredient/all',
                'dataSrc': ''
            },
            "columns": [
                {"data": "id"},
                {"data": "title"},
                {"data": "price"},

                {
                    "targets": -1,
                    "data": null,
                    "defaultContent": "<i class='fa fa-edit editBtn'></i> | <i class='fa fa-trash deleteBtn'></i>"
                }
                ]
        });
});



$("#addIngredientSubmitBtn").click(function (e) {
    e.preventDefault();

    var title = $('#ingredientTitleField').val();
    var price = $('#ingredientPriceField').val();

    $.post('/api/ingredient/add', {
        title: title,
        price: price
    },  function() {
             table.clear().draw();
                })
});
