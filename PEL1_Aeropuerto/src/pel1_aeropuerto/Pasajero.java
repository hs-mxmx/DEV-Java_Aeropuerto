package aeropuerto;

public class Pasajero extends Thread {
    
    private String id;
    private Cinta miCinta;
    
    public Pasajero(String id, Cinta cinta) {
        this.id = id;
        this.miCinta = cinta;
    }
    
    @Override
    public void run() {
            for(int i=0; i<2; i++)
            {
                try
                {
                    sleep((int)(500+500*Math.random()));
                } catch(InterruptedException e){ }
                    miCinta.dejarMaleta(id, "\033[33m"+id+"-M"+(i+1));  

            }
    }
}
    

