package model.orbita;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Satellite;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public  class Orbit {
    public Star star;
    private static final Logger logger = Logger.getGlobal();
    protected static final double G = 1;
     Satellite satellite= new Satellite();
    Planet planet = new Planet();
    private  double height;
    public double getVelocity() {
        return (satellite.getVelocity());
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return height;
    }

    public Orbit() {
    }

    public static int i=0;
    public String run(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
           @Override
            public void run() {
               i++;
             //  getVelocity(i);
            }
        };
        timer.schedule(task, 1, 100);
        String message="";
        if(i<20){
            message="velocity very small";
        }
        if(i>20 && i<50){
            message ="velocity normal ";
        }
        if(i>50){
            message="velocity very big";
        }
        return message;

    }

    public static class Builder {
        Planet planet;
        Satellite satellite;
        Star star;
        double height;

        public Builder(Planet planet) {
            this.planet = planet;
        }

        public Builder sattelite(Satellite satellite) {
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

}
