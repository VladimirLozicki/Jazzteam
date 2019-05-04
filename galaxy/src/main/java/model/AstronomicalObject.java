package model;

public class AstronomicalObject {

    private double weight;
    private double radius;
    private double temperature;
    private String name;

    public AstronomicalObject() {
    }

    public AstronomicalObject(double r, String n) {
        this.radius = r;
        this.name = n;
    }

    public AstronomicalObject(double w, double r, String n) {
        this.weight = w;
        this.radius = r;
        this.name = n;
    }
    public AstronomicalObject(double w, double r, double t, String n) {
        this.weight = w;
        this.radius = r;
        this.temperature = t;
        this.name = n;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
