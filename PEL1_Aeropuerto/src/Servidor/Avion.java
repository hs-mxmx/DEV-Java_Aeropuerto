package Servidor;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Avion {
   
        private ArrayList <String> maletas;
        private int total_maletas;
        private double tiempo_empleado;
        
        /* Avion */
        public Avion() {
            maletas = new ArrayList<>();
        }
        
        /* Dejar maletas en el avión */
        public synchronized void maletasAvion(String nombre, String maleta, JTextArea jTextArea3, JButton dnum_maletasAvion, Avion avion, double tiempo_avion){
            maletas.add(maleta);
            jTextArea3.setText(jTextArea3.getText() + "Maleta: " + maleta + "\n");
            dnum_maletasAvion.setText(String.valueOf(avion.totalMaletas()));
            tiempo_empleado = (System.nanoTime());
            tiempo_empleado = (tiempo_empleado - tiempo_avion);
            tiempo_empleado = (tiempo_empleado/1000000000);
            guardarDatos(nombre, tiempo_empleado);
        }
        
        /* Total de maletas en avion */
        public int totalMaletas(){
            total_maletas += 1;
            return total_maletas;
        }
        
        /* Array de maletas para el servidor */
        public ArrayList<String>getMaletasServidor(){
            return maletas;
        }
        
        /* Metodo para guardar los datos del historial general */
        public void guardarDatos(String nombre, double tiempo){
            FileWriter historial = null;
            PrintWriter hist_w = null;
            try{
                historial = new FileWriter("Historiales/Empleados.txt",true);
                hist_w = new PrintWriter(historial);
                hist_w.println(nombre + " vuelve del avion " + "\t\t\t\t[" + tiempo + "]");
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
          
    }
    
