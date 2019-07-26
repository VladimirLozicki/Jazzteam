package model.massiveastronomicalobject;

import model.planet.AstronomicalObject;

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
    @Transient
    private double luminosity;

    public MassiveAstronomicalObject() {
    }

    public MassiveAstronomicalObject(double weight, double radius) {
        super(weight, radius);

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}