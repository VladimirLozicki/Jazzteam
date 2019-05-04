package model.planet;

import model.AstronomicalObject;

public class Planet extends AstronomicalObject {
    private double secondCosmicVelocity;
    private double rotationPeriod;
    private double minDensity;
    private double maxDensity;
    private double density;
    private double minRadius;
    private double maxRadius;
    private double radius;
    private double minTemperature;
    private double maxTemperature;
    private double temperature;

    Planet(double w, double r, double t, String n, double density,
           double radius, double temperature) {
        super(w, r, t, n);
        this.density = density;
        this.radius = radius;
        this.temperature = temperature;
    }

    Planet(double w, double r, double t, String n,
           double rotation_period, double secondCosmicVelocity, double minDensity,
           double maxDensity, double minRadius, double maxRadius,
           double minTemperature, double maxTemperature) {
        super(w, r, t, n);
        this.rotationPeriod = rotation_period;
        this.secondCosmicVelocity = secondCosmicVelocity;
        this.minDensity = minDensity;
        this.maxDensity = maxDensity;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public double getSecondCosmicVelocity() {
        return secondCosmicVelocity;
    }

    public void setSecondCosmicVelocity(double secondCosmicVelocity) {
        this.secondCosmicVelocity = secondCosmicVelocity;
    }

    public double getRotation_period() {
        return rotationPeriod;
    }

    public void setRotation_period(double rotation_period) {
        this.rotationPeriod = rotation_period;
    }

    public double getMinDensity() {
        return minDensity;
    }

    public void setMinDensity(double minDensity) {
        this.minDensity = minDensity;
    }

    public double getMaxDensity() {
        return maxDensity;
    }

    public void setMaxDensity(double maxDensity) {
        this.maxDensity = maxDensity;
    }

    public double getMinRadius() {
        return minRadius;
    }

    public void setMinRadius(double minRadius) {
        this.minRadius = minRadius;
    }

    public double getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(double maxRadius) {
        this.maxRadius = maxRadius;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }
}