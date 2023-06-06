/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class CSVConsulta extends ConsultasObserver {

    /*String userHome = System.getProperty("user.home");
    String desktopPath = userHome + File.separator + "Desktop";
    String filePath = desktopPath + File.separator + "output.txt";*/
    
    @Override
    public String update(ArrayList<Bitacora> bitacoras) {
        String userHome = System.getProperty("user.home");
        String desktopPath = userHome + File.separator + "Desktop";
        String filePath = desktopPath + File.separator + "output.csv";

        // Generate the content for the file
        String content = new String();
        for (Bitacora bitacora : bitacoras) {
            content += bitacora.getIdBitacora() + ",";
            content += bitacora.getFecha() + ",";
            content += bitacora.getHora() + ",";
            content += bitacora.getAccion();
            content += "\n";
        }
        try {
            File file = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            //System.err.println("Error: " + e.getMessage());
        }
        return content;
    }

}


