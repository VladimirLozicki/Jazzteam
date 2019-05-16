package model.planet;

import javax.persistence.*;

@Entity
@Table (name = "sattelite")
public class Sattelite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    private int weight;
    private int radius;

    public Sattelite() {

    }

    public Sattelite(String name,  int radius, int weight) {
        this.name = name;
        this.radius=radius;
        this.weight=weight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "model.planet.Sattelite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", radius='" + radius + '\'' +
                ", weight='" + weight  +
                '}';
    }
}