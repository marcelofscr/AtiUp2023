/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.cursoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.Curso;

/**
 *
 * @author Agus
 */
@WebServlet(name = "controladorMostrarCursos", urlPatterns = {"/controladorMostrarCursos"})
public class controladorMostrarCursos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        cursoDAO miCursoDAO = new cursoDAO();
        String accion = request.getParameter("accion");
        ArrayList<Curso> x = new ArrayList();
  
        x = miCursoDAO.listarCursos();
        HttpSession misession = request.getSession();
        if (accion.equals("cargar")) {
            misession.setAttribute("lista", x);
             response.sendRedirect("ingresarCategoriaAdmin.jsp");
        }
          else if(accion.equals("cargarCursos"))
        {
            misession.setAttribute("listaC", x);
             response.sendRedirect("ingresarCategoriaCurso.jsp");
        }
    }
    
    
    

    
  

}
