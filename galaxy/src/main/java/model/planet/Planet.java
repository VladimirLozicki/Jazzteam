package model.planet;

import model.AstronomicalObject;

public class Planet extends AstronomicalObject{


    private double rotationPeriod;
    private double density;
    private double secondCosmicVelocity;

    Planet(){

    }

    Planet(double weight, double radius, String n){
        super(weight,radius,n);
    }

    public Planet(double weight, double radius, double temperature, String n, double density,
                  double rotationPeriod){
        super(weight,radius,temperature,n);
        this.density=density;
        this.rotationPeriod=rotationPeriod;
    }
    public double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getSecondCosmicVelocity() {
        return secondCosmicVelocity;
    }

    public void setSecondCosmicVelocity(double secondCosmicVelocity) {
        this.secondCosmicVelocity = secondCosmicVelocity;
    }
}