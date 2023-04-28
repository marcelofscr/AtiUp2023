<%-- 
    Document   : ConsultarTopXItems
    Created on : 25 abr 2023, 15:21:33
    Author     : Marcelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ConsultarTopItems</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {
                font-family: "Lato", sans-serif
            }
            .w3-bar,h1,button {
                font-family: "Montserrat", sans-serif
            }
            table, th, td {
                border: 1px solid;
                width: 90%;
            }
            select {
                width: 500px;
                margin: 10px;
            }
            select:focus {
                min-width: 150px;
                width: 500px;
            }
            w3-bar,h2,button {
                font-family: "Montserrat", sans-serif
            }
            form {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            input[type="submit"] {
                margin: 10px 0;
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
                <a href="ConsultarTopXItems.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Consultar Top Items</a>
                <a href="valoracionRespuestaUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion Respuesta</a>
                <a href="valoracionEjemploUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion Ejemplos</a>
                 <a href="analisisCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 1</a>
                <a href="analisisItem.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 2</a>
                <a href="analisisItemCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 3</a>
            
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">Inicio</a>
                <a href="consultarPromptsUsuario.jsp" class="w3-bar-item w3-button w3-padding-large">Consultar Prompts</a>
                <a href="ConsultarTopXItems.jsp" class="w3-bar-item w3-button w3-padding-large">Consulttar Top Items</a>
                <a href="valoracionRespuestaUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion Respuesta</a>
                <a href="valoracionEjemploUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion Ejemplos</a>
                <a href="analisisCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 1</a>
                <a href="analisisItem.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 2</a>
                <a href="analisisItemCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 3</a>
            
            </div>
        </div>

        <!-- Header -->
        <header class="w3-container w3-red w3-center" style="padding:56px 16px">
            <h1 class="w3-margin w3-jumbo">Consultar Top Items</h1>
        </header>

        <!-- Grid para ingresar consulta -->
        <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">            


            <!--PARA CONSULTAS -->            
            <form action="../ConsultarTopXItemsControlador"  method="POST" class="w3-button w3-green w3-padding-large w3-large w3-margin-right" >     
                <label>TOP (1-10):</label>
                <input class="w3-input" type="text" required id="topNumero" name="topNumero">  
                <!-- CONSULTA 1 -->     
                <input type="submit" name= "accionTop" value="ValoracionEjemplo">
                <input type="submit" name= "accionTop" value="ValoracionRespuesta">
                <input type="submit" name= "accionTop" value="ValoracionAmbas"><br>
                <!-- CONSULTA 2 --> 
                <input type="submit" name= "accionTop" value="ValoracionResAdmin">
                <input type="submit" name= "accionTop" value="ValoracionReschatgpt">
                <input type="submit" name= "accionTop" value="ValoracionResFuenteAmbas"><br>
                <!-- CONSULTA 3 --> 
                <input type="submit" name= "accionTop" value="ValoracionEjAdmin">
                <input type="submit" name= "accionTop" value="ValoracionEjchatgpt">
                <input type="submit" name= "accionTop" value="ValoracionEjFuenteAmbas"><br>               
            </form>
        </div> 


        <!-- Tabla Grid -->
        <div class="w3-row-padding w3-padding-64 w3-container">                     

            <table>
                <thead>
                    <tr>                        
                        <th>Prompt</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="str" items="${listait}">
                        <tr>                            
                            <td><c:out value = "${str}" /></td>                            
                        </tr>
                    </c:forEach>                
                </tbody>
            </table>


            <% String email = request.getParameter("email");%>
            <h5 style="margin-top: 20px;">Correo: <%= email%></h5>
            <button class="w3-button w3-green w3-padding-large w3-large w3-margin-right">Enviar pdf al correo</button>

        </div>

        <script>
            // Used to toggle the menu on small screens when clicking on the                     menu button
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
