package model.massiveastronomicalobject;


public class Star extends MassiveAstronomicalObject {
    private double luminosity;
    protected final static double SIGMA = 1;

    public Star(double radius, double luminosity) {
        super.setRadius(radius);
        this.luminosity = luminosity;
    }

    public double getTemperature() {
        return luminosity / SIGMA * Math.PI * getRadius() * getRadius();
    }
}
