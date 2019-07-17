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
    private double way;
    private double newVelocity;
    private double height;
    private double acceleration;
    private String condition;
    private double newHeight;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public double getNewHeight() {
        return newHeight;
    }

    public void setNewHeight(double newHeight) {
        this.newHeight = newHeight;
    }




    @OneToOne(cascade = {CascadeType.ALL})
    public Planet planet;

    public Orbit() {
    }

    public static class Builder {
        Planet planet;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double accelerationGravity() {
        return (getPlanet().getWeight()) / (Math.pow(getPlanet().getRadius(), 2));
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

    public double getWay() {
        return way;
    }

    public void setWay(double way) {
        this.way = way;
    }
}
