/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Daniella
 */
public interface iCategoriaDAO {
    public List listar();
    public CategoriaConceptual list(int id);
    
    
}


