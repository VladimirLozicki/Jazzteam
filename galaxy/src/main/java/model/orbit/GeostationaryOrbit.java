package model.orbit;

import model.planet.Planet;
import model.planet.Satellite;

public class GeostationaryOrbit extends Orbit {
    public static class GeostationaryBuilder extends Orbit.Builder {
        public GeostationaryBuilder(Planet planet, Satellite satellite) {
            super();
            this.planet=planet;
            this.satellite=satellite;

        }

        public Builder satellite(Satellite satellite) {
            this.satellite = satellite;
            return this;
        }

        @Override
        public Orbit build1() {
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