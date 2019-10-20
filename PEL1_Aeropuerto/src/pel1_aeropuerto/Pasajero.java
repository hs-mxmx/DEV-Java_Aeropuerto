package pel1_aeropuerto;

import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Pasajero extends Thread {
    String nombre;
    private String maleta;
    private Cinta miCinta;
    private Paso paso;
    Random rand = new Random();
    JTextArea jTextArea1, jTextArea4, jTextArea6;
    JLabel jLabel4, jLabel1, jLabel2, jLabel8,  jLabel16;
    private double tiempo_cinta, tiempo_abandono;
    
    public Pasajero(String nombre, Cinta cinta,JTextArea jTextArea1, JLabel jLabel4, 
            JLabel jLabel1, JLabel jLabel2, Paso paso, JLabel jLabel8, JTextArea jTextArea4, 
            JTextArea jTextArea6, JLabel jLabel16){
        this.nombre = nombre;
        miCinta = cinta;       
        this.jTextArea1 = jTextArea1;
        this.jLabel4 = jLabel4;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.paso = paso;
        this.jLabel8 = jLabel8;
        this.jTextArea4 = jTextArea4;
        this.jTextArea6 = jTextArea6;
        this.jLabel16 = jLabel16;

        
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
            miCinta.dejaMaleta(nombre, maleta, jTextArea1, jLabel4, jLabel1, jLabel2, jLabel8, jTextArea6, tiempo_cinta);
            if(i==1){
                miCinta.abandona(nombre, jTextArea4, jLabel16, tiempo_abandono);
            }
        }
    }
      
}



// maleta1 , maleta2, maleta3