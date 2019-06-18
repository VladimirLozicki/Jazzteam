package model.planet;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "satellite")
public class Satellite extends Planet {


    public Satellite() {

    }

    public Satellite(double weight) {
        this.setWeight(weight);
    }

    public Satellite(String name) {
        this.setName(name);
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


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public double getVelocity() {
        return super.getVelocity();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }
}