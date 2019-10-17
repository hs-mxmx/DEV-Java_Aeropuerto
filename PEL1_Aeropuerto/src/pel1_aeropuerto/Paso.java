/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pel1_aeropuerto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author dani
 */
public class Paso {
    
    Lock lock = new ReentrantLock();
    private Condition empleado1 = lock.newCondition();
    private Condition empleado2 = lock.newCondition();
    private Condition pasajeros = lock.newCondition();
    private Condition global = lock.newCondition();
    private int pasajeros_bloqueados, total_bloqueados = 0;
    
    private boolean c_empleado1 , c_empleado2, c_pasajeros, c_global = false;
     public void Mirar(String nombre){
        try{
            lock.lock();
            while(nombre.equals("Empleado 1" )&& c_empleado1){
                //System.out.println("Cerrado Empleados");
                c_empleado1 = false;
                try{
                    empleado1.await();
                }catch(Exception ie){}
            }while(nombre.equals("Empleado 2") && c_empleado2 ){
                //System.out.println("Cerrado Empleados");
                c_empleado2 = false;
                try{
                    empleado2.await();
                }catch(Exception ie){}
            }while(nombre.equals("Pasajeros") && c_pasajeros){
               //System.out.println("Cerrado Pasajeros");
                pasajeros_bloqueados += 1;
                try{
                    pasajeros.await();
                }catch(Exception ie){}
            }while(c_global){
                total_bloqueados += 1;
                //System.out.println("Bloqueados");
                try{
                    global.await();
                }catch(Exception ie){}
            }
        }finally{
            lock.unlock();
        }
    }
    
    public void abrir(String nombre){
        try{
            lock.lock();
            //System.out.println("Abierto");
            if(nombre.equals("jButton2")){
                c_empleado1=false;
                empleado1.signal();
            }if(nombre.equals("jButton4")){
                c_empleado2=false;
                empleado2.signal();
            }if(nombre.equals("jButton1")){
                c_pasajeros=false;
                while(pasajeros_bloqueados > 0){
                    pasajeros_bloqueados -= 1;
                    pasajeros.signal();   
                }
            }if(nombre.equals("jButton3")){
                c_global=false;
                global.signal();
                while(total_bloqueados > 0){
                    total_bloqueados -= 1;
                    global.signal();
                }
            }
        }
        finally{
            lock.unlock();
        }
    }
    
    public void cerrar(String nombre){
        try{
            lock.lock();
            //System.out.println("Cerrado");
            if(nombre.equals("jButton2")){
                //System.out.println("Cierro empleado 1");
                c_empleado1=true;
            }if(nombre.equals("jButton4")){
                c_empleado2=true;
            }if(nombre.equals("jButton1")){
               // System.out.println("Cierro Pasajeros");
                c_pasajeros=true;
            }if(nombre.equals("jButton3")){
                c_global=true;
            }
        }finally{
            lock.unlock();
        }
    }
    
}
