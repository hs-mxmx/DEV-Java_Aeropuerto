

package pel1_aeropuerto;

import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Empleado extends Thread{
    
    private String nombre;
    private Cinta miCinta;
    private Paso paso;
    private Avion miAvion;
    private int contador;
    JTextArea jTextArea2, jTextArea3;
    JLabel jLabel4, jLabel1, jLabel2, jLabel5;
    
    Random rand = new Random();
    
    public Empleado(String nombre, Cinta cinta, Avion avion, JTextArea jTextArea2, JTextArea jTextArea3, JLabel jLabel4, JLabel jLabel1, JLabel jLabel2, JLabel jLabel5, Paso paso){
        this.nombre = nombre;
        this.miCinta = cinta;
        this.miAvion = avion;
        this.jTextArea2 = jTextArea2;
        this.jTextArea3 = jTextArea3;
        this.jLabel4 = jLabel4;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel5 = jLabel5;
        this.paso = paso;
    }
    
    
    public void run(){
        while(true){
            contador += 1;
            paso.Mirar(nombre);
            try{
                sleep((rand.nextInt(700-400) + 1) + 400);
            } catch(InterruptedException e){  }
            paso.Mirar(nombre);
            String maleta = miCinta.cogeMaleta(nombre, jTextArea2, jLabel4,  jLabel1, jLabel2);     
            try{
                sleep((rand.nextInt(700-400) + 1) + 400);
            } catch(InterruptedException e){  }
            paso.Mirar(nombre);
            miAvion.maletasAvion(maleta, jTextArea3, jLabel5);
        }
    }
    
    

}
