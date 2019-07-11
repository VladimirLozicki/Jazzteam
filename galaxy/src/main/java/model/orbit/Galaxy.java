package model.orbit;

import model.massiveastronomicalobject.MassiveAstronomicalObject;

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


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class  Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private static int i = 0;
    @Transient
    protected static final double G = 1;
    public MassiveAstronomicalObject getMassiveAstronomicalObject() {
        return massiveAstronomicalObject;
    }

    public void setMassiveAstronomicalObject(MassiveAstronomicalObject massiveAstronomicalObject) {
        this.massiveAstronomicalObject = massiveAstronomicalObject;
    }

    @Transient
    MassiveAstronomicalObject massiveAstronomicalObject;


    public List<Orbit> getOrbit() {
        return orbit;
    }

    public void setOrbit(List<Orbit> orbit) {
        this.orbit = orbit;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Orbit> orbit;


    public Galaxy() {
    }


    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                i++;
                //   calculateVelocity(i);public
                //   getStateObject();
                //  deleteOrbit();
            }
        };
        timer.schedule(task, 10, 10000000);
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

    //    public String getStateObject() {
//        if (newVelocity == 0) {
//            return "satellite falls on the planet";
//        } else if (newVelocity == 8) {
//            return "satellite located on orbit planet";
//        } else if (newVelocity > 8) {
//            return "satellite leaves orbit planet";
//        }
//        return "";
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
