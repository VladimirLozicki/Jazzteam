package model.massive_astronomical_object;

import model.planet.AstronomicalObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MassiveAstronomicalObject extends AstronomicalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public MassiveAstronomicalObject() {
        /*
         * must be for hibernate
         */
    }

    public MassiveAstronomicalObject(double weight, double radius) {
        super(weight, radius);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}