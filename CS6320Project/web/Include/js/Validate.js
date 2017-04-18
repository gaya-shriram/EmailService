/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validate() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if (username == null || username == "") {
            alert("Please enter the username.");
            return false;
        }
        if (password == null || password == "") {
            alert("Please enter the password.");
            return false;
        }

    } 
