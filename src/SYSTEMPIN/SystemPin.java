/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEMPIN;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;


/**
 *
 * @author jagafe
 */
public class SystemPin {
    
    
    public ArrayList<puntaje> Entradas;
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main (String []args)     {
        
        Asistencia As=new Asistencia("c:/FP2-4196947909.txt","10/11/2014","17/11/2014");
        As.Comprobacion();
        /*Calendar c1 = GregorianCalendar.getInstance();
        System.out.println("Fecha actual: "+c1.getTime());
        c1.set(2000, Calendar.AUGUST, 31);
        System.out.println("Fecha 31 Agosto 2000: "+c1.getTime());
        c1.set(Calendar.MONTH, 13);
        System.out.println("Fecha 13 meses más: "+c1.getTime());
        /* como podremos observar no nos imprimirá la fecha deseada, hemos escrito una incoherencia*/
        //c1.set(2000, Calendar.AUGUST, 31);
        /* volvemos a la fecha anterior usando set y empleamos el método add */
        /*c1.add(Calendar.MONTH, 13); /* Añadir 13 meses */
        //System.out.println("Fecha 13 meses más: "+c1.getTime()); /*ahora sí es correcto*/
        //c1.roll(Calendar.HOUR, 25); /* Añadir 25 horas */
        //System.out.println("Fecha 25 horas más: "+c1.getTime());    /*uso de roll*/
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
        //System.out.println("Fecha Formateada: "+sdf.format(c1.getTime()));*/
    }
}
