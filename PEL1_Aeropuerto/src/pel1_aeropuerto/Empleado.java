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
    private double tiempo_cinta, tiempo_avion;
    JTextArea jTextArea2, jTextArea3, jTextArea6, jTextArea7;
    JLabel jLabel4, jLabel1, jLabel2, jLabel5, jLabel8, jLabel10, jLabel11, jLabel12, jLabel13;
    JTextField jTextField1, jTextField2;
    
    Random rand = new Random();
    
    public Empleado(Cinta cinta, Avion avion, JTextArea jTextArea2, JTextArea jTextArea3, 
            JLabel jLabel4, JLabel jLabel1, JLabel jLabel2, JLabel jLabel5, Paso paso, 
            JLabel jLabel8, JTextArea jTextArea6, JTextArea jTextArea7, JLabel jLabel10, 
            JLabel jLabel11, JLabel jLabel12, JLabel jLabel13){
        this.miCinta = cinta;
        this.miAvion = avion;
        this.jTextArea2 = jTextArea2;
        this.jTextArea3 = jTextArea3;
        this.jTextArea6 = jTextArea6;
        this.jTextArea7 = jTextArea7;
        this.jLabel4 = jLabel4;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel5 = jLabel5;
        this.paso = paso;
        this.jLabel8 = jLabel8;
        this.jLabel10 = jLabel10;
        this.jLabel11 = jLabel11;
        this.jLabel13 = jLabel13;
        this.jLabel12 = jLabel12;
    }

    
    public void run(){
        while(true){
            contador += 1;
            paso.Mirar(nombre);
            try{
                sleep((rand.nextInt(700-400) + 1) + 400);
            } catch(InterruptedException e){  }
            paso.Mirar(nombre);
            estadoEmpleado(nombre, 0, jLabel12, jLabel13);
            tiempo_cinta = (System.nanoTime());
            String maleta = miCinta.cogeMaleta(nombre, jTextArea2, jLabel4,  jLabel1, jLabel2, jLabel8, jTextArea6, jTextArea7, jLabel10, jLabel11, tiempo_cinta);
            try{
                sleep((rand.nextInt(700-400) + 1) + 400);
            } catch(InterruptedException e){  }
            paso.Mirar(nombre);
            estadoEmpleado(nombre, 1, jLabel12, jLabel13);
            maletasAvion(maleta, jTextArea3, jLabel5, miAvion);
            estadoEmpleado(nombre, 2, jLabel12, jLabel13);
        }
    }
    
        // Metodo para dejar maletas en el avion
        public void maletasAvion(String maleta, JTextArea jTextArea3, JLabel jLabel5, Avion avion){
            avion.getMaletas().add(maleta);
        jTextArea3.setText(jTextArea3.getText() + "Maleta: " + maleta + "\n");
            jLabel5.setText(String.valueOf(avion.totalMaletas()));
        }
        
        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        
        // Metodo para cambiar el jLabel del empleado segun su accion
        public void estadoEmpleado(String nombre, int time, JLabel jLabel12, JLabel jLabel13){
            if(nombre.contains("Dani")){
                if(time == 0){
                   jLabel12.setText("Descargando maletas"); 
                }
                if(time == 1){
                    jLabel12.setText("Llevando maleta al avion");
                }
                if(time == 2){
                    jLabel12.setText("Volviendo del avion");
                }
            }if(nombre.contains("Jorge")){
                if(time == 0){
                   jLabel13.setText("Descargando maletas"); 
                }
                if(time == 1){
                    jLabel13.setText("Llevando maleta al avion");
                }
                if(time == 2){
                    jLabel13.setText("Volviendo del avion");
                    }
            }
        }
        
    

}
