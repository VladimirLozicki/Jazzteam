package model.orbit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class  Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public void setOrbit(List<Orbit> orbit) {
        this.orbit = orbit;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Orbit> orbit;



    public Galaxy(Orbit orbit) {
    }

    public Galaxy() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
