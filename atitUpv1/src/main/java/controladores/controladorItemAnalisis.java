/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import ConexionConTerceros.ConexionChatGPT;
import DAO.AnalisisDeSentimientosDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "controladorItemAnalisis", urlPatterns = {"/controladorItemAnalisis"})
public class controladorItemAnalisis extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AnalisisDeSentimientosDAO miAnalisisDao = new AnalisisDeSentimientosDAO();
        String accion = request.getParameter("accion2");
        String x;
         
        String selectedValue2 = request.getParameter("selectedValue");
        int selectedIntValue = Integer.parseInt(selectedValue2);
        
        x =  miAnalisisDao.listarComentarios(selectedIntValue);
        //x = "No me gusta la repsuesta" + "Me gusta la respuesta" + "Deberían de mejorar las respuestas";
      
        HttpSession misession = request.getSession();
        if (accion.equals("consultar")) {
            String resultado = ConexionChatGPT.conexion(x,"Realice análisis de sentimientos que clasifica los comentarios como positivo, negativo o neutral");
            request.setAttribute("myAnalisis", resultado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("analisisCategoria.jsp");
            dispatcher.forward(request, response);
        }

    }
    
}