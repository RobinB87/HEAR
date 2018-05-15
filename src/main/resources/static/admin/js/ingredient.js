$(document).ready(function () {
        var table = $("#ingredientTable").DataTable({
            'ajax': {
                'url': '/api/ingredient/all',
                'dataSrc': ''
            },
            "columns": [
                {"data": "id"},
                {"data": "title"},
                {"data": "costPrice"},

                {
                    "targets": -1,
                    "data": null,
                    "defaultContent": "<i class='fa fa-edit editBtn'></i> | <i class='fa fa-trash deleteBtn'></i>"
                }
                ]
        });
        // Add ingredient functie
$("#addIngredientSubmitBtn").click(function (e) {
    e.preventDefault();

    var title = $('#ingredientTitleField').val();
    var costPrice = $('#ingredientPriceField').val();

    $.post('/api/ingredient/add', {
        title: title,
        costPrice: costPrice
    },  function() {
             //table.clear().draw();
             table.ajax.reload();
                });
    });
        // Edit ingredient functie
$('#ingredientTable tbody').on('click', '.editBtn', function () {
    $('#editIngredientModal').modal();
        var data = table.row($(this).parents('tr')).data();

        $('#ingredientIdField').val(data.id);
        $('#editIngredientTitleField').val(data.title);
		$('#editIngredientPriceField').val(data.costPrice);

        $('#editIngredientEditBtn').click(function () {

            var title = $('#editIngredientTitleField').val();
            var costPrice = $('#editIngredientPriceField').val();
            $.post('/api/ingredient/edit', {
                id: data.id,
                costPrice: costPrice,
                title: title
            }, function() {
                //table.clear().draw();
                table.ajax.reload();
            });

        });
    });
        // Delete Ingredient
     $('#ingredientTable tbody').on('click', '.deleteBtn', function () {
        $('#deleteIngredientModal').modal();
            var data = table.row($(this).parents('tr')).data();

            $('#ingredientIdField').val(data.id);
    		$('#deleteIngredientForm').val(data.title);

            $('#deleteIngredientConfirmBtn').click(function () {
                $.get('/api/ingredient/delete/' + data.id, {

                }, function() {
                    //table.clear().draw();
                    table.ajax.reload();
            });
      });
    });
});
