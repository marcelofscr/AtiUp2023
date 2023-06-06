<%-- 
    Document   : analisisItemCategoria
    Created on : 27 abr 2023, 17:04:49
    Author     : Usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <title>AnalisisItemCategoria</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1>Hello World!</h1>
       <!-- Navbar -->
        <div class="w3-top">
            <div class="w3-bar w3-red w3-card w3-left-align w3-large">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Inicio</a>
                <a href="ConsultarTopXItems.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Top Items</a>
                <a href="analisisCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 1</a>
                <a href="analisisItem.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 2</a>
                <a href="analisisItemCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 3</a>
            
            </div>
            
        </div>

        <!-- Header -->
        <header class="w3-container w3-red w3-center" style="padding:56px 16px">
            <h1 class="w3-margin w3-jumbo">Analisis de Sentimientos</h1>
        </header>
        <div class="w3-row-padding w3-padding-64 w3-container">

        <!-- Grid para ingresar consulta -->
        <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
            <label for="items">Categorias:</label>

            <select name="items" id="items">
                <c:forEach var="CategoriaConceptual" items="${lista}">
                    <option> <c:out value = "${CategoriaConceptual.getCodigoCategoria()}" /></option>
                </c:forEach>   
            </select>
            <form action="../controladorMostrarCategoriasA" method="POST"  >
                <input type="submit" name= "accion" value="cargar" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">
            </form>
            
            <label for="items">Items:</label>
            <select name="items" id="items">
                <c:forEach var="Item" items="${lista2}">
                    <option> <c:out value = "${Item.getIdItem()}" /></option>
                </c:forEach>   
            </select>

        </div>  
            
            <form action="../controladorAnalisisCategoriaItem" method="POST" >
                <label>Digitar categoria:</label>
                <input class="w3-input" type="text" required id="selectedValue" name="selectedValue">
                <label>Digitar item:</label>
                <input class="w3-input" type="text" required id="selectedValue2" name="selectedValue2">
                <input type="submit" name= "accionI" value="consultar">
                <div class="w3-section">
                    <textarea name="analisisItem" rows="5" cols="40">
                     <%= request.getAttribute("myAnalisisItem")%>
                    </textarea><br><br>
                 <div class="w3-section">
                 
                
            </form>

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