package aeropuerto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cinta {
    
    private int espacio = 0;
    private String maleta;
    private Lock cerrojo = new ReentrantLock();
    private Condition mirarCinta = cerrojo.newCondition();
    
    public void dejarMaleta (String id, String idm) {
        try {
            cerrojo.lock();
            while(cintaLlena()) {
                try {
                    mirarCinta.await();
                } catch (Exception e) {}
            }
            espacio++;
            maleta = idm;
            System.out.println("\n"+"\033[32m"+id + " \033[30mdeja la maleta " + maleta + " \033[30men la cinta");
            System.out.println("\033[35mMaletas en la cinta -> "+espacio);
            mirarCinta.signalAll(); 
            
        } finally {
            cerrojo.unlock();
        }
        
    }
    
    public void cogerMaleta (String id) {
        try {
            cerrojo.lock();
            while(cintaVacia()) {
                try {
                    mirarCinta.await();
                } catch (Exception e) {}
            }
            espacio--;
            System.out.println("\n"+"\033[36m"+id+" \033[30mcoge la maleta "+maleta+" \033[30my la lleva al avión");
            System.out.println("\033[35mMaletas en la cinta -> "+espacio);
            mirarCinta.signalAll();
       
        } finally {
            cerrojo.unlock();
        }
    }
    
    public boolean cintaVacia() {
        return espacio == 0;
    }
    
    public boolean cintaLlena() {
        return espacio == 8;
    }
    
    public String getMaleta() {
        return maleta;
    }

}
