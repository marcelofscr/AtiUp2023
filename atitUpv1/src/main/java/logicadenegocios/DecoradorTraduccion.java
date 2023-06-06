/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author Usuario
 */

public class DecoradorTraduccion implements ReporteBitacora {
    private ReporteBitacora reporteBitacora;
    private ResourceBundle recursos;

    public DecoradorTraduccion(ReporteBitacora reporteBitacora, ResourceBundle recursos) {
        this.reporteBitacora = reporteBitacora;
        this.recursos = recursos;
    }

    @Override
    public void generarReporte(Document documento) throws DocumentException {
        // Traducción de los encabezados de las columnas
        PdfPTable tabla = new PdfPTable(4);

        PdfPCell celda1 = new PdfPCell(new Paragraph(obtenerTextoTraducido("columna.hora"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda2 = new PdfPCell(new Paragraph(obtenerTextoTraducido("columna.fecha"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda3 = new PdfPCell(new Paragraph(obtenerTextoTraducido("columna.accion"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
        PdfPCell celda4 = new PdfPCell(new Paragraph(obtenerTextoTraducido("columna.id"), FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);

        // Llamar al método generarReporte del componente base
        reporteBitacora.generarReporte(documento);
    }

    private String obtenerTextoTraducido(String clave) {
        // Obtener el texto traducido del ResourceBundle
        String textoTraducido;
        try {
            textoTraducido = recursos.getString(clave);
        } catch (MissingResourceException e) {
            // En caso de que la clave no se encuentre en el ResourceBundle, se devuelve la clave original
            textoTraducido = clave;
        }
        return textoTraducido;
    }
}
    
