package model.orbita;
import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Sattelite;

import java.util.logging.Logger;

public class Orbita {
    public final double G = 1;
    private static final Logger logger = Logger.getGlobal();

    public double getHeight() {
        return height;
    }

    private double height;
    Planet planet;
    Sattelite sattelite;
    public Orbita(Planet planet, Sattelite sattelite) {
        this.planet = planet;
        this.sattelite=sattelite;
        this.height=height;
    }

    public Orbita(Planet planet, Star star, double height) {
        this.planet = planet;
        this.sattelite=sattelite;
        this.height=height;
    }

    public Orbita(Planet planet, Sattelite sattelite, double height) {
        this.planet = planet;
        this.sattelite=sattelite;
        this.height=height;
    }

    public double accelerationGravity(){
        return (G*planet.getWeight())/(Math.pow(planet.getRadius(),2));
    }

    public double PowerGravity(){
        return (G*planet.getWeight()*sattelite.getWeight())/Math.pow(height, 2);
    }
}
