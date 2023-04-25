/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparadores;

import java.util.Comparator;
import logicadenegocios.iItem;

/**
 *
 * @author Agus
 */
public class itemValoracionTotalItemComparator implements Comparator<iItem>{
    @Override
    public int compare(iItem obj1, iItem obj2) {
        return Integer.compare(obj1.getPonderadoTotalItem(), obj2.getPonderadoTotalItem());
    }
}
