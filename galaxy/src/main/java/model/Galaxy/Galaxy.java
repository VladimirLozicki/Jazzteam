package model.Galaxy;

import model.massiveastronomicalobject.MassiveAstronomicalObject;
import model.orbit.Orbit;
import model.planet.Planet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Galaxy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private MassiveAstronomicalObject massiveAstronomicalObject;
    private int time;
    private static int i = 0;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Orbit> orbits;

    /**
     * must be for hibernate
     */
    public Galaxy() {
    }

    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                i++;
                setTime(i);
                getStateGalaxy();
            }
        };
        timer.schedule(task, 10, 10);
    }

    private void toBumpInto(int i) {
        Planet planet = getOrbits().get(i).getPlanet();
        massiveAstronomicalObject.setWeight(planet.getWeight()
                + massiveAstronomicalObject.getWeight());
        planet.setWeight(0);
    }

    public void getStateGalaxy() {
        for (int j = 0; j < getOrbits().size(); j++) {
            Orbit orbit = getOrbits().get(j);
            orbit.setNewVelocity(orbit.getPlanet().getVelocity() +
                    orbit.getAcceleration() * i - orbit.accelerationGravity());
            orbit.setFirstVelocity(Math.sqrt(massiveAstronomicalObject.getWeight()
                    / getMassiveAstronomicalObject().getRadius() + orbit.getHeight()));
            if (orbit.getNewVelocity() == orbit.getPlanet().getVelocity()) {
                orbit.setCondition("planet on the orbit");
            }

            if (orbit.getNewVelocity() < orbit.getPlanet().getVelocity()) {
                orbit.setCondition("planet fall on star");
                toBumpInto(j);
            }
            if (orbit.getNewVelocity() > orbit.getPlanet().getVelocity()) {
                orbit.setCondition("planet flew away ");
            }
        }
    }


    public int getTime() {
        return i;
    }

    public int get() {
        return time;
    }


    public MassiveAstronomicalObject getMassiveAstronomicalObject() {
        return massiveAstronomicalObject;
    }

    public void setMassiveAstronomicalObject(MassiveAstronomicalObject massiveAstronomicalObject) {
        this.massiveAstronomicalObject = massiveAstronomicalObject;
    }

    public List<Orbit> getOrbits() {
        return orbits;
    }

    public void setOrbits(List<Orbit> orbit) {
        this.orbits = orbit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setTime(int time) {
        this.time = time;
    }

    public static void setI(int i) {
        Galaxy.i = i;
    }

    public static int getI() {
        return i;
    }

}
