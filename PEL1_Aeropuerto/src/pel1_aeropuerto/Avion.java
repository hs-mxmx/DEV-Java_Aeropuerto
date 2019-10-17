package aeropuerto;

import java.util.ArrayList;

public class Avion {
    
    private ArrayList <String> maletas;
    
    public Avion() {
        maletas = new ArrayList<>();
    }
    
    public ArrayList <String> getMaletas() {
        return maletas;
    }

    @Override
    public String toString() {
        return "Maletas en el avión:\n " + maletas;
    }
    
    
}
