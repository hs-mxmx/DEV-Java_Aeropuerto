/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pel1_aeropuerto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.event.*; 
import javax.swing.*; 


public class Cinta {
    
    private String maleta;
    private boolean hay_maleta = false;
    private Lock lock = new ReentrantLock();
    private Condition mirarCinta = lock.newCondition();
    private int contador_dejadas = 0, contador_cogidas = 0;
    private int total_maletas = 0;
    
    //private int total_maletas = 80;
    
   
    public void dejaMaleta(String id_maleta, String nombre, JTextArea jTextArea1, JLabel jLabel4,  JLabel jLabel1,  JLabel jLabel2){
        try{
            lock.lock();
            while(total_maletas == 8 && hay_maleta){
                try{
                    mirarCinta.await();
                }catch(Exception ie){}
            }
                total_maletas = total_maletas + 1;
                contador_dejadas = contador_dejadas + 1;
                //total_maletas -= 1;
                hay_maleta = true;
                maleta = id_maleta;
                jLabel4.setText(String.valueOf(total_maletas));
                jTextArea1.setText(jTextArea1.getText()+ Pasajero(id_maleta, nombre) + "\n" );
                jLabel1.setText(String.valueOf(contador_dejadas));
                mirarCinta.signalAll();
                Maletas();
        }finally{
            lock.unlock();
        }
    }
    
    public String cogeMaleta(String nombre, JTextArea jTextArea2, JLabel jLabel4, JLabel jLabel1,  JLabel jLabel2){
        try{
            lock.lock();
            while(!hay_maleta && contador_cogidas == contador_dejadas){
                try{
                    mirarCinta.await();
                }catch(Exception ie){}
            }
            hay_maleta = false;
            total_maletas = total_maletas - 1;
            contador_cogidas = contador_cogidas + 1;
            jLabel4.setText(String.valueOf(total_maletas));
            mirarCinta.signalAll();
            jTextArea2.setText(jTextArea2.getText() + Empleado(nombre) + "\n");
            jLabel2.setText(String.valueOf(contador_cogidas));
            return maleta;
        }finally{
            lock.unlock();
        }
    }
    
    
    public String Pasajero (String id_maleta, String nombre){
        String mensaje="[+] " + nombre + " deja la maleta: " + id_maleta;
        return mensaje;
    }
    
    public String Empleado (String nombre){
        String mensaje="[-] " + nombre + " coge maleta " + maleta;
        return mensaje;
    }
    
    public String Maletas (){
        String mensaje="Total Maletas: " + total_maletas;
        return mensaje;
    }
    /*
    public boolean hayMaletas(){
        if(total_maletas>0){
            return true;
        }else{
            return false;
        }
    }*/
    
}

