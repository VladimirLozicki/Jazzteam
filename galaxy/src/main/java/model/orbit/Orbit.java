package model.orbit;

import model.planet.Planet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Orbit {
    private double newVelocity;
    private double height;
    private double acceleration;
    private String condition;
    private double firstVelocity;
    private double secondVelocity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = {CascadeType.ALL})
    public Planet planet;


    public Orbit() {
        /*
         * must be for hibernate
         */
    }

    public static class Builder {
        Planet planet;
        double height;
        double acceleration;

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

        public Orbit build() {
            return new Orbit(this);
        }
    }

    public Orbit(Orbit.Builder builder) {
        planet = builder.planet;
        height = builder.height;
        acceleration = builder.acceleration;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


    public double getFirstVelocity() {
        return firstVelocity;
    }

    public void setFirstVelocity(double velocity) {
        this.firstVelocity = velocity;
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

    public double getNewVelocity() {
        return newVelocity;
    }

    public void setNewVelocity(double newVelocity) {
        this.newVelocity = newVelocity;
    }

    public double getSecondVelocity() {
        return secondVelocity;
    }

    public void setSecondVelocity(double secondVelocity) {
        this.secondVelocity = secondVelocity;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
