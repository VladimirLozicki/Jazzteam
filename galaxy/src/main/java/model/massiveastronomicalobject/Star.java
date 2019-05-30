package model.massiveastronomicalobject;


public class Star extends MassiveAstronomicalObject{
    private  double luminocity;
    private  double sigma=1;
    public Star(){

    }
    public Star(double radius, double luminocity) {
        super(radius);
       this.luminocity=luminocity;
    }
    public double Temperature(){
        return luminocity/sigma*Math.PI*getRadius()*getRadius();
    }

}
