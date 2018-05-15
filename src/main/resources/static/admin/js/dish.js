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

    var ingredientsArray = [];

    $.ajax({
        type: 'GET',
        url: '/api/ingredient/all',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (i, itemData) {
                ingredientsArray[i] = itemData;
            });
        }
    });

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

    var index = 0;

    $('#addIngredientBtn').click(function (e) {
        e.preventDefault();

        var html = '<div class="form-group">' +
            '<select class="select2 form-control ingSelect" id="ingredients' + index + '">';

        for(var i = 0; i < ingredientsArray.length; i++) {
            html = html + '<option value="' + ingredientsArray[i].id + '" name="ingredient[]">' + ingredientsArray[i].title + '</option>';
        }

        html = html + '</select>' +
            '</div>';

        $('#ingredientContainer').append(html);
        $('#ingredients' + index).select2();

        index++;

    });

    var dish = {title: "" , costPrice: "", ingredients: []};


    // Add button
    $("#addDishBtn").click(function (e) {
        e.preventDefault();

        dish.title = $('#dishTitleField').val();
        dish.price = $('#dishPriceField').val();

        $('.ingSelect').each(function(index, value) {
           var ingredient = {  "id": $(this).val() };
           dish.ingredients.push(ingredient);
        });

        $.ajax({
           'contentType': 'application/json',
           'type': 'POST',
            'url': '/api/menuitem/dish/add/' + $('#subCategoryListSelect2').val(),
           'data': JSON.stringify(dish),
           success: function() {
               alert('gelukt');
               table.clear().draw();
           }
        });

    });

    // Edit button
    $('#dishTable tbody').on('click', '.editBtn', function () {
        $('#editDishModal').modal();                                    // Kusjes Robin & Sietske <3
        var data = table.row($(this).parents('tr')).data();

        $('#dishIdField').val(data.id);
        $('#editDishTitleField').val(data.title);

        $('#editCategoryEditBtn').click(function () {

            var title = $('#editDishTitleField').val();
            $.post('/api/menuitem/dish/edit', {
                id: data.id,
                title: title
            }, function() {
                table.clear().draw();
            });
        });
    });

    // Delete button
    $('#dishTable tbody').on('click', '.deleteBtn', function () {
        $('#deleteDishModal').modal();
        var data = table.row($(this).parents('tr')).data();

        $('#dishIdField').val(data.id);
        $('#deleteDishTitleField').val(data.title);

        $('#deleteDishConfirmBtn').click(function () {
            $.get('/api/menuitem/dish/delete/' + data.id, {

            }, function() {
                table.clear().draw();
            });
        });
    });

    $('#subCategoryListSelect2').select2();
});