$(document).ready(function () {
    $("#subCategoryTable").DataTable({
        "processing": true,
        "serverSide": true,
        'ajax': {
            'url': '/api/subcategory/all',
            'dataSrc': ''
        },
        'columns': [
            {"data": "id"},
            {"data": "title"},
            {"data": "categoryTitle"}
        ]
    });
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

$('#newSubcategoryModal').click(function() {
    for (var i = 0; i < categoryArray.length; i++) {
        $('#categoryListSelect2')
            .append($("<option></option>")
                .attr("value", categoryArray[i].id)
                .text(categoryArray[i].title));
    }
});

$('#closeButton').click(function() {
   for(var i = 0; i < categoryArray.length; i++) {
       $('#categoryListSelect2').empty();
   }
});

$(document).ready(function() {
    $('#categoryListSelect2').select2();

    $('#subCategorySubmitBtn').click(function (e) {
        e.preventDefault();
        console.log("erin");

        var title = $('#subCategoryTitleField').val();
        var categoryId = $('#categoryListSelect2').val();

        $.post('/api/subcategory/add/' + categoryId, {
            title: title
        });

        $('#subCategoryTitleField').empty();
    });
});


