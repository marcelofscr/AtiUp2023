/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class XMLConsulta extends ConsultasObserver{

    String userHome = System.getProperty("user.home");
    String desktopPath = userHome + File.separator + "Desktop";
    String filePath = desktopPath + File.separator + "output.txt";

    @Override
    public String update(ArrayList<Bitacora> Bitacoras) {
            // Crear el documento XML
            try {
                // Crear el documento XML
                Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        
                // Crear el elemento raíz
                Element rootElement = doc.createElement("bitacoras");
                doc.appendChild(rootElement);
        
                // Crear los elementos hijo
                for (Bitacora b : Bitacoras) {
                    Element bitacoraElement = doc.createElement("bitacora");
                    rootElement.appendChild(bitacoraElement);
        
                    Element idElement = doc.createElement("id");
                    idElement.appendChild(doc.createTextNode(String.valueOf(b.getIdBitacora())));
                    bitacoraElement.appendChild(idElement);
        
                    Element accionElement = doc.createElement("accion");
                    accionElement.appendChild(doc.createTextNode(b.getAccion()));
                    bitacoraElement.appendChild(accionElement);
        
                    Element fechaElement = doc.createElement("fecha");
                    fechaElement.appendChild(doc.createTextNode(b.getFecha()));
                    bitacoraElement.appendChild(fechaElement);
        
                    Element horaElement = doc.createElement("hora");
                    horaElement.appendChild(doc.createTextNode(b.getHora()));
                    bitacoraElement.appendChild(horaElement);
                }
        
                // Guardar el archivo XML
                StringWriter writer = new StringWriter();
                TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(writer));
        
                return writer.toString();
            } catch (ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
                return null;
            }
    }
}
        
