/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var index = 0;
var images = document.getElementsByClassName('slideImg');
function display() {
    for (var i = 0; i < images.length; i++) {
        images[i].style.display = 'none';
    }
    images[index].style.display = 'block';
}
function nextImage() {
    if (index === images.length - 1) {
        index = 0;
    } else {
        index++;
    }
    display();
}
function backImage() {
    if (index === 0) {
        index = images.length - 1;
    } else {
        index--;
    }
    display();
}
var check = false;
var run;
function change() {
    if (check === false) {
        run = setInterval(function () {
            nextImage()
        }, 2000);
        check = true;
    } else {
        clearInterval(run);
        check = false;
    }
} 
var checkMenu = false;
function dropDown() {
   
    var btnMenu = document.getElementsByClassName('nav-link');
    if (checkMenu === false) {
        for (var i = 0; i < btnMenu.length; i++) {
            btnMenu[i].style.display = 'block';         
        }
        checkMenu = true;
               
    } else {
        for (var i = 0; i < btnMenu.length; i++) {
            btnMenu[i].style.display ="none";          
        }
         checkMenu = false;
    }


}




