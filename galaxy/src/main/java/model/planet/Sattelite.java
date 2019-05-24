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
    public Sattelite(double velocity) {
        this.setVelocity(velocity);
    }
    public Sattelite(String name,  int weight) {
        this.name = name;
        this.weight=weight;
    }

    public String getName() {
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

    @Override
    public String toString() {
        return "model.planet.Sattelite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight  +
                '}';
    }
}