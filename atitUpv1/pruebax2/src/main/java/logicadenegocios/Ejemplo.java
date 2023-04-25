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
public class Ejemplo {
    
    private String textoEjemplo;
    private ArrayList<Valoracion> valoraciones;
    private String fuenteEjemplo;
    private int idEjemplo;
      
    
    public Ejemplo(String pTextoEjemplo)
    {
        this.textoEjemplo = pTextoEjemplo;
        valoraciones = new ArrayList();
        this.idEjemplo = NumeroRandom.generarNumeroRandom();
    }
    
    public Ejemplo()
    {
         valoraciones = new ArrayList();
    }

    public void setTextoEjemplo(String textoEjemplo) {
        this.textoEjemplo =  textoEjemplo;
    }

    

    public String getTextoEjemplo() {
        return textoEjemplo;
    }

    
    public void agregarValoracionEjemplo(String pComentario, int pEstrellas)
    {
        Valoracion tValoracion = new Valoracion(pComentario, pEstrellas);
        this.valoraciones.add(tValoracion);
        
    }
    
     public void setFuenteEjemplo(String fuenteEjemplo) {
        this.fuenteEjemplo = fuenteEjemplo;
    }
     
     
    public String getFuenteEjemplo() {
        return fuenteEjemplo;
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
    
    public int getValorPonderadoEjemplo()
    {
       return getSumaEstrellas()/getCantidadValoraciones();
    }
    
    
    public int getCantidadValoraciones()
    {
        return this.valoraciones.size();
    }

    public void setIdEjemplo(int idEjemplo) {
        this.idEjemplo = idEjemplo;
    }

    public ArrayList<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public int getIdEjemplo() {
        return idEjemplo;
    }
    
    
}





