/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author Agus
 */
public class ItemEjemploDAO extends DAO{
    
    public int agregarItemEjemplo(int pIdItem, int pIdEjemplo)
    {
        String consulta = "insert into item_Ejemplo (idItem, idEjemplo) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdItem);
            ps.setInt(2,pIdEjemplo);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
}
