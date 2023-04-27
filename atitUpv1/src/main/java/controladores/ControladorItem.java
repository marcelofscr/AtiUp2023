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
 * @author Marcelo
 */

@WebServlet(name = "ControladorItem", urlPatterns = {"/ControladorItem"})
public class ControladorItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        itemDAO miItemDao = new itemDAO();   
        String accion = request.getParameter("accion3");
        ArrayList<Item> x = new ArrayList();
        x = (ArrayList<Item>) miItemDao.consultarTopXItems(5, true, true, true, false, false, false);
        HttpSession misession = request.getSession();
        if (accion.equals("cargar")) {
            misession.setAttribute("lista", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }

    }

}