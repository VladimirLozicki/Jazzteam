package model.massiveAstronomicalObject;

import model.AstronomicalObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MassiveAstronomicalObject extends AstronomicalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public MassiveAstronomicalObject() {

    }
    @Transient
    private double luminosity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public MassiveAstronomicalObject(double weight) {
        super(weight);

    }

    public MassiveAstronomicalObject(double weight, double radius) {
        super(weight, radius);

    }

    public MassiveAstronomicalObject(double radius, double weight, double luminosity) {
        super(radius, weight);
        this.luminosity = luminosity;
    }


    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }


    @Override
    public double getVelocity() {
        return super.getVelocity();
    }


    @Override
    public String getName() {
        return super.getName();
    }


}