

package pel1_aeropuerto;

import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pasajero extends Thread {
    String nombre;
    private String maleta;
    private Cinta miCinta;
    private Paso paso;
    Random rand = new Random();
    JTextArea jTextArea1;
    JLabel jLabel4, jLabel1, jLabel2;
    
    public Pasajero(String nombre, Cinta cinta,JTextArea jTextArea1, JLabel jLabel4, JLabel jLabel1, JLabel jLabel2, Paso paso){
        this.nombre = nombre;
        miCinta = cinta;       
        this.jTextArea1 = jTextArea1;
        this.jLabel4 = jLabel4;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.paso = paso;
        
    }
    
    public void run(){
        for(int i=0; i<2; i++){
            paso.Mirar("Pasajeros");
            try{
                sleep((rand.nextInt(1000-500) + 1) + 500);
            } catch(InterruptedException e){  }
            int id_maleta=i+1;
            maleta = nombre+"-"+id_maleta;
            paso.Mirar("Pasajeros");
            miCinta.dejaMaleta(maleta, nombre, jTextArea1, jLabel4, jLabel1, jLabel2);
        }
    }
      
}
