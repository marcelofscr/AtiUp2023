/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


/**
 *
 * @author Agus
 */
public class CategoriaCursoDao extends DAO{
    
     public int agregarCursoCategoria(String pIdCurso,int pCodigoCategoria)
    {
        String consulta = "insert into categoriaConceptual_Curso (codigoCategoria, idCurso) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pCodigoCategoria);
            ps.setString(2,pIdCurso);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            
        }
        return 1;
        
    }
     
    
    
}
