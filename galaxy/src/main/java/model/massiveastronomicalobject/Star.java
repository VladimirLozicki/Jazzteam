package model.massiveastronomicalobject;

public class Star extends MassiveAstronomicalObject {
    private  double minDistance;
    private  double maxDistance;

    public Star(double minLuminocity, double minDistance,double maxDistance, double maxLuminocity){
       super(minLuminocity,maxLuminocity);
       this.minDistance=minDistance;
       this.maxDistance=maxDistance;
    }


    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }
}
