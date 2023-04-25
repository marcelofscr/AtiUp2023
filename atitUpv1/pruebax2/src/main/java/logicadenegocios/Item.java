package logicadenegocios;

import java.util.Random;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Agustin Arias
 */
public class Item implements iItem{
    private String prompt;
    private Respuesta respuesta;
    private Ejemplo ejemplo;
    private CategoriaConceptual categoria;
    private int idItem;
    
    
    public Item()
    {
        
    }
    
    public Item(String pPrompt)
    {
        this.prompt = pPrompt;
        this.idItem = NumeroRandom.generarNumeroRandom();
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    public void setCategoria(CategoriaConceptual pCategoria)
    {
        this.categoria = pCategoria;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public Ejemplo getEjemplo() {
        return ejemplo;
    }

    public CategoriaConceptual getCategoria() {
        return categoria;
    }

    public int getIdItem() {
        return idItem;
    }

    
    
    @Override
    public String getTextoEjemplo()
    {
        return ejemplo.getTextoEjemplo();
    }
    
    @Override
    public String getTextoRespuesta()
    {
        return respuesta.getTextoRespuesta();
    }
    
    @Override
    public String getFuenteRespuesta()
    {
        return this.respuesta.getTextoRespuesta();
    }
    
    @Override
    public String getFuenteEjemplo()
    {
        return this.ejemplo.getFuenteEjemplo();
    }
  
    @Override
    public String getPrompt()
    {
        return prompt;
    }
    
    public void setRespuesta(String pRespuesta)
    {
        Respuesta tRespuesta;
        tRespuesta = new Respuesta(pRespuesta);
        this.respuesta = tRespuesta;
    }
    
    public void setEjemplo(String pEjemplo)
    {
        Ejemplo tEjemplo;
        tEjemplo = new Ejemplo(pEjemplo);
        this.ejemplo = tEjemplo;
    }
    
    
    public void agregarValoracionRespuesta(String pComentario, int pEstrella)
    {
        this.respuesta.agregarValoracionRespuesta(pComentario, pEstrella);
    }
    
    public void agregarValoracionEjemplo(String pComentario, int pEstrella)
    {
        this.ejemplo.agregarValoracionEjemplo(pComentario, pEstrella);
    }
    
    @Override
    public int getPonderadoValoracionesEjemplo()
    {
        return this.ejemplo.getValorPonderadoEjemplo();
    }
    
    @Override
    public int getPonderadoValoracionesRespuesta()
    {
        return this.respuesta.getValorPonderadoRespuesta();
    }
    
    @Override
    public int getPonderadoTotalItem()
    {
        return (respuesta.getSumaEstrellas() + (ejemplo.getSumaEstrellas()) / (ejemplo.getCantidadValoraciones() + respuesta.getCantidadValoraciones()));
    }
    
   
    
}
