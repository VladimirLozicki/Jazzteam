package model.planet;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "satellite")
public class Satellite extends Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double acceleration;
    @Column(name = "name")
    private String name;


    public Satellite() {

    }

    public Satellite(String name) {
        this.name = name;
    }

    public Satellite(double weight) {
        this.setWeight(weight);
    }

    public Satellite(double velocity, double weight) {
        this.setVelocity(velocity);
        this.setWeight(weight);
    }

    public Satellite(double velocity, String name) {
        this.setVelocity(velocity);
        this.name = name;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "model.planet.Satellite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // ", weight='" + weight +
                '}';
    }
}