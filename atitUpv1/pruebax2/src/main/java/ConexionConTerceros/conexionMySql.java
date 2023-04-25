/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionConTerceros;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Abstracción de la clase conexionMySql para  efectos académicos
 *
 * @author Agustín Arias, Ignacio Solano, Valeska Solórzano
 * @version 24/11/2022
 */
public class conexionMySql {
    
    Connection con;
    
    
    /**
    *Establece la conexión con la base de datos
    *@return un objeto de tipo Connection
    */
    public Connection establecerConexion()
    {
        
        String url = "jdbc:mysql://awseb-e-mkb6kdkeid-stack-awsebrdsdatabase-zi2fggvyxoek.ccczvrhbvl1s.us-east-1.rds.amazonaws.com/AtiUp";
        String user = "agstFrog";
        String pass = "boletospasesabonos";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            //JOptionPane.showMessageDialog(null,"Se conectó exitosamente");
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error al conectarse a la db"+ e.toString());
            System.out.println(e.toString());
        }
        return con;
    }
}
