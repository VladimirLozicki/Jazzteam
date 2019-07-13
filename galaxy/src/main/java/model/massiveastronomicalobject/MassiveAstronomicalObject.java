package model.massiveastronomicalobject;

import model.AstronomicalObject;

import javax.persistence.Transient;


public class MassiveAstronomicalObject extends AstronomicalObject {
    @Transient
    private double luminosity;

    public MassiveAstronomicalObject() {

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

    @Transient
    @Override
    public double getVelocity() {
        return super.getVelocity();
    }

    @Transient
    @Override
    public String getName() {
        return super.getName();
    }
}