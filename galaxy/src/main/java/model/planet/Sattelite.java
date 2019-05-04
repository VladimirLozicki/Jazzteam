package model.planet;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Sattelite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int weight;
    private int radius;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sattelite sattelite = (Sattelite) o;
        return id == sattelite.id &&
                weight == sattelite.weight &&
                radius == sattelite.radius &&
                Objects.equals(name, sattelite.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, radius);
    }
}
