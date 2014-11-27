/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEMPIN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author jagafe
 */
public class Asistencia {
    private ArrayList<puntaje> Puntajes;
    
    public Asistencia(String fileName){
        int codigo=-1;
        int num_prof=-1;
        String aux=null,st=null,aux3=null;
        StringTokenizer str=null,str2=null,str3=null;
        Puntajes=new ArrayList();
        try {
            BufferedReader br=new BufferedReader(new FileReader(fileName));
            while((st=br.readLine())!=null) {
                str  = new StringTokenizer(st," ");
                aux = str.nextToken().trim();
                if((num_prof=buscar(Integer.parseInt(aux)))==-1){
                    Puntajes.add(0,new puntaje(Integer.parseInt(aux)));
                    num_prof=0;
                }    
                else if (num_prof==Puntajes.size())
                   Puntajes.add(new puntaje(Integer.parseInt(aux)));
                else if(Puntajes.get(num_prof).getCodigo()!=Integer.parseInt(aux))
                    Puntajes.add(num_prof,new puntaje(Integer.parseInt(aux)));
               while (str.hasMoreTokens()) {
                   aux = str.nextToken().trim();
                   str2  = new StringTokenizer(aux,"-");
                   int datos[]=new int[5];
                   int i=0;
                   while (str2.hasMoreTokens()){
                       String aux2 = str2.nextToken().trim();
                       datos[i]=Integer.parseInt(aux2);
                       i++;
                   }
                   aux = str.nextToken().trim();
                   str3  = new StringTokenizer(aux,":");
                   while ((str3.hasMoreTokens())&&(i<5)){
                       aux3 = str3.nextToken().trim();
                       datos[i]=Integer.parseInt(aux3);
                       i++;
                   }
                   Puntajes.get(num_prof).addpuntaje(datos);
                   str3  = new StringTokenizer(aux," ");
                   while (str.hasMoreTokens())
                       aux = str.nextToken().trim(); 
               }
            }   
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    int buscar(int cod_){
        for(int i=0;i<Puntajes.size();i++){
            if(Puntajes.get(i).getCodigo()>cod_){
                if (i==0)
                    return -1;
                else
                    return i;
            }    
            else if((Puntajes.get(i).getCodigo()<cod_)&&(i==Puntajes.size()-1))
                return Puntajes.size();
            else if(Puntajes.get(i).getCodigo()==cod_)
                 return i;   
            }
        return -1;
    }
    
    public Asistencia(String fileName,String Inicio, String Final){
        int codigo=-1;
        int num_prof=-1;
        String aux=null,st=null,aux3=null;
        StringTokenizer str=null,str2=null,str3=null;
        boolean in=true,igualsig=false;
        Puntajes=new ArrayList();
        int dia1=Integer.parseInt(Inicio.substring(0,2));
        int mes1=Integer.parseInt(Inicio.substring(3,5));
        int anyo1=Integer.parseInt(Inicio.substring(6,10));
        int dia2=Integer.parseInt(Final.substring(0,2));
        int mes2=Integer.parseInt(Final.substring(3,5));
        int anyo2=Integer.parseInt(Final.substring(6,10));
        try {
            BufferedReader br=new BufferedReader(new FileReader(fileName));
            while((st=br.readLine())!=null) {
                in=true;
                str  = new StringTokenizer(st," ");
                aux = str.nextToken().trim();
                int posicion=Integer.parseInt(aux);
                
               while (str.hasMoreTokens()) {
                   aux = str.nextToken().trim();
                   str2  = new StringTokenizer(aux,"-");
                   int datos[]=new int[5];
                   int i=0;
                   while ((str2.hasMoreTokens())&&(in)){
                       String aux2 = str2.nextToken().trim();
                       datos[i]=Integer.parseInt(aux2);
                       if((i==1)&& !((mes1<=datos[1])&&(mes2>=datos[1])))
                           in=false;
                       else if((i==0)&& !((anyo1==datos[0])&&(anyo2>=datos[0])))
                           in=false;
                       i++;
                   }
                   if(in){
                        if(mes1==mes2){
                           if ((datos[2]<dia1)||(datos[2]>dia2))
                              in=false;
                        }   
                        else if((datos[1]==mes1)&&(datos[2]<dia1))
                             in=false;
                        else if((datos[1]==mes2)&&(datos[2]>dia2))    
                            in=false;
                   }     
                   if(in){
                        aux = str.nextToken().trim();
                        str3  = new StringTokenizer(aux,":");
                        while ((str3.hasMoreTokens())&&(i<5)){
                            aux3 = str3.nextToken().trim();
                            datos[i]=Integer.parseInt(aux3);
                            i++;
                        }
                        Calendar ca=null;
                        if((num_prof>0)&&(Puntajes.get(num_prof).size()>0)){
                            ca=Puntajes.get(num_prof).getCalLast();
                        }    
                        if((num_prof=buscar(posicion))==-1){
                            Puntajes.add(0,new puntaje(posicion));
                            num_prof=0;
                        }    
                        else if (num_prof==Puntajes.size())
                           Puntajes.add(new puntaje(posicion));
                        else if(Puntajes.get(num_prof).getCodigo()!=posicion)
                                    Puntajes.add(num_prof,new puntaje(posicion));
                        //Fallo aqui cuanto tamaño 0
                        else if((ca!=null)&&(Puntajes.get(num_prof).size()!=0)&&(ca.get(Calendar.YEAR)==datos[0])&&(ca.get(Calendar.MONTH)==datos[1])&&(ca.get(Calendar.DATE)==datos[2])&&(ca.get(Calendar.HOUR)==datos[3])){
                                igualsig=true;
                                if(Math.abs(datos[4]-Puntajes.get(num_prof-1).getCalLast().get(Calendar.MINUTE))>5){
                                    Puntajes.add(num_prof,new puntaje(posicion));    
                                    igualsig=false;
                                }
                            }    
                        else
                             Puntajes.add(num_prof,new puntaje(posicion));       
                        if(!igualsig)
                            Puntajes.get(num_prof).addpuntaje(datos);
                        str3  = new StringTokenizer(aux," ");
                        while (str.hasMoreTokens())
                            aux = str.nextToken().trim(); 
                   }  
               }
            }   
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    
    
    String Comprobacion(){
        String aux="";
        for(int i=0;i<Puntajes.size();i++){
            if(Puntajes.get(i).size()%2!=0){
                aux=aux+"\n El usuario "+Puntajes.get(i).getCodigo()+" no ha puesto el dedo :\n";
                aux=aux+Puntajes.get(i).Comprobar();
            }
        }
        System.out.println(aux);
        return aux;
    }
    
    
}
