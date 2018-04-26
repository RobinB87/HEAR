showCategories();

function showCategories() {
    var html = '';

    $.get('/api/menu/categories', function(data) {
        for (var i = 0; i < data.length; i++) {
            html += '<h1>- ' + data[i].name + '</h1>';
            html += showSubCategories(data[i].subCategories);
        }

        $('#menukaart').html(html);
    });
}

function showSubCategories(data) {
    var html = '';

    for (var i = 0; i < data.length; i++) {
        html += '<h2>-- ' + data[i].name + '</h2>';
        html += showMenuItems(data[i].menuItems);
    }
    return html;
}

function showMenuItems(data) {
    var html = '';

    for (var i = 0; i < data.length; i++) {
        html += '<h3>--- ' + data[i].name + ' ' + data[i].price + '</h3>';
        html += showIngredients(data[i].ingredientList);
    }
    return html;
}

function showIngredients(data) {
    var html = '';

    for (var i = 0; i < data.length; i++){
        html += '<h4>----' + data[i].name + ' ' + data[i].price + '</h4>';
    }
    return html;
}
