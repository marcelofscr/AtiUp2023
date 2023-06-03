/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.BitacoraDAO;
import DAO.ValoracionDAO;
import DAO.ValoracionRespuestaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.Bitacora;
import logicadenegocios.Valoracion;

/**
 *
 * @author Fagares
 */
@WebServlet(name = "controladorValoracionRespuesta", urlPatterns = {"/controladorValoracionRespuesta"})
public class controladorValoracionRespuesta extends HttpServlet {

    private static final long serialVersionUID = 1L;
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bitacora bitacora;
        BitacoraDAO miBitacora = new BitacoraDAO();
        ValoracionDAO valoracionDao = new ValoracionDAO();     
        ValoracionRespuestaDAO valoracionrespuestaDAO= new ValoracionRespuestaDAO();
        
        String accion = request.getParameter("accion");
        int estrella = Integer.parseInt(request.getParameter("stars"));
        String comentario = request.getParameter("comment");
        int idRespuesta = Integer.parseInt(request.getParameter("answer"));    
       
        Valoracion valoracion = new Valoracion(comentario, estrella);
        int x = valoracionDao.agregarValoracion(valoracion);
        int insertTablaIntermediaRes = valoracionrespuestaDAO.agregarValoracionEjemplo(valoracion.getIdValoracion() ,idRespuesta);
             
        HttpSession misession = request.getSession();
        
        if (accion.equals("insertar")) {
            bitacora = new Bitacora("Agregación de valoración a respuesta");
            miBitacora.agregarBitacora(bitacora);
            response.sendRedirect("valoracionRespuestaUsuario.jsp");
        }    
               
    }
}
