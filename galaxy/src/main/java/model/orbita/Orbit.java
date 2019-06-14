package model.orbita;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Satellite;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Orbit {
    private static final Logger logger = Logger.getGlobal();
    protected final static double G = 1;
    private static int i = 0;
    private double height;
    private double acceleration;
    Star star;
    Satellite satellite;
    Planet planet;

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
        timer.schedule(task, 1, 1000);
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

    public static class Builder {
        Planet planet;
        Satellite satellite;
        Star star;
        double height;

        public Builder(Planet planet) {
            this.planet = planet;
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

        public Orbit build() {
            return new Orbit(this);
        }
    }

    Orbit(Orbit.Builder builder) {
        planet = builder.planet;
        satellite = builder.satellite;
        star = builder.star;
        height = builder.height;
    }


    public double accelerationGravity() {
        return (G * planet.getWeight()) / (Math.pow(planet.getRadius(), 2));
    }


    public double powerGravity() {
        return (G * planet.getWeight() * satellite.getWeight()) / Math.pow(getHeight(), 2);
    }


    public double getWeight() {
        return planet.getWeight();
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
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

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

}
