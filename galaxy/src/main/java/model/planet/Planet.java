package model.planet;

import model.AstronomicalObject;
import org.apache.maven.model.Developer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "satellite")
public class Planet extends AstronomicalObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double rotationPeriod;
    private double density;
    private double secondCosmicVelocity;
    private String name;

    public Planet() {

    }


    public Planet(double radius) {
        super(radius);
    }


    public Planet(double weight, double radius, String n) {
        super(weight, radius, n);

    }

    public Planet(double weight, double radius, String n, double density,
                  double rotationPeriod) {
        super(weight, radius, n);
        this.density = density;
        this.rotationPeriod = rotationPeriod;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public double getSecondCosmicVelocity() {
        return secondCosmicVelocity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public String getGet() {
        String s = String.valueOf(getVelocity() * 4);
        return s;
    }
}