package model.massiveastronomicalobject;
import model.AstronomicalObject;

public class MassiveAstronomicalObject extends AstronomicalObject {
    private double minLuminocity;
    private double maxLuminocity;

    public MassiveAstronomicalObject(double minLuminocity, double maxLuminocity) {
        this.minLuminocity=minLuminocity;
        this.maxLuminocity=maxLuminocity;
    }


    public double getMinLuminocity() {
        return minLuminocity;
    }

    public void setMinLuminocity(double minLuminocity) {
        this.minLuminocity = minLuminocity;
    }

    public double getMaxLuminocity() {
        return maxLuminocity;
    }

    public void setMaxLuminocity(double maxLuminocity) {
        this.maxLuminocity = maxLuminocity;
    }
}
