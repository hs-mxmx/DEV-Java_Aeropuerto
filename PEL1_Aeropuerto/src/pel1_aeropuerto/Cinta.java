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
import java.util.Date;
import java.util.Map;
import java.util.Random;
import javax.swing.*; 


public class Cinta {
    
    private ArrayList <String> cinta;
    private String maleta;
    Random rand = new Random();
    private int posicion_random, pasajeros_abandonando;
    private Lock lock = new ReentrantLock();
    private Condition mirarCinta = lock.newCondition();
    private int maletas_e1, maletas_e2;
    private double tiempo_empleado, tiempo_empleado2, tiempo_pasajero;
    private int contador_dejadas = 0, contador_cogidas = 0;
    private int total_maletas = 0;
    ImageIcon go = new ImageIcon(this.getClass().getResource("/images/go2.png"));
    ImageIcon stop = new ImageIcon(this.getClass().getResource("/images/Stop_hand.png"));
    
    public Cinta(){
        cinta = new ArrayList<>();
    }
    
    public void dejaMaleta(String nombre, String id_maleta, JTextArea jTextArea1, JLabel jLabel4,  
            JLabel jLabel1,  JLabel jLabel2, JLabel jLabel8, JTextArea jTextArea6, double tiempo_cinta){
        try{
            lock.lock();
            while(cinta.size() >= 8){
                try{
                    mirarCinta.await();
                }catch(Exception ie){}
            }
                total_maletas += 1;
                contador_dejadas += + 1;
                maleta = id_maleta;
                cinta.add(maleta);
                if(cinta.size() == 8){
                    jLabel8.setIcon(stop);
                 }else{
                     jLabel8.setIcon(go);
                }
                jLabel4.setText(String.valueOf(total_maletas));
                jTextArea1.setText(jTextArea1.getText()+ Pasajero(maleta, nombre) + "\n" );  
                jTextArea6.setText(maletasCinta());
                jLabel1.setText(String.valueOf(contador_dejadas));
                tiempo_pasajero = (System.nanoTime());
                tiempo_pasajero = (tiempo_pasajero - tiempo_cinta);
                tiempo_pasajero = (tiempo_pasajero/1000000000);
                guardarDatos(nombre,maleta, tiempo_pasajero);
                guardarDatosPasajeros(nombre, tiempo_pasajero);
                guardarDatosMaletas(tiempo_pasajero);
                mirarCinta.signalAll();
                Maletas();
        }finally{
            lock.unlock();
        }
    }
    
    public String cogeMaleta(String nombre, JTextArea jTextArea2, JLabel jLabel4, 
            JLabel jLabel1,  JLabel jLabel2, JLabel jLabel8, JTextArea jTextArea6, 
            JTextArea jTextArea7, JLabel jLabel10, JLabel jLabel11, double tiempo_cinta){
        try{
            lock.lock();
            while((cinta.isEmpty() && (contador_cogidas == contador_dejadas))|| contador_dejadas == 0){
                try{
                    mirarCinta.await();
                }catch(Exception ie){}
            }
            posicionRandom(cinta);
            if(cinta.size() == 8){
                jLabel8.setIcon(stop);
            }else{
                jLabel8.setIcon(go);
            }
            total_maletas -= 1;
            contador_cogidas += 1;
            setTextEmpleado(nombre, jTextArea2, jTextArea7, jLabel10, jLabel11);
            jLabel4.setText(String.valueOf(total_maletas));
            jTextArea6.setText(maletasCinta());
            jLabel2.setText(String.valueOf(contador_cogidas));
            tiempo_cinta = tiempoEmpleado(nombre, tiempo_cinta);
            guardarDatos(nombre,maleta, tiempo_cinta); 
            guardarDatosEmpleados(nombre,maleta, tiempo_cinta);
            mirarCinta.signalAll();
            return maleta;
        }finally{
            lock.unlock();
        }
    }
    
    public void abandona(String nombre, JTextArea jTextArea4, JLabel jLabel16, double tiempo_abandono){
        jTextArea4.setText(jTextArea4.getText() + nombre + "\n");
        pasajeros_abandonando += 1;
        jLabel16.setText(String.valueOf(pasajeros_abandonando));
    }
    
    
    public String Pasajero (String id_maleta, String nombre){
        String mensaje= "[" + contador_dejadas + "] " + nombre + " deja la maleta (" + id_maleta + ")";
        return mensaje;
    }
    
    public String Empleado (String nombre){
        String mensaje= nombre + " coge maleta (" + maleta + ")";
        return mensaje;
    }
    
    public String Maletas (){
        String mensaje= "Total Maletas: " + total_maletas;
        return mensaje;
    }
    
