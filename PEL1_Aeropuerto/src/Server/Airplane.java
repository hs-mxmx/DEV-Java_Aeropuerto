package Server;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Airplane {
        /* Variables */
        private final ArrayList <String> suitCases;
        private double employee_time;
        private final int max_time = 1000000000;
        private final Console_Components components;
        Record record = new Record();
        
        /* Components */
        private final JButton dnum_casesAirport;
        private final JTextArea jTextArea_airportCases;

        /* Airplane */
        public Airplane(Console_Components components) {
            suitCases = new ArrayList<>();
            this.components = components;
            this.dnum_casesAirport = components.get_dnum_casesAirport();
            this.jTextArea_airportCases = components.get_jTextArea_airportCases();
        }
        
        /**
         * Method used by Employees to leave the cases they've picked on the belt to the airplane
         * @param name String
         * @param suitCase String
         * @param myPlane Airplane
         * @param plane_time double
         */
        public synchronized void casesPlane(String name, String suitCase, Airplane myPlane, double plane_time){
            suitCases.add(suitCase);
            jTextArea_airportCases.setText(jTextArea_airportCases.getText() + "Suitcase: " + suitCase + "\n");
            dnum_casesAirport.setText(String.valueOf(myPlane.suitCases.size()));
            employee_time = (System.nanoTime());
            employee_time = (employee_time - plane_time);
            employee_time = (employee_time/max_time);
            record.saveDataPlane(name, employee_time, suitCase);
        }
        
        /**
         * Method used to append suit cases to an array, which is gonna be returned to the Server
         * @return suitCases
         */
        public ArrayList<String>getCasesServer(){
            return suitCases;
        }
        
          
    }
    
