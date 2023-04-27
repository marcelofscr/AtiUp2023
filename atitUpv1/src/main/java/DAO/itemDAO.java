/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionConTerceros.conexionMySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import logicadenegocios.CategoriaConceptual;
import logicadenegocios.Item;

/**
 *
 * @author Agus
 */
public class itemDAO extends DAO {

    public ArrayList<Item> listarItemCompleto(String cateFiltro) {
        CategoriaConceptual cateTemp = new CategoriaConceptual();
        String consulta = "SELECT c.codigoCategoria, c.nombre, c.descripcion, i.prompt, a.respuesta, e.ejemplo\n"
                + "FROM categoriaConceptual c\n"
                + "INNER JOIN categoriaConceptual_Item ci ON c.codigoCategoria = ci.codigoCategoria\n"
                + "INNER JOIN item i ON ci.idItem = i.idItem\n"
                + "INNER JOIN item_Respuesta ia ON i.idItem = ia.idItem\n"
                + "INNER JOIN respuesta a ON ia.idRespuesta = a.idRespuesta\n"
                + "INNER JOIN item_Ejemplo ie ON i.idItem = ie.idItem\n"
                + "INNER JOIN ejemplo e ON ie.idEjemplo = e.idEjemplo\n"
                + "WHERE c.nombre = '"+cateFiltro+"'"
                + "ORDER BY i.prompt ASC;";
        ArrayList<Item> c = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item v = new Item();
                CategoriaConceptual categoriaconceptual = new CategoriaConceptual();
                
                categoriaconceptual.setCodigoCategoria(rs.getInt(1));
                categoriaconceptual.setNombre(rs.getString(2));
                categoriaconceptual.setDescripcion(rs.getString(3));
                
                v.setCategoria(categoriaconceptual);
                v.setPrompt(rs.getString(4));
                v.setRespuesta(rs.getString(5));
                v.setEjemplo(rs.getString(6));
                c.add(v);
            }

        } catch (SQLException e) {

        }
        return c;
    }

    public int agregarItem(Item pItem) {
        String consulta = "insert into item (idItem, prompt) values(?,?)";
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pItem.getIdItem());
            ps.setString(2, pItem.getPrompt());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
        return 1;

    }

    public ArrayList<String> listarPreguntasAlfabeticamente(String pCategoria) {
        String consulta = "SELECT i.prompt FROM item i INNER JOIN categoriaConceptual_Item ic ON i.idItem = ic.idItem"
                + "INNER JOIN categoriaConceptual c ON c.codigoCategoria = ic.codigoCategoria"
                + "WHERE c.nombre ='" + pCategoria + "'"
                + "ORDER BY i.prompt ASC;";
        ArrayList<String> prompts = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                String prompt = rs.getString(1);
                prompts.add(prompt);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
        return prompts;

    }

    public Item obtenerItemPorPregunta(String pPregunta) {
        String consulta = "Select * from item where prompt='" + pPregunta + "'";
        Item item = new Item();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item aux = new Item();
                aux.setIdItem(rs.getInt(1));
                aux.setPrompt(rs.getString(2));
                item = aux;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }

        return item;
    }

    public ArrayList<Item> consultarTopXItems(int x, boolean considerarRespuestas, boolean considerarEjemplos,
            boolean respuestasAdmin, boolean respuestasChatGPT,
            boolean ejemplosAdmin, boolean ejemplosChatGPT) {
        ArrayList<Item> items = new ArrayList<>();
        String sql = "SELECT item.idItem, item.prompt, valoracion.estrellas FROM item ";

        if (considerarRespuestas && considerarEjemplos) {
            sql += "INNER JOIN item_respuesta ON item.idItem = item_respuesta.idItem "
                    + "INNER JOIN respuesta ON item_respuesta.idRespuesta = respuesta.idRespuesta "
                    + "INNER JOIN item_ejemplo ON item.idItem = item_ejemplo.idItem "
                    + "INNER JOIN ejemplo ON item_ejemplo.idEjemplo = ejemplo.idEjemplo "
                    
                    + "INNER JOIN valoracion_Respuesta ON respuesta.idRespuesta = valoracion_Respuesta.idRespuesta"
                    + "INNER JOIN valoracion_Ejemplo ON ejemplo.idEjemplo = valoracion_Ejemplo.idEjemplo"
                    + "INNER JOIN valoracion ON valoracion_Respuesta.idValoracion = valoracion.idValoracion AND valoracion_Ejemplo.idValoracion = valoracion.idValoracion";
        } else if (considerarRespuestas) {
            sql += "INNER JOIN item_respuesta ON item.idItem = item_respuesta.idItem "
                    + "INNER JOIN respuesta ON item_respuesta.idRespuesta = respuesta.idRespuesta "
                    + "INNER JOIN valoracion_Respuesta ON respuesta.idRespuesta = valoracion_Respuesta.idRespuesta"
                    + "INNER JOIN valoracion ON valoracion_Respuesta.idValoracion = valoracion.idValoracion";
        } else if (considerarEjemplos) {
            sql += "INNER JOIN item_ejemplo ON item.idItem = item_ejemplo.idItem "
                    + "INNER JOIN ejemplo ON item_ejemplo.idEjemplo = ejemplo.idEjemplo "
                    + "INNER JOIN valoracion_Ejemplo ON ejemplo.idEjemplo = valoracion_Ejemplo.idEjemplo" 
                    + "INNER JOIN valoracion ON valoracion_Ejemplo.idValoracion = valoracion.idValoracion";
        }

        sql += "WHERE 1=1 ";

        if (considerarRespuestas) {
            if (respuestasAdmin) {
                sql += "AND respuesta.fuenteRes = 'admin' ";
            } else if (respuestasChatGPT) {
                sql += "AND respuesta.fuenteRes = 'chatGPT' ";
            }
        }

        if (considerarEjemplos) {
            if (ejemplosAdmin) {
                sql += "AND ejemplo.fuenteEj = 'admin' ";
            } else if (ejemplosChatGPT) {
                sql += "AND ejemplo.fuenteEj = 'chatGPT' ";
            }
        }

        sql += "GROUP BY item.idItem "
                + "HAVING AVG(valoracion.estrellas) >= 4 "
                + "ORDER BY AVG(valoracion.estrellas) DESC "
                + "LIMIT ?";

        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setIdItem(rs.getInt(1));
                item.setPrompt(rs.getString(2));

                items.add(item);
            }

        } catch (SQLException ex) {
            System.out.println("Error consultando top X items: " + ex.getMessage());
        }

        return items;
    }
}
