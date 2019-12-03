package Server;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Airplane {
        /* Variables */
        private final ArrayList <String> suitCases;
        private int total_cases;
        private double employee_time;
        private final int max_time = 1000000000;
        
        
        /* Airplane */
        public Airplane() {
            suitCases = new ArrayList<>();
        }
        
        /**
         * Method used by Employees to leave the cases they've picked on the belt to the airplane
         * @param name String
         * @param suitCase String
         * @param jTextArea_airportCases jTextArea
         * @param dnum_maletasAvion JButton
         * @param myPlane Airplane
         * @param plane_time double
         */
        public synchronized void casesPlane(String name, String suitCase, JTextArea jTextArea_airportCases, JButton dnum_maletasAvion, Airplane myPlane, double plane_time){
            suitCases.add(suitCase);
            jTextArea_airportCases.setText(jTextArea_airportCases.getText() + "Suitcase: " + suitCase + "\n");
            dnum_maletasAvion.setText(String.valueOf(myPlane.getTotalCases()));
            employee_time = (System.nanoTime());
            employee_time = (employee_time - plane_time);
            employee_time = (employee_time/max_time);
            saveData(name, employee_time);
        }
        
        /**
         * Method used to get total cases left on the airplane
         * @return total_cases
         */
        public int getTotalCases(){
            total_cases += 1;
            return total_cases;
        }
        
        /**
         * Method used to append suit cases to an array, which is gonna be returned to the Server
         * @return suitCases
         */
        public ArrayList<String>getCasesServer(){
            return suitCases;
        }
        
        /**
         * Method used to save data on general record from employees status
         * @param name String
         * @param time double
         */
        public void saveData(String name, double time){
            FileWriter historial = null;
            PrintWriter hist_w = null;
            try{
                historial = new FileWriter("Records/Employees.txt",true);
                hist_w = new PrintWriter(historial);
                if(name.contains("Dani")){
                    hist_w.println("[-] " + name + " comes back from plane " + "\t\t\t[" + time + "]");
                }else{
                    hist_w.println("[-] " + name + " comes back from plane " + "\t\t[" + time + "]");
                }
            }catch(Exception e){
            }finally{
                try{
                    if (null != historial)
                        historial.close();
                }catch(Exception e2){
                }
            }
        }   
          
    }
    
