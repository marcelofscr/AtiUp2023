/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import logicadenegocios.Valoracion;

/**
 *
 * @author Agus
 */
public class ValoracionDAO extends DAO{
    
    public int agregarValoracion(Valoracion pValoracion)
    {
        String consulta = "insert into valoracion (idValoracion, estrellas, comentario) values(?,?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1,pValoracion.getIdValoracion());
            ps.setInt(2,pValoracion.getEstrella());
            ps.setString(3,pValoracion.getComentario());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
}
