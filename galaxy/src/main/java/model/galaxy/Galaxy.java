package model.galaxy;

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


    public Galaxy() {
        /*
         * must be for hibernate
         */
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


    private double accelerationGravity(Orbit orbit) {
        return massiveAstronomicalObject.getWeight()
                / Math.pow(massiveAstronomicalObject.getRadius() + orbit.getHeight(), 2);
    }

    private void addNewVelocity(Orbit orbit) {
        orbit.setNewVelocity(orbit.getPlanet().getVelocity()
                + (orbit.getAcceleration() - accelerationGravity(orbit)) * i);

        orbit.setFirstVelocity(Math.sqrt(massiveAstronomicalObject.getWeight()
                / (massiveAstronomicalObject.getRadius() + orbit.getHeight())));

        orbit.setSecondVelocity(Math.sqrt(2 * massiveAstronomicalObject.getWeight()
                / (massiveAstronomicalObject.getRadius() + orbit.getHeight())));
    }

    private void toBumpInto(Planet planet) {
        massiveAstronomicalObject.setWeight(planet.getWeight() +
                massiveAstronomicalObject.getWeight());
    }

    private void planetMoveOnTheOrbit(Orbit orbit) {
        if (orbit.getNewVelocity() == orbit.getFirstVelocity()
                && orbit.getAcceleration() == accelerationGravity(orbit)) {
            orbit.setCondition("planet on the orbit");
        }
    }

    private void planetFall(Orbit orbit) {
        if (orbit.getNewVelocity() < orbit.getFirstVelocity() &&
                orbit.getAcceleration() <= accelerationGravity(orbit)
                || orbit.getNewVelocity() >= orbit.getFirstVelocity()
                && orbit.getAcceleration() < accelerationGravity(orbit)) {
            orbit.setCondition("planet fall on star");
            planetDied(orbit);
        }
    }

    private void planetDied(Orbit orbit) {
        if (orbit.getNewVelocity() < 0) {
            toBumpInto(orbit.planet);
            orbit.setCondition("planet died");
            orbit.planet.setWeight(0);
            orbit.setHeight(0);
            orbit.planet.setRadius(0);
            orbit.setNewVelocity(0);
            orbit.setAcceleration(0);
            orbit.setFirstVelocity(0);
            orbit.planet.setVelocity(0);
        }
    }

    private void flewAway(Orbit orbit) {
        if (orbit.getNewVelocity() >= orbit.getFirstVelocity()
                && orbit.getAcceleration() > accelerationGravity(orbit)
                || orbit.getNewVelocity() < orbit.getFirstVelocity() &&
                orbit.getAcceleration() >= accelerationGravity(orbit)) {
            orbit.setCondition("the planet flies away");
        }
    }

    public void getStateGalaxy() {
        for (int j = 0; j < getOrbits().size(); j++) {
            Orbit orbit = getOrbits().get(j);
            addNewVelocity(orbit);
            planetMoveOnTheOrbit(orbit);
            planetFall(orbit);
            flewAway(orbit);
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

    private void setTime(int time) {
        this.time = time;
    }

    public static void setI(int i) {
        Galaxy.i = i;
    }
}
