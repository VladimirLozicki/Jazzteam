package model.orbita;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Sattelite;

import java.util.logging.Logger;

public class Orbita {
    public final double G = 1;
    private static final Logger logger = Logger.getGlobal();

    public double height;
    public Planet planet;
    public Sattelite sattelite;
    public Star star;


Orbita(){}

    public static class Builder {
        private Planet planet;
        private Sattelite sattelite;
        private Star star;
        private double height;

        public Builder(Planet planet) {
            this.planet = planet;
        }

        public Builder sattelite(Sattelite sattelite) {
            this.sattelite = sattelite;
            return this;
        }

        public Builder star(Star star) {
            this.planet = planet;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Orbita build() {
            return new Orbita(this);
        }
    }

    Orbita(Orbita.Builder builder) {
        planet = builder.planet;
        sattelite = builder.sattelite;
        star = builder.star;
        height = builder.height;
    }

    public double accelerationGravity() {
        return (G * planet.getWeight()) / (Math.pow(planet.getRadius(), 2));
    }

    public double PowerGravity() {
        return (G * planet.getWeight() * sattelite.getWeight()) / Math.pow(height, 2);
    }

    public double getHeight() {
        return height;
    }

}
