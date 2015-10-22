/**
 * Created by Leo on 02/10/15.
 */


$(function() {
    console.log("Jquery looks ready !!")
    var nbCaracMax = 320;
    var container = $("#message");
    $(container.find("textarea")).on("keyup", function(e) {
        var nbCharLeft =  nbCaracMax - $(this).val().length;
        $(".nb_carac_remaining").html(nbCharLeft + "");
        if (nbCharLeft > 0) {
            $(".nb_carac_remaining").removeClass("label label-danger");
        } else {
            $(".nb_carac_remaining").addClass("label label-danger");
        }
    })
})