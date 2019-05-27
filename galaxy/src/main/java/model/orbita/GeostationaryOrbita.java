package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;

public class GeostationaryOrbita extends Orbita{

    public GeostationaryOrbita(Planet planet, Sattelite sattelite) {
        super(planet, sattelite);
    }

    public double heightOrbita(){
        return Math.cbrt(G*planet.getWeight());
    }

    public double heightRise(){
        return sattelite.getVelocity()*sattelite.getVelocity()/2*accelerationGravity();
    }

    @Override
    public void print(String message) {
        super.print(message);
    }
}
