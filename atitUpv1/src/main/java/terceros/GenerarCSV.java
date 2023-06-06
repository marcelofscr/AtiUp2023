/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logicadenegocios.Bitacora;

/**
 *
 * @author Marcelo
 */
public class GenerarCSV {

  public void writeCSV(ArrayList<Bitacora> bitacoras, String filename) {
    String delimiter = ",";
    String newline = "\n";

    try {
      FileWriter writer = new FileWriter(filename + ".csv");

      // Write header row
      writer.append("id").append(delimiter)
          .append("accion").append(delimiter)
          .append("fecha").append(delimiter)
          .append("hora").append(newline);

      // Write data rows
      for (Bitacora b : bitacoras) {
        writer.append(String.valueOf(b.getId())).append(delimiter)
            .append(b.getAccion()).append(delimiter)
            .append(b.getFecha()).append(delimiter)
            .append(b.getHora()).append(newline);
      }

      writer.flush();
      writer.close();
      System.out.println("Archivo CSV creado con éxito!");
    } catch (IOException e) {
      System.out.println("Error al crear el archivo CSV: " + e.getMessage());
    }
  }

}
