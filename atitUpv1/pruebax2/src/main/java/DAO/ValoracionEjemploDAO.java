/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadenegocios.Valoracion;

/**
 *
 * @author Agus
 */
public class ValoracionEjemploDAO extends DAO{
    
    public int agregarValoracionEjemplo(int pIdValoracion, int pIdEjemplo)
    {
        String consulta = "insert into valoracion_Ejemplo (idValoracion, idEjemplo) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdValoracion);
            ps.setInt(2,pIdEjemplo);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
    
    public ArrayList<Valoracion> getValoracionesEjemplo(String pIdRespuesta)
    {
        String consulta = "SELECT * FROM valoracion_Ejemplo"+
        "JOIN valoracion ON valoracion_Ejemplo.idValoracion = valoracion.idValoracion"+
         "WHERE valoracion_Ejemplo.idEjemplo ='"+pIdRespuesta+"'";
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
