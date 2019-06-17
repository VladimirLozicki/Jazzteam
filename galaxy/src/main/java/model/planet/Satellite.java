package model.planet;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "satellite")
public class Satellite extends Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "velocity")
    private double velocity;


    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

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
        this.setName(name);
    }

    public Satellite(double velocity, double weight, double radius, String name) {
        this.setVelocity(velocity);
        this.setWeight(weight);
        this.setRadius(radius);
        this.setName(name);
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
                // ", weight='" + weight +
                '}';
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}