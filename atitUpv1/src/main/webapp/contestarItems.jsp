<%-- 
    Document   : ingresarPromptAdmin
    Created on : Apr 21, 2023, 4:11:18 PM
    Author     : Daniella
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Contestar ítems</title>
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
                <a href="ingresarPromptAdmin.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Prompts & Respuestas</a>
                
            </div>

            <!-- Navbar on small screens -->
            
        </div>       

        <!-- INGRESAR CURSOS -->
       <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
            <label for="items">Ver cursos:</label>

            <select name="items" id="items">
                <c:forEach var="String" items="${lista}">
                    <option> <c:out value = "${String}" /></option>
                </c:forEach>   
            </select>
            <%
                String selectedValue = request.getParameter("items");
            %>

            <form action="../ControladorListarIdItems" method="POST"  >
                <input type="submit" name= "accion" value="cargar" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
            </form>

        </div>

        <!-- INSERTAR VALORACION -->
        <div class="w3-container" id="contact" style="margin-top:75px">
            <h1 class="w3-xxxlarge w3-text-red"><b>Contestar ítem.</b></h1>
            <hr style="width:50px;border:5px solid red" class="w3-round">
            
            <form action="../controladorContestarItems" method="POST">
                <div class="w3-section">
                    <label for="stars">Id del ítem:</label>
                    <input type="text" name="iditem"><br><br>
                </div>                
                <div class="w3-section">
                     <label for="stars">Fuente de la respuesta :</label>
                    <input type="text" name="fuenteEjR"> <br><br>
                    </div>  
                    <label for="comment">Respuesta:</label>
                    <textarea name="ejemplop" rows="5" cols="40">
                         <%= request.getAttribute("myEjemplop") %>
                    </textarea><br><br>
                    <input type="submit" name= "accion" value="consultar respuesta" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
                    <p></p>
                    <input type="submit" name= "accion" value="insertarRespuesta" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">

                    <label for="comment">Ejemplo:</label>
                    <textarea name="ejemplo" rows="5" cols="40">
                         <%= request.getAttribute("myEjemplo") %>
                    </textarea><br><br>
                     <div class="w3-section">
                    <label for="stars">Fuente del ejemplo :</label>
                    <input type="text" name="fuenteEj"> <br><br>
                     <input type="submit" name= "accion" value="consultar ejemplo" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
                    </div> 
                 <div class="w3-section">               
                  <input type="submit" name= "accion" value="insertarEjemplo" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
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

