package model.orbita;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Sattelite;

public class Orbita {
    public double constG = 1;
    public double height;
    public Planet planet;
    public Sattelite sattelite;
    public Star star;


    Orbita() {

    }

    public static class Builder {
        Planet planet;
        Sattelite sattelite;
        Star star;
        double height;

        public Builder(Planet planet) {
            this.planet = planet;
        }

        public Builder sattelite(Sattelite sattelite) {
            this.sattelite = sattelite;
            return this;
        }

        public Builder star(Star star) {
            this.star = star;
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

    public double accelerationGravity(Planet planet) {
        return (constG * planet.getWeight()) / (Math.pow(planet.getRadius(), 2));
    }



    public double powerGravity(Planet planet, Sattelite sattelite) {
        return (constG * planet.getWeight() * sattelite.getWeight()) / Math.pow(height, 2);
    }

    public double getHeight() {
        return height;
    }

}
