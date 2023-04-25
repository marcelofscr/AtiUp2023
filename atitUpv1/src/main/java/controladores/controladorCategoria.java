package controladores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DAO.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fagares
 */
@WebServlet(name = "controladorCategoria" ,urlPatterns = {"/controladorCategoria"})
public class controladorCategoria extends HttpServlet {
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        String accion = request.getParameter("accion");
        HttpSession misession = request.getSession();
        if (accion.equals("cargar")) {
            misession.setAttribute("lista", miCategoriaDAO.listarC());
             response.sendRedirect("ingresarPromptAdmin.jsp");
        }
       

    }

}
