package model.orbit;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Satellite;
import org.springframework.ui.ModelMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

@Entity
public class Orbit {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double height;

    private double acceleration;

    @Transient//@OneToOne(cascade = CascadeType.ALL)
    Satellite satellite;


    @Transient// @OneToOne( cascade = CascadeType.ALL)
    Planet planet;

    @Transient
    Star star;

//    @OneToMany
//    private Set<Orbit> elements;
//
//    public void setElements(Set<Orbit> elements) {
//        this.elements = elements;
//    }

    private static final Logger logger = Logger.getGlobal();
    @Transient
    protected final static double G = 1;
    @Transient
    private static int i = 0;




    public Orbit(double height, double acceleration) {
        this.height = height;
        this.acceleration = acceleration;
    }


    public Orbit() {

    }

    public Orbit(double height) {
        this.height = height;
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
        public Satellite satellite;


        Star star;
        double height;
        double acceleration;
        double velocity;

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

        public Builder velocity(double velocity) {
            this.velocity = velocity;
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
       // velocity = builder.velocity;
    }


    public double accelerationGravity() {
        return (G * getPlanet().getWeight()) / (Math.pow(getPlanet().getRadius(), 2));
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
