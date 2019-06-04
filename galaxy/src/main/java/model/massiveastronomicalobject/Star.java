package model.massiveastronomicalobject;


public class Star extends MassiveAstronomicalObject {
    private double luminocity;
    protected final static double SIGMA = 1;

    public Star(double radius, double luminocity) {
        super.setRadius(radius);
        this.luminocity = luminocity;
    }

    public double getTemperature() {
        return luminocity / SIGMA * Math.PI * getRadius() * getRadius();
    }
}
