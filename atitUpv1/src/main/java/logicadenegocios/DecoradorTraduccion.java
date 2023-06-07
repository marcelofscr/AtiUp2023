/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */

public class DecoradorTraduccion {
    private BitacoraDAO mibitacoraDAO;

    private ReporteBitacora reporteBitacora;
    //private ResourceBundle recursos;

    public DecoradorTraduccion(ReporteBitacora reporteBitacora) {
        //ReporteBitacora reporteBitacora;
        this.reporteBitacora = reporteBitacora;}
    
    /**
     *
     * @param documento
     * @throws DocumentException
     * @throws IOException
     */

    public void generarReporte(Document documento) throws DocumentException, IOException {
        mibitacoraDAO = new BitacoraDAO();
        ArrayList<Bitacora> x = new ArrayList();
        x = mibitacoraDAO.listarBitacorasDehoy();
        try{
        //reporteBitacora.generarReporte(documento);
        documento.newPage();
        Paragraph par11 = new Paragraph();
        par11.add(new Phrase(Chunk.NEWLINE));
        par11.add(new Phrase(Chunk.NEWLINE));
        par11.add(new Phrase(Chunk.NEWLINE));
        par11.add(new Phrase(Chunk.NEWLINE));
        documento.add(par11);

        PdfPTable tabla1 = new PdfPTable(4);

        PdfPCell celda5 = new PdfPCell(new Paragraph(translate("es","en","Hora"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda6 = new PdfPCell(new Paragraph(translate("es","en","Fecha"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda7 = new PdfPCell(new Paragraph(translate("es","en","Accion"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda8 = new PdfPCell(new Paragraph(translate("es", "en","ID"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        tabla1.addCell(celda5);
        tabla1.addCell(celda6);
        tabla1.addCell(celda7);
        tabla1.addCell(celda8);
        /*for (Bitacora bitacora : x) {
            tabla1.addCell(new PdfPCell(new Paragraph(bitacora.getHora(), FontFactory.getFont("Arial", 12))));
            tabla1.addCell(new PdfPCell(new Paragraph(bitacora.getFecha(), FontFactory.getFont("Arial", 12))));
            tabla1.addCell(new PdfPCell(new Paragraph(translate("es","en",bitacora.getAccion()), FontFactory.getFont("Arial", 12))));
            tabla1.addCell(new PdfPCell(new Paragraph(String.valueOf(bitacora.getIdBitacora()), FontFactory.getFont("Arial", 12))));
        }
*/
        documento.add(tabla1);
            
        }catch(DocumentException | IOException e){
            System.out.println("Respuesta de traducción: " + e.toString());
            
        }


    }
              

    private String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbzL1_0hSOPQXmTAXIFuoQtiGInTy9fCHKB2H_tfUOoPAyFI1JjysUFF4b7dqlpraJxBYQ/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Respuesta de traducción: " + response.toString());
        return response.toString();
    }
}

     