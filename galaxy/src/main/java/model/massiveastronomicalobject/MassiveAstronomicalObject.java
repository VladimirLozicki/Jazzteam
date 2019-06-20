package model.massiveastronomicalobject;

import model.AstronomicalObject;


public class MassiveAstronomicalObject extends AstronomicalObject {
    private double luminosity;

    public MassiveAstronomicalObject() {

    }

    public MassiveAstronomicalObject(double radius, double luminosity) {
        super(radius);
        this.luminosity = luminosity;
    }


    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }
}