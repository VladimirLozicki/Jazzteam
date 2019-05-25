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
    private double weight;

    public Sattelite(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sattelite(double velocity, String name) {
        this.setVelocity(velocity);
        this.name=name;
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