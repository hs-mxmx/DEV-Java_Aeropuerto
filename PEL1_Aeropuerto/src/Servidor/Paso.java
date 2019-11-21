package Servidor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Paso {
    
    private Lock lock = new ReentrantLock();
    private Condition empleado1 = lock.newCondition();
    private Condition empleado2 = lock.newCondition();
    private Condition pasajeros = lock.newCondition();
    private Condition empleados = lock.newCondition();
    private Condition global = lock.newCondition();
    private int pasajeros_bloqueados, total_bloqueados = 0;
    private boolean c_empleado1 , c_empleado2, c_empleados, c_pasajeros, c_global = false;
    
    /* Metodo que consulta cada uno de los hilos para saber si ha sido parado o no */
     public void Mirar(String nombre){
        try{
            lock.lock();
            while(nombre.contains("Dani" )&& c_empleado1){
                //System.out.println("Cerrado Empleados");
                c_empleado1 = false;
                try{
                    empleado1.await();
                }catch(Exception ie){}
            }while(nombre.contains("Jorge") && c_empleado2 ){
                //System.out.println("Cerrado Empleados");
                c_empleado2 = false;
                try{
                    empleado2.await();
                }catch(Exception ie){}
            }while((nombre.contains("Dani")||nombre.contains("Jorge"))&& c_empleados){
                try{
                    empleados.await();
                }catch(Exception ie){}
            }while(c_pasajeros && !nombre.contains("Dani") && !nombre.contains("Jorge")){
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
    
    /* Metodo que recibe el nombre del boton y abre segun este */
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
            }if(nombre.equals("jButton7")){
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
            }if(nombre.equals("jButton5")){
                c_empleados=false;
                for(int i = 0; i<2; i++){
                    empleados.signal();
                }
            }
        }
        finally{
            lock.unlock();
        }
    }
    
    /* Metodo que recibe el nombre del boton y cierra segun este */
    public void cerrar(String nombre){
        try{
            lock.lock();
            //System.out.println("Cerrado");
            if(nombre.equals("jButton2")){
                //System.out.println("Cierro empleado 1");
                c_empleado1=true;
            }if(nombre.equals("jButton4")){
                c_empleado2=true;
            }if(nombre.equals("jButton7")){
               // System.out.println("Cierro Pasajeros");
                c_pasajeros=true;
            }if(nombre.equals("jButton3")){
                c_global=true;
            }if(nombre.equals("jButton5")){
                c_empleados=true;
            }
        }finally{
            lock.unlock();
        }
    }
    
}
