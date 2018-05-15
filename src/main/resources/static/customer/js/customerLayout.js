// $('#viewMenuBtn').click(viewMenu);
//
//
// function viewMenu(e) {
//     e.preventDefault();
//     $.get('#menu/index.html',
//         function (data) {
//             $('#content-box-menuCard').html(data);}
// //     )}
//
// $('#viewCategory').click(function(e) {
//     e.preventDefault();
//     $.get('category/index.html', function(data) {
//         $('#content-box-hear').html(data);
//     });
// });



$('#viewMenuBtn').click(function(e) {
    e.preventDefault();
    $.get('menu/index.html', function (data) {
            $('#content-box-menuCard').html(data);
        });
});