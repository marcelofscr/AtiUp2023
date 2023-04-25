/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.Random;

/**
 *
 * @author Agus
 */
public class Valoracion {
    
    private int estrella;
    private String comentario;
    private int idValoracion;
    
    public Valoracion(String pComentario, int pEstrellas)
    {
        this.estrella = pEstrellas;
        this.comentario = pComentario;
        this.idValoracion =  NumeroRandom.generarNumeroRandom();
        
    }
    
    public Valoracion()
    {
        
    }

    public void setEstrella(int estrella) {
        this.estrella = estrella;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstrella() {
        return estrella;
    }

    public String getComentario() {
        return comentario;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdValoracion() {
        return idValoracion;
    }
    
    
    
    
    
    
}
