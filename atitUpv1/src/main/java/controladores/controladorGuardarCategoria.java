/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.BitacoraDAO;
import DAO.CategoriaCursoDao;
import DAO.CategoriaDAO;
import DAO.cursoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicadenegocios.Bitacora;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Agus
 */
@WebServlet(name = "controladorGuardarCategoria", urlPatterns = {"/controladorGuardarCategoria"})
public class controladorGuardarCategoria extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        BitacoraDAO miBitacora = new BitacoraDAO();
        Bitacora bitacora;
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
            bitacora = new Bitacora("Agregacion de categoria");
            miBitacora.agregarBitacora(bitacora);
            response.sendRedirect("ingresarCategoriaAdmin.jsp");
        }
        
     
        
    }
}
