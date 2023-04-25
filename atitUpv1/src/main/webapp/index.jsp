<%-- 
    Document   : index
    Created on : Apr 11, 2023, 8:01:51 PM
    Author     : Agustin Arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>MainPage</title>
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

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
            <div class="w3-container">
                <h3 class="w3-padding-64"><b>aTitUp</b></h3>
            </div>
            <div class="w3-bar-block">
                <a href="index.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Pagina Principal</a> 
                <a href="principalAdmin.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Administrador</a> 
                <a href="principalUsuario.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Usuario</a> 
            </div>
        </nav>

        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
            <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
            <span>aTitUp</span>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px">

            <!-- Header -->
            <div class="w3-container" style="margin-top:80px" id="showcase">
                <h1 class="w3-jumbo"><b>aTi tUtor Personal</b></h1>
            </div>            

            <!-- Services -->
            <div class="w3-container" id="services" style="margin-top:75px">
                <h1 class="w3-xxxlarge w3-text-red"><b>Servicios.</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">
                <h5>La computación cognitiva nos abre una puerta para el diseño y construcción de aplicaciones innovadoras y disruptivas. En ATI estamos llamados a potencializar la sofisticación de los negocios a través del uso intensivo e innovador
                    de la tecnología en todos los aspectos de la vida personal, profesional y empresarial.</h5>
            </div>

            <!-- Packages / Pricing Tables -->
            <div class="w3-container" id="packages" style="margin-top:75px">
                <h1 class="w3-xxxlarge w3-text-red"><b>Ingresar.</b></h1>
                <hr style="width:50px;border:5px solid red" class="w3-round">
            </div>

            <div class="w3-row-padding">
                <div class="w3-half w3-margin-bottom">
                    <ul class="w3-ul w3-light-grey w3-center">
                        <li class="w3-dark-grey w3-xlarge w3-padding-32">Admin.</li>                        
                        <li class="w3-light-grey w3-padding-24">
                            <form action="principalAdmin.jsp">
                                <input type="submit" value="Ingresar">
                            </form>
                        </li>
                    </ul>
                </div>

                <div class="w3-half">
                    <ul class="w3-ul w3-light-grey w3-center">
                        <li class="w3-red w3-xlarge w3-padding-32">Usuario</li>                        
                        <li class="w3-light-grey w3-padding-24">
                            <form action="principalUsuario.jsp">
                                <input type="submit" value="Ingresar">
                            </form>                            
                    </ul>
                </div>
            </div>
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
