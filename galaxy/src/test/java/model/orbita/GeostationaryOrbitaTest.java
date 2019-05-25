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
        int actual = (int) geostationaryOrbita.getHeightOrbita();
        int expected = (int) geostationaryOrbita.getHeightRise();
        //System.out.println(actual + "   "+ expected);
        assertEquals(actual, expected);
    }

    @Test
    public void testNotOutOnOrbita() {
        Sattelite sattelite = new Sattelite(3.5, "Moon");
        Planet planet = new Planet(10000, 100, 4, "Kepler748b", 5.8,
                22.1);
        GeostationaryOrbita geostationaryOrbita = new GeostationaryOrbita(planet, sattelite);
        assertFalse(Equals(geostationaryOrbita.getHeightRise(), geostationaryOrbita.getHeightOrbita()));
    }

    @Test
    public void testBeyondLimitsOrbita() {
        Sattelite sattelite = new Sattelite(10, "Moon");

        Planet planet = new Planet(10000, 100, 4, "Kepler748b", 5.8,
                22.1);
        GeostationaryOrbita geostationaryOrbita = new GeostationaryOrbita(planet, sattelite);
        assertTrue(Equals(geostationaryOrbita.getHeightRise(), geostationaryOrbita.getHeightOrbita()));
    }

    public boolean Equals(double a, double b) {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    }
}