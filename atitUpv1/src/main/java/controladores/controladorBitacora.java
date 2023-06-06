package controladores;

import DAO.BitacoraDAO;
import DAO.ConsultasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicadenegocios.Bitacora;
import logicadenegocios.ConsultasObserver;
import logicadenegocios.TramaPlanaConsulta;

/**
 *
 * @author Daniella
 */
@WebServlet(name = "controladorBitacora", urlPatterns = {"/controladorBitacora"})
public class controladorBitacora extends HttpServlet {

    private BitacoraDAO mibitacoraDAO;
    private List<ConsultasObserver> observers;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mibitacoraDAO = new BitacoraDAO();

        String accion = request.getParameter("accionBitacora");
        ArrayList<Bitacora> x = new ArrayList();
        String hora1 = request.getParameter("hora1");
        String hora2 = request.getParameter("hora2");
        HttpSession misession = request.getSession();

        //CONSULTA 1 
        if (accion.equals("Hoy")) {
            x = mibitacoraDAO.listarBitacorasDehoy();
            misession.setAttribute("listabit", x);
            response.sendRedirect("bitacoraConsultas.jsp");
        }
        //CONSULTA 2 
        if (accion.equals("RangoHora")) {
            x = mibitacoraDAO.listarBitacorasDeHoyHoras(hora1, hora2);
            misession.setAttribute("listabit", x);
            response.sendRedirect("bitacoraConsultas.jsp");
        }
        //CONSULTA 3 
        if (accion.equals("All")) {
            x = mibitacoraDAO.listarBitacorasGeneral();
            misession.setAttribute("listabit", x);
            response.sendRedirect("bitacoraConsultas.jsp");            
        }

    }
   

}
