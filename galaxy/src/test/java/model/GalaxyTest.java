package model;
import model.massiveAstronomicalObject.MassiveAstronomicalObject;
import model.orbit.Orbit;
import model.planet.Planet;
import org.hibernate.Session;
import org.testng.annotations.Test;
import services.ServiceGalaxy;
import java.util.ArrayList;
import static org.testng.Assert.*;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

public class GalaxyTest {

    Galaxy galaxy = new Galaxy();
    ArrayList<Orbit> orbits = new ArrayList<>();
    ServiceGalaxy serviceGalaxy = new ServiceGalaxy();

    @Test
    public void testSave() {
        Galaxy galaxy1 = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "name");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .build();
        orbits.add(orbit);
        Orbit orbit1 = new Orbit.Builder()
                .acceleration(1)
                .build();
        orbits.add(orbit1);
        galaxy1.setOrbits(orbits);
        MassiveAstronomicalObject massiveAstronomicalObject = new MassiveAstronomicalObject();
        galaxy1.setMassiveAstronomicalObject(massiveAstronomicalObject);
        serviceGalaxy.save(galaxy1);
        Galaxy newGalaxy = serviceGalaxy.find(132);
        assertNotEquals(galaxy1, newGalaxy);
        serviceGalaxy.delete(galaxy1);
    }

    @Test
    public void testToBumpInto() {
        Galaxy galaxy = new Galaxy();
        ArrayList<Orbit> orbits = new ArrayList<>();
        Planet planet = new Planet(100, 10, "name");
        planet.setVelocity(100);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(-0.5)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        MassiveAstronomicalObject massiveAstronomicalObject =
                new MassiveAstronomicalObject(100, 10);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        Galaxy.setI(10);
        galaxy.getStateGalaxy();
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet fall on star");
        orbits.remove(orbit);
    }

    @Test
    public void testPlanetOnTheOrbit() {
        Galaxy galaxy = new Galaxy();
        ArrayList<Orbit> orbits = new ArrayList<>();
        Planet planet = new Planet(100, 10, "name");
        planet.setVelocity(100);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(0.1)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        MassiveAstronomicalObject massiveAstronomicalObject =
                new MassiveAstronomicalObject(100, 10);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        Galaxy.setI(10);
        galaxy.getStateGalaxy();
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet on the orbit");
        orbits.remove(orbit);
    }

    @Test
    public void testPlanetFlewAway() {
        Planet planet = new Planet(100, 10, "name");
        planet.setVelocity(100);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(1)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        MassiveAstronomicalObject massiveAstronomicalObject =
                new MassiveAstronomicalObject(100, 10);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        Galaxy.setI(10);
        galaxy.getStateGalaxy();
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet flew away ");
    }

    @Test
    public void testGetWay() {
        assertEquals(getSystem().getOrbits().get(0).getPlanet().getVelocity() * 5, 500.0);
    }

    private Galaxy getSystem() {
        Galaxy galaxy = new Galaxy();
        MassiveAstronomicalObject massiveAstronomicalObject =
                new MassiveAstronomicalObject(100.0, 10.0);
        ArrayList<Orbit> orbits = new ArrayList<>();
        Planet planet = new Planet(687500.0, 100.0, "Kepler48b");
        planet.setVelocity(100);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        return galaxy;
    }

    @Test
    public void s() {
        System.out.println(getMaxId());
    }

    private int getMaxId() {
        Session session = getSessionFactory().openSession();
        int id = (int) session.createSQLQuery("select max(id) from galaxy")
                .uniqueResult();
        return id;
    }
}