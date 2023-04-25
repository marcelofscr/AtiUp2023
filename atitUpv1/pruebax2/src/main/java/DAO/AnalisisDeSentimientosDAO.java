/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
/*
import ConexionConTerceros.AnalisisSentimientos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


 /*
 * @author Usuario
 */
/*
public class AnalisisDeSentimientosDAO extends DAO{
   public String analisisSentimientosCategoria(int pCodigoCategoria) {
       String sqlItems = "SELECT idItem FROM categoriaConceptual_Item WHERE codigoCategoria = ?";
       String sqlRespuestas = "SELECT valoracion.comentario FROM valoracion" +
            "JOIN valoracion_Respuesta ON valoracion.idValoracion = valoracion_Respuesta.idValoracion"+
            "WHERE valoracion_Respuesta.idRespuesta IN" +" (SELECT idRespuesta FROM item_Respuesta WHERE idItem = ?)";
    try {
        con = conexion.establecerConexion();
        // Obtener los ítems asociados con la categoría conceptual de interés      
        PreparedStatement consultaItems = con.prepareStatement(sqlItems);
        consultaItems.setInt(1, pCodigoCategoria);
        ResultSet resultadoItems = consultaItems.executeQuery();
        // Concatenar todos los comentarios para cada ítem
        StringBuilder comentariosItems = new StringBuilder();
        while (resultadoItems.next()) {
            int idItem = resultadoItems.getInt("idItem");
            PreparedStatement consultaRespuestas = con.prepareStatement(sqlRespuestas);
            consultaRespuestas.setInt(1, idItem);
            ResultSet resultadoRespuestas = consultaRespuestas.executeQuery();
            StringBuilder comentariosItem = new StringBuilder();
            while (resultadoRespuestas.next()) {
                String comentario = resultadoRespuestas.getString("comentario");
                comentariosItem.append(comentario).append(" ");
            }
            resultadoRespuestas.close();
            comentariosItems.append(comentariosItem.toString()).append(" ");
        }
        resultadoItems.close();  
        // Realizar el análisis de sentimientos de la cadena de texto de la categoría conceptual
        String comentariosCategoria = comentariosItems.toString();
        //String sentimiento = AnalisisSentimientos.main(comentariosCategoria);
        con.close();
        return sentimiento;
        //System.out.println("Sentimiento de la categoría conceptual: " + sentimiento);   
    } catch (SQLException e) {
        System.err.println("Error de conexión a la base de datos: " + e.getMessage());
    }
     return "No existe categorias registradas para realizar el sentimiento";  
}

public String analisisSentimientosItem(int pIdItem) {
    String sql = "SELECT valoracion.comentario FROM valoracion JOIN valoracion_Respuesta" +
            "ON valoracion.idValoracion = valoracion_Respuesta.idValoracion WHERE valoracion_Respuesta.idRespuesta " + 
            "IN (SELECT idRespuesta FROM item_Respuesta WHERE idItem = ?)";
    try {
        con = conexion.establecerConexion();
        PreparedStatement consulta = con.prepareStatement(sql);
        consulta.setInt(1, pIdItem);
        ResultSet resultado = consulta.executeQuery();
        StringBuilder comentarios = new StringBuilder();
        while (resultado.next()) {
            String comentario = resultado.getString("comentario");
            comentarios.append(comentario).append(" ");
        }
        resultado.close();  
        // Realizar el análisis de sentimientos de la cadena de texto de los comentarios del ítem
        String comentariosItem = comentarios.toString();
        String sentimiento = AnalisisSentimientos.main(comentariosItem);
        con.close();
        return sentimiento;
    } catch (SQLException e) {
        System.err.println("Error de conexión a la base de datos: " + e.getMessage());
    }
    return "No existen comentarios registrados para el ítem seleccionado";
} 


public String analisisSentimientosComentario(int pIdItem, int pCodigoCategoria) {
    String sqlRespuestas = "SELECT valoracion.comentario FROM valoracion" + "JOIN valoracion_Respuesta ON valoracion.idValoracion"
            + " = valoracion_Respuesta.idValoracion" + "JOIN item_Respuesta ON valoracion_Respuesta.idRespuesta = item_Respuesta.idRespuesta"+ 
            "JOIN categoriaConceptual_Item ON item_Respuesta.idItem = categoriaConceptual_Item.idItem" + "WHERE categoriaConceptual_Item.codigoCategoria = ? AND item_Respuesta.idItem = ?";
    try {
        con = conexion.establecerConexion();
        PreparedStatement consultaRespuestas = con.prepareStatement(sqlRespuestas);
        consultaRespuestas.setInt(1, pIdItem);
        consultaRespuestas.setInt(2, pCodigoCategoria);
        ResultSet resultadoRespuestas = consultaRespuestas.executeQuery();
        StringBuilder comentariosItem = new StringBuilder();
        while (resultadoRespuestas.next()) {
            String comentario = resultadoRespuestas.getString("comentario");
            comentariosItem.append(comentario).append(" ");
        }
        resultadoRespuestas.close();
        String comentarios = comentariosItem.toString();
        String sentimiento = AnalisisSentimientos.main(comentarios);
        con.close();
        return sentimiento;
    } catch (SQLException e) {
        System.err.println("Error de conexión a la base de datos: " + e.getMessage());
    }
    return "No se pudo obtener el sentimiento del comentario.";
}}

*/