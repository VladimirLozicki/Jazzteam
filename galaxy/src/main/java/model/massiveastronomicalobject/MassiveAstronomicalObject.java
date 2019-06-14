package model.massiveastronomicalobject;

import model.AstronomicalObject;


public class MassiveAstronomicalObject extends AstronomicalObject {
    private double luminosity;

    public MassiveAstronomicalObject() {

    }

    public MassiveAstronomicalObject(double radius) {
        super();
    }


    public double getLuminocity() {
        return luminosity;
    }

    public void setLuminocity(double luminosity) {
        this.luminosity = luminosity;
    }
}