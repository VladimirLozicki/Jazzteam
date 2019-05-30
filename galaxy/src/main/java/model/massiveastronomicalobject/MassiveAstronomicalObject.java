package model.massiveastronomicalobject;
import model.AstronomicalObject;


public class MassiveAstronomicalObject extends AstronomicalObject {
    private double minLuminocity;
    private double maxLuminocity;
    private double luminocity;
   public  MassiveAstronomicalObject(){

    }

    public MassiveAstronomicalObject( double radius) {
        super(radius);
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
