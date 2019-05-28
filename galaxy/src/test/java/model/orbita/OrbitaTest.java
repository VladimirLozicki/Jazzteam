package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OrbitaTest {
    @Test
    public void testCreatBalanceSystem() {
        Planet planet = new Planet(100.0, 10.0, 10, "Kepler48b", 5.0,
                15.0);
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita(planet, sattelite);
        assertEquals(orbita.accelerationGravity(), 1.0);
    }

    @Test
    public void testSatteliteGoLimitPlanet() {
        Planet planet = new Planet(100.0, 5.0, 10, "Kepler74", 5.0,
                15.0);
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita(planet, sattelite);
        assertEquals(orbita.accelerationGravity(), 4.0);
    }

    @Test
    public void testSatteliteFallOnPlanet() {
        Planet planet = new Planet(100.0, 100.0, 10, "Mars", 5.0,
                15.0);
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita(planet, sattelite);
        assertEquals(orbita.accelerationGravity(), 0.01);
    }

}