package model.massiveastronomicalobject;


public class Star extends MassiveAstronomicalObject {
    private double luminocity;
    private double sigma = 1;

    public Star(double radius, double luminocity) {
        super.setRadius(radius);
        this.luminocity = luminocity;
    }

    public double temperature() {
        return luminocity / sigma * Math.PI * getRadius()*getRadius();
    }

}
