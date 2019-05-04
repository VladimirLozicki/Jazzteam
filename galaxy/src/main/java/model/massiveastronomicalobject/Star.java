package model.massiveastronomicalobject;

public class Star extends MassiveAstronomicalObject {
    private double luminocity;
    public Star(double minLuminocity, double maxLuminocity) {
        super(minLuminocity, maxLuminocity);
    }

    public Star(double luminocity) {
       this.luminocity=luminocity;
    }

    public double getLuminocity() {
        return luminocity;
    }

    public void setLuminocity(double luminocity) {
        this.luminocity = luminocity;
    }
}
