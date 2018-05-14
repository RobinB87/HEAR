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
            '<select class="select2 form-control" id="ingredients' + index + '">';

        for(var i = 0; i < ingredientsArray.length; i++) {
            html = html + '<option value="' + ingredientsArray[i].id + '" name="ingredient[]">' + ingredientsArray[i].getTitle() + '</option>';
        }

        html = html + '</select>' +
            '</div>';

        console.table(ingredientsArray);
        console.log(html);

        $('#ingredientContainer').append(html);
        $('#ingredients' + index).select2();

        index++;

    });

    $("#addDishBtn").click(function (e) {
        e.preventDefault();

        var ingredients = [];
        $('input[name="ingredient[]"]').each(function() {
           var ingredient = { id: $(this).val() };
           ingredients.add(ingredient);
        });

        console.log(ingredients);


        $.post('/api/menuitem/dish/add/' + $('#subCategoryListSelect2').val(), {
                title: $('#dishTitleField').val(),
                costPrice: $('#dishPriceField').val(),
                ingredients: ingredients

        }, function () {
            table.clear().draw();
        });
    });

    $('#subCategoryListSelect2').select2();
});