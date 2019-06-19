package model.planet;

import model.AstronomicalObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Planet extends AstronomicalObject {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Planet() {

    }

    public Planet(double weight, double radius, String n) {
        super(weight, radius, n);

    }

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
}