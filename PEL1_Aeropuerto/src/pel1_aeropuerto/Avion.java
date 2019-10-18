
package pel1_aeropuerto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Avion {
   
        private ArrayList <String> maletas;
        private int total_maletas;
        
        public Avion() {
            maletas = new ArrayList<>();
        }
        
        public ArrayList <String> getMaletas(){
            return maletas;
        }
        
        public int totalMaletas(){
            total_maletas += 1;
            return total_maletas;
        }
    }
    
