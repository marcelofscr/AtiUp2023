<%-- 
    Document   : consultarPrompts
    Created on : Apr 19, 2023, 2:26:36 PM
    Author     : Daniella
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>PaginaInicioUsuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


        <style>
            body,h1,h2,h3,h4,h5,h6 {
                font-family: "Lato", sans-serif
            }
            .w3-bar,h1,button {
                font-family: "Montserrat", sans-serif
            }
            .fa-anchor,.fa-coffee {
                font-size:200px
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

        <!-- Header -->
        <header class="w3-container w3-red w3-center" style="padding:64px 16px">
            <h1 class="w3-margin w3-jumbo">aTitUp</h1>
            <p class="w3-xlarge">aTi tUtor Personal</p>
        </header>

        <!-- First Grid -->
        <div class="w3-row-padding w3-padding-64 w3-container">
            <div class="w3-content">
                <div class="w3-twothird">
                    <h1>Registrarse</h1>
                    <form class="w3-container" action="consultarPromptsUsuario.jsp" method="get">
                        <div id="google_translate_element"></div>
                        <script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
                        <script>
                    function googleTranslateElementInit() {
                        new google.translate.TranslateElement(
                                {pageLanguage: 'en'},
                                'google_translate_element'
                                );
                    }
                        </script>
                        <p>
                        <input class="w3-input" type="text" required id="email" name="email">
                            <label>Email</label></p>
                        <input class="w3-button w3-black w3-padding-large w3-large w3-margin-" type="submit" value="Ingresar" >                       
                    </form>                     
                </div>
                <div class="w3-third w3-center">
                    <i class="fa fa-anchor w3-padding-64 w3-text-red"></i>
                </div>
            </div>
        </div>

        <!-- Second Grid -->
        <div class="w3-row-padding w3-light-grey w3-padding-64 w3-container">
            <div class="w3-content">
                <div class="w3-third w3-center">
                    <i class="fa fa-coffee w3-padding-64 w3-text-red w3-margin-right"></i>
                </div>

                <div class="w3-twothird">
                    <h1>Acerca de Nosotros</h1>
                    <h5 class="w3-padding-32">La computación cognitiva nos abre una puerta para el diseño y construcción de aplicaciones innovadoras y disruptivas. En ATI estamos llamados a potencializar la sofisticación de los negocios a través del uso intensivo e innovador
                        de la tecnología en todos los aspectos de la vida personal, profesional y empresarial. Nuestra carrera tiene frente así una gran oportunidad de entrar en la era cognitiva para agregar valor a la formación de profesionales capaces de romper con el status quo y encontrar nuevos modelos de negocio, ya sea por sus propios 
                        emprendimientos,o aportando su conocimiento y experiencias a las cadenas de valor empresariales. La capacidad de incorporar, entre otras, capacidades de procesamiento de lenguaje natural, representación de conocimientos, aprendizaje 
                        de máquina y traducción de contenidos a nuestras aplicaciones de usuario final, puede representar la ventaja competitiva en los modelos de negocios ofrecidos a los clientes.</h5>
                </div>
            </div>
        </div>

        <script>
            // Used to toggle the menu on small screens when clicking on the menu button
            function myFunction() {
                var x = document.getElementById("navDemo");
                if (x.className.indexOf("w3-show") == -1) {
                    x.className += " w3-show";
                } else {
                    x.className = x.className.replace(" w3-show", "");
                }
            }
        </script>

    </body>
</html>
