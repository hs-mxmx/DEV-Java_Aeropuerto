package aeropuerto;

public class Empleado extends Thread {
 
    private Cinta miCinta;
    private String id;
    private Avion a;
    
    public Empleado(String id, Cinta miCinta)
    {
        this.miCinta=miCinta;
        this.id=id;
    }
    
    public void setAvion(Avion avion) {
        this.a=avion;
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
                sleep((int)(400+300*Math.random()));
            } catch(InterruptedException e){ }
                miCinta.cogerMaleta(id);
                llevarMaleta(a);
        }
    }
    
    public void llevarMaleta(Avion a) {
        a.getMaletas().add(miCinta.getMaleta());
        System.out.println(a.toString());
    }
}
