package model.massiveastronomicalobject;


public class Star extends MassiveAstronomicalObject {

    protected final static double SIGMA = 1;

    public Star(double radius, double luminosity) {
        super.setRadius(radius);
        this.setLuminosity(luminosity);
    }

    public double getTemperature() {
        return getLuminosity() / SIGMA * Math.PI * getRadius() * getRadius();
    }


}
