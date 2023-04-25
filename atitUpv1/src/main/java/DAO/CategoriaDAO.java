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
            //JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return c;
    }

    

}
