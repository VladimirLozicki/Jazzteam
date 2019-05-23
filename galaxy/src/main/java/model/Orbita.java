package model;

import model.planet.Planet;
import model.planet.Sattelite;

public class Orbita {
    final static double G =1;
    double velocityObject;
    private double height;
    Planet planet;
    Sattelite sattelite;
    public Orbita(double height, Planet planet) {
        this.height = height;
        this.planet = planet;
    }

    public Orbita(double height, Planet planet, Sattelite sattelite) {
        this.height = height;
        this.planet = planet;
        this.sattelite=sattelite;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAcceleration(double weight, double radius){
        return (G*weight)/(radius*radius);
        //return radius;
    }

}
