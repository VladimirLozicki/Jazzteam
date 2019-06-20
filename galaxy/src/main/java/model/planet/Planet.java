package model.planet;

import model.AstronomicalObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Planet extends AstronomicalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Planet() {

    }

    public Planet(double weight, double radius, String n) {
        super(weight, radius, n);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}