    public int getMaletas(){
        return total_maletas;
    }
    
    public double tiempoEmpleado(String nombre, double tiempo){
        if(nombre.contains("Dani")){
            tiempo_empleado = (System.nanoTime() + tiempo_empleado);
            tiempo_empleado = tiempo_empleado - tiempo;
            tiempo_empleado = (tiempo_empleado/1000000000);
            return tiempo_empleado;
        }
        tiempo_empleado2 = (System.nanoTime() + tiempo_empleado2);
        tiempo_empleado2 = tiempo_empleado2 -tiempo;
        tiempo_empleado2 = (tiempo_empleado2/1000000000);
        return tiempo_empleado2;
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
    
    public String posicionRandom(ArrayList <String> cinta){
        int long_cinta = cinta.size()-1;
        if(!cinta.isEmpty()){
            posicion_random = rand.nextInt((long_cinta-0)+1)+0;
            maleta = cinta.get(long_cinta-posicion_random);
            cinta.remove(long_cinta-posicion_random);  
        }
        return "";
    }

    public void setTextEmpleado(String nombre, JTextArea jTextArea, JTextArea jTextArea2, JLabel jLabel, JLabel jLabel2){
        if(nombre.contains("Dani")){
            maletas_e1 += 1;
            jLabel.setText(String.valueOf(maletas_e1));
            jTextArea.setText(jTextArea.getText() + Empleado(nombre) + "\n");
        }if(nombre.contains("Jorge")){
            maletas_e2 += 1;
            jLabel2.setText(String.valueOf(maletas_e2));
            jTextArea2.setText(jTextArea2.getText() + Empleado(nombre) + "\n");  
        }
    }
        
    
    public void guardarDatos(String nombre, String id_maleta, double tiempo){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Historial.txt", true);
            hist_w = new PrintWriter(historial);
            if(contador_dejadas == 1){
                if(nombre.contains("Dani")){
                    hist_w.println("\n\t========== HISTORIAL ========== \t  Tiempos\n"
                            + "\n[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t\t[" + tiempo + "]");
                }if(nombre.contains("Jorge")){
                    hist_w.println("\n\t========== HISTORIAL ========== \t  Tiempos\n"
                            + "\n[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t[" + tiempo + "]");
                }else{
                    hist_w.println("\n\t========== HISTORIAL ========== \t  Tiempos\n"
                            + "\n[-] " + nombre + " coge maleta (" + maleta + ")" + "\t[" + tiempo + "]");
                }
            }else{
                if(nombre.contains("Dani")||nombre.contains("Jorge")){
                    hist_w.println("[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t\t[" + tiempo + "]");
                }else{
                    hist_w.println("[-] " + nombre + " coge maleta (" + maleta + ")" + "\t[" + tiempo + "]");
                }  
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
    
    public void guardarDatosEmpleados(String nombre, String id_maleta, double tiempo){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Empleados.txt", true);
            hist_w = new PrintWriter(historial);
            if(contador_cogidas == 1){
                if(nombre.contains("Dani")){
                    hist_w.println("\n\t========== EMPLEADOS ========== \t  Tiempos\n"
                            + "[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t\t[" + tiempo + "]");
                }else{
                    hist_w.println("\n\t========== EMPLEADOS ========== \t  Tiempos\n"
                            + "[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t[" + tiempo + "]");  
                }
            }else{
                if(nombre.contains("Dani")){
                    hist_w.println("[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t\t[" + tiempo + "]");
                }else{
                    hist_w.println("[+] " + nombre + " deja la maleta (" + id_maleta + ")" + "\t[" + tiempo + "]");  
                }
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
    
    public void guardarDatosPasajeros(String nombre, double tiempo){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Pasajeros.txt", true);
            hist_w = new PrintWriter(historial);
            if(contador_dejadas==1){
                hist_w.println("\n\t========== PASAJEROS ========== \t  Tiempos"
                        + "\n\n[-] " + nombre + " coge maleta (" + maleta + ")" + "\t[" + tiempo + "]");
            }else{
            hist_w.println("[-] " + nombre + " coge maleta (" + maleta + ")" + "\t[" + tiempo + "]");
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
    
    public void guardarDatosMaletas(double tiempo){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            historial = new FileWriter("Historiales/Maletas.txt", true);
            hist_w = new PrintWriter(historial);
            if(contador_dejadas == 1){
                hist_w.println("\n\t========== MALETAS ========== \t  Tiempos\n"
                        + "\n\tMaleta: " + maleta + "\t\t[" + tiempo + "]");
            }else{
                hist_w.println("\tMaleta: " + maleta + "\t\t[" + tiempo + "]");
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

