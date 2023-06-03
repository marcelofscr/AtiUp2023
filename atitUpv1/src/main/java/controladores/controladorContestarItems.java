/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.BitacoraDAO;
import DAO.EjemploDAO;
import DAO.ItemEjemploDAO;
import DAO.ItemRespuestaDAO;
import DAO.RespuestaDAO;
import DAO.itemDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicadenegocios.Bitacora;
import logicadenegocios.Ejemplo;
import logicadenegocios.Respuesta;
import terceros.ConexionChatGPT;

/**
 *
 * @author Agus
 */

@WebServlet(name = "controladorContestarItems", urlPatterns = {"/controladorContestarItems"})

public class controladorContestarItems extends HttpServlet {

    
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //objetos del modelo
        
         Respuesta respuesta;
         Ejemplo ejemplo;
         //Daos
         itemDAO iDao = new itemDAO();
         RespuestaDAO rDao= new RespuestaDAO();
         EjemploDAO eDao = new EjemploDAO();
         ItemEjemploDAO ieDao = new ItemEjemploDAO();
         ItemRespuestaDAO irDao = new ItemRespuestaDAO();
         Bitacora bitacora;
         BitacoraDAO miBitacora = new BitacoraDAO();
         //Parametros
         String accion = request.getParameter("accion");
         int idItem = Integer.parseInt(request.getParameter("iditem"));
         String prompt = iDao.getPrompt(idItem);
         String respuestaIn = request.getParameter("ejemplop");
         String ejemploIn = request.getParameter("ejemplo");
         String fuenteRes = request.getParameter("fuenteEjR");
         String fuenteEj = request.getParameter("fuenteEj");
         if(accion.equals("consultar respuesta"))
         {
             String respuestaC = ConexionChatGPT.conexion(prompt,"contestar y explicar pregunta");
             request.setAttribute("myEjemplop", respuestaC);
             RequestDispatcher dispatcher = request.getRequestDispatcher("contestarItems.jsp");
             bitacora = new Bitacora("Consulta de respuesta al chatGPT");
             miBitacora.agregarBitacora(bitacora);
             dispatcher.forward(request, response);
             //response.sendRedirect("ingresarPromptAdmin.jsp");
         }
         if(accion.equals("consultar ejemplo"))
         {
             String ejemploC = ConexionChatGPT.conexion(prompt,"contestar y dar un ejemplo");
             request.setAttribute("myEjemplo", ejemploC);
             RequestDispatcher dispatcher = request.getRequestDispatcher("contestarItems.jsp");
             bitacora = new Bitacora("Consulta de ejemplo al chatGPT");
             miBitacora.agregarBitacora(bitacora);
             dispatcher.forward(request, response);
             
         }
         if(accion.equals("insertarRespuesta"))
         {
             respuesta = new Respuesta(respuestaIn);
             respuesta.setFuenteRespuesta(fuenteRes);
             rDao.agregarRespuesta(respuesta);
             irDao.agregarItemRespuesta(idItem, respuesta.getIdRespuesta());
             bitacora = new Bitacora("Agregación de respuesta a item");
             miBitacora.agregarBitacora(bitacora);
             response.sendRedirect("contestarItems.jsp");
         }
         if(accion.equals("insertarEjemplo"))
         {
             ejemplo = new Ejemplo(ejemploIn);
             ejemplo.setFuenteEjemplo(fuenteEj);
             eDao.agregarEjemplo(ejemplo);
             ieDao.agregarItemEjemplo(idItem, ejemplo.getIdEjemplo());
             bitacora = new Bitacora("Agregación de ejemplo a item");
             miBitacora.agregarBitacora(bitacora);
             response.sendRedirect("contestarItems.jsp");
         }
    }

}
