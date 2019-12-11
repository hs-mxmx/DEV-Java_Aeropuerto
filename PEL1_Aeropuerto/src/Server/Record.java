package Server;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Record {
     /**
     * Method used to save data on General's Record
     * @param name String
     * @param id_case String
     * @param time double
     * @param total_casesLeft int
     */
    public void saveRecord(String name, String id_case, double time, int total_casesLeft){
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
                if(name.contains("Daniel")){
                    hist_w.println("\n\t========== HISTORIAL ========== \t\t  == Times ==\n"
                            + "\n[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t\t[" + time + "]");
                }if(name.contains("Jorge")){
                    hist_w.println("\n\t========== HISTORIAL ========== \t\t  == Times ==\n"
                            + "\n[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t\t[" + time + "]");
                }else{
                    hist_w.println("\n\t========== HISTORIAL ========== \t\t  == Times ==\n"
                            + "\n[-] " + name + " left suitcase (" + id_case + ")" + "\t\t[" + time + "]");
                }
            }else{
                if(name.contains("Daniel")||name.contains("Jorge")){
                    hist_w.println("[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t[" + time + "]");
                }else{
                    hist_w.println("[-] " + name + " left suitcase (" + id_case + ")" + "\t\t[" + time + "]");
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
     * @param total_casesPicked int
     */
    public void saveEmployeeRecord(String name, String id_case, double time, int total_casesPicked){
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
                if(name.contains("Daniel")){
                    hist_w.println("\n\t========== EMPLOYEES ========== \t\t  == Times ==\n"
                            + "[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t[" + time + "]");
                }else{
                    hist_w.println("\n\t========== EMPLOYEES ========== \t\t  == Times ==\n"
                            + "[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t[" + time + "]");  
                }
            }else{
                if(name.contains("Daniel")){
                    hist_w.println("[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t[" + time + "]");
                }else{
                    hist_w.println("[+] " + name + " takes suitcase (" + id_case + ")" + "\t\t[" + time + "]");  
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
     * @param suitCase String
     * @param total_casesLeft int
     */
    public void savePassengerRecord(String name, double time, String suitCase, int total_casesLeft){
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
                        + "\n\n[-] " + name + " left suitcase (" + suitCase + ")" + "\t\t[" + time + "]");
            }else{
            hist_w.println("[-] " + name + " left suitcase (" + suitCase + ")" + "\t\t[" + time + "]");
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
     * @param suitCase String
     * @param total_casesLeft int
     */
    public void saveCaseRecords(double time, String suitCase, int total_casesLeft){
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
    
        /**
         * Method used to save data on general record from employees status
         * @param name String
         * @param time double
         * @param suitCase String
         */
        public void saveDataPlane(String name, double time, String suitCase){
            FileWriter historial = null;
            PrintWriter hist_w = null;
            try{
                historial = new FileWriter("Records/Employees.txt",true);
                hist_w = new PrintWriter(historial);
                if(name.contains("Daniel")){
                    hist_w.println("[-] " + name + " left suitcase (" + suitCase + ") \t\t[" + time + "]");
                }else{
                    hist_w.println("[-] " + name + " left suitcase (" + suitCase + ") \t\t[" + time + "]");
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
