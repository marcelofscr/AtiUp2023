/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadenegocios.Respuesta;
import logicadenegocios.Valoracion;

/**
 *
 * @author Agus
 */
public class ValoracionRespuestaDAO extends DAO {
    
     public int agregarValoracionEjemplo(int pIdValoracion, int pIdRespuesta)
    {
        String consulta = "insert into valoracion_Respuesta (idValoracion, idRespuesta) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdValoracion);
            ps.setInt(2,pIdRespuesta);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
     
     public ArrayList<Valoracion> getValoracionesRespuesta(String pIdRespuesta)
    {
        String consulta = "SELECT * FROM valoracion_Respuesta"+
        "JOIN valoracion ON valoracion_Respuesta.idValoracion = valoracion.idValoracion"+
         "WHERE valoracion_Respuesta.idRespuesta ='"+pIdRespuesta+"'";
        ArrayList<Valoracion> valoraciones = new ArrayList();
        try{
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
               Valoracion v = new Valoracion();
               v.setIdValoracion(rs.getInt(1));
               v.setEstrella(rs.getInt(2));
               v.setComentario(rs.getString(3));
               valoraciones.add(v);
            }
             
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return valoraciones;
    }
    
}
