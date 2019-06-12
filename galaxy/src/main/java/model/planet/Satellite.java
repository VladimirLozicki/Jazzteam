package model.planet;

import javax.persistence.*;

@Entity
@Table(name = "satellite")
public class Satellite extends Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    private double velocity;


    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }


    private double acceleration;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;


    public Satellite() {

    }

    public Satellite(String name) {
        this.name = name;
    }

    public Satellite(double weight) {
        this.setWeight(weight);
    }

    public Satellite(double velocity, double weight) {
        this.setVelocity(velocity);
        this.setWeight(weight);
    }

    public Satellite(double velocity, String name) {
        this.setVelocity(velocity);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "model.planet.Satellite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight +
                '}';
    }
}