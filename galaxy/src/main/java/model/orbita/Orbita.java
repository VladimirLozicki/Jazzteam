package model.orbita;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Sattelite;

import java.util.Timer;
import java.util.TimerTask;

public class Orbita {

    protected final static double G = 1;
    public double height;
    public Planet planet;
    public Sattelite sattelite;
    public Star star;

    Orbita() {
    }


    public void run(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Inside Timer Task" + System.currentTimeMillis());
            }
        };

        //System.out.println("Current time" + System.currentTimeMillis());

        timer.schedule(task, 100, 1000);
    }


    public double getHeight() {
        return height;
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

    public double accelerationGravity() {
        return (G * planet.getWeight()) / (Math.pow(planet.getRadius(), 2));
    }

    public double powerGravity() {
        return (G * planet.getWeight() * sattelite.getWeight()) / Math.pow(getHeight(), 2);
    }

//    public double getVelocity(int time, double velocity_0, double acceleration, double radius) {
//        double l=Math.PI*2*radius;
//        return (velocity- velocity_0)/time;
//        ;
//    }




}
