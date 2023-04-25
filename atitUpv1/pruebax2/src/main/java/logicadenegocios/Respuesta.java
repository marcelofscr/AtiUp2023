/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author Agus
 */
public class Respuesta {
    
    private String textoRespuesta;
    private ArrayList<Valoracion> valoraciones;
    private String fuenteRespuesta;
    private int idRespuesta;
    
    
    
    public Respuesta()
    {
        this.valoraciones = new ArrayList();
    }
    
    public Respuesta(String pTextoRespuesta)
    {
        this.textoRespuesta = pTextoRespuesta;
        this.valoraciones = new ArrayList();
        this.idRespuesta = NumeroRandom.generarNumeroRandom();
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    
    public void agregarValoracionRespuesta(String pComentario, int pEstrellas)
    {
        Valoracion tValoracion = new Valoracion(pComentario, pEstrellas);
        this.valoraciones.add(tValoracion);
        
    }
    
     public void setFuenteRespuesta(String fuenteRespuesta) {
        this.fuenteRespuesta = fuenteRespuesta;
    }

   
    public String getFuenteRespuesta() {
        return fuenteRespuesta;
    }
    
    public int getSumaEstrellas()
    {
      int i = 0;
      int suma;
      for(Valoracion v: valoraciones)
      {
          i +=  v.getEstrella();
      }
       suma = i; 
       return suma;
    }
    
    public int getValorPonderadoRespuesta()
    {
       return getSumaEstrellas()/getCantidadValoraciones();
    }
    
    
    public int getCantidadValoraciones()
    {
        return this.valoraciones.size();
    }

    public ArrayList<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
    
    
    
}
