/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadenegocios.Curso;

/**
 *
 * @author Agus
 */
public class cursoDAO extends DAO{
    
    
    
    public ArrayList<Curso> listarCursos()
    {
        String consulta = "Select * from curso";
        ArrayList<Curso> cursos = new ArrayList();
        try{
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                Curso curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                cursos.add(curso);
            }
             
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return cursos;
    }
    
    
}
