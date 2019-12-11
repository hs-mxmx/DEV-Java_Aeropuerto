package Server;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JButton;

public class Employee extends Thread{
    /* Variables */
    private final Belt myBelt;
    private final Leap leap;
    private final Airplane myPlane;
    private final JButton demp1, demp2;
    private final Random rand = new Random();
    private final int maxTime = 700;
    private final int minTime = 400;
    private String name;
    private double belt_time, plane_time;
    
    
    /* Employee */
    public Employee(Belt belt, Airplane myPlane, Leap leap, Console_Components components){
        this.myBelt = belt;
        this.myPlane = myPlane;
        this.leap = leap;
        this.demp1 = components.get_demp1();
        this.demp2 = components.get_demp2();
    }

    /* Run */
    public void run(){
        while(true){
            leap.check(name);
            try{
                sleep((rand.nextInt(maxTime-minTime) + 1) + minTime);
            } catch(InterruptedException e){  }
            leap.check(name);
            employeeStatus(name, 0);
            belt_time = (System.nanoTime());
            String suitCase = myBelt.pickCase(name, belt_time);
            try{
                sleep((rand.nextInt(maxTime-minTime) + 1) + minTime);
            } catch(InterruptedException e){  }
            leap.check(name);
            employeeStatus(name, 1);
            plane_time = (System.nanoTime());
            myPlane.casesPlane(name, suitCase, myPlane, plane_time);
            employeeStatus(name, 2);
        }
    }
    
        /**
         * Method used to set employee's name
         * @param name String
         */
        public void setName_employee(String name){
            this.name = name;
        }
        
        /**
         * Method to set employee's status on Console
         * @param name String
         * @param time int
         */
        public void employeeStatus(String name, int time){
            if(time == 0){
                if(name.contains("Jorge")){
                    demp2.setText("Picking Suitcases"); 
                }else{
                    demp1.setText("Picking Suitcases"); 
                }
            }
            if(time == 1){
                if(name.contains("Jorge")){
                    demp2.setText("Taking Suitcases to Airplane"); 
                }else{
                    demp1.setText("Taking Suitcases to Airplane"); 
                }
            }
            if(time == 2){
                if(name.contains("Jorge")){
                    demp2.setText("Comming from Airplane"); 
                }else{
                    demp1.setText("Comming from Airplane"); 
                }
            }
        }
}
