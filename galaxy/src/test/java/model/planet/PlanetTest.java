package model.planet;

import model.massiveastronomicalobject.Star;
import model.orbit.Orbit;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PlanetTest {
    private double attitude = 2.09999508929799;

    @Test
    public void testCreatePlanetWithLife() {
        SolidPlanet planetEarthType = new SolidPlanet(5.97e24, 6371, "Earth",
                11.0, 12.0, 5.0, 6.0,
                6200, 6700, 0, 25, 22,
                24);
        Star sun = new Star(10000, 1.0);
        Orbit orbit = new Orbit.Builder()
                .planet(planetEarthType)
                .star(sun)
                .height(149600000.0)
                .build1();
        double actual = getAttitude(sun, orbit);
        assertEquals(actual, attitude);
    }

    @Test
    public void testCheckMoreDistance() {
        Planet planet = new Planet(670.0, 670.0, "Kepler748b");
        Star myStars = new Star(1.0, 0.6);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .star(myStars)
                .height(1000.0)
                .build1();
        double actual = getAttitude(myStars, orbit);
        assertTrue(actual < attitude);

    }

    @Test
    public void testCheckLessDistance() {
        Planet planet1 = new Planet(6000.0, 650.0, "Kepler748b");
        Star myStars = new Star(100, 0.5);
        Orbit orbit = new Orbit.Builder()
                .planet(planet1)
                .star(myStars)
                .height(100.0)
                .build1();
        double actual = getAttitude(myStars, orbit);
        assertTrue(actual > attitude);
    }

    public double getAttitude(Star star, Orbit orbit) {
        return star.getTemperature() / orbit.getHeight();
    }

}
