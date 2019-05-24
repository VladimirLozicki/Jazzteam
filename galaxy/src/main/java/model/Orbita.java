package model;
import model.planet.Planet;
import model.planet.Sattelite;

import java.util.logging.Logger;

public class Orbita {
     private final static double G =1;
    private static final Logger logger = Logger.getGlobal();
    private double height;
    Planet planet;
    Sattelite sattelite;
    public Orbita(double height, Planet planet) {
        this.height = height;
        this.planet = planet;
    }

    public Orbita(double height, Planet planet, Sattelite sattelite) {
        this.height = height;
        this.planet = planet;
        this.sattelite=sattelite;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double run(){
        return (G*planet.getWeight())/(planet.getRadius()*planet.getRadius());
    }

    public void printResult(String message){
        logger.info(sattelite.getName() + " " + message + " " + planet.getName());
    }
}
