package model;


import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class AstronomicalObject {

    private double weight;
    private double radius;
    private String name;
    private double velocity;

    public AstronomicalObject() {

    }

    public AstronomicalObject(double weight, double radius) {
        this.weight = weight;
        this.radius=radius;
    }

    public AstronomicalObject(double weight) {
        this.weight = weight;
    }

    public AstronomicalObject(double w, double r, String n) {
        this.weight = w;
        this.radius = r;
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


    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

}