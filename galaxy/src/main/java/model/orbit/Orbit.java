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
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Orbit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Transient
    protected final static double G = 1;

    private int time=run();

    private static int i=0;
    private static final Logger logger = Logger.getGlobal();
    private double height;

    private double acceleration;

    @OneToOne(cascade = {CascadeType.ALL})
    public Satellite satellite;

    @OneToOne(cascade = {CascadeType.ALL})
    public Planet planet;

    @Transient
    Star star;

    public Orbit() {

    }

    public int run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                i++;
            }
        };
        timer.schedule(task, 1000,  10000);
        return i;
    }

    public double getWay() {
        return getVelocity() * run();
    }

    public double getVelocity() {
        if (getSatellite().getVelocity() + getAcceleration() * run() <= 0) {
            return 0;
        }
        return getSatellite().getVelocity() + getAcceleration() * run();
    }

    public String getMessage() {

        if (getHeight() > getVelocity() * run()) {
            return "satellite falls on the planet";
        } else if (getHeight() == getVelocity() * run()) {
            return "satellite located on orbit planet";
        } else if (getHeight() < getVelocity() * run()) {
            return "satellite leaves orbit planet";
        }
        return "";
    }

    public int getTime() {
        return time;
    }

    public static class Builder {
        Planet planet;
        Satellite satellite;
        Star star;
        double height;
        double acceleration;

        public Builder() {

        }

        public Builder planet(Planet planet) {
            this.planet = planet;
            return this;
        }

        public Builder satellite(Satellite satellite) {
            this.satellite = satellite;
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
        satellite = builder.satellite;
        height = builder.height;
        acceleration = builder.acceleration;
    }


    public double accelerationGravity() {
        return (G * getPlanet().getWeight()) / (Math.pow(getPlanet().getRadius(), 2));
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public double powerGravity() {
        return (G * planet.getWeight() * satellite.getWeight()) / Math.pow(getHeight(), 2);
    }


    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }


    public void setHeight(double height) {
        this.height = height;
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
