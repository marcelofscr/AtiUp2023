/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.ConsultasDAO;
import DAO.BitacoraDAO;
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
 * @author Marcelo
 */
@WebServlet(name = "ConsultarTopXItemsControlador", urlPatterns = {"/ConsultarTopXItemsControlador"})
public class ConsultarTopXItemsControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConsultasDAO miconsultasDAO = new ConsultasDAO();
        Bitacora bitacora;
        BitacoraDAO miBitacora = new BitacoraDAO();
        

        String accion = request.getParameter("accionTop");
        ArrayList<String> x = new ArrayList();
        String topNumero = request.getParameter("topNumero");

        HttpSession misession = request.getSession();

        //CONSULTA 1 - SUBCONSULTA 1
        if (accion.equals("ValoracionEjemplo")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 1);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        //CONSULTA 1 - SUBCONSULTA 2
        if (accion.equals("ValoracionRespuesta")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 2);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        //CONSULTA 1 - SUBCONSULTA 3
        if (accion.equals("ValoracionAmbas")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 3);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }

        //CONSULTA 2 - SUBCONSULTA 1
        if (accion.equals("ValoracionResAdmin")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 4);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        //CONSULTA 2 - SUBCONSULTA 2
        if (accion.equals("ValoracionReschatgpt")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 5);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        //CONSULTA 2 - SUBCONSULTA 3
        if (accion.equals("ValoracionResFuenteAmbas")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 6);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }

        //CONSULTA 3 - SUBCONSULTA 1
        if (accion.equals("ValoracionEjAdmin")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 7);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        //CONSULTA 3 - SUBCONSULTA 2
        if (accion.equals("ValoracionEjchatgpt")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 8);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        //CONSULTA 3 - SUBCONSULTA 3
        if (accion.equals("ValoracionEjFuenteAmbas")) {
            x = miconsultasDAO.listarItemConsulta(topNumero, 9);
            misession.setAttribute("listait", x);
            response.sendRedirect("ConsultarTopXItems.jsp");
        }
        bitacora = new Bitacora("Consulta de top X items");
        miBitacora.agregarBitacora(bitacora);
        

    }

}
