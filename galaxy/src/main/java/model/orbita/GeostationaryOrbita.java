package model.orbita;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Sattelite;

public class GeostationaryOrbita extends Orbita {

    public static class Builder {
        // Обязательные параметры
        private Planet planet;
        // необязательные параметры
        private Sattelite sattelite;
        private Star star;
        private double height;

        public Builder(Planet planet) {
          this.planet=planet;
        }

        public GeostationaryOrbita build() {
            return new GeostationaryOrbita(this);
        }

        public Builder sattelite(Sattelite sattelite) {
            this.sattelite=sattelite;
            return this;
        }
    }

    GeostationaryOrbita(GeostationaryOrbita.Builder builder) {
        planet = builder.planet;
        sattelite = builder.sattelite;

    }

    public double heightOrbita() {
        return Math.cbrt(G * planet.getWeight());
    }

    public double heightRise() {
        return sattelite.getVelocity() * sattelite.getVelocity() / 2 * accelerationGravity();
    }

}
