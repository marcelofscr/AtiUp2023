/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.CategoriaDAO;
import DAO.itemDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.*;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "ConsultarTopXItemsControlador", urlPatterns = {"/ConsultarTopXItemsControlador"})
public class ConsultarTopXItemsControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        itemDAO miItemDAO = new itemDAO();
        String accion = request.getParameter("accion4");
        ArrayList<Item> x = new ArrayList();
        String selectedValue = request.getParameter("items");
        x = miItemDAO.listarItemCompleto(selectedValue);
        HttpSession misession = request.getSession();
        if (accion.equals("visualizar")) {
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }

    }

}
