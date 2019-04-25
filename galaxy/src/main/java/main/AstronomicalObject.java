package main;

public abstract class AstronomicalObject {

    double velocity;
    double weight;
    double radius;
    double gravity;


    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }


    public double getVelocity() {
        return velocity;
    }


    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getGravity() {
        return gravity;
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


}
