/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static ConexionConTerceros.ConexionChatGPT.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadenegocios.Item;
import logicadenegocios.Valoracion;


 /*
 * @author Usuario
 */

public class AnalisisDeSentimientosDAO extends DAO{   
// ANALISIS POR MEDIO DE UNA CATEGORIA
public String listarComentarios(int id){
        String seleccionarValoracion = "SELECT valoracion.idValoracion, estrellas, comentario FROM valoracion JOIN valoracion_Respuesta ON " +
                "valoracion.idValoracion = valoracion_Respuesta.idValoracion" + " WHERE valoracion_Respuesta.idRespuesta IN " + 
                "(SELECT idRespuesta FROM item_Respuesta WHERE idItem ='"+id+"')";
        String r = "";
        ArrayList<Valoracion> c = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(seleccionarValoracion);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Valoracion v = new Valoracion();
                //v.setIdValoracion(rs.getInt(1));
               //v.setEstrella(rs.getInt(2));
                r += (rs.getString(3));
                //c.add(v);
            }

        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null,"Error"+ e.toString());

        }
        return r;
    }
     
     
     public String listarComentariosId(int pCategoria)
     {
         ArrayList<Item> listaItems = listarItemsCategoria(pCategoria);
         String comentarios = "";
         for(Item it: listaItems)
         {
             comentarios += listarComentarios(it.getIdItem());
         }
         return comentarios;
     }
     
     
     public ArrayList<Item> listarItemsCategoria(int pCategoria)
    {
        
        String consulta = "SELECT item.* "+
                 "FROM item "+
                 "JOIN categoriaConceptual_Item ON item.idItem = categoriaConceptual_Item.idItem WHERE categoriaConceptual_Item.codigoCategoria ='"+pCategoria+"'";
        ArrayList<Item> c = new ArrayList();
        
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setIdItem(rs.getInt(1));
                item.setPrompt(rs.getString(2));
                c.add(item);
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Error"+ e.toString());
            
        }
        return c;
        
    }
     
 // ANALISIS POR MEDIO DE  UN ITEM
     
    public String listarComentariosItem(int pItem){
         ArrayList<Item> listaItems2 = listarItems(pItem);
         String comentarios = "";
         for(Item it2: listaItems2)
         {
             comentarios += listarComentarios(it2.getIdItem());
         }
         return comentarios;
     }
 
     public ArrayList<Item> listarItems(int pItem)
    {
        
        String consulta = "SELECT item.* "+
                 "FROM item "+
                 " WHERE idItem ='"+pItem+"'";
        ArrayList<Item> c = new ArrayList();
        
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setIdItem(rs.getInt(1));
                item.setPrompt(rs.getString(2));
                c.add(item);
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Error"+ e.toString());
            
        }
        return c;
        
    }

}