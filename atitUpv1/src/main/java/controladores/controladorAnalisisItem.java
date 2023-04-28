/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import DAO.itemDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.Item;


/**
 *
 * @author Usuario
 */
@WebServlet(name = "controladorAnalisisItem", urlPatterns = {"/controladorAnalisisItem"})
public class controladorAnalisisItem extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        itemDAO miItemDAO = new itemDAO();
        String accion = request.getParameter("accion");
        ArrayList<Item> x = new ArrayList();
        x = miItemDAO.listarItems();
        HttpSession misession = request.getSession();
        if (accion.equals("cargar")) {
            misession.setAttribute("lista", x);
            response.sendRedirect("analisisItem.jsp");
        }

    }
    
}

