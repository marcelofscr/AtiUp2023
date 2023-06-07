/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logicadenegocios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public interface ReporteBitacora {
    public void generarReporte(Document documento) throws DocumentException, IOException ;   
}
