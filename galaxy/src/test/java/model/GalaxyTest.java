package model;

import model.galaxy.Galaxy;
import model.massive_astronomical_object.MassiveAstronomicalObject;
import model.orbit.Orbit;
import model.planet.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath:beans.xml"})
public class GalaxyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ServiceGalaxy serviceGalaxy;

    @Autowired
    private Galaxy galaxy;

    @Autowired
    private Planet planet;

    @Autowired
    private MassiveAstronomicalObject massiveAstronomicalObject;

    private ArrayList<Orbit> orbits = new ArrayList<>();

    @BeforeMethod
    public void createSystem() {
        planet.setWeight(100);
        planet.setRadius(10);
        massiveAstronomicalObject.setWeight(100);
        massiveAstronomicalObject.setRadius(10);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
    }

    @Test
    public void testAccelerationGravity() {
        Orbit orbit = new Orbit.Builder().height(0).build();
        assertEquals(galaxy.accelerationGravity(orbit), 1.0);
    }

    @Test
    public void testPlanetToFall() {
        planet.setVelocity(3);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(0)
                .build();
        orbit.setFirstVelocity(10);
        orbit.setNewVelocity(5);
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        galaxy.planetFall(orbit);
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet fall on star");
    }

    @Test
    public void testPlanetToFallSecondCondition() {
        planet.setVelocity(10);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(-0.5)
                .build();
        orbit.setFirstVelocity(10);
        orbit.setNewVelocity(5);
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        galaxy.planetFall(orbit);
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet fall on star");
    }

    @Test
    public void testPlanetOnTheOrbit() {
        planet.setVelocity(10);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(1)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        galaxy.planetMoveOnTheOrbit(orbit);
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet on the orbit");
    }

    @Test
    public void testPlanetFlewAway() {
        planet.setVelocity(1000);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(2)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        galaxy.flewAway(orbit);
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "the planet flies away");
    }

    @Test
    public void testPlanetFlewAwaySecondCondition() {
        planet.setVelocity(-0.5);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(2)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        galaxy.flewAway(orbit);
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "the planet flies away");
    }

    @Test
    public void testPlanetDied() {
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .acceleration(0)
                .build();
        orbits.add(orbit);
        orbit.setNewVelocity(-1);
        galaxy.setOrbits(orbits);
        galaxy.planetDied(orbit);
        assertEquals(galaxy.getOrbits().get(0).getCondition(), "planet died");
    }

    @Test
    public void testBumpInto() {
        galaxy.toBumpInto(planet);
        assertEquals(massiveAstronomicalObject.getWeight(), 200.0);
    }

    @AfterMethod
    public void delete() {
        orbits.clear();
    }
}