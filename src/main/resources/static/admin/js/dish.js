$("#addDishBtn").click(function (e) {
    e.preventDefault();

    var title = $('#dishTitleField').val();
    var price = $('#dishPriceField').val();
    var ingr = $('#dishIngredientListField').val();

    $.post('/api/menuitem/dish/add', {
        title: title,
        price: price,
        ingr: ingr

    });
});