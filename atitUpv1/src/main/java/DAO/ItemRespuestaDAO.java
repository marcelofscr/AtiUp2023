/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import logicadenegocios.Respuesta;

/**
 *
 * @author Agus
 */
public class ItemRespuestaDAO extends DAO{
    
    public int agregarItemRespuesta(int pIdItem, int pIdRespuesta){
        String consulta = "insert into item_Respuesta (idItem, idRespuesta) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdItem);
            ps.setInt(2,pIdRespuesta);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
    
    
    
}
