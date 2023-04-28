/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import DAO.AnalisisDeSentimientosDAO;
import java.io.IOException;
import ConexionConTerceros.ConexionChatGPT;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import logicadenegocios.Valoracion;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "controladorAnalisisCategoriaItem", urlPatterns = {"/controladorAnalisisCategoriaItem"})
public class controladorAnalisisCategoriaItem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AnalisisDeSentimientosDAO miAnalisisDao = new AnalisisDeSentimientosDAO();
        String accion = request.getParameter("accionI");
        String x;
         
        String selectedValue2 = request.getParameter("selectedValue");
        int selectedIntValue = Integer.parseInt(selectedValue2);
        String selectedValue3 = request.getParameter("selectedValue2");
        int selectedIntValue2 = Integer.parseInt(selectedValue3);
        
        x =  miAnalisisDao.listarComentarios(selectedIntValue2);
        //x = "No me gusta la repsuesta" + "Me gusta la respuesta" + "Deberían de mejorar las respuestas";
      
        HttpSession misession = request.getSession();
        if (accion.equals("consultar")) {
            //String resultado = ConexionChatGPT.conexion(x,"Realice análisis de sentimientos que clasifica los comentarios como positivo, negativo o neutral");
            String resultado = "Nuetral";
            request.setAttribute("myAnalisisItem", resultado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("analisisItemCategoria.jsp");
            dispatcher.forward(request, response);
        }

    }
    
}

