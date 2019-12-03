package Server;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Leap {
    /* Variables */
    private final Lock lock = new ReentrantLock();
    private final Condition emp1 = lock.newCondition();
    private final Condition emp2 = lock.newCondition();
    private final Condition emp = lock.newCondition();
    private boolean c_emp1 , c_emp2, c_emp = false;
    
    /**
     * Method used by threads to check if they're stopped 
     * @param name  String
     */
     public void check(String name){
        try{
            lock.lock();
            while(name.contains("Dani" )&& c_emp1){
                c_emp1 = false;
                try{
                    emp1.await();
                }catch(Exception ie){}
            }while(name.contains("Jorge") && c_emp2 ){
                c_emp2 = false;
                try{
                    emp2.await();
                }catch(Exception ie){
                    System.out.println(ie.getMessage());
                }
            }while((name.contains("Dani")||name.contains("Jorge"))&& c_emp){
                try{
                    emp.await();
                }catch(Exception ie){}
            }
        }finally{
            lock.unlock();
        }
    }
    
    /**
     * Method which receives jButton's String and opens threads according to it
     * @param name String
     */
    public void open(String name){
        try{
            lock.lock();
            if(name.equals("dani")){
                c_emp1=false;
                emp1.signal();
            }if(name.equals("jorge")){
                c_emp2=false;
                emp2.signal();
            }if(name.equals("employees")){
                c_emp=false;
                for(int i = 0; i<2; i++){
                    emp.signal();
                }
            }
        }
        finally{
            lock.unlock();
        }
    }
    
    /**
     * Method which receives jButton's String and closes threads according to it
     * @param name 
     */
    public void close(String name){
        try{
            lock.lock();
            if(name.equals("dani")){
                c_emp1=true;
            }if(name.equals("jorge")){
                c_emp2=true;
            }if(name.equals("employees")){
                c_emp=true;
            }
        }finally{
            lock.unlock();
        }
    }
    
}
