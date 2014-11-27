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
public class Horario {

    private int codigo;
    
    private ArrayList<Hora> Horas;
    
    
    public Horario(int cod){
        codigo=cod;
        Horas=new ArrayList<Hora>();
    }
   
    public Horario(String Fichero){
    
    
    }
    /**
     * 
     * @param anyo
     * @param mes
     * @param dia
     * @param hora
     * @param min
     * @param Tipo_ 
     */
    public void anyadirHora(int anyo,int mes,int dia,int hora,int min,String Tipo_){
        Horas.add(new Hora(Tipo_,hora,min));
    }

    private class Hora{
        private String Tipo;
        private Time hora;
    
    /**
     * 
     * @param Tipo_
     * @param hora_ 
     */
    public Hora(String Tipo_,int hora_,int min_){
        Tipo=Tipo_;
        hora=new Time(hora_,min_);
    }
    
    /**
     * 
     * @return 
     */
    public String getTipo(){return Tipo;}
    
    /**
     * 
     * @return 
     */
    public Time getHora(){return hora;}

}    
    
}


