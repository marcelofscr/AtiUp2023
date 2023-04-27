/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Agus
 */
public class CategoriaDAO extends DAO {

    
    public ArrayList<CategoriaConceptual> listarC() {
        String consulta = "SELECT * FROM categoriaConceptual";
        ArrayList<CategoriaConceptual> c = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaConceptual v = new CategoriaConceptual();
                v.setCodigoCategoria(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setDescripcion(rs.getString(3));
                c.add(v);
            }

        } catch (Exception e) {
            
        }
        return c;
    }
    
       public int agregarCategoria(CategoriaConceptual categoria)
    {
        String consulta = "insert into categoriaConceptual(codigoCategoria,nombre,descripcion) values(?,?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1,categoria.getCodigoCategoria());
            ps.setString(2,categoria.getNombre());
            ps.setString(3,categoria.getDescripcion());
            ps.executeUpdate();
        
        }
        catch(Exception e)
        {
            
        }
        return 1;
        
    }

      
       public int buscarIDCategoria(String pNombre)
       {
           int id = 0;
           ArrayList<CategoriaConceptual> lista = listarC();
           for(CategoriaConceptual categoria: lista)
           {
               if(categoria.getNombre().equals(pNombre))
               {
                   id = categoria.getCodigoCategoria();
               }
           }
           return id;
       }

}
