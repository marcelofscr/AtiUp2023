/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadenegocios.Respuesta;

/**
 *
 * @author Agus
 */
public class RespuestaDAO extends DAO{
    
    
    public int agregarRespuesta(Respuesta pRespuesta)
    {
        String consulta = "insert into respuesta (idRespuesa, respuesta, fuenteRes) values(?,?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1,pRespuesta.getIdRespuesta());
            ps.setString(2,pRespuesta.getTextoRespuesta());
            ps.setString(3,pRespuesta.getFuenteRespuesta());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
    public Respuesta obtenerRespuestaPorIdItem(String pIdItem)
    {
        String consulta = "SELECT respuesta.respuesta"
                + "FROM item"+
                "JOIN item_Respuesta ON item.idItem = item_Respuesta.idItem"+
                "JOIN respuesta ON item_Respuesta.idRespuesta = respuesta.idRespuesta"+
                "WHERE item.idItem ='" + pIdItem +"'";
        Respuesta respuesta = new Respuesta();
        try{
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                Respuesta aux = new Respuesta();
                aux.setIdRespuesta(rs.getInt(1));
                aux.setTextoRespuesta(rs.getString(2));
                aux.setFuenteRespuesta(rs.getString(3));
                respuesta = aux;     
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        
        return respuesta;
        
    }
    
}
