package controladores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fagares
 */
@WebServlet(urlPatterns = {"/controladorCategoria"})
public class controladorCategoria extends HttpServlet {
    
    String listar = "vistas/ingresarPromptAdmin.jsp";
    String add = "";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")){
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        //get the data from the db (model)
        String[] categorias = {"SOLID", "ABC", "DEF"};
        request.setAttribute("categorias", categorias);
        
        //redirect to a different page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("ingresarPromptAdmin.jsp");
        dispatcher.forward(request,response);
        
        
        
        
    }
    
    
   

}
