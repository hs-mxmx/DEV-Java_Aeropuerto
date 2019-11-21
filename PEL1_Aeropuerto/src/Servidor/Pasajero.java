package Servidor;

import java.util.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Pasajero extends Thread {
    private String nombre;
    private String maleta;
    private Cinta miCinta;
    private Paso paso;
    private Random rand = new Random();
    private JTextArea jTextArea1, jTextArea4, jTextArea6;
    private JLabel jLabel1, jLabel8,  jLabel16;
    private double tiempo_cinta, tiempo_abandono;
    private JButton jButton1, dnum_pasajeros, dnum_maletascinta, dnum_completos;
    
    /* Pasajero */
    public Pasajero(String nombre, Cinta cinta,JTextArea jTextArea1, JButton dnum_pasajeros, 
            JButton dnum_maletascinta, Paso paso, JLabel jLabel8, JTextArea jTextArea4, 
            JTextArea jTextArea6, JButton dnum_completos, JButton jButton1){
        this.nombre = nombre;
        miCinta = cinta;       
        this.jTextArea1 = jTextArea1;
        this.dnum_pasajeros = dnum_pasajeros;
        this.dnum_maletascinta = dnum_maletascinta;
        this.paso = paso;
        this.jLabel8 = jLabel8;
        this.jTextArea4 = jTextArea4;
        this.jTextArea6 = jTextArea6;
        this.dnum_completos = dnum_completos;
        this.jButton1 = jButton1;
    }
    
    public void run(){
        for(int i=0; i<2; i++){
            tiempo_cinta = (System.nanoTime());
            paso.Mirar("Pasajeros");
            try{
                sleep((rand.nextInt(1000-500) + 1) + 500);
            } catch(InterruptedException e){  }
            int id_maleta=i+1;
            maleta = nombre+"-"+id_maleta;
            paso.Mirar("Pasajeros");
            miCinta.dejaMaleta(nombre, maleta, jTextArea1, dnum_pasajeros, dnum_maletascinta, jLabel8, jTextArea6, tiempo_cinta, jButton1);
            if(i==1){
                miCinta.abandonaPasajero(nombre, jTextArea4, dnum_completos, tiempo_abandono);
            }
        }
    }
      
}
