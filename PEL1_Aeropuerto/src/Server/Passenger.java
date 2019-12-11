package Server;
import java.util.*;

public class Passenger extends Thread {
    /* Variables */
    private final String name;
    private final Belt myBelt;
    private final Random rand = new Random();
    private String suitCase;
    private double tiempo_cinta;
    private final int maxTime = 1000;
    private final int minTime = 500;

    
    /* Passenger */
    public Passenger(String nombre, Belt belt){
        this.name = nombre;
        myBelt = belt;       
    }
    
    /* Run */
    public void run(){
        for(int i=0; i<2; i++){
            tiempo_cinta = (System.nanoTime());
            try{
                sleep((rand.nextInt(maxTime-minTime) + 1) + minTime);
            } catch(InterruptedException e){  }
            int id_maleta=i+1;
            suitCase = name+"-"+id_maleta;
            myBelt.leftCase(name, suitCase,tiempo_cinta);
            if(i==1){
                myBelt.leftPassenger(name);
            }
        }
    }
      
}
