/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import logicadenegocios.Ejemplo;

/**
 *
 * @author Agus
 */
public class EjemploDAO extends DAO {
    
    
    public int agregarEjemplo(Ejemplo pEjemplo)
    {
        String consulta = "insert into ejemplo (idEjemplo, ejemplo, fuenteEj) values(?,?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1,pEjemplo.getIdEjemplo());
            ps.setString(2,pEjemplo.getTextoEjemplo());
            ps.setString(3,pEjemplo.getFuenteEjemplo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
    public Ejemplo obtenerEjemploPorIdItem(String pIdItem)
    {
        String consulta = "SELECT ejemplo.idEjemplo, ejemplo.ejemplo, ejemplo.fuenteEj"+
                "FROM ejemplo"+
                "JOIN item_Ejemplo ON ejemplo.idEjemplo = item_Ejemplo.idEjemplo"+
                "JOIN item ON item_Ejemplo.idItem = item.idItem"+
                "WHERE item.idItem ='"+pIdItem+"'";
        Ejemplo ejemplo = new Ejemplo();
        try{
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                Ejemplo aux = new Ejemplo();
                aux.setIdEjemplo(rs.getInt(1));
                aux.setTextoEjemplo(rs.getString(2));
                aux.setFuenteEjemplo(rs.getString(3));
                ejemplo = aux;     
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        
        return ejemplo;
        
    }
    
    
    
    
}
