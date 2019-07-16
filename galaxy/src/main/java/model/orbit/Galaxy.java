package model.orbit;

import model.massiveastronomicalobject.MassiveAstronomicalObject;
import model.planet.Planet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Galaxy {
    private static final Logger logger = Logger.getGlobal();
    @Transient
    private MassiveAstronomicalObject massiveAstronomicalObject;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private static int i = 0;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Orbit> orbit;
    private int time;

    private void setTime(int i) {
        this.time = i;
    }

    public MassiveAstronomicalObject getMassiveAstronomicalObject() {
        return massiveAstronomicalObject;
    }

    public void setMassiveAstronomicalObject(MassiveAstronomicalObject massiveAstronomicalObject) {
        this.massiveAstronomicalObject = massiveAstronomicalObject;
    }


    public List<Orbit> getOrbit() {
        return orbit;
    }

    public void setOrbit(List<Orbit> orbit) {
        this.orbit = orbit;
    }


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
        timer.schedule(task, 1, 10);
    }

    private void toBumpInto(int i) {
        Planet planet = getOrbit().get(i).getPlanet();
        massiveAstronomicalObject.setWeight(planet.getWeight()
                + massiveAstronomicalObject.getWeight());
        planet.setWeight(0);
    }

    private void getStateGalaxy() {
        for (int j = 0; j < getOrbit().size(); j++) {
            Orbit orbit = getOrbit().get(j);
            double h = getOrbit().get(j).getHeight();
            orbit.setNewVelocity(orbit.getPlanet().getVelocity() + orbit.getAcceleration() * getTime());
            orbit.setWay(orbit.getNewVelocity()*getTime());
            if (h == 1) {
                toBumpInto(j);
                orbit.setCondition("planet fall on star");
                delete(j);
            }
            if(h >1 && h<getMassiveAstronomicalObject().getRadius() * 5){
                orbit.setCondition("planet on the orbit ");
            }

            if (h > getMassiveAstronomicalObject().getRadius() * 5) {
                flewAway(getTime());
                orbit.setCondition("planet flew away ");
            }
        }
    }


    public int getTime() {
        return time;
    }

    private void delete(int i) {
        getOrbit().remove(i);
    }

    private void flewAway(int i) {
        delete(i);
    }

}
