package model.orbita;

import model.planet.Planet;
import model.planet.Satellite;

public class GeostationaryOrbit extends Orbit {
    GeostationaryOrbit(GeostationaryOrbit.Builder builder) {
        Planet planet = builder.planet;
        satellite = builder.satellite;
    }

    public double heightOrbit() {
        return Math.cbrt(G * planet.getWeight());
    }


    public double heightRise() {
        return satellite.getVelocity() * satellite.getVelocity() / 2 * accelerationGravity();
    }

    public static class GeostationaryBuilder extends Orbit.Builder {
        public GeostationaryBuilder(Planet planet, Satellite satellite) {
            super(planet);
            this.satellite = satellite;
        }

        @Override
        public GeostationaryOrbit build() {
            return new GeostationaryOrbit(this);
        }

    }


}
