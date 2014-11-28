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
public class puntaje {
    private int codigo;
    private ArrayList<Calendar> puntajes;
    
    
    public puntaje(int cod){
        codigo=cod;
        puntajes=new ArrayList<Calendar>();
    }
    
    
    public void addpuntaje(int dia,int mes,int anyo,int hora,int min){
        Calendar puntaj=null;
        puntaj.set(anyo, mes, dia, hora, min);
        puntajes.add(puntaj);
    }
    
    public void addpuntaje(int date[]){
        Calendar puntaj=GregorianCalendar.getInstance();
        puntaj.set(date[0], date[1], date[2], date[3], date[4]);
        puntajes.add(puntaj);
     }
    
    public ArrayList<Calendar> buscarpuntaje(int dia,int mes,int anyo){
        ArrayList<Calendar> busqueda=new ArrayList<Calendar>();
        for(int  i=0;i<puntajes.size();i++){
            Calendar c=puntajes.get(i);
            if((c.get(Calendar.YEAR)==anyo)&&(c.get(Calendar.MONTH)==mes)&&(c.get(Calendar.DATE)==dia))
                busqueda.add(c);
        }
        return busqueda;
    }
    
    public int getCodigo(){return this.codigo;}
    
    public Calendar getCalLast(){return this.puntajes.get(puntajes.size()-1);}
    
    public int size(){return this.puntajes.size();}
    
    public String Comprobar(){
        String aux="";
        if(puntajes.size()==1){
            Calendar c=puntajes.get(0);
            return "Solo tiene un puntaje registrado"+c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+"  "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE);
        }    
        for(int i=0;i<this.size()-1;){
            if(Math.abs(puntajes.get(i).getTimeInMillis()-puntajes.get(i+1).getTimeInMillis())>25200000){
                Calendar c=puntajes.get(i);
                aux=aux+"                                           Falta un puntaje el dia : "+c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+"\n";//+sdf.format(puntajes.get(i).getTime());
                i=i-1;
            }
            i=i+2;
        }
        return aux;
    }
}
