/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Agus
 */
public class CategoriaDAO extends DAO implements iCategoriaDAO {

    @Override
    public ArrayList<CategoriaConceptual> listar() {
        ArrayList<CategoriaConceptual> list = new ArrayList();
        String sql = "select * from categoriaConceptual;";
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                while (rs.next()) {
                    CategoriaConceptual cate = new CategoriaConceptual();
                    cate.setCodigoCategoria(rs.getInt("codigoCategoria"));
                    cate.setNombre(rs.getString("nombre"));
                    cate.setDescripcion(rs.getString("descripcion"));
                    list.add(cate);
                }
            } catch (SQLException e){
            }
        return list;
    }

    @Override
    public CategoriaConceptual list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
