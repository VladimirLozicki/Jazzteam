package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;

public class Gravity  extends GeostationaryOrbita {
    public Gravity(Planet planet, Sattelite sattelite){
        super(planet, sattelite);
    }

    public double gravitation(){
       return G*planet.getWeight()*sattelite.getWeight()/heightOrbita()*heightOrbita();
    }

}
