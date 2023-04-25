<%-- 
    Document   : principalAdmin
    Created on : Apr 11, 2023, 8:14:33 PM
    Author     : Agustin Arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>PaginaInicioAdmin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
        <style>
            body,h1,h2,h3,h4,h5 {
                font-family: "Poppins", sans-serif
            }
            body {
                font-size:16px;
            }


        </style>
    </head>
    <body>


        <!-- Navbar -->
        <div class="w3-top">
            <div class="w3-bar w3-red w3-card w3-left-align w3-large">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Inicio</a>
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">Inicio</a>
            </div>
        </div>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:40px;margin-right:40px">

            <!-- Header -->
            <div class="w3-container" style="margin-top:80px" id="showcase">
                <h1 class="w3-jumbo"><b>aTitUp</b></h1>
            </div>

            <!-- Contact -->
            <div class="w3-container" id="contact" style="margin-top:75px">
                <h1 class="w3-xxxlarge w3-text-red"><b>Ingresar.</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">
                <form action="ingresarPromptAdmin.jsp" method="get">                    
                    <div class="w3-section">
                        <input class="w3-input w3-border" type="text" required id="email" name="email">
                        <label>Email</label></p>
                        <input class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom" type="submit" value="Ingresar" > 
                    </div>                    

                </form>  
            </div>

            <!-- End page content -->
        </div>


        <script>
            // Script to open and close sidebar
            function w3_open() {
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("myOverlay").style.display = "block";
            }

            function w3_close() {
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("myOverlay").style.display = "none";
            }

            // Modal Image Gallery
            function onClick(element) {
                document.getElementById("img01").src = element.src;
                document.getElementById("modal01").style.display = "block";
                var captionText = document.getElementById("caption");
                captionText.innerHTML = element.alt;
            }
        </script>

    </body>
</html>