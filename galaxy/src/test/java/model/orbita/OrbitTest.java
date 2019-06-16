package model.orbita;

import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrbitTest {

    @Test
    public void testCreatBalanceSystem() {
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite).build1();
        assertEquals(orbit.accelerationGravity(), 1.0);
    }

    @Test
    public void testSatelliteGoLimitPlanet() {
        Planet planet = new Planet(100.0, 5.0, "Kepler74");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite).build1();
        assertEquals(orbit.accelerationGravity(), 4.0);
    }

    @Test
    public void testSatelliteFallOnPlanet() {
        Planet planet = new Planet(100.0, 100.0, "Mars");
        Satellite satellite = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite).build1();
        assertEquals(orbit.accelerationGravity(), 0.01);

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
        Satellite satellite = new Satellite(100.0);
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite).height(1000).build1();
        return orbit;
    }

}