$("#addDrinkBtn").click(function (e) {
    e.preventDefault();

    var title = $('#drinkTitleField').val();
    var price = $('#drinkPriceField').val();

    $.post('/api/menuitem/drink/add', {
        title: title,
        price: price
    });
});