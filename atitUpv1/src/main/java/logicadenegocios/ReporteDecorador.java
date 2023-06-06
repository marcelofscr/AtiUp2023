/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

/**
 *
 * @author Jimena
 */
public abstract class ReporteDecorador implements ReporteBitacora {
    protected ReporteBitacora reporteBitacora; 
    
    public ReporteDecorador(ReporteDecorador pReporteDecorador){
        reporteBitacora = pReporteDecorador;
    }
    
    public void generarReporte(Document documento) throws DocumentException{
        reporteBitacora.generarReporte(documento);
        
    }
}
