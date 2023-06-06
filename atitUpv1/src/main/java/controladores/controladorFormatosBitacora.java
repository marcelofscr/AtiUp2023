package controladores;

import DAO.BitacoraDAO;
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
@WebServlet(name = "controladorFormatosBitacora", urlPatterns = {"/controladorFormatosBitacora"})
public class controladorFormatosBitacora extends HttpServlet {

    private BitacoraDAO mibitacoraDAO;
    private List<ConsultasObserver> observers;
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mibitacoraDAO = new BitacoraDAO();
        observers = new ArrayList<>();              
        ArrayList<Bitacora> x = new ArrayList();
        String accion = request.getParameter("accionBitacora");
        String hora1 = request.getParameter("hora1");
        String hora2 = request.getParameter("hora2");
        String accionFormato = request.getParameter("buttontxt");
        HttpSession misession = request.getSession();     
        x = (ArrayList<Bitacora>) misession.getAttribute("listabit");    
        
        if (accionFormato.equals("TXT")) {
            response.setContentType("text/plain;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=BitacoraRegistro.txt");
            PrintWriter out = response.getWriter();

            // Create observers
            ConsultasObserver txtObserver = new TramaPlanaConsulta();
            observers.add(txtObserver);            
            //notificar a los observers
            String txt = txtObserver.update(x);
            
            try {
                out.println(txt);               
            } finally {
                out.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
