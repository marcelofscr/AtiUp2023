/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.CategoriaCursoDao;
import DAO.CategoriaDAO;
import DAO.cursoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.CategoriaConceptual;
import logicadenegocios.Curso;

/**
 *
 * @author Agus
 */
@WebServlet(name = "controladorGuardarCategoria", urlPatterns = {"/controladorGuardarCategoria"})
public class controladorGuardarCategoria extends HttpServlet {

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
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher x = null;
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        CategoriaCursoDao miCC = new CategoriaCursoDao();
        cursoDAO cursoD = new cursoDAO();
        CategoriaConceptual categoria;
        //HttpSession misession = request.getSession();
        String accion = request.getParameter("accion");
        String categoriaIn = request.getParameter("categoria");
        String descripcionIn = request.getParameter("descripcion");
        String cursoIn = request.getParameter("cursos");
        if("GuardarCategoria".equals(accion)) 
        {
            categoria = new CategoriaConceptual(categoriaIn, descripcionIn);
            miCategoriaDAO.agregarCategoria(categoria);
            miCC.agregarCursoCategoria(cursoD.obtenerIDCurso(cursoIn), categoria.getCodigoCategoria());
            x = request.getRequestDispatcher("ingresarCategoriaAdmin.jsp");
        }

}*/
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher x = null;
        //HttpSession session = request.getSession();
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        CategoriaCursoDao miCC = new CategoriaCursoDao();
        cursoDAO cursoD = new cursoDAO();
        CategoriaConceptual categoria;
        //HttpSession misession = request.getSession();
        String accion = request.getParameter("accion");
       //String categoriaIn = (String) session.getAttribute("categoria");
       //String descripcionIn = (String) session.getAttribute("descripcion");
       String categoriaIn = (String)request.getAttribute("categoria");
       String descripcionIn = (String)request.getAttribute("descripcion");
        //String cursoIn = (String) session.getAttribute("cursos");
       String cursoIn = (String)request.getAttribute("cursos");
        if("GuardarCategoria".equals(accion)) 
        {
            categoria = new CategoriaConceptual(categoriaIn, descripcionIn);
            miCategoriaDAO.agregarCategoria(categoria);
            miCC.agregarCursoCategoria(cursoD.obtenerIDCurso(cursoIn), categoria.getCodigoCategoria());
            response.sendRedirect("ingresarCategoriaAdmin.jsp");
        }
        
     
        
    }
}
