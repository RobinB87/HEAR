$("#addIngredientBtn").click(function (e) {
    e.preventDefault();

    var title = $('#ingredientTitleField').val();
    var price = $('#ingredientPriceField').val();

    $.post('/api/ingredient/add', {
        title: title,
        price: price
    });
});