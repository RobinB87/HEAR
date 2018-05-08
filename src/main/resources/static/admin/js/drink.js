// DataTable for drinks
$(document).ready(function () {
    var table = $("#drinkTable").DataTable({
        'ajax': {
            'url': '/api/menuitem/drink/all',
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

    // Edit button
    $('#drinkTable tbody').on('click', '.editBtn', function () {
        var data = table.row($(this).parents('tr')).data();

        $('#editDrinkIdField').val(data.id);
        $('#editDrinkTitleField').val(data.title);
        $('#editDrinkPriceField').val(data.price);


        $("#editDrinkModal").modal();

        $('#editDrinkBtn').click(function () {
            var title = $('#editDrinkTitleField').val();
            var price = $('#editPriceTitleField').val();

            $.post('/api/menuitem/drink/edit', {
                id: data.id,
                title: title,
                price: price
            }, function() {
                table.clear().draw();
            });
        });
    });


    // delete button
    $('#drinkTable tbody').on('click', '.deleteBtn', function () {       //drinkTable is de tabel
        var data = table.row($(this).parents('tr')).data();                 //get data of this row

        // get the values of this Id category:
        $('#deleteDrinkIdField').val(data.id);         //get id
        $("#deleteDrinkModal").modal();      //open confirmation

        $('#deleteDrinkBtn').click(function () {           //button function
            $.get('/api/menuitem/drink/delete/' + data.id, {

            }, function() {
                table.clear().draw();
            });
        });
    });


    // Add button
    $("#addDrinkBtn").click(function (e) {
        e.preventDefault();

        var title = $('#drinkTitleField').val();
        var price = $('#drinkPriceField').val();

        $.post('/api/menuitem/drink/add', {
            title: title,
            price: price
        }, function() {
            table.clear().draw();
        });
    });
});