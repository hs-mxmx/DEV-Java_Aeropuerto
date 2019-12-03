package Server;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Passenger extends Thread {
    /* Variables */
    private final String name;
    private final Belt myBelt;
    private final Random rand = new Random();
    private final JTextArea jText_totalPassengers, jTextArea_completedPassengers, jText_totalCases;
    private final JButton beltStatus, dnum_passengers, dnum_casesBelt, dnum_completed;
    private final JLabel status_icon;
    private String suitCase;
    private JLabel jLabel1, jLabel16;
    private double tiempo_cinta;

    
    /* Passenger */
    public Passenger(String nombre, Belt belt, JTextArea jText_totalPassengers, JButton dnum_passengers, 
            JButton dnum_casesBelt, Leap leap, JLabel status_icon, JTextArea jTextArea_completedPassengers, 
            JTextArea jText_totalCases, JButton dnum_completed, JButton beltStatus){
        this.name = nombre;
        myBelt = belt;       
        this.jText_totalPassengers = jText_totalPassengers;
        this.dnum_passengers = dnum_passengers;
        this.dnum_casesBelt = dnum_casesBelt;
        this.status_icon = status_icon;
        this.jTextArea_completedPassengers = jTextArea_completedPassengers;
        this.jText_totalCases = jText_totalCases;
        this.dnum_completed = dnum_completed;
        this.beltStatus = beltStatus;
    }
    
    /* Run */
    public void run(){
        for(int i=0; i<2; i++){
            tiempo_cinta = (System.nanoTime());
            try{
                sleep((rand.nextInt(1000-500) + 1) + 500);
            } catch(InterruptedException e){  }
            int id_maleta=i+1;
            suitCase = name+"-"+id_maleta;
            myBelt.leftCase(name, suitCase, jText_totalPassengers, dnum_passengers, dnum_casesBelt, status_icon, jText_totalCases, tiempo_cinta, beltStatus);
            if(i==1){
                myBelt.leftPassenger(name, jTextArea_completedPassengers, dnum_completed);
            }
        }
    }
      
}
