package model.planet;

import javax.persistence.*;

@Entity
@Table (name = "sattelite")
public class Sattelite extends Planet{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;

    public Sattelite(String name) {
        this.name = name;
    }


    public Sattelite(double velocity, double weight) {
        this.setVelocity(velocity);
        this.weight = weight;
    }

    public Sattelite(double velocity, String name) {
        this.setVelocity(velocity);
        this.setName(name);
    }
    public Sattelite(double weight) {
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "model.planet.Sattelite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight  +
                '}';
    }
}