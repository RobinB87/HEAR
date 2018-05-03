$("#submitBtn").click(function(e) {
    e.preventDefault();

    $.post('api/category/add', {
    title:title

    });
});





