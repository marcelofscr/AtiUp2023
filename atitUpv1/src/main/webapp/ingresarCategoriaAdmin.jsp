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
        <title>RegistrarCategorias</title>
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
                <a href="ingresarCategoriaAdmin.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Categorias</a>
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">Inicio</a>
                <a href="ingresarPromptAdmin.jsp" class="w3-bar-item w3-button w3-padding-large">Prompts & Respuestas</a>
                <a href="ingresarCategoriaAdmin.jsp" class="w3-bar-item w3-button w3-padding-large">Agregar ítems</a>
            </div>
        </div>       

        <!-- INGRESAR CURSOS -->
       <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
            <label for="items">Seleccionar curso:</label>

            <select name="items" id="items">
                <c:forEach var="Curso" items="${lista}">
                    <option> <c:out value = "${Curso.getNombre()}" /></option>
                </c:forEach>   
            </select>
            <%
                String selectedValue = request.getParameter("items");
            %>

            <form action="../controladorMostrarCursos" method="POST"  >
                <input type="submit" name= "accion" value="cargar" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
            </form>

        </div>

            <!<!-- comment -->
        
         <!-- INSERTAR CATEGORIA -->
        <div class="w3-container" id="contact" style="margin-top:75px">
            <h1 class="w3-xxxlarge w3-text-red"><b>Categoria</b></h1>
            <hr style="width:50px;border:5px solid red" class="w3-round">
            <form action="../controladorGuardarCategoria" method="POST">
                <div class="w3-section">
                    <label for="stars">Curso:</label>
                    <input type="text" name="curso"><br><br>
                </div> 
                <div class="w3-section">
                    <label for="stars">Categoría:</label>
                    <input type="text" name="stars"><br><br>
                </div>                
                <div class="w3-section">
                    <label for="comment">Descripción:</label>
                    <textarea name="comment" cols="40"></textarea><br><br>
                    <input type="submit" name= "accion" value="insertar" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
                </div>
            </form>   
        
    </body>
</html>
