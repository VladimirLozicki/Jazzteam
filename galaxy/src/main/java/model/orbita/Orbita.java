package model.orbita;
import model.planet.Planet;
import model.planet.Sattelite;

import java.util.logging.Logger;

public class Orbita {
    public final double G = 1;
    private static final Logger logger = Logger.getGlobal();
    Planet planet;
    Sattelite sattelite;
    public Orbita(Planet planet, Sattelite sattelite) {
        this.planet = planet;
        this.sattelite=sattelite;
    }

    public double accelerationGravity(){
        return (G*planet.getWeight())/(planet.getRadius()*planet.getRadius());
    }
}
