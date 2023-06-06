<%-- 
    Document   : bitacoraConsultas
    Created on : Jun 3, 2023, 1:30:05 PM
    Author     : Daniella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BitacoraConsultas</title>
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
            .styled-button {
                background-color: #4CAF50; /* Set the background color */
                border: none; /* Remove border */
                color: green; /* Set text color */
                padding: 10px 20px; /* Set padding */
                text-align: center; /* Align text center */
                text-decoration: none; /* Remove underline */
                display: inline-block; /* Make it an inline element */
                font-size: 16px; /* Set font size */               
                border-radius: 4px; /* Add rounded corners */
            }

        </style>
    </head>
    <body>

        <!-- Navbar -->
        <div class="w3-top">
            <div class="w3-bar w3-red w3-card w3-left-align w3-large">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Inicio</a>
                <a href="ConsultarTopXItems.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Consultar Top</a>
                <a href="analisisCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 1</a>
                <a href="analisisItem.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 2</a>
                <a href="analisisItemCategoria.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Analisis 3</a>
                <a href="bitacoraConsultas.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Bitacora</a>
            </div>            
        </div>

        <!-- Header -->
        <header class="w3-container w3-red w3-center" style="padding:56px 16px">
            <h1 class="w3-margin w3-jumbo">Bitacora</h1>
        </header>

        <!-- Grid para ingresar consulta -->
        <div class="w3-container w3-black w3-center w3-opacity w3-padding-64">            


            <!--PARA CONSULTAS -->            
            <form action="../controladorBitacora"  method="POST" class="w3-button w3-green w3-padding-large w3-large w3-margin-right" >     
                <label>Hora Inicial</label>
                <input class="w3-input" type="text" id="hora" name="hora1"> 
                <label>Hora Final</label>
                <input class="w3-input" type="text" id="hora" name="hora2">  
                <!-- CONSULTA 1 -->     
                <input type="submit" name= "accionBitacora" value="Hoy">
                <input type="submit" name= "accionBitacora" value="RangoHora">
                <input type="submit" name= "accionBitacora" value="All"><br>           
            </form>
        </div> 


        <!-- Tabla Grid -->
        <div class="w3-row-padding w3-padding-64 w3-container">                     

            <table>
                <thead>
                    <tr>                        
                        <th>Hora</th>
                        <th>Fecha</th>
                        <th>Accion</th>
                        <th>ID</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Bitacora" items="${listabit}">
                        <tr>
                            <td><c:out value = "${Bitacora.getHora()}" /></td>
                            <td><c:out value = "${Bitacora.getFecha()}" /></td>
                            <td><c:out value = "${Bitacora.getAccion()}" /></td>
                            <td><c:out value = "${Bitacora.getIdBitacora()}" /></td>
                        </tr>
                    </c:forEach>              
                </tbody>
            </table>

            
            <form action="../controladorFormatosBitacora" method="post">
                <input type="submit" name="buttontxt" value="TXT" class="w3-button w3-red">
                <input type="submit" name="buttontxt" value="XML" class="w3-button w3-red">
                <input type="submit" name="buttontxt" value="CSV" class="w3-button w3-red">
            </form>
            <form action="../controladorPDF"  method="GET" >  
              <!-- <input type="submit" name= "accionPDF" value="PDF"> -->
               <button action="../controladorPDF"  method="GET"class="w3-button w3-red">PDF</button>
            </form>
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
