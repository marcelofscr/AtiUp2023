package logicadenegocios;


import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Agus
 */
public class NumeroRandom {
    
    
    public static int generarNumeroRandom()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return number;
    }
    
}
