package Server;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*; 


public class Belt {
    /* Variables */
    private final ArrayList <String> belt;
    private final Random rand = new Random();
    private final Lock lock = new ReentrantLock();
    private final Condition checkBelt = lock.newCondition();
    private String suitCase;
    private int cases_e1, cases_e2, total_casesLeft, total_casesPicked, totalCases, belt_randomPos, left_passenger;
    private double employee_time, employee2_time, time_passenger;
    private final int belt_maxSize = 8;
    private final int max_time = 1000000000;

    
    /* Get images from project folder */
    private final ImageIcon go = new ImageIcon(this.getClass().getResource("/images/go2.png"));
    private final ImageIcon stop = new ImageIcon(this.getClass().getResource("/images/Stop_hand.png"));
    
    /* Belt */
    public Belt(){
        belt = new ArrayList<>();
    }
    
    /**
     * Method used by the passenger which he is going to use to leave the suitcase on the belt
     * @param name String
     * @param id_maleta String
     * @param jText_passenger JTextArea
     * @param dnum_passengers JButton
     * @param dnum_cases JButton
     * @param belt_icon JLabel
     * @param jText_beltStatus JTextArea
     * @param belt_time double
     * @param belt_status JButton
     */
    public void leftCase(String name, String id_maleta, JTextArea jText_passenger, JButton dnum_passengers,  
            JButton dnum_cases, JLabel belt_icon, JTextArea jText_beltStatus, double belt_time, JButton belt_status){
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
                belt_icon.setIcon(stop);
                belt_status.setText("Belt full, wait...");
             }else{
                belt_icon.setIcon(go);
                belt_status.setText("Fit " + (belt_maxSize-(belt.size()+1)) + " suitcases");
            }
            // SetText
            dnum_cases.setText(String.valueOf(totalCases));
            jText_passenger.setText(jText_passenger.getText()+ passengerData(suitCase, name) + "\n" );  
            jText_beltStatus.setText(beltCases());
            dnum_passengers.setText(String.valueOf(total_casesLeft));
            // Times
            time_passenger = (System.nanoTime());
            time_passenger = (time_passenger - belt_time);
            time_passenger = (time_passenger/max_time);
            // Save and record data
            saveRecord(name,suitCase, time_passenger);
            savePassengerRecord(name, time_passenger);
            saveCaseRecords(time_passenger);
            // Signal
            checkBelt.signalAll();
            caseMessage();
        }finally{
            lock.unlock();
        }
    }
    
    /**
     * Method used by the employee which he is going to use to pick up the suitcases from the belt
     * @param name String
     * @param jTextArea_emp1 JTextArea
     * @param dnum_casesBelt JButton
     * @param dnum_pickUpCases JButton
     * @param status_icon JLabel
     * @param jText_totalCases JTextArea
     * @param jTextArea_emp2 JTextArea
     * @param dnum_emp1 JButton
     * @param dnum_emp2 JButton
     * @param belt_time double
     * @param belt_status JButton
     * @return suitcase
     */
    public String pickCase(String name, JTextArea jTextArea_emp1, JButton dnum_casesBelt,  
            JButton dnum_pickUpCases, JLabel status_icon, JTextArea jText_totalCases, 
            JTextArea jTextArea_emp2, JButton dnum_emp1, JButton dnum_emp2, double belt_time, JButton belt_status){
        try{
            lock.lock();
            while((belt.isEmpty() && (total_casesPicked == total_casesLeft))|| total_casesLeft == 0){
                try{
                    checkBelt.await();
                }catch(Exception ie){}
            }
            randomPos(belt);
            if(belt.size() == belt_maxSize){
                status_icon.setIcon(stop);
                belt_status.setText("Belt full, wait for your turn...");
             }else{
                status_icon.setIcon(go);
                belt_status.setText("Fit " + (belt_maxSize-(belt.size()+1)+1) + " suitcases");
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
            saveRecord(name,suitCase, belt_time); 
            saveEmployeeRecord(name,suitCase, belt_time);
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
     * @param jTextLeft JTextArea
     * @param dnum_completed JButton
     */
    public void leftPassenger(String name, JTextArea jTextLeft, JButton dnum_completed){
        jTextLeft.setText(jTextLeft.getText() + name + "\n");
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
     * Method to get all cases left on the belt
     * @return totalCases
     */
    private int getCases(){
        return totalCases;
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
        
    
    
    /**
     * Method used to save data on General's Record
     * @param name String
     * @param id_case String
     * @param time double
     */
    private void saveRecord(String name, String id_case, double time){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            //if(total_casesLeft == 1){
            //    historial = new FileWriter("Records/General.txt");
            //}else{
                historial = new FileWriter("Records/General.txt",true);
            //}
            hist_w = new PrintWriter(historial);
            if(total_casesLeft == 1){
                if(name.contains("Dani")){
                    hist_w.println("\n\t========== HISTORIAL ========== \t\t  == Times ==\n"
                            + "\n[+] " + name + " left suitcase (" + id_case + ")" + "\t\t\t[" + time + "]");
                }if(name.contains("Jorge")){
                    hist_w.println("\n\t========== HISTORIAL ========== \t\t  == Times ==\n"
                            + "\n[+] " + name + " left suitcase (" + id_case + ")" + "\t\t\t[" + time + "]");
                }else{
                    hist_w.println("\n\t========== HISTORIAL ========== \t\t  == Times ==\n"
                            + "\n[-] " + name + " takes suitcase (" + suitCase + ")" + "\t\t[" + time + "]");
                }
            }else{
                if(name.contains("Dani")||name.contains("Jorge")){
                    hist_w.println("[+] " + name + " left suitcase (" + id_case + ")" + "\t\t\t[" + time + "]");
                }else{
                    hist_w.println("[-] " + name + " takes suitcase (" + suitCase + ")" + "\t\t[" + time + "]");
                }  
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
    
    /**
     * Method used to save data from employees on Employees' Record
     * @param name String
     * @param id_case String
     * @param time double
     */
    private void saveEmployeeRecord(String name, String id_case, double time){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            //if(total_casesPicked == 1){
            //    historial = new FileWriter("Records/Employees.txt");
            //}else{
                historial = new FileWriter("Records/Employees.txt", true);
            //}
            hist_w = new PrintWriter(historial);
            if(total_casesPicked == 1){
                if(name.contains("Dani")){
                    hist_w.println("\n\t========== EMPLOYEES ========== \t  == Times ==\n"
                            + "[+] " + name + " left suitcase (" + id_case + ")" + "\t\t[" + time + "]");
                }else{
                    hist_w.println("\n\t========== EMPLOYEES ========== \t  == Times ==\n"
                            + "[+] " + name + " left suitcase (" + id_case + ")" + "\t[" + time + "]");  
                }
            }else{
                if(name.contains("Dani")){
                    hist_w.println("[+] " + name + " left suitcase (" + id_case + ")" + "\t\t[" + time + "]");
                }else{
                    hist_w.println("[+] " + name + " left suitcase (" + id_case + ")" + "\t[" + time + "]");  
                }
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
    
    /**
     * Method used to save data from passengers on Passengers' Record
     * @param name String
     * @param time double
     */
    private void savePassengerRecord(String name, double time){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            //if(total_casesLeft == 1){
            //    historial = new FileWriter("Records/Passengers.txt");
            //}else{
                historial = new FileWriter("Records/Passengers.txt", true);
            //}
            hist_w = new PrintWriter(historial);
            if(total_casesLeft==1){
                hist_w.println("\n\t========== PASSENGERS ========== \t\t  == Times =="
                        + "\n\n[-] " + name + " takes suitcase (" + suitCase + ")" + "\t\t[" + time + "]");
            }else{
            hist_w.println("[-] " + name + " takes suitcase (" + suitCase + ")" + "\t\t[" + time + "]");
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
    
    /**
     * Method used to save data from suitcases on Suitcases' Record
     * @param time double
     */
    private void saveCaseRecords(double time){
        FileWriter historial = null;
        PrintWriter hist_w = null;
        try{
            //if(contador_dejadas == 1){
            //    historial = new FileWriter("Historiales/Maletas.txt");
            //}else{
                historial = new FileWriter("Records/Suitcases.txt", true);
            //}
            hist_w = new PrintWriter(historial);
            if(total_casesLeft == 1){
                hist_w.println("\n\t========== SUITCASES ========== \t  == Times ==\n"
                        + "\n\tSuitcase: " + suitCase + "\t\t[" + time + "]");
            }else{
                hist_w.println("\tSuitcase: " + suitCase + "\t\t[" + time + "]");
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

