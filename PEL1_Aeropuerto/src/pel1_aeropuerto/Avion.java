
package pel1_aeropuerto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Avion {
   private ArrayList<String> space = new ArrayList<>();
   private int maletas_avion;
   
    public void maletasAvion(String maleta, JTextArea jTextArea3, JLabel jLabel5){
        maletas_avion += 1;
        space.add("Maleta: " + maleta);
        jTextArea3.setText(jTextArea3.getText() + Avion(maleta) + "\n");
        jLabel5.setText(String.valueOf(maletas_avion));
        }
    
        public String Avion (String maleta){
            String mensaje="Maleta: " + maleta;
            return mensaje;
        }
    }
    
