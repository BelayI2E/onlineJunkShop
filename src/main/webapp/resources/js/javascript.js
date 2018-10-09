/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function buy(postId) {
    $.ajax({
        url: '/OnlineJunkShop/buy/' + postId,
        success: function (data) {
            alert("Successfull perform action!!!");
        }
    });
}
function wish(postId) {
    $.ajax({
        url: '/OnlineJunkShop/wish/' + postId,
        success: function (data) {
            alert("Successfull perform action!!!");
        }
    });
}


