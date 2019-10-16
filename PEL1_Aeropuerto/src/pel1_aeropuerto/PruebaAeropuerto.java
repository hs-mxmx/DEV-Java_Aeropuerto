package aeropuerto;

public class PruebaAeropuerto {

    public static void main(String[] args) {
        
        Cinta c = new Cinta();      
        
        for (int i=0; i<40; i++) {
            if (i<=1) {
                Empleado e = new Empleado("Empleado"+(i+1), c);
                if (i==0) {
                    e.setID("Empleado Jorge");
                } else {
                    e.setID("Empleado Daniel");
                }
                e.start();
            }
            Pasajero p = new Pasajero("Pasajero"+(i+1), c);
            p.start();
        }
        
    }
    
}
