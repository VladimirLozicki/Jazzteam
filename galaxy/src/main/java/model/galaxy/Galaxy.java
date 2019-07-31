package model.galaxy;

import model.massive_astronomical_object.MassiveAstronomicalObject;
import model.orbit.Orbit;
import model.planet.Planet;
import org.springframework.test.context.ContextConfiguration;

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
import javax.persistence.Transient;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ContextConfiguration(locations = {"classpath:beans.xml"})
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

    @Transient
    private Timer timer = new Timer();

    public void run() {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                i++;
                time = i;
                getStateGalaxy();
            }
        };
        timer.schedule(task, 10, 10);
    }

    public void killTime() {
        timer.cancel();
        setI(0);
    }

    public double accelerationGravity(Orbit orbit) {
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

    public void toBumpInto(Planet planet) {
        massiveAstronomicalObject.setWeight(planet.getWeight() +
                massiveAstronomicalObject.getWeight());
    }

    public void planetMoveOnTheOrbit(Orbit orbit) {
        if (orbit.getNewVelocity() == orbit.getFirstVelocity()
                && orbit.getAcceleration() == accelerationGravity(orbit)) {
            orbit.setCondition("planet on the orbit");
        }
    }

    public void planetFall(Orbit orbit) {
        double new_velocity = orbit.getNewVelocity();
        if (new_velocity < orbit.getFirstVelocity() &&
                orbit.getAcceleration() <= accelerationGravity(orbit)
                || new_velocity >= orbit.getFirstVelocity()
                && orbit.getAcceleration() < accelerationGravity(orbit)) {
            orbit.setCondition("planet fall on star");
            planetDied(orbit);
        }
    }

    public void planetDied(Orbit orbit) {
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

    public void flewAway(Orbit orbit) {
        if (orbit.getNewVelocity() >= orbit.getFirstVelocity()
                && orbit.getAcceleration() > accelerationGravity(orbit)
                || orbit.getNewVelocity() < orbit.getFirstVelocity() &&
                orbit.getAcceleration() >= accelerationGravity(orbit)) {
            orbit.setCondition("the planet flies away");
        }
    }

    private void getStateGalaxy() {
        for (int j = 0; j < getOrbits().size(); j++) {
            Orbit orbit = getOrbits().get(j);
            addNewVelocity(orbit);
            planetMoveOnTheOrbit(orbit);
            planetFall(orbit);
            flewAway(orbit);
        }
    }

    public int getTime() {
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

    public static void setI(int i) {
        Galaxy.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Galaxy galaxy = (Galaxy) o;
        return id == galaxy.id &&
                time == galaxy.time &&
                Objects.equals(massiveAstronomicalObject, galaxy.massiveAstronomicalObject) &&
                Objects.equals(orbits, galaxy.orbits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, massiveAstronomicalObject, time, orbits);
    }

}
