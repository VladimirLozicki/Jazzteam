package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;

public class GeostationaryOrbita extends Orbita{
    GeostationaryOrbita(Planet planet, Sattelite sattelite){
        super(planet,sattelite);
    }

    public double getHeightOrbita(){
        return Math.cbrt(G*planet.getWeight());
    }

    public double getHeightRise(){
        return sattelite.getVelocity()*sattelite.getVelocity()/2*accelerationGravity();
    }

}
