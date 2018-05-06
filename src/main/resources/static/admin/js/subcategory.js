$(document).ready(function () {
    var categoryList = $.get('/api/category/all', function (data) {
        return data;
    });

    $('#categoryListSelect2').select2({
        data: {
            results: function(data) {
                return {
                    results: $.map(data, function(item) {
                        return {
                            text: item.title,
                            id: item.id
                        }
                    })
                }
            }
        }
    });
});


$("#addSubCategoryBtn").click(function (e) {
    e.preventDefault();

    var title = $('#titleField').val();

    $.post('/api/subcategory/add/', {
        title: title
    });
});