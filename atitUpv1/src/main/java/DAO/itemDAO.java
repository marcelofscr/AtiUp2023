/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
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
        String consulta = "SELECT c.nombre, i.prompt, a.respuesta, e.ejemplo\n"
                + "FROM categoriaConceptual c\n"
                + "INNER JOIN categoriaConceptual_Item ci ON c.codigoCategoria = ci.codigoCategoria\n"
                + "INNER JOIN item i ON ci.idItem = i.idItem\n"
                + "INNER JOIN item_Respuesta ia ON i.idItem = ia.idItem\n"
                + "INNER JOIN respuesta a ON ia.idRespuesta = a.idRespuesta\n"
                + "INNER JOIN item_Ejemplo ie ON i.idItem = ie.idItem\n"
                + "INNER JOIN ejemplo e ON ie.idEjemplo = e.idEjemplo";
                //"WHERE c.nombre =" +cateFiltro+ ";";
        ArrayList<Item> c = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item v = new Item();
                cateTemp.setNombre(rs.getString(1));
                v.setCategoria(cateTemp);
                v.setPrompt(rs.getString(2));
                v.setRespuesta(rs.getString(3));
                v.setEjemplo(rs.getString(4));
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

}
