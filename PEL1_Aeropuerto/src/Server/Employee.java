package Server;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Employee extends Thread{
    /* Variables */
    private final Belt myBelt;
    private final Leap leap;
    private final Airplane myPlane;
    private final JTextArea jTextArea_emp1, jTextArea_AirplaneCases, jText_totalCases, jTextArea_emp2;
    private final JLabel status_icon;
    private final JButton  dnum_casesBelt, dnum_pickUpCases, demp1, demp2, dnum_emp1, dnum_emp2, dnum_casesAirplane, belt_status;
    private final Random rand = new Random();
    private final int maxTime = 700;
    private final int minTime = 400;
    private String name;
    private double belt_time, plane_time;
    
    
    /* Employee */
    public Employee(Belt belt, Airplane myPlane, JTextArea jTextArea_emp1, JTextArea jTextArea_AirplaneCases, 
            JButton dnum_passengers, JButton dnum_casesBelt, JButton dnum_pickUpCases, JButton dnum_casesAirplane, Leap leap, 
            JLabel status_icon, JTextArea jText_totalCases, JTextArea jTextArea_emp2, JButton dnum_emp1, 
            JButton dnum_emp2, JButton demp1, JButton demp2, JButton belt_status){
        
        this.myBelt = belt;
        this.myPlane = myPlane;
        this.jTextArea_emp1 = jTextArea_emp1;
        this.jTextArea_AirplaneCases = jTextArea_AirplaneCases;
        this.jText_totalCases = jText_totalCases;
        this.jTextArea_emp2 = jTextArea_emp2;
        this.dnum_casesBelt = dnum_casesBelt;
        this.dnum_pickUpCases = dnum_pickUpCases;
        this.dnum_casesAirplane = dnum_casesAirplane;
        this.leap = leap;
        this.status_icon = status_icon;
        this.dnum_emp1 = dnum_emp1;
        this.dnum_emp2 = dnum_emp2;
        this.demp1 = demp1;
        this.demp2 = demp2;
        this.belt_status = belt_status;
    }

    /* Run */
    public void run(){
        while(true){
            leap.check(name);
            try{
                sleep((rand.nextInt(maxTime-minTime) + 1) + minTime);
            } catch(InterruptedException e){  }
            leap.check(name);
            employeeStatus(name, 0, demp1, demp2);
            belt_time = (System.nanoTime());
            String suitCase = myBelt.pickCase(name, jTextArea_emp1,  dnum_casesBelt, dnum_pickUpCases, 
                    status_icon, jText_totalCases, jTextArea_emp2, dnum_emp1, dnum_emp2, belt_time, belt_status);
            try{
                sleep((rand.nextInt(maxTime-minTime) + 1) + minTime);
            } catch(InterruptedException e){  }
            leap.check(name);
            employeeStatus(name, 1, demp1, demp2);
            plane_time = (System.nanoTime());
            myPlane.casesPlane(name, suitCase, jTextArea_AirplaneCases, dnum_casesAirplane, myPlane, plane_time);
            employeeStatus(name, 2, demp1, demp2);
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
         * @param demp1 JButton
         * @param demp2 JButton
         */
        public void employeeStatus(String name, int time, JButton demp1, JButton demp2){
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
