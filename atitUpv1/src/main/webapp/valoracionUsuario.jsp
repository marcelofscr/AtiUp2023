<%-- 
    Document   : valoracionUsuario
    Created on : Apr 19, 2023, 3:11:25 PM
    Author     : Fagares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Valoraciones</title>
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
            .w3-half img{
                margin-bottom:-6px;
                margin-top:16px;
                opacity:0.8;
                cursor:pointer
            }
            .w3-half img:hover{
                opacity:1
            }
        </style>
    </head>
    <body>
         <!-- Navbar -->
        <div class="w3-top">
            <div class="w3-bar w3-red w3-card w3-left-align w3-large">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Inicio</a>
                <a href="consultarPromptsUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Consultar Prompts</a>
                <a href="ConsultarTopXItems.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Top Items</a>
                <a href="valoracionUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion</a>
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">Inicio</a>
                <a href="consultarPromptsUsuario.jsp" class="w3-bar-item w3-button w3-padding-large">Consultar Prompts</a>
                <a href="ConsultarTopXItems.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Top Items</a>
                <a href="valoracionUsuario.jsp" class="w3-bar-item w3-button w3-padding-large">Valoracion</a>
            </div>
        </div>

        <!-- INSERTAR VALORACION -->
        <div class="w3-container" id="contact" style="margin-top:75px">
            <h1 class="w3-xxxlarge w3-text-red"><b>Valoracion.</b></h1>
            <hr style="width:50px;border:5px solid red" class="w3-round">
            
            <form action="../controladorValoracion" method="POST">
                <div class="w3-section">
                    <label for="stars">Estrellas (1-5):</label>
                    <input type="number" name="stars" min="1" max="5"><br><br>
                </div>
                <div class="w3-section">
                    <label>Email</label>
                    <input class="w3-input w3-border" type="text" name="Email" required>
                </div>
                <div class="w3-section">
                    <label for="comment">Comment:</label>
                    <textarea name="comment" rows="5" cols="40"></textarea><br><br>
                  <input type="submit" name= "accion" value="insertar" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
                </div>               
            </form> 
            
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

