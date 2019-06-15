package model.planet;

import model.AstronomicalObject;
public class Planet extends AstronomicalObject {
    private double rotationPeriod;
    private double density;
    private double secondCosmicVelocity;

    public Planet() {

    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
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


}