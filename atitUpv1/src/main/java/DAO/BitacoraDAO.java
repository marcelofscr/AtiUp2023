/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import logicadenegocios.Bitacora;

/**
 *
 * @author Agus
 */
public class BitacoraDAO extends DAO{
    
    String fechaHoy = LocalDate.now().toString();
    
    
    public BitacoraDAO(){}
    
    
    public int agregarBitacora(Bitacora pBitacora)
    {
        String consulta = "insert into Bitacora(id_bitacora,accion,fecha,hora) values(?,?,?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1,pBitacora.getIdBitacora());
            ps.setString(2,pBitacora.getAccion());
            ps.setDate(3, Date.valueOf(pBitacora.getFecha()));
            String hora = pBitacora.getHora();
            Time time = Time.valueOf(hora);
            ps.setTime(4, time);
            //ps.setTime(4, Time.valueOf(LocalTime.parse(pBitacora.getHora()).minusHours(6)));
            ps.executeUpdate();
        
        }
        catch(Exception e)
        {
            
        }
        return 1;
        
    }
    
    
    
    //Consulta de bitacoras generica
     private ArrayList<Bitacora> listarBitacoras(String pConsulta) {
        String consulta = pConsulta;
        ArrayList<Bitacora> bitacoras = new ArrayList();
        try {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Bitacora b = new Bitacora();
                b.setId(rs.getInt(1));
                b.setAccion(rs.getString(2));
                b.setFecha(rs.getDate(3).toString());
                b.setHora(rs.getTime(4).toString());
                bitacoras.add(b);
            }

        } catch (Exception e) {
            
        }
        return bitacoras;
    }
    
    //Consultas requeridas por el usuario
    public ArrayList<Bitacora> listarBitacorasGeneral()
    {
        return listarBitacoras("SELECT * FROM Bitacora;");
        
        
    }
    
    public ArrayList<Bitacora> listarBitacorasDehoy()
    {
        
        return listarBitacoras("SELECT * FROM Bitacora WHERE fecha = '" + fechaHoy +"';");
    }
    
    public ArrayList<Bitacora> listarBitacorasDeHoyHoras(String pHoraUno, String pHoraDos)
    {
        return listarBitacoras("SELECT * FROM Bitacora WHERE fecha = '" + fechaHoy +"'" + " AND hora BETWEEN '"+ pHoraUno+ "'" + " AND '"+pHoraDos+"';");
    }
     
     
    
    
}
