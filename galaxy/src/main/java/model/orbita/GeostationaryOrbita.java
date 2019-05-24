package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;

public class GeostationaryOrbita {
    Planet planet;
    Sattelite sattelite;
    private double G=1.0;
    GeostationaryOrbita(Planet planet, Sattelite sattelite){
        this.planet=planet;
        this.sattelite=sattelite;
    }
    public double getHeightOrbita(){
        return Math.cbrt(G*planet.getWeight());
    }

    public double getHeightRise(){
        return sattelite.getVelocity()/2*run();
    }

    public double run(){
        return (G*planet.getWeight())/(planet.getRadius()*planet.getRadius());
    }
}
