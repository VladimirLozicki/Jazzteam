package model;

import model.planet.Planet;

public class Orbita {

    Planet planet;
    private double distance;

    private double minDistance;
    private double maxDistance;
    public Orbita(double minDistance, double maxDistance, Planet planet) {
        this.maxDistance = maxDistance;
        this.minDistance =minDistance ;
        this.planet=planet;
    }

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
    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

}
