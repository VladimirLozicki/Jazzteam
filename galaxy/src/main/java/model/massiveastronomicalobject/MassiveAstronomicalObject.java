package model.massiveastronomicalobject;

import model.AstronomicalObject;


public class MassiveAstronomicalObject extends AstronomicalObject {
    private double minLuminocity;
    private double maxLuminocity;
    private double luminocity;

    public MassiveAstronomicalObject() {

    }

    public MassiveAstronomicalObject(double radius) {
        super();
    }


    public double getLuminocity() {
        return luminocity;
    }

    public void setLuminocity(double luminocity) {
        this.luminocity = luminocity;
    }
}