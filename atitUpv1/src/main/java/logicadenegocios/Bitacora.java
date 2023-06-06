/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agus
 */
public class Bitacora {

    private String hora;
    private String fecha;
    private String accion;
    private int idBitacora;
    private List<ConsultasObserver> observers = new ArrayList<>();

    public Bitacora(String pAccion) {
        setId();
        setHora();
        setFecha();
        this.accion = pAccion;

    }

    public Bitacora() {
    }

    public int getIdBitacora() {
        return idBitacora;
    }

    public void setId(int pId) {
        this.idBitacora = pId;
    }

    private void setId() {
        this.idBitacora = NumeroRandom.generarNumeroRandom();
    }

    public void setHora(String pHora) {
        this.hora = pHora;
    }

    public void setFecha(String pFecha) {
        this.fecha = pFecha;
    }

    public void setAccion(String pAccion) {
        this.accion = pAccion;
    }

    private void setHora() {
        this.hora = getHoraSistema().toString();

    }

    private LocalTime getHoraSistema() {
        LocalTime horaActual = LocalTime.now().minusHours(6);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(horaActual.format(formato));

    }

    private void setFecha() {
        if (validarFecha()) {
            this.fecha = LocalDate.now().minusDays(1).toString();
        } else {
            this.fecha = LocalDate.now().toString();
        }

    }

    private boolean validarFecha() {
        LocalTime hora = getHoraSistema();
        return hora.getHour() >= 18;
    }

    public String getFecha() {
        return fecha;

    }

    public String getHora() {
        return hora;
    }

    public String getAccion() {
        return accion;
    }
    
    public void attach(ConsultasObserver observer) {
        observers.add(observer);
    }

    public void detach(ConsultasObserver observer) {
        observers.remove(observer);
    }
 
}
