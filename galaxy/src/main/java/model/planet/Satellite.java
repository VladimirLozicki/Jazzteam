package model.planet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Satellite extends Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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