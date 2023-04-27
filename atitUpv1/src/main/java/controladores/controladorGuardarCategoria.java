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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        CategoriaCursoDao miCC = new CategoriaCursoDao();
        cursoDAO cursoD = new cursoDAO();
        CategoriaConceptual categoria;
        String accion = request.getParameter("accion");
       String categoriaIn = request.getParameter("stars");
       String descripcionIn = request.getParameter("comment");
       String selectedValue = request.getParameter("curso");
        if("insertar".equals(accion)) 
        {
            categoria = new CategoriaConceptual(categoriaIn, descripcionIn);
            miCategoriaDAO.agregarCategoria(categoria);
            miCC.agregarCursoCategoria(cursoD.obtenerIDCurso(selectedValue), categoria.getCodigoCategoria());
            response.sendRedirect("ingresarCategoriaAdmin.jsp");
        }
        
     
        
    }
}
