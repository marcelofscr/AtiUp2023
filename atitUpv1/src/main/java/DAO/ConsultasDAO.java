/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import logicadenegocios.CategoriaConceptual;
import logicadenegocios.Item;
import ConexionConTerceros.*;

/**
 *
 * @author Fagares
 */
public class ConsultasDAO extends DAO {

    public ArrayList<String> listarItemConsulta(String topNumero, int tipoConsulta) {
        String consulta = null;
        if (tipoConsulta == 1) {
            consulta = "SELECT DISTINCT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "INNER JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "INNER JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "INNER JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo \n"
                    + "INNER JOIN item i ON ie.idItem = i.idItem \n"
                    + "WHERE o.estrellas >= 4 \n"
                    + "ORDER BY o.estrellas DESC \n"
                    + "LIMIT " + topNumero + ";";
        }
        if (tipoConsulta == 2) {
            consulta = "SELECT DISTINCT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "INNER JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "INNER JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "INNER JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "INNER JOIN item i ON ia.idItem = i.idItem \n"
                    + "WHERE o.estrellas >= 4 \n"
                    + "ORDER BY o.estrellas DESC \n"
                    + "LIMIT " + topNumero + ";";
        }

        if (tipoConsulta == 3) {
            consulta = "SELECT DISTINCT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo \n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "GROUP BY i.prompt\n"
                    + "HAVING AVG(o.estrellas) >= 4\n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }

        if (tipoConsulta == 4) {
            consulta = "SELECT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo\n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "WHERE a.fuenteRes = 'Admin' \n"
                    + "GROUP BY i.prompt \n"
                    + "HAVING AVG(o.estrellas) >= 4 \n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }

        if (tipoConsulta == 5) {
            consulta = "SELECT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo\n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "WHERE a.fuenteRes = 'chatgpt' \n"
                    + "GROUP BY i.prompt \n"
                    + "HAVING AVG(o.estrellas) >= 4 \n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }

        if (tipoConsulta == 6) {
            consulta = "SELECT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo\n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "WHERE a.fuenteRes IN ('Admin', 'chatgpt')  \n"
                    + "GROUP BY i.prompt \n"
                    + "HAVING AVG(o.estrellas) >= 4 \n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }
        if (tipoConsulta == 7) {
            consulta = "SELECT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo\n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "WHERE e.fuenteEj = 'Admin' \n"
                    + "GROUP BY i.prompt \n"
                    + "HAVING AVG(o.estrellas) >= 4 \n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }
        if (tipoConsulta == 8) {
            consulta = "SELECT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo\n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "WHERE e.fuenteEj = 'chatgpt' \n"
                    + "GROUP BY i.prompt \n"
                    + "HAVING AVG(o.estrellas) >= 4 \n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }
        if (tipoConsulta == 9) {
            consulta = "SELECT i.prompt\n"
                    + "FROM valoracion o \n"
                    + "LEFT JOIN valoracion_Ejemplo oe ON o.idValoracion = oe.idValoracion \n"
                    + "LEFT JOIN ejemplo e ON oe.idEjemplo = e.idEjemplo \n"
                    + "LEFT JOIN valoracion_Respuesta oa ON o.idValoracion = oa.idValoracion \n"
                    + "LEFT JOIN respuesta a ON oa.idRespuesta = a.idRespuesta \n"
                    + "LEFT JOIN item_Respuesta ia ON a.idRespuesta = ia.idRespuesta \n"
                    + "LEFT JOIN item_Ejemplo ie ON e.idEjemplo = ie.idEjemplo\n"
                    + "LEFT JOIN item i ON COALESCE(ia.idItem, ie.idItem) = i.idItem \n"
                    + "WHERE e.fuenteEj IN ('Admin', 'chatgpt') \n"
                    + "GROUP BY i.prompt \n"
                    + "HAVING AVG(o.estrellas) >= 4 \n"
                    + "ORDER BY AVG(o.estrellas) DESC \n"
                    + "LIMIT " + topNumero + ";";
        }

        ArrayList<String> c = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                String v;
                v = rs.getString(1);
                c.add(v);
            }

        } catch (SQLException e) {

        }
        return c;
    }
}
