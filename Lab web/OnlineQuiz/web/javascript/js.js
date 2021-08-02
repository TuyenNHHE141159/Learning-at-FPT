/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var index;
var txt;
var total;
function setValue(myindex, mytxt, mytotal) {
    index = myindex;
    txt = mytxt;
    total = mytotal;
}
var questions = document.getElementsByClassName('perQuestion');
function display() {
    for (var i = 0; i < questions.length; i++) {
        questions[i].style.display = 'none';
    }
    questions[index].style.display = 'block';
}

function submitToServer() {
    if (index === questions.length - 1) {
        var myForm = document.createElement("form");
        myForm.method = "POST";
        myForm.action = "result";
        myForm.style.display = "none";
        var myInput = document.createElement("input");
        myInput.type = "text";
        myInput.name = "data";
        myInput.value = txt;
        myForm.appendChild(myInput);
        document.body.appendChild(myForm);
        myForm.submit();
    }
}
function addQuestion(qid) {
    txt += qid + '-';
    var checkboxes = document.querySelectorAll('input[type=checkbox]:checked');
    if (checkboxes.length !== 0) {
        for (var i = 0; i < checkboxes.length; i++) {
            if (i !== checkboxes.length - 1) {
                txt += checkboxes[i].value + ' ';
            } else {
                txt += checkboxes[i].value;
            }
        }
//cho tat ca checkbox ve false
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = false;
        }
    }
    if (index !== questions.length - 1) {
        txt += '|';
    }
}

function nextQuestion(qid) {
    addQuestion(qid);
    submitToServer();
    index++;
    document.cookie = "myindex=" + index;
    document.cookie = "answers=" + txt;
    console.log(txt);
    display();
}


function timer() {
    total--;
    if (total <= 0) {
        document.getElementsByTagName("button")[index].click();
        submitToServer();
        return;
    }
    var minute = Math.floor(total / 60);
    var second = total - minute * 60;
    var timeBox = document.getElementById('t');
    if (second < 10) {
        timeBox.innerHTML = minute + ":0" + second;
    } else {
        timeBox.innerHTML = minute + ":" + second;
    }
}
var checkMenu = false;
function dropDown() {
   
    var btnMenu = document.getElementsByClassName('all_menu1');
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

