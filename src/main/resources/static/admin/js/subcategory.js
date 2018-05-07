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
});


$("#addSubCategoryBtn").click(function (e) {
    e.preventDefault();

    var title = $('#titleField').val();

    $.post('/api/subcategory/add', {
        title: title
    });
});