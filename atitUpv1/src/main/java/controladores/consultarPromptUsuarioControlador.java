/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.BitacoraDAO;
import DAO.itemDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.*;

/**
 *
 * @author 
 */
@WebServlet(name = "consultarPromptUsuarioControlador", urlPatterns = {"/consultarPromptUsuarioControlador"})
public class consultarPromptUsuarioControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        itemDAO miItemDAO = new itemDAO();
        Bitacora bitacora;
        BitacoraDAO miBitacora = new BitacoraDAO();
        String accion = request.getParameter("accion2");        
        ArrayList<Item> x = new ArrayList();        
        String selectedValue = request.getParameter("selectedValue");
        
        x = miItemDAO.listarItemCompleto(selectedValue);
        HttpSession misession = request.getSession();
        if (accion.equals("visualizar")) {
            misession.setAttribute("listait", x);
            bitacora = new Bitacora("Consulta de prompts");
            miBitacora.agregarBitacora(bitacora);
            response.sendRedirect("consultarPromptsUsuario.jsp");
        }

    }

}
