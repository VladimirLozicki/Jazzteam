package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;
import org.testng.annotations.Test;

import static junit.framework.Assert.*;

public class GeostationaryOrbitaTest {

    @Test
    public void testGoOutOnOrbita() {
        Sattelite sattelite = new Sattelite(6.5, "Moon");
        Planet planet = new Planet(10000, 100, 4, "Kepler748b", 5.8,
                22.1);
        GeostationaryOrbita geostationaryOrbita = new GeostationaryOrbita(planet, sattelite);
        int actual = (int) geostationaryOrbita.heightOrbita();
        int expected = (int) geostationaryOrbita.heightRise();
        assertEquals(actual, expected);
    }

    @Test
    public void testNotOutOnOrbita() {
        Sattelite sattelite = new Sattelite(3.5, "Gf893");
        Planet planet = new Planet(10000, 100, 4, "Kepler748b", 5.8,
                22.1);
        GeostationaryOrbita geostationaryOrbita = new GeostationaryOrbita(planet, sattelite);
        assertFalse(geostationaryOrbita.heightRise()> geostationaryOrbita.heightOrbita());
    }

    @Test
    public void testBeyondLimitsOrbita() {
        Sattelite sattelite = new Sattelite(10, "Kepler6782");
        Planet planet = new Planet(10000, 100, 4, "Kepler748b", 5.8,
                22.1);
        GeostationaryOrbita geostationaryOrbita = new GeostationaryOrbita(planet, sattelite);
        assertTrue(geostationaryOrbita.heightRise()> geostationaryOrbita.heightOrbita());
    }


}