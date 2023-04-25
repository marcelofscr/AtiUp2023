<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <div>            
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="CategoriaConceptual" items="${lista}">
                            <tr>
                                <td><c:out value = "${CategoriaConceptual.getCodigoCategoria()}" /></td>
                                <td><c:out value = "${CategoriaConceptual.getNombre()}" /></td>
                                <td><c:out value = "${CategoriaConceptual.getDescripcion()}" /></td>
                            </tr>
                        </c:forEach>                
                    </tbody>
                </table>
                <form action="../controladorCategoria" method="POST"  >
                    <input type="submit" name= "accion" value="cargar">
                </form>
        </div>
    </body>
</html>
