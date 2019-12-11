package Server;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Console_Components {
    /* JButtons */
    private final JButton dnum_passengers;
    private final JButton dnum_casesBelt;
    private final JButton dnum_completed;
    private final JButton beltStatus;
    private final JButton dnum_pickUpCases;
    private final JButton dnum_casesAirport;
    private final JButton dnum_emp1;
    private final JButton dnum_emp2;
    private final JButton demp1;
    private final JButton demp2;
    
    /* JTextAreas */
    private final JTextArea jText_totalPassengers;
    private final JTextArea jTextArea_completedPassengers;
    private final JTextArea jText_totalCases;
    private final JTextArea jTextArea_emp1;
    private final JTextArea jTextArea_airportCases;
    private final JTextArea jTextArea_emp2;
    
    /* JLabel */
    private final JLabel status_icon;
    
    public Console_Components(JTextArea jText_totalPassengers,JButton dnum_passengers,
            JButton dnum_casesBelt, JLabel status_icon, JTextArea jTextArea_completedPassengers,
            JTextArea jText_totalCases, JButton dnum_completed, JButton beltStatus,
            JTextArea jTextArea_emp1, JTextArea jTextArea_airportCases, JButton dnum_pickUpCases,
            JButton dnum_casesAirport, JTextArea jTextArea_emp2, JButton dnum_emp1, JButton dnum_emp2,
            JButton demp1, JButton demp2){
        
        this.dnum_passengers = dnum_passengers;
        this.dnum_casesBelt = dnum_casesBelt;
        this.dnum_completed = dnum_completed;
        this.beltStatus = beltStatus;
        this.dnum_pickUpCases = dnum_pickUpCases;
        this.dnum_casesAirport = dnum_casesAirport;
        this.dnum_emp1 = dnum_emp1;
        this.dnum_emp2 = dnum_emp2;
        this.demp1 = demp1;
        this.demp2 = demp2;
        this.jText_totalPassengers = jText_totalPassengers;
        this.jTextArea_completedPassengers = jTextArea_completedPassengers;
        this.jText_totalCases = jText_totalCases;
        this.jTextArea_emp1 = jTextArea_emp1;
        this.jTextArea_airportCases = jTextArea_airportCases;
        this.jTextArea_emp2 = jTextArea_emp2;
        this.status_icon = status_icon;
    }
    
    /* JButtons */
    
    /**
     * 
     * @return dnum_passengers
     */
    public JButton get_dnum_passengers(){
        return dnum_passengers;
    }
    
    /**
     * 
     * @return get_dnum_casesBelt
     */
    public JButton get_dnum_casesBelt(){
        return dnum_casesBelt;
    }
    
    /**
     * 
     * @return dnum_completed
     */
    public JButton get_dnum_completed(){
        return dnum_completed;
    }
    
    /**
     * 
     * @return beltStatus
     */
    public JButton get_beltStatus(){
        return beltStatus;
    }
    
    /**
     * 
     * @return dnum_pickUpCases
     */
    public JButton get_dnum_pickUpCases(){
        return dnum_pickUpCases;
    }
    
    /**
     * 
     * @return dnum_casesAirport
     */
    public JButton get_dnum_casesAirport(){
        return dnum_casesAirport;
    }
    
    /**
     * 
     * @return dnum_emp1
     */
    public JButton get_dnum_emp1(){
        return dnum_emp1;
    }
    
    /**
     * 
     * @return dnum_emp2
     */
    public JButton get_dnum_emp2(){
        return dnum_emp2;
    }
    
    /**
     * 
     * @return demp1
     */
    public JButton get_demp1(){
        return demp1;
    }
    
    /**
     * 
     * @return demp2
     */
    public JButton get_demp2(){
        return demp2;
    }
    
    /* JTextArea */
    
    /**
     * 
     * @return jText_totalPassengers
     */
    public  JTextArea get_jText_totalPassengers(){
        return jText_totalPassengers;
    }
    
    /**
     * 
     * @return jTextArea_completedPassengers
     */
    public  JTextArea get_jTextArea_completedPassengers(){
        return jTextArea_completedPassengers;
    }
    
    /**
     * 
     * @return jText_totalCases
     */
    public  JTextArea get_jText_totalCases(){
        return jText_totalCases;
    }
    
    /**
     * 
     * @return jTextArea_emp1
     */
    public  JTextArea get_jTextArea_emp1(){
        return jTextArea_emp1;
    }
    
    /**
     * 
     * @return jTextArea_airportCases
     */
    public  JTextArea get_jTextArea_airportCases(){
        return jTextArea_airportCases;
    }
    
    /**
     * 
     * @return jTextArea_emp2
     */
    public  JTextArea get_jTextArea_emp2(){
        return jTextArea_emp2;
    }
    
    /* JLabel */
    
    /**
     * 
     * @return status_icon
     */
    public JLabel get_status_icon(){
        return status_icon;
    } 
}
