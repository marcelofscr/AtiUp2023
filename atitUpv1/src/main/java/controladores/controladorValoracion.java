/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.ValoracionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.Valoracion;

/**
 *
 * @author Fagares
 */
@WebServlet(name = "controladorValoracion", urlPatterns = {"/controladorValoracion"})
public class controladorValoracion extends HttpServlet {

    private static final long serialVersionUID = 1L;
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ValoracionDAO valoracionDao = new ValoracionDAO();
         String accion = request.getParameter("accion");
        int estrella = Integer.parseInt(request.getParameter("stars"));
        String comentario = request.getParameter("comment");

        Valoracion valoracion = new Valoracion(comentario, estrella);
        int x = valoracionDao.agregarValoracion(valoracion);
        HttpSession misession = request.getSession();
        if (accion.equals("insertar")) {            
            response.sendRedirect("valoracionUsuario.jsp");
        }    
               
    }
}
