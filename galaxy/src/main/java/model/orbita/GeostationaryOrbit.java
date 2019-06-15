package model.orbita;

import model.orbita.Orbit;
import model.planet.Planet;
import model.planet.Satellite;

public class GeostationaryOrbit extends Orbit {
    public static class GeostationaryBuilder extends Orbit.Builder {
        public GeostationaryBuilder(Planet planet, Satellite satellite) {
            super(planet);
            this.satellite=satellite;

        }

        public Builder satellite(Satellite satellite) {
            this.satellite = satellite;
            return this;
        }

        @Override
        public Orbit build() {
            return new GeostationaryOrbit(this);
        }

    }

    GeostationaryOrbit(GeostationaryOrbit.Builder builder) {
        planet = builder.planet;
        satellite = builder.satellite;
    }

    public double heightOrbit() {
        return Math.cbrt(G * planet.getWeight());
    }


    public double heightRise() {
        return satellite.getVelocity() * satellite.getVelocity() / 2 * accelerationGravity();
    }
}