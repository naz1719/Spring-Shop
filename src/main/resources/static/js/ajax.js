/**
 * Created by nazar on 4/9/17.
 */

$(document).ready(function () {
    $("#allProducts").click(function () {
        $.ajax({
            url: "products"
        })
            .done(function (result) {
                $("#products").html(result);
            });
    });
    $("#newProduct").click(function () {
        $.ajax({
            url: "/product/new"
        })
            .done(function (result) {
                $("#products").html(result);
            });
    });
});