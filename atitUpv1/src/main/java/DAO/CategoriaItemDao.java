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
    
     public int agregarCategoriaItem(int pCodigoCategoria, int IdItem)
    {
        String consulta = "insert into categoriaConceptual_Item (codigoCategoria, idItem) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pCodigoCategoria);
            ps.setInt(2,IdItem);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
           
        }
        return 1;
        
    }
    
}
