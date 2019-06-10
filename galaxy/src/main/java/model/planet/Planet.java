package model.planet;

import model.AstronomicalObject;
import org.apache.maven.model.Developer;

public class Planet extends AstronomicalObject {

    private double rotationPeriod;
    private double density;
    private double secondCosmicVelocity;
    private String name;

    public Planet() {

    }


    public Planet(double radius) {
        super(radius);
    }


    public Planet(double weight, double radius, String n) {
        super(weight, radius, n);

    }

    public Planet(double weight, double radius, String n, double density,
                  double rotationPeriod) {
        super(weight, radius, n);
        this.density = density;
        this.rotationPeriod = rotationPeriod;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public double getSecondCosmicVelocity() {
        return secondCosmicVelocity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}