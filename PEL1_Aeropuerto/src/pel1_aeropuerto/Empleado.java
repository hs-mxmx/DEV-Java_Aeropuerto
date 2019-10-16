package aeropuerto;

public class Empleado extends Thread {
 
    private Cinta miCinta;
    private String id;
    
    public Empleado(String id, Cinta miCinta)
    {
        this.miCinta=miCinta;
        this.id=id;
    }
    
    public void setID(String nombre) {
        this.id=nombre;
    }
    
    @Override
    public void run()
    {
        while(true) {
            try
            {
                sleep((int)(400+300*Math.random())); //?????
            } catch(InterruptedException e){ }
                miCinta.recogerMaleta(id);
        }
    }
}
