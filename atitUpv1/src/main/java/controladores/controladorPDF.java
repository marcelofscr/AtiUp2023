/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;
import java.sql.*;
import javax.swing.JOptionPane;
import ConexionConTerceros.conexionMySql;
import DAO.BitacoraDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Statement;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.swing.GroupLayout.Alignment.CENTER;
import logicadenegocios.Bitacora;
import java.util.ResourceBundle;
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

        OutputStream out = response.getOutputStream();
        response.setContentType("application/pdf");
        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);

            documento.open();

            ReporteBitacoraBase reporteBase = (ReporteBitacoraBase) new ReporteBitacoraBase(bitacoras);
            // Decorar con otros objetos decoradores según sea necesario
           // ReporteBitacora reporteDecorado = new DecoradorTraduccion(reporteBase);
            // Agregar más decoradores si es necesario

            reporteBase.generarReporte(documento);

            documento.close();
        } catch (DocumentException ex) {
            String message = ex.getMessage();
            System.out.println("Mensaje de excepción: " + message);
        } finally {
            
        }
    }
}