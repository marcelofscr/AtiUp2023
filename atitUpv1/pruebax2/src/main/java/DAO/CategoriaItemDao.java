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
public class CategoriaItemDao extends DAO {
    
     public int agregarCategoriaItem(String pCodigoCategoria, int IdItem)
    {
        String consulta = "insert into categoriaConceptual_Item (codigoCategoria, idItem) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setString(1, pCodigoCategoria);
            ps.setInt(2,IdItem);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
}
