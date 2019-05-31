package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrbitaTest {
    @Test
    public void testCreatBalanceSystem() {
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).build();
        assertEquals(orbita.accelerationGravity(planet), 1.0);
    }

    @Test
    public void testSatteliteGoLimitPlanet() {
        Planet planet = new Planet(100.0, 5.0, "Kepler74");
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).build();
        assertEquals(orbita.accelerationGravity(planet), 4.0);
    }

    @Test
    public void testSatteliteFallOnPlanet() {
        Planet planet = new Planet(100.0, 100.0, "Mars");
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).build();
        assertEquals(orbita.accelerationGravity(planet), 0.01);
    }

}