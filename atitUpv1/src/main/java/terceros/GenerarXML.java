/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import logicadenegocios.Bitacora;

/**
 *
 * @author Marcelo
 */
public class GenerarXML {

  public void generarArchivoXML(ArrayList<Bitacora> bitacoras, String direccionArchivo) {

    try {
      // Crear el documento XML
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

      // Crear el elemento raíz
      Element rootElement = doc.createElement("bitacoras");
      doc.appendChild(rootElement);

      // Crear los elementos hijo
      for (Bitacora b : bitacoras) {
        Element bitacoraElement = doc.createElement("bitacora");
        rootElement.appendChild(bitacoraElement);

        Element idElement = doc.createElement("id");
        idElement.appendChild(doc.createTextNode(String.valueOf(b.getId())));
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
      FileWriter writer = new FileWriter(new File(direccionArchivo));
      TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(writer));

    } catch (ParserConfigurationException | TransformerException | IOException e) {
      e.printStackTrace();
    }
  }

}
