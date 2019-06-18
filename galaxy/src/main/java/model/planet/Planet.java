package model.planet;

import model.AstronomicalObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "planet")
public class Planet extends AstronomicalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @Transient
//    static double rotationPeriod;
//    @Transient
//    private double density;
//    @Transient
//    private double secondCosmicVelocity;

    public Planet() {

    }


    public Planet(double weight, double radius, String n) {
        super(weight, radius, n);

    }

    public Planet(double weight, double radius, String n, double density,
                  double rotationPeriod) {
        super(weight, radius, n);
        // this.density = density;
        // this.rotationPeriod = rotationPeriod;
    }


//    protected  double getPeriod() {
//        return rotationPeriod;
//    }


    @Override
    public double getVelocity() {
        return super.getVelocity();
    }

    @Override
    public void setVelocity(double velocity) {
        super.setVelocity(velocity);
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Planet(double radius) {
        super(radius);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}