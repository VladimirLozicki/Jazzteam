package model;

import model.Galaxy.Galaxy;
import model.massiveastronomicalobject.MassiveAstronomicalObject;
import model.orbit.Orbit;
import model.planet.Planet;
import org.hibernate.Session;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

public class GalaxyTest {

    private Galaxy galaxy = new Galaxy();
    private ArrayList<Orbit> orbits = new ArrayList<>();

    @Test
    public void testToBumpInto() {
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
    }

    @Test
    public void testPlanetOnTheOrbit() {
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

    @AfterMethod
    public void delete() {
        orbits.clear();
    }

    @BeforeMethod
    public void deleteBD() {
        Session session = getSessionFactory().openSession();
        session.createSQLQuery("DELETE TABLE galaxy");
        session.close();
    }
}