package model.planet;

import model.AstronomicalObject;

public class Planet extends AstronomicalObject {

    private double rotationPeriod;
    private double density;
    private double secondCosmicVelocity;

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

//    public static class Builder {
//        double weight;
//        double radius;
//        String name;
//        double density;
//        double rotationPeriod;
//
//        public Builder(double weight, double radius, String name) {
//            this.weight = weight;
//            this.radius=radius;
//            this.name=name;
//        }
//
//        public Planet.Builder sattelite(double density) {
//            this.density = density;
//            return this;
//        }
//
//        public Planet.Builder star(double rotationPeriod) {
//            this.rotationPeriod =rotationPeriod;
//            return this;
//        }
//
//
//
//        public Planet build() {
//            return new Planet(this);
//        }
//    }
//
//    Planet(Planet.Builder builder) {
//        getWeight()=builder.weight;
//    }

}