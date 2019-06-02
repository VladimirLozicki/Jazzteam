package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;

public class GeostationaryOrbita extends Orbita {

    public double heightOrbita() {
        return Math.cbrt(G * planet.getWeight());
    }


    public double heightRise() {
        return sattelite.getVelocity() * sattelite.getVelocity() / 2 * accelerationGravity();
    }

    public static class GeostationaryBuilder extends Orbita.Builder {
        public GeostationaryBuilder(Planet planet, Sattelite sattelite) {
            super(planet);
            this.sattelite = sattelite;
        }

        @Override
        public GeostationaryOrbita build() {
            return new GeostationaryOrbita(this);
        }

    }

    GeostationaryOrbita(GeostationaryOrbita.Builder builder) {
        planet = builder.planet;
        sattelite = builder.sattelite;
    }


}
