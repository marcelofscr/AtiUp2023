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
            <h1>Categorias</h1>  
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="CategoriaConceptual" items="${categorias}">
                        <tr>
                            <td>${CategoriaConceptual.getCodigoCategoria()}</td>
                            <td>${CategoriaConceptual.getNombre()}</td>
                            <td>${CategoriaConceptual.getDescripcion()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
