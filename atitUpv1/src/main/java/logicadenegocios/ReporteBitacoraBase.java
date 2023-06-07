/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

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
import java.util.ArrayList;

/**
 *
 * @author Jimena
 */
public class ReporteBitacoraBase implements ReporteBitacora {
    private final ArrayList<Bitacora> bitacoras;

    public ReporteBitacoraBase(ArrayList<Bitacora> bitacoras){
        this.bitacoras = bitacoras;}
    
    @Override
    public void generarReporte(Document documento) throws DocumentException {
        Paragraph par1 = new Paragraph();
        Font fonttiulo = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        par1.add(new Phrase("Reporte de Bitacora", fonttiulo));
        par1.setAlignment(15);
        par1.add(new Phrase(Chunk.NEWLINE));
        par1.add(new Phrase(Chunk.NEWLINE));
        documento.add(par1);

        PdfPTable tabla = new PdfPTable(4);
        PdfPCell celda1 = new PdfPCell(new Paragraph("Hora", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda2 = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda3 = new PdfPCell(new Paragraph("Accion", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda4 = new PdfPCell(new Paragraph("ID", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);
        for (Bitacora bitacora : bitacoras) {
            tabla.addCell(new PdfPCell(new Paragraph(bitacora.getHora(), FontFactory.getFont("Arial", 12))));
            tabla.addCell(new PdfPCell(new Paragraph(bitacora.getFecha(), FontFactory.getFont("Arial", 12))));
            tabla.addCell(new PdfPCell(new Paragraph(bitacora.getAccion(), FontFactory.getFont("Arial", 12))));
            tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(bitacora.getIdBitacora()), FontFactory.getFont("Arial", 12))));
        }
        documento.add(tabla);
    }
}