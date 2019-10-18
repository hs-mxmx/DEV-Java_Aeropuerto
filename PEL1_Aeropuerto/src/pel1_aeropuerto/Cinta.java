/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pel1_aeropuerto;

import java.awt.Font;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.event.*; 
import java.awt.font.TextAttribute;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import javax.swing.*; 


public class Cinta {
    
    private ArrayList <String> cinta;
    private String maleta;
    Random rand = new Random();
    private int posicion_random;
    private boolean hay_maleta = false;
    private Lock lock = new ReentrantLock();
    private Condition mirarCinta = lock.newCondition();
    private int contador_dejadas = 0, contador_cogidas = 0;
    private int total_maletas = 0;
    ImageIcon go = new ImageIcon(this.getClass().getResource("/images/go2.png"));
    ImageIcon stop = new ImageIcon(this.getClass().getResource("/images/Stop_hand.png"));
    
    public Cinta(){
        cinta = new ArrayList<>();
    }
    
    public void dejaMaleta(String nombre, String id_maleta, JTextArea jTextArea1, JLabel jLabel4,  
            JLabel jLabel1,  JLabel jLabel2, JLabel jLabel8, JTextArea jTextArea6){
        try{
            lock.lock();
            if(cinta.size() == 8){
                jLabel8.setIcon(stop);
            }else{
                jLabel8.setIcon(go);
            }
            while(cinta.size() >= 8){
                try{
                    mirarCinta.await();
                }catch(Exception ie){}
            }
                total_maletas = total_maletas + 1;
                contador_dejadas = contador_dejadas + 1;
                //total_maletas -= 1;
                maleta = id_maleta;
                cinta.add(maleta);
                jLabel4.setText(String.valueOf(total_maletas));
                jTextArea1.setText(jTextArea1.getText()+ Pasajero(maleta, nombre) + "\n" );  
                jTextArea6.setText(maletasCinta());
                jLabel1.setText(String.valueOf(contador_dejadas));
                guardarDatos(nombre,maleta);
                guardarDatosPasajeros(nombre);
                guardarDatosMaletas();
                mirarCinta.signalAll();
                Maletas();
        }finally{
            lock.unlock();
        }
    }
    
    public String cogeMaleta(String nombre, JTextArea jTextArea2, JLabel jLabel4, 
            JLabel jLabel1,  JLabel jLabel2, JLabel jLabel8, JTextArea jTextArea6){
            int long_cinta = cinta.size()-1;
        try{
            lock.lock();
            if(cinta.size() == 8){
                jLabel8.setIcon(stop);
            }else{
                jLabel8.setIcon(go);
            }
            while(cinta.isEmpty() && contador_cogidas == contador_dejadas){
                try{
                    mirarCinta.await();
                }catch(Exception ie){}
            }
            posicion_random = rand.nextInt((long_cinta-0)+1)+0;
            System.out.println("Size: " + cinta.size());
            System.out.println("Random: " + posicion_random);
            maleta = cinta.get(long_cinta-posicion_random);
            cinta.remove(long_cinta-posicion_random);
            total_maletas = total_maletas - 1;
            contador_cogidas = contador_cogidas + 1;
            jLabel4.setText(String.valueOf(total_maletas));
            mirarCinta.signalAll();
            jTextArea2.setText(jTextArea2.getText() + Empleado(nombre) + "\n");
            jTextArea6.setText(maletasCinta());
            jLabel2.setText(String.valueOf(contador_cogidas));
            guardarDatos(nombre,maleta); 
            guardarDatosEmpleados(nombre,maleta);
            return maleta;
        }finally{
            lock.unlock();
        }
    }
    
    public void abandona(String nombre, JTextArea jTextArea4){
        jTextArea4.setText(jTextArea4.getText() + nombre + "\n");
    }
    
    
    public String Pasajero (String id_maleta, String nombre){
        String mensaje="[+] " + nombre + " deja la maleta (" + id_maleta + ")";
        return mensaje;
    }
    
    public String Empleado (String nombre){
        String mensaje="[-] " + nombre + " coge maleta (" + maleta + ")";
        return mensaje;
    }
    
    public String Maletas (){
        String mensaje="Total Maletas: " + total_maletas;
        return mensaje;
    }
    
    public String maletasCinta(){
        int i = 0;
        String contenido = "";
        if(cinta.isEmpty()){
            return "La cinta esta vacia";
        }
        while(i <cinta.size()){
            contenido = contenido + cinta.get(i) + "\n";
            i++;
        }
        return contenido;
    }
        
    
    public void guardarDatos(String nombre, String id_maleta){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Historial.txt", true);
            hist_w = new PrintWriter(historial);
            
            if(nombre.contains("Dani")||nombre.contains("Jorge")){
                hist_w.println("[+] " + nombre + " deja la maleta (" + id_maleta + ")");
            }else{
                hist_w.println("[-] " + nombre + " coge maleta (" + maleta + ")");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial)
                    historial.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void guardarDatosEmpleados(String nombre, String id_maleta){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Empleados.txt", true);
            hist_w = new PrintWriter(historial);
            hist_w.println("[+] " + nombre + " deja la maleta (" + id_maleta + ")");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial)
                    historial.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }       
    }
    
    public void guardarDatosPasajeros(String nombre){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Pasajeros.txt", true);
            hist_w = new PrintWriter(historial);
            hist_w.println("[-] " + nombre + " coge maleta (" + maleta + ")");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial)
                    historial.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void guardarDatosMaletas(){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Maletas.txt", true);
            hist_w = new PrintWriter(historial);
            hist_w.println("Maleta: " + maleta );
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial)
                    historial.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    /*
    private AttributedString maleta_tachada(String id_maleta){
        Font font = new Font("Cracked", Font.PLAIN, 12);
        Map  attributes = font.getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        Font newFont = new Font(attributes);
        maleta_tachada.addAttribute(TextAttribute.FONT, newFont);
        return maleta_tachada;
    }/*
    
    /*
    public boolean hayMaletas(){
        if(total_maletas>0){
            return true;
        }else{
            return false;
        }
    }*/
    
}

