package Servidor;

import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JButton;
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
    private JTextArea jTextArea2, jTextArea3, jTextArea6, jTextArea7;
    private JLabel  jLabel5, jLabel8, jLabel12, jLabel13;
    private JTextField jTextField1, jTextField2;
    private JButton dnum_pasajeros, dnum_maletascinta, dnum_maletasrecogidas, demp1, demp2, dnum_emp1, dnum_emp2, dnum_maletasAvion, estado_cinta;
    
    Random rand = new Random();
    
    /* Empleado */
    public Empleado(Cinta cinta, Avion avion, JTextArea jTextArea2, JTextArea jTextArea3, 
            JButton dnum_pasajeros, JButton dnum_maletascinta, JButton dnum_maletasrecogidas, JButton dnum_maletasAvion, Paso paso, 
            JLabel jLabel8, JTextArea jTextArea6, JTextArea jTextArea7, JButton dnum_emp1, 
            JButton dnum_emp2, JButton demp1, JButton demp2, JButton estado_cinta){
        this.miCinta = cinta;
        this.miAvion = avion;
        this.jTextArea2 = jTextArea2;
        this.jTextArea3 = jTextArea3;
        this.jTextArea6 = jTextArea6;
        this.jTextArea7 = jTextArea7;
        this.dnum_maletascinta = dnum_maletascinta;
        this.dnum_pasajeros = dnum_pasajeros;
        this.dnum_maletasrecogidas = dnum_maletasrecogidas;
        this.dnum_maletasAvion = dnum_maletasAvion;
        this.paso = paso;
        this.jLabel8 = jLabel8;
        this.dnum_emp1 = dnum_emp1;
        this.dnum_emp2 = dnum_emp2;
        this.demp1 = demp1;
        this.demp2 = demp2;
        this.estado_cinta = estado_cinta;
    }

    
    public void run(){
        while(true){
            contador += 1;
            paso.Mirar(nombre);
            try{
                sleep((rand.nextInt(700-400) + 1) + 400);
            } catch(InterruptedException e){  }
            paso.Mirar(nombre);
            estadoEmpleado(nombre, 0, demp1, demp2);
            tiempo_cinta = (System.nanoTime());
            String maleta = miCinta.cogeMaleta(nombre, jTextArea2,  dnum_maletascinta, dnum_maletasrecogidas, 
                    jLabel8, jTextArea6, jTextArea7, dnum_emp1, dnum_emp2, tiempo_cinta, estado_cinta);
            try{
                sleep((rand.nextInt(700-400) + 1) + 400);
            } catch(InterruptedException e){  }
            paso.Mirar(nombre);
            estadoEmpleado(nombre, 1, demp1, demp2);
            tiempo_avion = (System.nanoTime());
            miAvion.maletasAvion(nombre, maleta, jTextArea3, dnum_maletasAvion, miAvion, tiempo_avion);
            estadoEmpleado(nombre, 2, demp1, demp2);
        }
    }
    
        /* Nombre del Empleado */
        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        
        /* Estado del Empleado para la consola */
        public void estadoEmpleado(String nombre, int time, JButton demp1, JButton demp2){
            if(nombre.contains("Dani")){
                if(time == 0){
                   demp1.setText("Descargando maletas"); 
                }
                if(time == 1){
                    demp1.setText("Llevando maleta al avion");
                }
                if(time == 2){
                    demp1.setText("Volviendo del avion");
                }
            }if(nombre.contains("Jorge")){
                if(time == 0){
                   demp2.setText("Descargando maletas"); 
                }
                if(time == 1){
                    demp2.setText("Llevando maleta al avion");
                }
                if(time == 2){
                    demp2.setText("Volviendo del avion");
                    }
            }
        }
}
