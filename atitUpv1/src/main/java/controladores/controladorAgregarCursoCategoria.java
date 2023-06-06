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
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicadenegocios.Bitacora;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Agus
 */
public class controladorAgregarCursoCategoria extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        BitacoraDAO miBitacora = new BitacoraDAO();
        Bitacora bitacora;
        CategoriaDAO categoriaDao = new CategoriaDAO();
        CategoriaCursoDao miCC = new CategoriaCursoDao();
        cursoDAO cursoD = new cursoDAO();
        String accion = request.getParameter("accion");
        String curso = request.getParameter("curso");
        String categoria = request.getParameter("stars");
        if("insertar".equals(accion)) 
        {
            miCC.agregarCursoCategoria(cursoD.obtenerIDCurso(curso),categoriaDao.buscarIDCategoria(categoria));
            bitacora = new Bitacora("Agregacion de curso a categoria");
            miBitacora.agregarBitacora(bitacora);
            response.sendRedirect("ingresarCategoriaCurso.jsp");
        }
        
     
        
    }

}
