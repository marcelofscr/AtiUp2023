/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.BitacoraDAO;
import DAO.CategoriaDAO;
import DAO.CategoriaItemDao;
import DAO.itemDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicadenegocios.Bitacora;
import logicadenegocios.Item;

/**
 *
 * @author Agus
 */
@WebServlet(name = "controladorGuardarItem", urlPatterns = {"/controladorGuardarItem"})

public class controladorGuardarItem extends HttpServlet {

  
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //objetos del modelo
         Item item;
         //Daos
         itemDAO iDao = new itemDAO();
         CategoriaDAO cDao = new CategoriaDAO();
         Bitacora bitacora;
         BitacoraDAO miBitacora = new BitacoraDAO();
         CategoriaItemDao ciDao = new CategoriaItemDao();
         //Parametros
         String accion = request.getParameter("accion");
         String prompt = request.getParameter("prompt");
         String categoria =request.getParameter("categoria");
         if(accion.equals("insertar"))
         {
             item = new Item(prompt);
             iDao.agregarItem(item);
             ciDao.agregarCategoriaItem(cDao.buscarIDCategoria(categoria), item.getIdItem());
             bitacora = new Bitacora("Agregacion de item");
             miBitacora.agregarBitacora(bitacora);
             response.sendRedirect("ingresarPromptAdmin.jsp");
         }
       
    }

  
}
