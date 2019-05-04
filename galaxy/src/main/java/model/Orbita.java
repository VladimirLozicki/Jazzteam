package model;

import model.planet.Planet;

public class Orbita {

    Planet planet;
    private double distance;

    public Orbita(double distance, Planet planet) {
        this.distance = distance;
        this.planet = planet;
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
