package Server;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*; 


public class Belt {
    
    /* Variables */
    private final ArrayList <String> belt;
    private final Random rand = new Random();
    private final Lock lock = new ReentrantLock();
    private final Condition freeBelt = lock.newCondition();
    private final Condition checkBelt = lock.newCondition();
    private String suitCase;
    private int cases_e1, cases_e2, total_casesLeft, total_casesPicked, totalCases, belt_randomPos, left_passenger;
    private double employee_time, employee2_time, time_passenger;
    private final int belt_maxSize = 8;
    private final int max_time = 1000000000;
    private final Record record = new Record();
    private final Console_Components components;
    
    /* Components */
    private final JButton dnum_passengers;
    private final JButton dnum_casesBelt;
    private final JButton dnum_completed;
    private final JButton beltStatus;
    private final JButton dnum_pickUpCases;
    private final JButton dnum_emp1;
    private final JButton dnum_emp2;
    
    private final JTextArea jText_totalPassengers;
    private final JTextArea jTextArea_completedPassengers;
    private final JTextArea jText_totalCases;
    private final JTextArea jTextArea_emp1;
    private final JTextArea jTextArea_emp2;
    
    private final JLabel status_icon;
    /* Get images from project folder */
    private final ImageIcon go = new ImageIcon(this.getClass().getResource("/images/go2.png"));
    private final ImageIcon stop = new ImageIcon(this.getClass().getResource("/images/Stop_hand.png"));
    
    /* Belt */
    public Belt(Console_Components components){
        this.components = components;
        belt = new ArrayList<>();
        dnum_passengers = components.get_dnum_passengers();
        dnum_casesBelt = components.get_dnum_casesBelt();
        dnum_completed = components.get_dnum_completed();
        beltStatus = components.get_beltStatus();
        dnum_pickUpCases = components.get_dnum_pickUpCases();
        dnum_emp1 = components.get_dnum_emp1();
        dnum_emp2 = components.get_dnum_emp2();
        
        jText_totalPassengers = components.get_jText_totalPassengers();
        jTextArea_completedPassengers = components.get_jTextArea_completedPassengers();
        jText_totalCases = components.get_jText_totalCases();
        jTextArea_emp1 = components.get_jTextArea_emp1();
        jTextArea_emp2 = components.get_jTextArea_emp2();
        
        status_icon = components.get_status_icon();
    }
    
    /**
     * Method used by the passenger which he is going to use to leave the suitcase on the belt
     * @param name String
     * @param id_maleta String
     * @param belt_time double
     */
    public void leftCase(String name, String id_maleta, double belt_time){
        try{
            lock.lock();
            while(belt.size() >= belt_maxSize){
                try{
                    checkBelt.await();
                }catch(Exception ie){}
            }
            totalCases += 1;
            total_casesLeft += + 1;
            suitCase = id_maleta;
            belt.add(suitCase);
            if(belt.size() == belt_maxSize){
                status_icon.setIcon(stop);
                beltStatus.setText("Belt full, wait...");
             }else{
                status_icon.setIcon(go);
                beltStatus.setText("Fit " + (belt_maxSize-(belt.size()+1)) + " suitcases");
            }
            // SetText
            dnum_casesBelt.setText(String.valueOf(totalCases));
            jText_totalPassengers.setText(jText_totalPassengers.getText()+ passengerData(suitCase, name) + "\n" );  
            jText_totalCases.setText(beltCases());
            dnum_passengers.setText(String.valueOf(total_casesLeft));
            // Times
            time_passenger = (System.nanoTime());
            time_passenger = (time_passenger - belt_time);
            time_passenger = (time_passenger/max_time);
            // Save and record data
            record.saveRecord(name,suitCase, time_passenger, total_casesLeft);
            record.savePassengerRecord(name, time_passenger, suitCase, total_casesLeft);
            record.saveCaseRecords(time_passenger,suitCase, total_casesLeft);
            // Signal
            freeBelt.signalAll();
            caseMessage();
        }finally{
            lock.unlock();
        }
    }
    
