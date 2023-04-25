<%-- 
    Document   : consultarPrompts
    Created on : Apr 19, 2023, 2:26:36 PM
    Author     : Daniella
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ConsultarItems</title>
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
                <a href="valoracionUsuario.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Valoracion</a>
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">Inicio</a>
                <a href="consultarPromptsUsuario.jsp" class="w3-bar-item w3-button w3-padding-large">Consultar Prompts</a>
                <a href="valoracionUsuario.jsp" class="w3-bar-item w3-button w3-padding-large">Valoracion</a>
            </div>
        </div>

        <!-- Header -->
        <header class="w3-container w3-red w3-center" style="padding:56px 16px">
            <h1 class="w3-margin w3-jumbo">Consultar Items</h1>
        </header>

        <!-- Grid para ingresar consulta -->
        <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
            <label for="items">Seleccionar categoria:</label>
            <select name="items" id="items">
                <option value="item1">Item 1</option>
                <option value="item2">Item 2</option>
            </select>
        </div>
        <input type="submit" name="listarCategorias" value="Listar categorias" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom" href="consultarPromptUsuarioControlador?accion=consultarPromptsUsuario">
    

        <!-- First Grid -->
        <div class="w3-row-padding w3-padding-64 w3-container">                     
          
            <table>
                <thead>
                <tr>
                    <th>Codigo de categoria</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="em" items="${categorias}" >
                    
                <tr>
                    <td>${em.toString()}</td>
                    <td>${em.toString()}</td>
                    <td>${em.toString()}</td>
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
                             function myF                        unction() {
                             var x = document.getElementById("navDemo");
                             if (x.className.indexOf("w3-show                            ") == -1) {
                                 x.className += " w3-show";
                             } else {
                                 x.className = x.className.replace(" w3-                        show", "");
                                 }
                             }
      </script>

    </body>
</html>