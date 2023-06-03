/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import DAO.BitacoraDAO;
import DAO.CategoriaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.Bitacora;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "controladorCategoriaAnalisis", urlPatterns = {"/controladorCategoriaAnalisis"})
public class controladorCategoriaAnalisis extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        String accion2 = request.getParameter("accion");
        ArrayList<CategoriaConceptual> x1 = new ArrayList();
        x1 = miCategoriaDAO.listarC();
        HttpSession misession = request.getSession();
        if (accion2.equals("cargar")) {
            misession.setAttribute("lista2", x1);
            
            response.sendRedirect("analisisCategoria.jsp");
        }

    }
    
    
}