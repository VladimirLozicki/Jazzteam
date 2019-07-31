package model.planet;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AstronomicalObject {

    private double weight;
    private double radius;
    private String name;
    private double velocity;

    protected AstronomicalObject() {
        /*
         * must be for hibernate
         */
    }

    public AstronomicalObject(double weight, double radius) {
        this.weight = weight;
        this.radius = radius;
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

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

}