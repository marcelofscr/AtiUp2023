/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionConTerceros.conexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Agus
 */
public class DAO {
    
    conexionMySql conexion = new conexionMySql();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
}
