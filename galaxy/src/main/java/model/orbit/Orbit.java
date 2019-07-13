package model.orbit;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Satellite;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Orbit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private double height;
    private double acceleration;
    @OneToOne(cascade = {CascadeType.ALL})
    public Planet planet;


    public Orbit() {
    }

    public static class Builder {
        Planet planet;
        Star star;
        double height;
        double acceleration;

        public Builder() {

        }

        public Builder planet(Planet planet) {
            this.planet = planet;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }


        public Builder acceleration(double acceleration) {
            this.acceleration = acceleration;
            return this;
        }

        public Orbit build1() {
            return new Orbit(this);
        }
    }

    public Orbit(Orbit.Builder builder) {
        planet = builder.planet;
        height = builder.height;
        acceleration = builder.acceleration;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }


    public double getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
