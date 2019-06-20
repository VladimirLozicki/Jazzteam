package model.orbit;

import model.massiveastronomicalobject.Star;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class OrbitTest {

    @Test
    public void testCreatBalanceSystem() {
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .height(1000)
                .build1();
        assertEquals(orbit.accelerationGravity(), 1.0);
    }

    @Test
    public void testSatelliteGoLimitPlanet() {
        Planet planet = new Planet(100.0, 5.0, "Kepler74");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .build1();
        assertEquals(orbit.accelerationGravity(), 4.0);
    }

    @Test
    public void testSatelliteFallOnPlanet() {
        Planet planet = new Planet(100.0, 100.0, "Mars");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .build1();
        assertEquals(orbit.accelerationGravity(), 0.01);
    }


    @Test
    public void testGetSatellite() {
        Satellite satellite = new Satellite(100.0, 100.0);
        Orbit orbit = new Orbit.Builder().satellite(satellite).build1();
        assertEquals(orbit.getSatellite(), satellite);
    }


    @Test
    public void testGetPlanet() {
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .height(1000)
                .build1();
        assertEquals(planet, orbit.getPlanet());
    }

    @Test
    public void testGetStar() {
        Star star = new Star(1.9, 1.0);
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .height(1000)
                .star(star)
                .build1();
        assertEquals(star, orbit.getStar());
    }

    @Test
    public void testGetId() {
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .height(1000)
                .build1();
        ServiceOrbit serviceOrbit = new ServiceOrbit();
        serviceOrbit.save(orbit);
        Orbit newOrbit = serviceOrbit.find(1);
        assertNotEquals(orbit, newOrbit);
    }


    @Test
    public void testAccelerationGravity() {
        double actual = getSystem().accelerationGravity();
        assertEquals(actual, 68.75);
    }

    @Test
    public void testPowerGravity() {
        double actual = getSystem().powerGravity();
        assertEquals(actual, 68.75);
    }

    public Orbit getSystem() {
        Planet planet = new Planet(687500.0, 100.0, "Kepler48b");
        Satellite satellite = new Satellite(100.0, 100.0);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .height(1000)
                .build1();
        return orbit;
    }

    @Test
    public void testGetWay() {
        Planet planet = new Planet(687500.0, 100.0, "Kepler48b");
        Satellite satellite = new Satellite(100.0, 4.0);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .satellite(satellite)
                .height(1000)
                .acceleration(0)
                .build1();
        assertEquals(orbit.satellite.getVelocity() * 5, 500.0);
    }

}