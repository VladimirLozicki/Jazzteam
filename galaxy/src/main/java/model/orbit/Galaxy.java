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

import java.util.ArrayList;
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
    @Transient
    protected static final double G = 1;

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
                getStateObject();
            }
        };
        timer.schedule(task, 10, 10000000);
    }

    private void toBumpInto(int i) {
        Planet planet = getOrbit().get(i).getPlanet();
        massiveAstronomicalObject.setWeight(planet.getWeight()
                + massiveAstronomicalObject.getWeight());
        planet.setWeight(0);
    }

    public void getStateObject() {
        for (int j = 0; j < getOrbit().size(); j++) {
            double h = getOrbit().get(j).getHeight();
            if (h == 0) {
                toBumpInto(j);
                delete(j);
            }
            if (h > getMassiveAstronomicalObject().getRadius() * 5) {
                flewAway(i);
            }
        }
    }

    private void delete(int i) {
        getOrbit().remove(i);
    }

    private void flewAway(int i) {
        logger.info(getOrbit().get(i).getId() + "planet flew away");
    }

    //       public void calculateVelocity(int i) {
//        setNewVelocity(getSatellite().getVelocity() + getAcceleration() * i);
//    }
//
//    public void deleteOrbit(){
//        if(getNewVelocity()==0){
//
//        }
//    }


//    public double accelerationGravity() {
//        return (G *getPlanet().getWeight()) / (Math.pow(getPlanet().getRadius(), 2));
//    }
//
//    public double powerGravity() {
//        return (G * planet.getWeight() * satellite.getWeight()) / Math.pow(getHeight(), 2);
//    }


    //    public double heightOrbit() {
//        return Math.cbrt(G * planet.getWeight());
//    }
//
//
//    public double heightRise() {
//        return satellite.getVelocity() * satellite.getVelocity() / 2 * accelerationGravity();
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
