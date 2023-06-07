/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.BitacoraDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicadenegocios.Bitacora;
import logicacreacional.EmailSingleton;
import logicadenegocios.DecoradorTraduccion;
import logicadenegocios.Email;
import logicadenegocios.ReporteBitacora;
import logicadenegocios.ReporteBitacoraBase;

/**
 *
 * @author Jimena
 */
@WebServlet(name = "controladorPDF", urlPatterns = {"/controladorPDF"})
public class controladorPDF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BitacoraDAO bitacoraDAO = new BitacoraDAO();
        ArrayList<Bitacora> bitacoras = bitacoraDAO.listarBitacorasGeneral();
        String correo = request.getParameter("correo");
        OutputStream out = response.getOutputStream();
        response.setContentType("application/pdf");
        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);

            documento.open();
 
            //ReporteBitacoraBase reporteBase = (ReporteBitacoraBase) new ReporteBitacoraBase(bitacoras);
            //reporteBase.generarReporte(documento);
 
            // Generar informe en inglés
            ReporteBitacora reporteIngles = new ReporteBitacoraBase(bitacoras);
            DecoradorTraduccion reporteInglesTraducido = new DecoradorTraduccion(reporteIngles);
            reporteInglesTraducido.generarReporte(documento);
            
            //ENVIAR CORREO
            Email emailSender = EmailSingleton.getInstance();
            emailSender.createAndSendEmail(correo, "PDF AtiTup", documento, bitacoras);

           documento.close();
        } catch (DocumentException ex) {
           String message = ex.getMessage();
           System.out.println("Mensaje de excepción: " + message);
        } finally {

       }
    }
}