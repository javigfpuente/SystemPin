/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEMPIN;

/**
 *
 * @author jagafe
 */
public class Time {
    private long hour;
    private long minute;
    
    public void Time() {
        long minute = System.currentTimeMillis();
        long hour = System.currentTimeMillis();
    }
    
    public Time(int hora,int min) {
        long minute = (long)min;
        long hour = (long)hora;
    }
    public Time(long elapsedTime){
       long millisecond = System.currentTimeMillis();
       long second = millisecond / 1000;
       minute = second / 60;
       hour = minute /60;
    }
     public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    
   public String toString(){
       String aux="";
       return aux=hour+":"+minute;   // what should i return here, String.towhat?
   }
}