    /**
     * Method used by the employee which he is going to use to pick up the suitcases from the belt
     * @param name String
     * @param belt_time double
     * @return suitcase
     */
    public String pickCase(String name, double belt_time){
        try{
            lock.lock();
            while((belt.isEmpty() && (total_casesPicked == total_casesLeft))|| total_casesLeft == 0){
                try{
                    freeBelt.await();
                }catch(Exception ie){}
            }
            randomPos(belt);
            if(belt.size() == belt_maxSize){
                status_icon.setIcon(stop);
                beltStatus.setText("Belt full, wait for your turn...");
             }else{
                status_icon.setIcon(go);
                beltStatus.setText("Fit " + (belt_maxSize-(belt.size()+1)+1) + " suitcases");
            }
            // Variables modified
            totalCases -= 1;
            total_casesPicked += 1;
            // SetText
            setTextEmployee(name, jTextArea_emp1, jTextArea_emp2, dnum_emp1, dnum_emp2);
            dnum_casesBelt.setText(String.valueOf(totalCases));
            jText_totalCases.setText(beltCases());
            dnum_pickUpCases.setText(String.valueOf(total_casesPicked));
            // Times
            belt_time = employeeTime(name, belt_time);
            // Save and record data
            record.saveRecord(name,suitCase, belt_time, total_casesLeft); 
            record.saveEmployeeRecord(name,suitCase, belt_time, total_casesPicked);
            // Signal
            checkBelt.signalAll();
            return suitCase;
        }finally{
            lock.unlock();
        }
    }
    
    
    /**
     * Method used to calculate the total number of passengers who left both suitcases
     * @param name String
     */
    public void leftPassenger(String name){
        jTextArea_completedPassengers.setText(jTextArea_completedPassengers.getText() + name + "\n");
        left_passenger += 1;
        dnum_completed.setText(String.valueOf(left_passenger));
    }
    
    /**
     * Method to return passenger Status (Left Case)
     * @param id_case String
     * @param name String
     * @return message
     */
    private String passengerData (String id_case, String name){
        String message = "[" + total_casesLeft + "] " + name + " left case (" + id_case + ")";
        return message;
    }
    
    /**
     * Method to return employee Status (Takes Case)
     * @param name String
     * @return message
     */
    private String employeeData (String name){
        String message = name + " takes case (" + suitCase + ")";
        return message;
    }
    
    /**
     * Method to return suitcase Status (Total suitcases)
     * @return message
     */
    private String caseMessage (){
        String message = "Total SuitCases: " + totalCases;
        return message;
    }
    
    
    /**
     * Method used to calculate times from employees whenever they take a suitcase
     * @param name String
     * @param time double
     * @return time
     */
    private double employeeTime(String name, double time){
        if(name.contains("Dani")){
            employee_time = (System.nanoTime() + employee_time);
            employee_time = employee_time - time;
            employee_time = (employee_time/max_time);
            return employee_time;
        }
        employee2_time = (System.nanoTime() + employee2_time);
        employee2_time = employee2_time -time;
        employee2_time = (employee2_time/max_time);
        return employee2_time;
    }
    
    /**
     * Method used by the Server to get belt's Status
     * @return belt
     */
    public ArrayList<String> serverCases(){
        return belt;
    }
    
    /**
     * Method to return suitcases from belt according to the content of the arrayList
     * @return content
     */
    private String beltCases(){
        int i = 0;
        String content = "";
        if(belt.isEmpty()){
            return "Belt is empty...";
        }
        while(i <belt.size()){
            content = content + belt.get(i) + "\n";
            i++;
        }
        return content;
    }
    
    /**
     * Method to generate a random pos when suitcase is left according to arrayList's size
     * @param belt ArrayList<String>
     * @return ""
     */
    private String randomPos(ArrayList <String> belt){
        int long_cinta = belt.size()-1;
        if(!belt.isEmpty()){
            belt_randomPos = rand.nextInt((long_cinta-0)+1)+0;
            suitCase = belt.get(long_cinta-belt_randomPos);
            belt.remove(long_cinta-belt_randomPos);  
        }
        return "";
    }

    /**
     * Method user to change JTextArea according to the employee
     * @param name String
     * @param jTextArea_emp1 JTextArea
     * @param jTextArea_emp2 JTextArea
     * @param dnum_emp1 JButton
     * @param dnum_emp2 JButton
     */
    private void setTextEmployee(String name, JTextArea jTextArea_emp1, JTextArea jTextArea_emp2, JButton dnum_emp1, JButton dnum_emp2){
        if(name.contains("Dani")){
            cases_e1 += 1;
            dnum_emp1.setText(String.valueOf(cases_e1));
            jTextArea_emp1.setText(jTextArea_emp1.getText() + employeeData(name) + "\n");
        }if(name.contains("Jorge")){
            cases_e2 += 1;
            dnum_emp2.setText(String.valueOf(cases_e2));
            jTextArea_emp2.setText(jTextArea_emp2.getText() + employeeData(name) + "\n");  
        }
    }
         
}

