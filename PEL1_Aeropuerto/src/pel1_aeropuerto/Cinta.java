package pel1_aeropuerto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*; 


public class Cinta {
    
    private ArrayList <String> cinta;
    private String maleta;
    private int maletas_e1, maletas_e2, contador_dejadas, contador_cogidas, total_maletas, posicion_random, pasajeros_abandonando;
    private double tiempo_empleado, tiempo_empleado2, tiempo_pasajero;
    Random rand = new Random();
    private Lock lock = new ReentrantLock();
    private Condition mirarCinta = lock.newCondition();
    
    // Get images from project folder
    ImageIcon go = new ImageIcon(this.getClass().getResource("/images/go2.png"));
    ImageIcon stop = new ImageIcon(this.getClass().getResource("/images/Stop_hand.png"));
    
    public Cinta(){
        cinta = new ArrayList<>();
    }
    
    // Metodo dejar maleta (Pasajero)
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
                // Tiempos
                tiempo_pasajero = (System.nanoTime());
                tiempo_pasajero = (tiempo_pasajero - tiempo_cinta);
                tiempo_pasajero = (tiempo_pasajero/1000000000);
                // Guardar Datos
                guardarDatos(nombre,maleta, tiempo_pasajero);
                guardarDatosPasajeros(nombre, tiempo_pasajero);
                guardarDatosMaletas(tiempo_pasajero);
                // Dar señal
                mirarCinta.signalAll();
                Maletas();
        }finally{
            lock.unlock();
        }
    }
    
    // Metodo coger maleta (Empleados)
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
            // Tiempos
            tiempo_cinta = tiempoEmpleado(nombre, tiempo_cinta);
            // Guardar datos
            guardarDatos(nombre,maleta, tiempo_cinta); 
            guardarDatosEmpleados(nombre,maleta, tiempo_cinta);
            // Dar señal
            mirarCinta.signalAll();
            return maleta;
        }finally{
            lock.unlock();
        }
    }
    
    
    // Metodo para calcular cuantos han dejado ambas maletas
    public void abandona(String nombre, JTextArea jTextArea4, JLabel jLabel16, double tiempo_abandono){
        jTextArea4.setText(jTextArea4.getText() + nombre + "\n");
        pasajeros_abandonando += 1;
        jLabel16.setText(String.valueOf(pasajeros_abandonando));
    }
    
    
    // Return Pasajero
    public String Pasajero (String id_maleta, String nombre){
        String mensaje= "[" + contador_dejadas + "] " + nombre + " deja la maleta (" + id_maleta + ")";
        return mensaje;
    }
    
    // Return Empleado
    public String Empleado (String nombre){
        String mensaje= nombre + " coge maleta (" + maleta + ")";
        return mensaje;
    }
    
    // Return Maletas
    public String Maletas (){
        String mensaje= "Total Maletas: " + total_maletas;
        return mensaje;
    }
    
    // Get Total de maletas dejadas en la cinta
    public int getMaletas(){
        return total_maletas;
    }
    
    // Metodo para calcular los tiempos de los empleados
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
    
    
    // Metodo para devolver las maletas en cinta segun el contenido del arrayList
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
    
    // Metodo para generar una posicion random segun el tamaño del arrayList
    public String posicionRandom(ArrayList <String> cinta){
        int long_cinta = cinta.size()-1;
        if(!cinta.isEmpty()){
            posicion_random = rand.nextInt((long_cinta-0)+1)+0;
            maleta = cinta.get(long_cinta-posicion_random);
            cinta.remove(long_cinta-posicion_random);  
        }
        return "";
    }

    // Metodo para cambiar el JTextArea segun el empleado
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
        
    // Metodo para guardar los datos del historial general
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
    
    // Metodo para guardar los datos de los empleados en el historial empleados
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
    
    // Metodo para guardar los datos de los pasajeros en el historial pasajeros
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
    
    // Metodo para guardar los datos de las maletas en el historial maletas
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

