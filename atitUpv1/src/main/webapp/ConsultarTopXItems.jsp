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
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">Inicio</a>
                <a href="consultarPromptsUsuario.jsp" class="w3-bar-item w3-button w3-padding-large">Consultar Prompts</a>
                <a href="ConsultarTopXItems.html" class="w3-bar-item w3-button w3-padding-large">Consulttar Top Items</a>
                <a href="valoracionRespuestaUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion Respuesta</a>
                <a href="valoracionEjemploUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion Ejemplos</a>
            </div>
        </div>

        <!-- Header -->
        <header class="w3-container w3-red w3-center" style="padding:56px 16px">
            <h1 class="w3-margin w3-jumbo">Consultar Top Items</h1>
        </header>

        <!-- Grid para ingresar consulta -->
        <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
            <label for="items">Considerar Respuestas:</label>
            <select name="considerarRespuestas" id="considerarRespuestas">
                <option value="True">Si</option>
                <option value="False">No</option>
            </select>
            <input class="form-check-input" type="checkbox" value="True" id="respuestasChatGPT" checked>
            <label class="form-check-label" for="flexCheckChecked">
                Respuestas de ChatGPT
            </label>
            <input class="form-check-input" type="checkbox" value="True" id="respuestasUsuarios" checked>
            <label class="form-check-label" for="flexCheckChecked">
                Respuestas de usuarios
            </label>
            </br>
            <label for="items">Considerar Ejemplos:</label>
            <select name="considerarRespuestas" id="considerarRespuestas">
                <option value="True">Si</option>
                <option value="False">No</option>
            </select>
            <input class="form-check-input" type="checkbox" value="True" id="ejemplosChatGPT" checked>
            <label class="form-check-label" for="flexCheckChecked">
                Ejemplos de ChatGPT
            </label>
            <input class="form-check-input" type="checkbox" value="True" id="ejemplosUsuarios" checked>
            <label class="form-check-label" for="flexCheckChecked">
                Ejemplos de usuarios
            </label>
            </br>
            <label for="items">Cantidad items:</label>
            <select name="limt" id="limit">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="1017">10</option>
            </select>
        </div>
        <input type="submit" name="listarTopItems" value="Listar top items" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom" href="consultarPromptUsuarioControlador?accion=consultarPromptsUsuario">
    
        

        <!-- First Grid -->
        <div class="w3-row-padding w3-padding-64 w3-container">                     
          
            <table>
                <thead>
                <tr>
                    <th>Pregunta</th>
                    <th>Respuesta</th>
                    <th>Ejemplo</th>
                    <th>Categoria</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="em" items="${item}" >
                    
                <tr>
                    <td>${em.getPrompt()}</td>
                    <td>${em.getRespuesta()}</td>
                    <td>${em.getEjemplo()}</td>
                    <td>${em.getCategoria()}</td>
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
