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
public class CategoriaCursoDao extends DAO{
    
     public int agregarCursoCategoria(int pIdCurso,String pCodigoCategoria)
    {
        String consulta = "insert into categoriaConceptual_Curso (codigoCategoria, idCurso) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdCurso);
            ps.setString(2,pCodigoCategoria);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
}
