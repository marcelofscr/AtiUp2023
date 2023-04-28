/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import DAO.CategoriaDAO;
import DAO.itemDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.CategoriaConceptual;
import logicadenegocios.Item;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "controladorMostrarCategoriasA", urlPatterns = {"/controladorMostrarCategoriasA"})
public class controladorMostrarCategoriasA extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        itemDAO miItemDAO = new itemDAO();
        String accion = request.getParameter("accion");
        ArrayList<CategoriaConceptual> x = new ArrayList();
         ArrayList<Item> y = new ArrayList();
        x = miCategoriaDAO.listarC();
        y = miItemDAO.listarItems();
        HttpSession misession = request.getSession();
        if (accion.equals("cargar")) {
            misession.setAttribute("lista", x);
            misession.setAttribute("lista2", y);
            response.sendRedirect("analisisItemCategoria.jsp");
        }

    }

    
}